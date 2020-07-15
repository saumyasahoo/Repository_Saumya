package com.prokarma.customer.consumer.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerInput
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-07-06T13:52:56.367Z")

public class CustomerInput {

  @NotNull
  @JsonProperty("address")
  private Address address = null;

  @NotNull
  @Pattern(regexp = "[0-9]{1,2}-[0-9]{2}-[0-9]{4}", message = "date shoud be dd-MM-yyyy format")
  @JsonProperty("birthdate")
  private String birthdate = null;

  @NotEmpty
  @JsonProperty("country")
  private String country = null;

  @NotEmpty
  @Size(min = 2, message = "must contain 2 digit")
  @JsonProperty("countryCode")
  private String countryCode = null;

  @NotEmpty
  @Pattern(regexp = "[A-Z][0-9]*", message = "must contain alpha numeric character example: C000000002")
  @Size(min = 10, message = "must contain alpha numeric and length should be 10")
  @JsonProperty("customerNumber")
  private String customerNumber = null;

  /**
   * Gets or Sets customerStatus
   */

  public enum CustomerStatusEnum {
    OPEN("OPEN"),

    CLOSE("CLOSE"),

    RESTORED("RESTORED"),

    SUSPENDED("SUSPENDED");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

  }

  @NotNull
  @JsonProperty("customerStatus")
  private CustomerStatusEnum customerStatus = null;

  @NotEmpty
  @Size(max = 50)
  @JsonProperty("email")
  private String email = null;

  @NotEmpty
  @Size(max = 50, min = 10)
  @JsonProperty("firstName")
  private String firstName = null;

  @NotEmpty
  @Size(max = 50, min = 10)
  @JsonProperty("lastName")
  private String lastName = null;

  @NotEmpty
  @Size(min = 10, message = "must contain 10 digit")
  @JsonProperty("mobileNumber")
  private String mobileNumber = null;


  /**
   * Get address
   * 
   * @return address
   **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  /**
   * Get birthdate
   * 
   * @return birthdate
   **/
  @ApiModelProperty(value = "")

  @Valid

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }


  /**
   * Get country
   * 
   * @return country
   **/
  @ApiModelProperty(value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  /**
   * Get countryCode
   * 
   * @return countryCode
   **/
  @ApiModelProperty(value = "")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }


  /**
   * Get customerId
   * 
   * @return customerId
   **/

  /**
   * Get customerNumber
   * 
   * @return customerNumber
   **/
  @ApiModelProperty(value = "")


  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }


  /**
   * Get customerStatus
   * 
   * @return customerStatus
   **/
  @ApiModelProperty(value = "")


  public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }


  /**
   * Get email
   * 
   * @return email
   **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  /**
   * Get firstName
   * 
   * @return firstName
   **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  /**
   * Get lastName
   * 
   * @return lastName
   **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  /**
   * Get mobileNumber
   * 
   * @return mobileNumber
   **/
  @ApiModelProperty(value = "")


  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerInfo {\n");

    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

