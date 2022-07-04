package com.redhat.services.ffm.ams.core;

import com.redhat.services.ffm.ams.core.models.CreateResourceRequest;

import io.smallrye.mutiny.Uni;

public interface AccountManagementService {

    Uni<String> createResource(CreateResourceRequest createResourceRequest);

}
