package dev.bf2.ffm.ams.core.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.bf2.ffm.ams.core.Constants;

public class ResourceCreatedTest {

    @Test
    void builderThrowsExceptionIfMandatoryPropertyIsMissing() {
        Assertions.assertThatThrownBy(() -> new AccountInfo.Builder().build()).isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new AccountInfo.Builder()
                .withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions
                .assertThatThrownBy(() -> new AccountInfo.Builder()
                        .withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                        .withAccountUsername(Constants.DEFAULT_USERNAME)
                        .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions
                .assertThatThrownBy(() -> new AccountInfo.Builder()
                        .withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                        .withAccountUsername(Constants.DEFAULT_USERNAME)
                        .withAdminRole(Constants.DEFAULT_ADMIN_ROLE)
                        .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new AccountInfo.Builder()
                .withAccountId(Constants.DEFAULT_ACCOUNT_ID)
                .withAccountUsername(Constants.DEFAULT_USERNAME)
                .withOrganizationId(Constants.DEFAULT_ORGANIZATION_ID)
                .build())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void builderSetsAllProperties() {
        ResourceCreated resourceCreated = new ResourceCreated.Builder().withSubscriptionId(Constants.DEFAULT_SUBSCRIPTION_ID)
                .build();
        Assertions.assertThat(resourceCreated.getSubscriptionId()).isEqualTo(Constants.DEFAULT_SUBSCRIPTION_ID);
    }
}
