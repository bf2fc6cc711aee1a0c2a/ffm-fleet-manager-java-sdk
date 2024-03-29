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
import dev.bf2.ffm.ams.client.models.SelfServiceLandingPageSchemaConfigTryLearn;
import dev.bf2.ffm.ams.client.models.SelfServiceLandingPageSchemaEstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SelfServiceLandingPageSchema
 */
@JsonPropertyOrder({
  SelfServiceLandingPageSchema.JSON_PROPERTY_CONFIG_TRY_LEARN,
  SelfServiceLandingPageSchema.JSON_PROPERTY_ESTATE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class SelfServiceLandingPageSchema {
  public static final String JSON_PROPERTY_CONFIG_TRY_LEARN = "configTryLearn";
  private SelfServiceLandingPageSchemaConfigTryLearn configTryLearn;

  public static final String JSON_PROPERTY_ESTATE = "estate";
  private SelfServiceLandingPageSchemaEstate estate;

  public SelfServiceLandingPageSchema() { 
  }

  public SelfServiceLandingPageSchema configTryLearn(SelfServiceLandingPageSchemaConfigTryLearn configTryLearn) {
    this.configTryLearn = configTryLearn;
    return this;
  }

   /**
   * Get configTryLearn
   * @return configTryLearn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONFIG_TRY_LEARN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SelfServiceLandingPageSchemaConfigTryLearn getConfigTryLearn() {
    return configTryLearn;
  }


  @JsonProperty(JSON_PROPERTY_CONFIG_TRY_LEARN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConfigTryLearn(SelfServiceLandingPageSchemaConfigTryLearn configTryLearn) {
    this.configTryLearn = configTryLearn;
  }


  public SelfServiceLandingPageSchema estate(SelfServiceLandingPageSchemaEstate estate) {
    this.estate = estate;
    return this;
  }

   /**
   * Get estate
   * @return estate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ESTATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SelfServiceLandingPageSchemaEstate getEstate() {
    return estate;
  }


  @JsonProperty(JSON_PROPERTY_ESTATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEstate(SelfServiceLandingPageSchemaEstate estate) {
    this.estate = estate;
  }


  /**
   * Return true if this SelfServiceLandingPageSchema object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SelfServiceLandingPageSchema selfServiceLandingPageSchema = (SelfServiceLandingPageSchema) o;
    return Objects.equals(this.configTryLearn, selfServiceLandingPageSchema.configTryLearn) &&
        Objects.equals(this.estate, selfServiceLandingPageSchema.estate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configTryLearn, estate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SelfServiceLandingPageSchema {\n");
    sb.append("    configTryLearn: ").append(toIndentedString(configTryLearn)).append("\n");
    sb.append("    estate: ").append(toIndentedString(estate)).append("\n");
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

