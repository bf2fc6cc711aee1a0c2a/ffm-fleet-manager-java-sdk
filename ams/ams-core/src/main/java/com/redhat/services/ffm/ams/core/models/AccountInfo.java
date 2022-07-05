package com.redhat.services.ffm.ams.core.models;

/**
 * This class constains the account information of the user that wants to perform an operation on a resource.
 */
public class AccountInfo {

    private final String organizationId;
    private final String accountUsername;
    private final Boolean adminRole;
    private final Long accountId;

    protected AccountInfo(String organizationId, String accountUsername, Boolean adminRole, Long accountId) {
        this.organizationId = organizationId;
        this.accountUsername = accountUsername;
        this.accountId = accountId;
        this.adminRole = adminRole;
    }

    /**
     * Gets the organization id.
     *
     * @return the organization id.
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * Gets the account username.
     *
     * @return the account username.
     */
    public String getAccountUsername() {
        return accountUsername;
    }

    /**
     * Gets the admin role..
     *
     * @return <code>true</code> if the user is admin, <code>false</code> otherwise.
     */
    public boolean getAdminRole() {
        return adminRole;
    }

    /**
     * Gets the account id.
     *
     * @return the account id.
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Builder for {@link AccountInfo}.
     */
    public static class Builder {

        private String organizationId;
        private String accountUsername;
        private Boolean adminRole;
        private Long accountId;

        public Builder() {
        }

        /**
         * Sets the organization id in the builder.
         *
         * @param organizationId
         * @return the builder.
         */
        public Builder withOrganizationId(String organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        /**
         * Sets the account username in the builder.
         *
         * @param accountUsername
         * @return the builder.
         */
        public Builder withAccountUsername(String accountUsername) {
            this.accountUsername = accountUsername;
            return this;
        }

        /**
         * Sets the admin role in the builder.
         *
         * @param adminRole
         * @return the builder.
         */
        public Builder withAdminRole(Boolean adminRole) {
            this.adminRole = adminRole;
            return this;
        }

        /**
         * Sets the account id in the builder.
         *
         * @param accountId
         * @return the builder.
         */
        public Builder withAccountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        /**
         * Builds the AccountInfo.
         *
         * @return the {@link AccountInfo} instance.
         */
        public AccountInfo build() {
            if (organizationId == null || organizationId.isBlank()) {
                throw new IllegalStateException("The organization id can not be null or blank.");
            }
            if (accountUsername == null || accountUsername.isBlank()) {
                throw new IllegalStateException("The account username can not be null or blank.");
            }
            if (adminRole == null) {
                throw new IllegalStateException("The admin role can not be null.");
            }
            if (accountId == null) {
                throw new IllegalStateException("The account id can not be null.");
            }
            return new AccountInfo(organizationId, accountUsername, adminRole, accountId);
        }
    }
}