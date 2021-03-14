package com.example.targetcasestudy;

import com.example.targetcasestudy.entity.Error;

/**
 * @author vishnupriyaamara
 * @since 13/03/21.
 */

public class BusinessException extends RuntimeException {

  private Error error;

  public BusinessException(Error errorCode) {
    this.error = errorCode;
  }

  public String getCode() {
    return this.error.getCode();
  }

  @Override
  public String getMessage() {
    return this.error.getMessage();
  }
}
