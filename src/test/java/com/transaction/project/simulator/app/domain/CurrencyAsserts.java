package com.transaction.project.simulator.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCurrencyAllPropertiesEquals(Currency expected, Currency actual) {
        assertCurrencyAutoGeneratedPropertiesEquals(expected, actual);
        assertCurrencyAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCurrencyAllUpdatablePropertiesEquals(Currency expected, Currency actual) {
        assertCurrencyUpdatableFieldsEquals(expected, actual);
        assertCurrencyUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCurrencyAutoGeneratedPropertiesEquals(Currency expected, Currency actual) {
        assertThat(expected)
            .as("Verify Currency auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCurrencyUpdatableFieldsEquals(Currency expected, Currency actual) {
        assertThat(expected)
            .as("Verify Currency relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getCode()).as("check code").isEqualTo(actual.getCode()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCurrencyUpdatableRelationshipsEquals(Currency expected, Currency actual) {
        // empty method
    }
}
