package com.redhat.services.ffm.ams.core.models;

public class ResourceCreated {

    private final String id;

    protected ResourceCreated(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Builder for {@link ResourceCreated}.
     */
    public static class Builder {

        private String id;

        public Builder() {
        }

        /**
         * Sets the id of the created resource in the builder.
         *
         * @param id
         * @return
         */
        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        /**
         * Builds the ResourceCreated.
         *
         * @return the {@link ResourceCreated} instance.
         */
        public ResourceCreated build() {
            return new ResourceCreated(id);
        }
    }
}
