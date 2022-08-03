package dev.bf2.ffm.ams.core;

import dev.bf2.ffm.ams.core.exceptions.CreationNotAllowedException;
import dev.bf2.ffm.ams.core.exceptions.TermsRequiredException;
import dev.bf2.ffm.ams.core.models.AccountInfo;
import dev.bf2.ffm.ams.core.models.CreateResourceRequest;
import dev.bf2.ffm.ams.core.models.ResourceCreated;
import io.smallrye.mutiny.Uni;

/**
 * Service to interact with Account Management Service.
 */
public interface AccountManagementService {

    /**
     * Creates a resource if the organization has available quotas on the Account Management Service.
     *
     * If the user has not accepted the available terms a {@link TermsRequiredException} is raised.
     * If the terms have been accepted but the user is not allowed to create the resource for whatever reason, a
     * {@link CreationNotAllowedException} is raised.
     * If the resource has been created successfully, an object that contains the id of the resource is returned.
     *
     * @param createResourceRequest
     * @return The created resource reference.
     */
    Uni<ResourceCreated> createResource(CreateResourceRequest createResourceRequest);

    /**
     * Deletes a resource by subscription id.
     *
     * @param resourceId
     * @return void.
     */
    Uni<Void> deleteResource(String resourceId);

    /**
     * Determine if the organization has available quota for a product.
     *
     * @param accountInfo
     * @return <code>true</code> if the organization has available quota, <code>false</code> otherwise.
     */
    Uni<Boolean> organizationHasAvailableQuota(AccountInfo accountInfo, String productId, String resourceName);
}
