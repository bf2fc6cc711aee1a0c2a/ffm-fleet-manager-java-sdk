package com.redhat.services.ffm.ams.core.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.redhat.services.ffm.ams.core.Constants;

public class AccountInfoTest {

    @Test
    void builderThrowsExceptionIfMandatoryPropertyIsMissing() {
        Assertions.assertThatThrownBy(() -> new AccountInfo.Builder().build()).isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new AccountInfo.Builder().withAccountId(Constants.DEFAULT_ACCOUNT_ID).build())
                .isInstanceOf(IllegalStateException.class);
        Assertions
                .assertThatThrownBy(() -> new AccountInfo.Builder().withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                        .withAccountUsername(Constants.DEFAULT_USERNAME).build())
                .isInstanceOf(IllegalStateException.class);
        Assertions
                .assertThatThrownBy(() -> new AccountInfo.Builder().withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                        .withAccountUsername(Constants.DEFAULT_USERNAME).withAdminRole(Constants.DEFAULT_ADMIN_ROLE).build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new AccountInfo.Builder().withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                .withAccountUsername(Constants.DEFAULT_USERNAME).withOrganizationId(Constants.DEFAULT_ORGANIZATION_ID).build())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void builderSetsAllProperties() {
        AccountInfo accountInfo = new AccountInfo.Builder().withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                .withAccountUsername(Constants.DEFAULT_USERNAME).withAdminRole(Constants.DEFAULT_ADMIN_ROLE)
                .withOrganizationId(Constants.DEFAULT_ORGANIZATION_ID).build();
        Assertions.assertThat(accountInfo.getAccountId()).isEqualTo(Constants.DEFAULT_ACCOUNT_ID);
        Assertions.assertThat(accountInfo.getAccountUsername()).isEqualTo(Constants.DEFAULT_USERNAME);
        Assertions.assertThat(accountInfo.getAdminRole()).isEqualTo(Constants.DEFAULT_ADMIN_ROLE);
        Assertions.assertThat(accountInfo.getOrganizationId()).isEqualTo(Constants.DEFAULT_ORGANIZATION_ID);
    }
}
