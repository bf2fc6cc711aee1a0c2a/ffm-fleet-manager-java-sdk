package com.redhat.services.ffm.ams.core.models;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagementServiceClientConfigTest {

    private static final String DEFAULT_HOST = "http://localhost";
    private static final Integer DEFAULT_PORT = 8080;
    private static final Duration DEFAULT_CONNECTION_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(20);

    @Test
    void builderSetsAllProperties() {
        AccountManagementServiceClientConfig accountManagementServiceClientConfig = new AccountManagementServiceClientConfig.Builder()
                .withHost(DEFAULT_HOST)
                .withPort(DEFAULT_PORT)
                .withConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT)
                .withReadTimeout(DEFAULT_READ_TIMEOUT)
                .build();
        Assertions.assertThat(accountManagementServiceClientConfig.getHost()).isEqualTo(DEFAULT_HOST);
        Assertions.assertThat(accountManagementServiceClientConfig.getPort()).isEqualTo(DEFAULT_PORT);
        Assertions.assertThat(accountManagementServiceClientConfig.getConnectionTimeout())
                .isEqualTo(DEFAULT_CONNECTION_TIMEOUT);
        Assertions.assertThat(accountManagementServiceClientConfig.getReadTimeout()).isEqualTo(DEFAULT_READ_TIMEOUT);
    }

    @Test
    void builderSetsNullByDefault() {
        AccountManagementServiceClientConfig accountManagementServiceClientConfig = new AccountManagementServiceClientConfig.Builder()
                .build();
        Assertions.assertThat(accountManagementServiceClientConfig.getHost()).isNull();
        Assertions.assertThat(accountManagementServiceClientConfig.getPort()).isNull();
        Assertions.assertThat(accountManagementServiceClientConfig.getReadTimeout()).isNull();
        Assertions.assertThat(accountManagementServiceClientConfig.getConnectionTimeout()).isNull();
    }
}
