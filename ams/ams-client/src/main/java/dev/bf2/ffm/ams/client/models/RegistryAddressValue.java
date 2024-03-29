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
 * RegistryAddressValue
 */
@JsonPropertyOrder({
  RegistryAddressValue.JSON_PROPERTY_AUTH,
  RegistryAddressValue.JSON_PROPERTY_EMAIL
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RegistryAddressValue {
  public static final String JSON_PROPERTY_AUTH = "auth";
  private String auth;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public RegistryAddressValue() { 
  }

  public RegistryAddressValue auth(String auth) {
    this.auth = auth;
    return this;
  }

   /**
   * Get auth
   * @return auth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_AUTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAuth() {
    return auth;
  }


  @JsonProperty(JSON_PROPERTY_AUTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAuth(String auth) {
    this.auth = auth;
  }


  public RegistryAddressValue email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmail(String email) {
    this.email = email;
  }


  /**
   * Return true if this RegistryAddress_value object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistryAddressValue registryAddressValue = (RegistryAddressValue) o;
    return Objects.equals(this.auth, registryAddressValue.auth) &&
        Objects.equals(this.email, registryAddressValue.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(auth, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistryAddressValue {\n");
    sb.append("    auth: ").append(toIndentedString(auth)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

