package com.greenfox.chatapp.models;

public abstract class Log {
  String path;
  String methodType;
  String dateAndTime;
  String logLevel;
  String requestData;
  String errorMessage;


  public Log() {
  }

  public Log(String path, String methodType, String dateAndTime, String logLevel, String requestData, String errorMessage) {
    this.path = path;
    this.methodType = methodType;
    this.dateAndTime = dateAndTime;
    this.logLevel = logLevel;
    this.requestData = requestData;
    this.errorMessage = errorMessage;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethodType() {
    return methodType;
  }

  public void setMethodType(String methodType) {
    this.methodType = methodType;
  }

  public String getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(String dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
