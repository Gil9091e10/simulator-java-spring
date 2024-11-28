package com.transaction.project.simulator.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class AcquirerAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAcquirerAllPropertiesEquals(Acquirer expected, Acquirer actual) {
        assertAcquirerAutoGeneratedPropertiesEquals(expected, actual);
        assertAcquirerAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAcquirerAllUpdatablePropertiesEquals(Acquirer expected, Acquirer actual) {
        assertAcquirerUpdatableFieldsEquals(expected, actual);
        assertAcquirerUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAcquirerAutoGeneratedPropertiesEquals(Acquirer expected, Acquirer actual) {
        assertThat(expected)
            .as("Verify Acquirer auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAcquirerUpdatableFieldsEquals(Acquirer expected, Acquirer actual) {
        assertThat(expected)
            .as("Verify Acquirer relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getSocketUrl()).as("check socketUrl").isEqualTo(actual.getSocketUrl()))
            .satisfies(e -> assertThat(e.getEmail()).as("check email").isEqualTo(actual.getEmail()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAcquirerUpdatableRelationshipsEquals(Acquirer expected, Acquirer actual) {
        // empty method
    }
}
