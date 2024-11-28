package com.transaction.project.simulator.app.web.rest;

import com.transaction.project.simulator.app.repository.TransactionRepository;
import com.transaction.project.simulator.app.service.TransactionQueryService;
import com.transaction.project.simulator.app.service.TransactionService;
import com.transaction.project.simulator.app.service.criteria.TransactionCriteria;
import com.transaction.project.simulator.app.service.dto.TransactionDto;
import com.transaction.project.simulator.app.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.transaction.project.simulator.app.domain.Transaction}.
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionResource.class);

    private static final String ENTITY_NAME = "transaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TransactionService transactionService;

    private final TransactionRepository transactionRepository;

    private final TransactionQueryService transactionQueryService;

    public TransactionResource(
        TransactionService transactionService,
        TransactionRepository transactionRepository,
        TransactionQueryService transactionQueryService
    ) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
        this.transactionQueryService = transactionQueryService;
    }

    /**
     * {@code POST  /transactions} : Create a new transaction.
     *
     * @param transactionDto the transactionDto to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionDto, or with status {@code 400 (Bad Request)} if the transaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TransactionDto> createTransaction(@Valid @RequestBody TransactionDto transactionDto) throws URISyntaxException {
        LOG.debug("REST request to save Transaction : {}", transactionDto);
        if (transactionDto.getId() != null) {
            throw new BadRequestAlertException("A new transaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        transactionDto = transactionService.save(transactionDto);
        return ResponseEntity.created(new URI("/api/transactions/" + transactionDto.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, transactionDto.getId().toString()))
            .body(transactionDto);
    }

    /**
     * {@code PUT  /transactions/:id} : Updates an existing transaction.
     *
     * @param id the id of the transactionDto to save.
     * @param transactionDto the transactionDto to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionDto,
     * or with status {@code 400 (Bad Request)} if the transactionDto is not valid,
     * or with status {@code 500 (Internal Server Error)} if the transactionDto couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TransactionDto> updateTransaction(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody TransactionDto transactionDto
    ) throws URISyntaxException {
        LOG.debug("REST request to update Transaction : {}, {}", id, transactionDto);
        if (transactionDto.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, transactionDto.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!transactionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        transactionDto = transactionService.update(transactionDto);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, transactionDto.getId().toString()))
            .body(transactionDto);
    }

    /**
     * {@code PATCH  /transactions/:id} : Partial updates given fields of an existing transaction, field will ignore if it is null
     *
     * @param id the id of the transactionDto to save.
     * @param transactionDto the transactionDto to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionDto,
     * or with status {@code 400 (Bad Request)} if the transactionDto is not valid,
     * or with status {@code 404 (Not Found)} if the transactionDto is not found,
     * or with status {@code 500 (Internal Server Error)} if the transactionDto couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<TransactionDto> partialUpdateTransaction(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody TransactionDto transactionDto
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update Transaction partially : {}, {}", id, transactionDto);
        if (transactionDto.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, transactionDto.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!transactionRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<TransactionDto> result = transactionService.partialUpdate(transactionDto);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, transactionDto.getId().toString())
        );
    }

    /**
     * {@code GET  /transactions} : get all the transactions.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TransactionDto>> getAllTransactions(
        TransactionCriteria criteria,
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get Transactions by criteria: {}", criteria);

        Page<TransactionDto> page = transactionQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transactions/count} : count all the transactions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/count")
    public ResponseEntity<Long> countTransactions(TransactionCriteria criteria) {
        LOG.debug("REST request to count Transactions by criteria: {}", criteria);
        return ResponseEntity.ok().body(transactionQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /transactions/:id} : get the "id" transaction.
     *
     * @param id the id of the transactionDto to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionDto, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransaction(@PathVariable("id") Long id) {
        LOG.debug("REST request to get Transaction : {}", id);
        Optional<TransactionDto> transactionDto = transactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionDto);
    }

    /**
     * {@code DELETE  /transactions/:id} : delete the "id" transaction.
     *
     * @param id the id of the transactionDto to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete Transaction : {}", id);
        transactionService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}