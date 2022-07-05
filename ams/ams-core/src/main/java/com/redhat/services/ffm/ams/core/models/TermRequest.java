package com.redhat.services.ffm.ams.core.models;

public class TermRequest {
    private final String siteCode;
    private final String eventCode;

    protected TermRequest(String siteCode, String eventCode) {
        this.siteCode = siteCode;
        this.eventCode = eventCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    /**
     * Builder for {@link TermRequest}.
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
         * @return the {@link TermRequest} instance.
         */
        public TermRequest build() {
            if (siteCode == null || siteCode.isBlank()) {
                throw new IllegalStateException("The site code can't be null or empty.");
            }

            if (eventCode == null || eventCode.isBlank()) {
                throw new IllegalStateException("The site code can't be null or empty.");
            }

            return new TermRequest(siteCode, eventCode);
        }
    }
}
