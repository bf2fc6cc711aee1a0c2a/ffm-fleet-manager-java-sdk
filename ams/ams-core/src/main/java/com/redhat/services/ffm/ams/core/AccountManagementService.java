package com.redhat.services.ffm.ams.core;

import com.redhat.services.ffm.ams.core.models.CreateResourceRequest;
import com.redhat.services.ffm.ams.core.models.ResourceCreated;

import io.smallrye.mutiny.Uni;

public interface AccountManagementService {

    Uni<ResourceCreated> createResource(CreateResourceRequest createResourceRequest);

}
