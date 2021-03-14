package com.example.targetcasestudy.model.response;

/**
 * @author vishnupriyaamara
 * @since 12/03/21.
 */

public class BaseResponse<T> {

  private String errorMessage;
  private String errorCode;
  private boolean success;
  private T data;

  public BaseResponse(boolean success, T data) {
    this.success = success;
    this.data = data;
  }

  public BaseResponse(String errorMessage, String errorCode, boolean success) {
    this.errorMessage = errorMessage;
    this.errorCode = errorCode;
    this.success = success;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
