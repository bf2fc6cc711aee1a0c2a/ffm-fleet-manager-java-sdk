package com.redhat.services.ffm.ams.core;

import com.redhat.services.ffm.ams.core.models.CreateResourceRequest;
import com.redhat.services.ffm.ams.core.models.ResourceCreated;

import io.smallrye.mutiny.Uni;

/**
 * Service to interact with Account Management Service.
 */
public interface AccountManagementService {

    /**
     * Creates a resource if the organization has available quotas on the Account Management Service.
     *
     * @param createResourceRequest
     * @return The created resource reference.
     */
    Uni<ResourceCreated> createResource(CreateResourceRequest createResourceRequest);

}
