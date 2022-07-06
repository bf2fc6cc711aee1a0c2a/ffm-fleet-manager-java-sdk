package com.redhat.services.ffm.ams.core.models;

import java.util.Objects;

public class ResourceCreated {

    private final String id;

    protected ResourceCreated(String id) {
        this.id = id;
    }

    /**
     * Gets the id of the created resource.
     *
     * @return the id.
     */
    public String getId() {
        return id;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
         * @return the builder.
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
