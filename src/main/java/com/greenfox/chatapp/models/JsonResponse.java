package com.greenfox.chatapp.models;

public class JsonResponse {
  String status;

  public JsonResponse() {
  }

  public JsonResponse(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
