package com.greenfox.chatapp.models;

public class JsonResponseError extends JsonResponse{
  String message;

  public JsonResponseError() {
  }

  public JsonResponseError(String message) {
    this.message = message;
  }

  public JsonResponseError(String status, String message) {
    super(status);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
