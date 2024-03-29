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
import dev.bf2.ffm.ams.client.models.ExcessResourceAllOf;
import dev.bf2.ffm.ams.client.models.ObjectReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ExcessResource
 */
@JsonPropertyOrder({
  ExcessResource.JSON_PROPERTY_HREF,
  ExcessResource.JSON_PROPERTY_ID,
  ExcessResource.JSON_PROPERTY_KIND,
  ExcessResource.JSON_PROPERTY_AVAILABILITY_ZONE_TYPE,
  ExcessResource.JSON_PROPERTY_BILLING_MODEL,
  ExcessResource.JSON_PROPERTY_BYOC,
  ExcessResource.JSON_PROPERTY_COUNT,
  ExcessResource.JSON_PROPERTY_RESOURCE_NAME,
  ExcessResource.JSON_PROPERTY_RESOURCE_TYPE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ExcessResource {
  public static final String JSON_PROPERTY_HREF = "href";
  private String href;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_KIND = "kind";
  private String kind;

  public static final String JSON_PROPERTY_AVAILABILITY_ZONE_TYPE = "availability_zone_type";
  private String availabilityZoneType;

  public static final String JSON_PROPERTY_BILLING_MODEL = "billing_model";
  private String billingModel;

  public static final String JSON_PROPERTY_BYOC = "byoc";
  private Boolean byoc;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_RESOURCE_NAME = "resource_name";
  private String resourceName;

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resource_type";
  private String resourceType;

  public ExcessResource() { 
  }

  public ExcessResource href(String href) {
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


  public ExcessResource id(String id) {
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


  public ExcessResource kind(String kind) {
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


  public ExcessResource availabilityZoneType(String availabilityZoneType) {
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


  public ExcessResource billingModel(String billingModel) {
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


  public ExcessResource byoc(Boolean byoc) {
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


  public ExcessResource count(Integer count) {
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


  public ExcessResource resourceName(String resourceName) {
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


  public ExcessResource resourceType(String resourceType) {
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


  /**
   * Return true if this ExcessResource object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExcessResource excessResource = (ExcessResource) o;
    return Objects.equals(this.href, excessResource.href) &&
        Objects.equals(this.id, excessResource.id) &&
        Objects.equals(this.kind, excessResource.kind) &&
        Objects.equals(this.availabilityZoneType, excessResource.availabilityZoneType) &&
        Objects.equals(this.billingModel, excessResource.billingModel) &&
        Objects.equals(this.byoc, excessResource.byoc) &&
        Objects.equals(this.count, excessResource.count) &&
        Objects.equals(this.resourceName, excessResource.resourceName) &&
        Objects.equals(this.resourceType, excessResource.resourceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, kind, availabilityZoneType, billingModel, byoc, count, resourceName, resourceType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExcessResource {\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    availabilityZoneType: ").append(toIndentedString(availabilityZoneType)).append("\n");
    sb.append("    billingModel: ").append(toIndentedString(billingModel)).append("\n");
    sb.append("    byoc: ").append(toIndentedString(byoc)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
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

