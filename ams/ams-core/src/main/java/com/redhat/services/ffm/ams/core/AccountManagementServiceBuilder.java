package com.redhat.services.ffm.ams.core;

import com.redhat.services.ffm.ams.client.ApiClient;
import com.redhat.services.ffm.ams.client.api.DefaultApi;
import com.redhat.services.ffm.ams.core.models.AccountManagementServiceClientConfig;
import com.redhat.services.ffm.ams.infra.auth.TokenProvider;

/**
 * The builder for the Account Management Service
 */
public class AccountManagementServiceBuilder {

    private AccountManagementServiceClientConfig config;
    private TokenProvider tokenProvider;

    public AccountManagementServiceBuilder() {
    }

    /**
     * The config.
     *
     * @param config
     * @return the builder.
     */
    public AccountManagementServiceBuilder withConfig(AccountManagementServiceClientConfig config) {
        this.config = config;
        return this;
    }

    /**
     * The token provider.
     *
     * @param tokenProvider
     * @return the builder.
     */
    public AccountManagementServiceBuilder withTokenProvider(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
        return this;
    }

    /**
     * Builds the AccountManagementService implementation.
     *
     * @return the implementation for the AccountManagementService.
     */
    public AccountManagementService build() {
        ApiClient apiClient = buildApiClient(config, tokenProvider);
        return new AccountManagementServiceImpl(new DefaultApi(apiClient));
    }

    private static ApiClient buildApiClient(AccountManagementServiceClientConfig config, TokenProvider tokenProvider) {

        ApiClient apiClient = new ApiClient();

        if (config.getHost() != null) {
            apiClient.setHost(config.getHost());
        }
        if (config.getPort() != null) {
            apiClient.setPort(config.getPort());
        }
        if (config.getConnectionTimeout() != null) {
            apiClient.setConnectTimeout(config.getConnectionTimeout());
        }
        if (config.getReadTimeout() != null) {
            apiClient.setReadTimeout(config.getReadTimeout());
        }

        if (tokenProvider != null) {
            apiClient.setRequestInterceptor(x -> x.setHeader("Authorization", "Bearer " + tokenProvider.getToken()));
        }

        return apiClient;
    }
}
