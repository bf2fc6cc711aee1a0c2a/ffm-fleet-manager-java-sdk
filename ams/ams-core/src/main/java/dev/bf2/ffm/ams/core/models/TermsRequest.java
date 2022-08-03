package dev.bf2.ffm.ams.core.models;

import java.util.Objects;

public class TermsRequest {
    private final String siteCode;
    private final String eventCode;

    protected TermsRequest(String siteCode, String eventCode) {
        this.siteCode = siteCode;
        this.eventCode = eventCode;
    }

    /**
     * Gets the site code.
     *
     * @return the site code
     */
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * Gets the event code.
     *
     * @return the event code.
     */
    public String getEventCode() {
        return eventCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TermsRequest that = (TermsRequest) o;
        return Objects.equals(siteCode, that.siteCode) && Objects.equals(eventCode, that.eventCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteCode, eventCode);
    }

    /**
     * Builder for {@link TermsRequest}.
     */
    public static class Builder {
        private String siteCode;
        private String eventCode;

        public Builder() {
        }

        /**
         * The site code.
         *
         * @param siteCode
         * @return the builder.
         */
        public Builder withSiteCode(String siteCode) {
            this.siteCode = siteCode;
            return this;
        }

        /**
         * The event code.
         *
         * @param eventCode
         * @return the builder.
         */
        public Builder withEventCode(String eventCode) {
            this.eventCode = eventCode;
            return this;
        }

        /**
         * Builds the TermRequest.
         *
         * @return the {@link TermsRequest} instance.
         */
        public TermsRequest build() {
            if (siteCode == null || siteCode.isBlank()) {
                throw new IllegalStateException("The site code can't be null or empty.");
            }

            if (eventCode == null || eventCode.isBlank()) {
                throw new IllegalStateException("The site code can't be null or empty.");
            }

            return new TermsRequest(siteCode, eventCode);
        }
    }
}
