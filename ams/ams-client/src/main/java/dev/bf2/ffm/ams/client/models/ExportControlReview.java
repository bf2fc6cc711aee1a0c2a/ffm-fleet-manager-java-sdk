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
 * ExportControlReview
 */
@JsonPropertyOrder({
  ExportControlReview.JSON_PROPERTY_RESTRICTED
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ExportControlReview {
  public static final String JSON_PROPERTY_RESTRICTED = "restricted";
  private Boolean restricted;

  public ExportControlReview() { 
  }

  public ExportControlReview restricted(Boolean restricted) {
    this.restricted = restricted;
    return this;
  }

   /**
   * Get restricted
   * @return restricted
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_RESTRICTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getRestricted() {
    return restricted;
  }


  @JsonProperty(JSON_PROPERTY_RESTRICTED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRestricted(Boolean restricted) {
    this.restricted = restricted;
  }


  /**
   * Return true if this ExportControlReview object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExportControlReview exportControlReview = (ExportControlReview) o;
    return Objects.equals(this.restricted, exportControlReview.restricted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restricted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExportControlReview {\n");
    sb.append("    restricted: ").append(toIndentedString(restricted)).append("\n");
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

