package dev.bf2.ffm.ams.core.models;

import java.time.Duration;
import java.util.Objects;

import dev.bf2.ffm.ams.core.AccountManagementService;

/**
 * This class contains the configuration for the {@link AccountManagementService}.
 */
public class AccountManagementServiceClientConfig {

    private final String host;
    private final Integer port;
    private final Duration readTimeout;
    private final Duration connectionTimeout;

    protected AccountManagementServiceClientConfig(String host, Integer port, Duration readTimeout,
            Duration connectionTimeout) {
        this.host = host;
        this.port = port;
        this.readTimeout = readTimeout;
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * Gets the Account Management Service host.
     *
     * @return the host.
     */
    public String getHost() {
        return host;
    }

    /**
     * Gets the Account Management Service port.
     *
     * @return the port.
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Gets the read timeout configuration for the HTTP client interacting with the Account Management Service.
     *
     * @return the read timeout configuration.
     */
    public Duration getReadTimeout() {
        return readTimeout;
    }

    /**
     * Gets the connection timeout configuration for the HTTP client interacting with the Account Management Service.
     *
     * @return the connection timeout configuration.
     */
    public Duration getConnectionTimeout() {
        return connectionTimeout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountManagementServiceClientConfig that = (AccountManagementServiceClientConfig) o;
        return Objects.equals(host, that.host) && Objects.equals(port, that.port)
                && Objects.equals(readTimeout, that.readTimeout) && Objects.equals(connectionTimeout, that.connectionTimeout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, readTimeout, connectionTimeout);
    }

    /**
     * Builder for {@link AccountManagementServiceClientConfig}.
     */
    public static class Builder {
        private String host;
        private Integer port;
        private Duration readTimeout;
        private Duration connectionTimeout;

        public Builder() {
        }

        /**
         * Sets the Account Management Service host in the builder.
         *
         * @param host
         * @return the builder.
         */
        public Builder withHost(String host) {
            this.host = host;
            return this;
        }

        /**
         * Sets the Account Management Service port in the builder.
         *
         * @param port
         * @return the builder.
         */
        public Builder withPort(Integer port) {
            this.port = port;
            return this;
        }

        /**
         * Sets the read timeout configuration for the HTTP client interacting with Account Management Service in the builder.
         *
         * @param readTimeout
         * @return the builder.
         */
        public Builder withReadTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        /**
         * Sets the timeout connection configuration for the HTTP client interacting with Account Management Service in the
         * builder.
         *
         * @param connectionTimeout
         * @return the builder.
         */
        public Builder withConnectionTimeout(Duration connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        /**
         * Builds the AccountManagementServiceClientConfig.
         *
         * @return the {@link AccountManagementServiceClientConfig} instance.
         */
        public AccountManagementServiceClientConfig build() {
            return new AccountManagementServiceClientConfig(host, port, readTimeout, connectionTimeout);
        }
    }
}
