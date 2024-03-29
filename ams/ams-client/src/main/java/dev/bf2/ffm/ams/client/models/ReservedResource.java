/*
 * Account Management Service API
 * Manage user subscriptions and clusters
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package dev.bf2.ffm.ams.client.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import dev.bf2.ffm.ams.client.models.ObjectReference;
import dev.bf2.ffm.ams.client.models.ReservedResourceAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ReservedResource
 */
@JsonPropertyOrder({
  ReservedResource.JSON_PROPERTY_HREF,
  ReservedResource.JSON_PROPERTY_ID,
  ReservedResource.JSON_PROPERTY_KIND,
  ReservedResource.JSON_PROPERTY_AVAILABILITY_ZONE_TYPE,
  ReservedResource.JSON_PROPERTY_BILLING_MARKETPLACE_ACCOUNT,
  ReservedResource.JSON_PROPERTY_BILLING_MODEL,
  ReservedResource.JSON_PROPERTY_BYOC,
  ReservedResource.JSON_PROPERTY_CLUSTER,
  ReservedResource.JSON_PROPERTY_COUNT,
  ReservedResource.JSON_PROPERTY_CREATED_AT,
  ReservedResource.JSON_PROPERTY_RESOURCE_NAME,
  ReservedResource.JSON_PROPERTY_RESOURCE_TYPE,
  ReservedResource.JSON_PROPERTY_SUBSCRIPTION,
  ReservedResource.JSON_PROPERTY_UPDATED_AT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ReservedResource {
  public static final String JSON_PROPERTY_HREF = "href";
  private String href;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_KIND = "kind";
  private String kind;

  public static final String JSON_PROPERTY_AVAILABILITY_ZONE_TYPE = "availability_zone_type";
  private String availabilityZoneType;

  public static final String JSON_PROPERTY_BILLING_MARKETPLACE_ACCOUNT = "billing_marketplace_account";
  private String billingMarketplaceAccount;

  public static final String JSON_PROPERTY_BILLING_MODEL = "billing_model";
  private String billingModel;

  public static final String JSON_PROPERTY_BYOC = "byoc";
  private Boolean byoc;

  public static final String JSON_PROPERTY_CLUSTER = "cluster";
  private Boolean cluster;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_RESOURCE_NAME = "resource_name";
  private String resourceName;

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
  private String resourceType;

  public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";
  private ObjectReference subscription;

  public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
  private OffsetDateTime updatedAt;

  public ReservedResource() { 
  }

  public ReservedResource href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Get href
   * @return href
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHref() {
    return href;
  }


  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHref(String href) {
    this.href = href;
  }


  public ReservedResource id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public ReservedResource kind(String kind) {
    this.kind = kind;
    return this;
  }

   /**
   * Get kind
   * @return kind
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKind() {
    return kind;
  }


  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKind(String kind) {
    this.kind = kind;
  }


  public ReservedResource availabilityZoneType(String availabilityZoneType) {
    this.availabilityZoneType = availabilityZoneType;
    return this;
  }

   /**
   * Get availabilityZoneType
   * @return availabilityZoneType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_AVAILABILITY_ZONE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAvailabilityZoneType() {
    return availabilityZoneType;
  }


  @JsonProperty(JSON_PROPERTY_AVAILABILITY_ZONE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAvailabilityZoneType(String availabilityZoneType) {
    this.availabilityZoneType = availabilityZoneType;
  }


  public ReservedResource billingMarketplaceAccount(String billingMarketplaceAccount) {
    this.billingMarketplaceAccount = billingMarketplaceAccount;
    return this;
  }

   /**
   * Get billingMarketplaceAccount
   * @return billingMarketplaceAccount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BILLING_MARKETPLACE_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBillingMarketplaceAccount() {
    return billingMarketplaceAccount;
  }


  @JsonProperty(JSON_PROPERTY_BILLING_MARKETPLACE_ACCOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBillingMarketplaceAccount(String billingMarketplaceAccount) {
    this.billingMarketplaceAccount = billingMarketplaceAccount;
  }


  public ReservedResource billingModel(String billingModel) {
    this.billingModel = billingModel;
    return this;
  }

   /**
   * Get billingModel
   * @return billingModel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BILLING_MODEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBillingModel() {
    return billingModel;
  }


  @JsonProperty(JSON_PROPERTY_BILLING_MODEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBillingModel(String billingModel) {
    this.billingModel = billingModel;
  }


  public ReservedResource byoc(Boolean byoc) {
    this.byoc = byoc;
    return this;
  }

   /**
   * Get byoc
   * @return byoc
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_BYOC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getByoc() {
    return byoc;
  }


  @JsonProperty(JSON_PROPERTY_BYOC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setByoc(Boolean byoc) {
    this.byoc = byoc;
  }


  public ReservedResource cluster(Boolean cluster) {
    this.cluster = cluster;
    return this;
  }

   /**
   * Get cluster
   * @return cluster
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CLUSTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getCluster() {
    return cluster;
  }


  @JsonProperty(JSON_PROPERTY_CLUSTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCluster(Boolean cluster) {
    this.cluster = cluster;
  }


  public ReservedResource count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCount() {
    return count;
  }


  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCount(Integer count) {
    this.count = count;
  }


  public ReservedResource createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }


  public ReservedResource resourceName(String resourceName) {
    this.resourceName = resourceName;
    return this;
  }

   /**
   * Get resourceName
   * @return resourceName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResourceName() {
    return resourceName;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }


  public ReservedResource resourceType(String resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResourceType() {
    return resourceType;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }


  public ReservedResource subscription(ObjectReference subscription) {
    this.subscription = subscription;
    return this;
  }

   /**
   * Get subscription
   * @return subscription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ObjectReference getSubscription() {
    return subscription;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubscription(ObjectReference subscription) {
    this.subscription = subscription;
  }


  public ReservedResource updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }


  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  /**
   * Return true if this ReservedResource object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservedResource reservedResource = (ReservedResource) o;
    return Objects.equals(this.href, reservedResource.href) &&
        Objects.equals(this.id, reservedResource.id) &&
        Objects.equals(this.kind, reservedResource.kind) &&
        Objects.equals(this.availabilityZoneType, reservedResource.availabilityZoneType) &&
        Objects.equals(this.billingMarketplaceAccount, reservedResource.billingMarketplaceAccount) &&
        Objects.equals(this.billingModel, reservedResource.billingModel) &&
        Objects.equals(this.byoc, reservedResource.byoc) &&
        Objects.equals(this.cluster, reservedResource.cluster) &&
        Objects.equals(this.count, reservedResource.count) &&
        Objects.equals(this.createdAt, reservedResource.createdAt) &&
        Objects.equals(this.resourceName, reservedResource.resourceName) &&
        Objects.equals(this.resourceType, reservedResource.resourceType) &&
        Objects.equals(this.subscription, reservedResource.subscription) &&
        Objects.equals(this.updatedAt, reservedResource.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, kind, availabilityZoneType, billingMarketplaceAccount, billingModel, byoc, cluster, count, createdAt, resourceName, resourceType, subscription, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservedResource {\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    availabilityZoneType: ").append(toIndentedString(availabilityZoneType)).append("\n");
    sb.append("    billingMarketplaceAccount: ").append(toIndentedString(billingMarketplaceAccount)).append("\n");
    sb.append("    billingModel: ").append(toIndentedString(billingModel)).append("\n");
    sb.append("    byoc: ").append(toIndentedString(byoc)).append("\n");
    sb.append("    cluster: ").append(toIndentedString(cluster)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

