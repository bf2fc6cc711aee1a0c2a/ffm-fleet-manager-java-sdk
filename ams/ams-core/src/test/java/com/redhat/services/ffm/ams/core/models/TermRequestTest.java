package com.redhat.services.ffm.ams.core.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.redhat.services.ffm.ams.core.Constants;

public class TermRequestTest {

    @Test
    void builderThrowsExceptionIfMandatoryPropertyIsMissing() {
        Assertions.assertThatThrownBy(() -> new TermRequest.Builder()
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new TermRequest.Builder()
                .withSiteCode(Constants.DEFAULT_TERM_SITE_CODE)
                .build())
                .isInstanceOf(IllegalStateException.class);
        Assertions.assertThatThrownBy(() -> new TermRequest.Builder()
                .withEventCode(Constants.DEFAULT_TERM_EVENT_CODE)
                .build())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void builderSetsAllProperties() {
        TermRequest termRequest = new TermRequest.Builder()
                .withEventCode(Constants.DEFAULT_TERM_EVENT_CODE)
                .withSiteCode(Constants.DEFAULT_TERM_SITE_CODE)
                .build();
        Assertions.assertThat(termRequest.getEventCode()).isEqualTo(Constants.DEFAULT_TERM_EVENT_CODE);
        Assertions.assertThat(termRequest.getSiteCode()).isEqualTo(Constants.DEFAULT_TERM_SITE_CODE);
    }
}
