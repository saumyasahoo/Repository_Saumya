package com.prokarma.customer.consumer.util;

public class MaskString {

  private MaskString() {
    // not to be instantiate this class using constructor
  }

  public static String mask(String strText, int start, int end) {
    char maskChar='*';
    int maskLength = end - start;
    StringBuilder sbMaskString = new StringBuilder(maskLength);
  
    for (int i = 0; i < maskLength; i++) {
      sbMaskString.append(maskChar);
    }

    return strText.substring(0, start) + sbMaskString.toString()
        + strText.substring(start + maskLength);
  }

}
