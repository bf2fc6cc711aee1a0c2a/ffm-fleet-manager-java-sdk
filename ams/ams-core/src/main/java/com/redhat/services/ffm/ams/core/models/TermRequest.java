package com.redhat.services.ffm.ams.core.models;

public class TermRequest {
    private String siteCode;
    private String eventCode;

    public TermRequest(String siteCode, String eventCode) {
        this.siteCode = siteCode;
        this.eventCode = eventCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}
