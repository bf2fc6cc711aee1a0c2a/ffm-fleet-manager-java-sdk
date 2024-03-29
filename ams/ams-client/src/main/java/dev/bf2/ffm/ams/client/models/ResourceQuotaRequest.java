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
 * ResourceQuotaRequest
 */
@JsonPropertyOrder({
  ResourceQuotaRequest.JSON_PROPERTY_SKU,
  ResourceQuotaRequest.JSON_PROPERTY_SKU_COUNT,
  ResourceQuotaRequest.JSON_PROPERTY_TYPE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ResourceQuotaRequest {
  public static final String JSON_PROPERTY_SKU = "sku";
  private String sku;

  public static final String JSON_PROPERTY_SKU_COUNT = "sku_count";
  private Integer skuCount;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    CONFIG("Config"),
    
    MANUAL("Manual"),
    
    SUBSCRIPTION("Subscription");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public ResourceQuotaRequest() { 
  }

  public ResourceQuotaRequest sku(String sku) {
    this.sku = sku;
    return this;
  }

   /**
   * Get sku
   * @return sku
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SKU)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSku() {
    return sku;
  }


  @JsonProperty(JSON_PROPERTY_SKU)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSku(String sku) {
    this.sku = sku;
  }


  public ResourceQuotaRequest skuCount(Integer skuCount) {
    this.skuCount = skuCount;
    return this;
  }

   /**
   * Get skuCount
   * @return skuCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SKU_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getSkuCount() {
    return skuCount;
  }


  @JsonProperty(JSON_PROPERTY_SKU_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSkuCount(Integer skuCount) {
    this.skuCount = skuCount;
  }


  public ResourceQuotaRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  /**
   * Return true if this ResourceQuotaRequest object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceQuotaRequest resourceQuotaRequest = (ResourceQuotaRequest) o;
    return Objects.equals(this.sku, resourceQuotaRequest.sku) &&
        Objects.equals(this.skuCount, resourceQuotaRequest.skuCount) &&
        Objects.equals(this.type, resourceQuotaRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, skuCount, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceQuotaRequest {\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    skuCount: ").append(toIndentedString(skuCount)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

