package com.transaction.project.simulator.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageIsoConfigAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageIsoConfigAllPropertiesEquals(MessageIsoConfig expected, MessageIsoConfig actual) {
        assertMessageIsoConfigAutoGeneratedPropertiesEquals(expected, actual);
        assertMessageIsoConfigAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageIsoConfigAllUpdatablePropertiesEquals(MessageIsoConfig expected, MessageIsoConfig actual) {
        assertMessageIsoConfigUpdatableFieldsEquals(expected, actual);
        assertMessageIsoConfigUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageIsoConfigAutoGeneratedPropertiesEquals(MessageIsoConfig expected, MessageIsoConfig actual) {
        assertThat(expected)
            .as("Verify MessageIsoConfig auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageIsoConfigUpdatableFieldsEquals(MessageIsoConfig expected, MessageIsoConfig actual) {
        assertThat(expected)
            .as("Verify MessageIsoConfig relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getFilename()).as("check filename").isEqualTo(actual.getFilename()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageIsoConfigUpdatableRelationshipsEquals(MessageIsoConfig expected, MessageIsoConfig actual) {
        assertThat(expected)
            .as("Verify MessageIsoConfig relationships")
            .satisfies(e -> assertThat(e.getAcquirer()).as("check acquirer").isEqualTo(actual.getAcquirer()))
            .satisfies(e ->
                assertThat(e.getMessageTypeIndicator()).as("check messageTypeIndicator").isEqualTo(actual.getMessageTypeIndicator())
            );
    }
}
