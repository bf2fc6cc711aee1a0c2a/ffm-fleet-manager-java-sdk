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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ResourceReview
 */
@JsonPropertyOrder({
  ResourceReview.JSON_PROPERTY_ACCOUNT_USERNAME,
  ResourceReview.JSON_PROPERTY_ACTION,
  ResourceReview.JSON_PROPERTY_CLUSTER_IDS,
  ResourceReview.JSON_PROPERTY_CLUSTER_UUIDS,
  ResourceReview.JSON_PROPERTY_ORGANIZATION_IDS,
  ResourceReview.JSON_PROPERTY_RESOURCE_TYPE,
  ResourceReview.JSON_PROPERTY_SUBSCRIPTION_IDS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ResourceReview {
  public static final String JSON_PROPERTY_ACCOUNT_USERNAME = "account_username";
  private String accountUsername;

  /**
   * Gets or Sets action
   */
  public enum ActionEnum {
    GET("get"),
    
    LIST("list"),
    
    CREATE("create"),
    
    DELETE("delete"),
    
    UPDATE("update");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ActionEnum fromValue(String value) {
      for (ActionEnum b : ActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ACTION = "action";
  private ActionEnum action;

  public static final String JSON_PROPERTY_CLUSTER_IDS = "cluster_ids";
  private List<String> clusterIds = new ArrayList<>();

  public static final String JSON_PROPERTY_CLUSTER_UUIDS = "cluster_uuids";
  private List<String> clusterUuids = new ArrayList<>();

  public static final String JSON_PROPERTY_ORGANIZATION_IDS = "organization_ids";
  private List<String> organizationIds = new ArrayList<>();

  /**
   * Gets or Sets resourceType
   */
  public enum ResourceTypeEnum {
    CLUSTER("Cluster"),
    
    SUBSCRIPTION("Subscription");

    private String value;

    ResourceTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResourceTypeEnum fromValue(String value) {
      for (ResourceTypeEnum b : ResourceTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
  private ResourceTypeEnum resourceType;

  public static final String JSON_PROPERTY_SUBSCRIPTION_IDS = "subscription_ids";
  private List<String> subscriptionIds = new ArrayList<>();

  public ResourceReview() { 
  }

  public ResourceReview accountUsername(String accountUsername) {
    this.accountUsername = accountUsername;
    return this;
  }

   /**
   * Get accountUsername
   * @return accountUsername
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACCOUNT_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccountUsername() {
    return accountUsername;
  }


  @JsonProperty(JSON_PROPERTY_ACCOUNT_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccountUsername(String accountUsername) {
    this.accountUsername = accountUsername;
  }


  public ResourceReview action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ActionEnum getAction() {
    return action;
  }


  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAction(ActionEnum action) {
    this.action = action;
  }


  public ResourceReview clusterIds(List<String> clusterIds) {
    this.clusterIds = clusterIds;
    return this;
  }

  public ResourceReview addClusterIdsItem(String clusterIdsItem) {
    this.clusterIds.add(clusterIdsItem);
    return this;
  }

   /**
   * Get clusterIds
   * @return clusterIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CLUSTER_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getClusterIds() {
    return clusterIds;
  }


  @JsonProperty(JSON_PROPERTY_CLUSTER_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClusterIds(List<String> clusterIds) {
    this.clusterIds = clusterIds;
  }


  public ResourceReview clusterUuids(List<String> clusterUuids) {
    this.clusterUuids = clusterUuids;
    return this;
  }

  public ResourceReview addClusterUuidsItem(String clusterUuidsItem) {
    this.clusterUuids.add(clusterUuidsItem);
    return this;
  }

   /**
   * Get clusterUuids
   * @return clusterUuids
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CLUSTER_UUIDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getClusterUuids() {
    return clusterUuids;
  }


  @JsonProperty(JSON_PROPERTY_CLUSTER_UUIDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClusterUuids(List<String> clusterUuids) {
    this.clusterUuids = clusterUuids;
  }


  public ResourceReview organizationIds(List<String> organizationIds) {
    this.organizationIds = organizationIds;
    return this;
  }

  public ResourceReview addOrganizationIdsItem(String organizationIdsItem) {
    this.organizationIds.add(organizationIdsItem);
    return this;
  }

   /**
   * Get organizationIds
   * @return organizationIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ORGANIZATION_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getOrganizationIds() {
    return organizationIds;
  }


  @JsonProperty(JSON_PROPERTY_ORGANIZATION_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOrganizationIds(List<String> organizationIds) {
    this.organizationIds = organizationIds;
  }


  public ResourceReview resourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResourceTypeEnum getResourceType() {
    return resourceType;
  }


  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
  }


  public ResourceReview subscriptionIds(List<String> subscriptionIds) {
    this.subscriptionIds = subscriptionIds;
    return this;
  }

  public ResourceReview addSubscriptionIdsItem(String subscriptionIdsItem) {
    this.subscriptionIds.add(subscriptionIdsItem);
    return this;
  }

   /**
   * Get subscriptionIds
   * @return subscriptionIds
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getSubscriptionIds() {
    return subscriptionIds;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubscriptionIds(List<String> subscriptionIds) {
    this.subscriptionIds = subscriptionIds;
  }


  /**
   * Return true if this ResourceReview object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceReview resourceReview = (ResourceReview) o;
    return Objects.equals(this.accountUsername, resourceReview.accountUsername) &&
        Objects.equals(this.action, resourceReview.action) &&
        Objects.equals(this.clusterIds, resourceReview.clusterIds) &&
        Objects.equals(this.clusterUuids, resourceReview.clusterUuids) &&
        Objects.equals(this.organizationIds, resourceReview.organizationIds) &&
        Objects.equals(this.resourceType, resourceReview.resourceType) &&
        Objects.equals(this.subscriptionIds, resourceReview.subscriptionIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountUsername, action, clusterIds, clusterUuids, organizationIds, resourceType, subscriptionIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceReview {\n");
    sb.append("    accountUsername: ").append(toIndentedString(accountUsername)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    clusterIds: ").append(toIndentedString(clusterIds)).append("\n");
    sb.append("    clusterUuids: ").append(toIndentedString(clusterUuids)).append("\n");
    sb.append("    organizationIds: ").append(toIndentedString(organizationIds)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    subscriptionIds: ").append(toIndentedString(subscriptionIds)).append("\n");
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

