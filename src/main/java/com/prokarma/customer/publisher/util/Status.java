package com.prokarma.customer.publisher.util;

public enum Status {

  FAILURE("error"), SUCCESS("success"), MESSAGE_PUBLISHED(
      "Customerinfo published successfully"), MESSAGE_PUBLISHED_FAILED("Customerinfo published failed"),GENERIC_EXCEPTION("Generic exception");

  private String value;

  private Status(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
