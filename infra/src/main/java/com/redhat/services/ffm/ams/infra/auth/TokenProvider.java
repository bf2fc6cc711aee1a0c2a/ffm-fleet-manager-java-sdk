package com.redhat.services.ffm.ams.infra.auth;

public interface TokenProvider {
    String getName();

    String getToken();
}
