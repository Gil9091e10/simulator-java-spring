import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './currency.reducer';

export const CurrencyDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const currencyEntity = useAppSelector(state => state.currency.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="currencyDetailsHeading">
          <Translate contentKey="simulatorApp.currency.detail.title">Currency</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{currencyEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="simulatorApp.currency.name">Name</Translate>
            </span>
          </dt>
          <dd>{currencyEntity.name}</dd>
          <dt>
            <span id="code">
              <Translate contentKey="simulatorApp.currency.code">Code</Translate>
            </span>
          </dt>
          <dd>{currencyEntity.code}</dd>
        </dl>
        <Button tag={Link} to="/currency" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/currency/${currencyEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CurrencyDetail;
