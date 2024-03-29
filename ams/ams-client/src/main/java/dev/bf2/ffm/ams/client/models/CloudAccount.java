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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CloudAccount
 */
@JsonPropertyOrder({
  CloudAccount.JSON_PROPERTY_CLOUD_ACCOUNT_ID,
  CloudAccount.JSON_PROPERTY_CLOUD_PROVIDER_ID
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CloudAccount {
  public static final String JSON_PROPERTY_CLOUD_ACCOUNT_ID = "cloud_account_id";
  private String cloudAccountId;

  public static final String JSON_PROPERTY_CLOUD_PROVIDER_ID = "cloud_provider_id";
  private String cloudProviderId;

  public CloudAccount() { 
  }

  public CloudAccount cloudAccountId(String cloudAccountId) {
    this.cloudAccountId = cloudAccountId;
    return this;
  }

   /**
   * Get cloudAccountId
   * @return cloudAccountId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CLOUD_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCloudAccountId() {
    return cloudAccountId;
  }


  @JsonProperty(JSON_PROPERTY_CLOUD_ACCOUNT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCloudAccountId(String cloudAccountId) {
    this.cloudAccountId = cloudAccountId;
  }


  public CloudAccount cloudProviderId(String cloudProviderId) {
    this.cloudProviderId = cloudProviderId;
    return this;
  }

   /**
   * Get cloudProviderId
   * @return cloudProviderId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CLOUD_PROVIDER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCloudProviderId() {
    return cloudProviderId;
  }


  @JsonProperty(JSON_PROPERTY_CLOUD_PROVIDER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCloudProviderId(String cloudProviderId) {
    this.cloudProviderId = cloudProviderId;
  }


  /**
   * Return true if this CloudAccount object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloudAccount cloudAccount = (CloudAccount) o;
    return Objects.equals(this.cloudAccountId, cloudAccount.cloudAccountId) &&
        Objects.equals(this.cloudProviderId, cloudAccount.cloudProviderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudAccountId, cloudProviderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloudAccount {\n");
    sb.append("    cloudAccountId: ").append(toIndentedString(cloudAccountId)).append("\n");
    sb.append("    cloudProviderId: ").append(toIndentedString(cloudProviderId)).append("\n");
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

