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
import dev.bf2.ffm.ams.client.models.SkuRulesAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SkuRules
 */
@JsonPropertyOrder({
  SkuRules.JSON_PROPERTY_HREF,
  SkuRules.JSON_PROPERTY_ID,
  SkuRules.JSON_PROPERTY_KIND,
  SkuRules.JSON_PROPERTY_ALLOWED,
  SkuRules.JSON_PROPERTY_QUOTA_ID,
  SkuRules.JSON_PROPERTY_SKU
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SkuRules {
  public static final String JSON_PROPERTY_HREF = "href";
  private String href;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_KIND = "kind";
  private String kind;

  public static final String JSON_PROPERTY_ALLOWED = "allowed";
  private Integer allowed;

  public static final String JSON_PROPERTY_QUOTA_ID = "quota_id";
  private String quotaId;

  public static final String JSON_PROPERTY_SKU = "sku";
  private String sku;

  public SkuRules() { 
  }

  public SkuRules href(String href) {
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


  public SkuRules id(String id) {
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


  public SkuRules kind(String kind) {
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


  public SkuRules allowed(Integer allowed) {
    this.allowed = allowed;
    return this;
  }

   /**
   * Get allowed
   * @return allowed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ALLOWED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAllowed() {
    return allowed;
  }


  @JsonProperty(JSON_PROPERTY_ALLOWED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAllowed(Integer allowed) {
    this.allowed = allowed;
  }


  public SkuRules quotaId(String quotaId) {
    this.quotaId = quotaId;
    return this;
  }

   /**
   * Get quotaId
   * @return quotaId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_QUOTA_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getQuotaId() {
    return quotaId;
  }


  @JsonProperty(JSON_PROPERTY_QUOTA_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQuotaId(String quotaId) {
    this.quotaId = quotaId;
  }


  public SkuRules sku(String sku) {
    this.sku = sku;
    return this;
  }

   /**
   * Get sku
   * @return sku
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SKU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSku() {
    return sku;
  }


  @JsonProperty(JSON_PROPERTY_SKU)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSku(String sku) {
    this.sku = sku;
  }


  /**
   * Return true if this SkuRules object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SkuRules skuRules = (SkuRules) o;
    return Objects.equals(this.href, skuRules.href) &&
        Objects.equals(this.id, skuRules.id) &&
        Objects.equals(this.kind, skuRules.kind) &&
        Objects.equals(this.allowed, skuRules.allowed) &&
        Objects.equals(this.quotaId, skuRules.quotaId) &&
        Objects.equals(this.sku, skuRules.sku);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, kind, allowed, quotaId, sku);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SkuRules {\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
    sb.append("    quotaId: ").append(toIndentedString(quotaId)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
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

