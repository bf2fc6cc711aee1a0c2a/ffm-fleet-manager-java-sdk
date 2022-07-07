package com.redhat.services.ffm.ams.core.models;

import java.util.Objects;

public class ResourceCreated {

    private final String subscriptionId;

    protected ResourceCreated(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the id of the created resource.
     *
     * @return the subscription id.
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResourceCreated that = (ResourceCreated) o;
        return Objects.equals(subscriptionId, that.subscriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId);
    }

    /**
     * Builder for {@link ResourceCreated}.
     */
    public static class Builder {

        private String subscriptionId;

        public Builder() {
        }

        /**
         * Sets the subscriptionId of the created resource in the builder.
         *
         * @param subscriptionId
         * @return the builder.
         */
        public Builder withSubscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        /**
         * Builds the ResourceCreated.
         *
         * @return the {@link ResourceCreated} instance.
         */
        public ResourceCreated build() {
            return new ResourceCreated(subscriptionId);
        }
    }
}
