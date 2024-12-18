package com.transaction.project.simulator.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuerAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertIssuerAllPropertiesEquals(Issuer expected, Issuer actual) {
        assertIssuerAutoGeneratedPropertiesEquals(expected, actual);
        assertIssuerAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertIssuerAllUpdatablePropertiesEquals(Issuer expected, Issuer actual) {
        assertIssuerUpdatableFieldsEquals(expected, actual);
        assertIssuerUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertIssuerAutoGeneratedPropertiesEquals(Issuer expected, Issuer actual) {
        assertThat(expected)
            .as("Verify Issuer auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertIssuerUpdatableFieldsEquals(Issuer expected, Issuer actual) {
        assertThat(expected)
            .as("Verify Issuer relevant properties")
            .satisfies(e -> assertThat(e.getCode()).as("check code").isEqualTo(actual.getCode()))
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertIssuerUpdatableRelationshipsEquals(Issuer expected, Issuer actual) {
        // empty method
    }
}
