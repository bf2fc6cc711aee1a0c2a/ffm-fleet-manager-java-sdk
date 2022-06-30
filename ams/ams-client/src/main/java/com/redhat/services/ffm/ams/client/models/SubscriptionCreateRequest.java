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


package com.redhat.services.ffm.ams.client.models;

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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SubscriptionCreateRequest
 */
@JsonPropertyOrder({
  SubscriptionCreateRequest.JSON_PROPERTY_CLUSTER_UUID,
  SubscriptionCreateRequest.JSON_PROPERTY_CONSOLE_URL,
  SubscriptionCreateRequest.JSON_PROPERTY_DISPLAY_NAME,
  SubscriptionCreateRequest.JSON_PROPERTY_PLAN_ID,
  SubscriptionCreateRequest.JSON_PROPERTY_STATUS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SubscriptionCreateRequest {
  public static final String JSON_PROPERTY_CLUSTER_UUID = "cluster_uuid";
  private String clusterUuid;

  public static final String JSON_PROPERTY_CONSOLE_URL = "console_url";
  private String consoleUrl;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "display_name";
  private String displayName;

  /**
   * Gets or Sets planId
   */
  public enum PlanIdEnum {
    OCP("OCP");

    private String value;

    PlanIdEnum(String value) {
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
    public static PlanIdEnum fromValue(String value) {
      for (PlanIdEnum b : PlanIdEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PLAN_ID = "plan_id";
  private PlanIdEnum planId;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    DISCONNECTED("Disconnected");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public SubscriptionCreateRequest() { 
  }

  public SubscriptionCreateRequest clusterUuid(String clusterUuid) {
    this.clusterUuid = clusterUuid;
    return this;
  }

   /**
   * Get clusterUuid
   * @return clusterUuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CLUSTER_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getClusterUuid() {
    return clusterUuid;
  }


  @JsonProperty(JSON_PROPERTY_CLUSTER_UUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClusterUuid(String clusterUuid) {
    this.clusterUuid = clusterUuid;
  }


  public SubscriptionCreateRequest consoleUrl(String consoleUrl) {
    this.consoleUrl = consoleUrl;
    return this;
  }

   /**
   * Get consoleUrl
   * @return consoleUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONSOLE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getConsoleUrl() {
    return consoleUrl;
  }


  @JsonProperty(JSON_PROPERTY_CONSOLE_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConsoleUrl(String consoleUrl) {
    this.consoleUrl = consoleUrl;
  }


  public SubscriptionCreateRequest displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public SubscriptionCreateRequest planId(PlanIdEnum planId) {
    this.planId = planId;
    return this;
  }

   /**
   * Get planId
   * @return planId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PlanIdEnum getPlanId() {
    return planId;
  }


  @JsonProperty(JSON_PROPERTY_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPlanId(PlanIdEnum planId) {
    this.planId = planId;
  }


  public SubscriptionCreateRequest status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StatusEnum getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  /**
   * Return true if this SubscriptionCreateRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionCreateRequest subscriptionCreateRequest = (SubscriptionCreateRequest) o;
    return Objects.equals(this.clusterUuid, subscriptionCreateRequest.clusterUuid) &&
        Objects.equals(this.consoleUrl, subscriptionCreateRequest.consoleUrl) &&
        Objects.equals(this.displayName, subscriptionCreateRequest.displayName) &&
        Objects.equals(this.planId, subscriptionCreateRequest.planId) &&
        Objects.equals(this.status, subscriptionCreateRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusterUuid, consoleUrl, displayName, planId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionCreateRequest {\n");
    sb.append("    clusterUuid: ").append(toIndentedString(clusterUuid)).append("\n");
    sb.append("    consoleUrl: ").append(toIndentedString(consoleUrl)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

