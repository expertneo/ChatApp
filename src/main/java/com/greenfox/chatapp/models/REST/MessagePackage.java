package com.greenfox.chatapp.models.REST;

import com.greenfox.chatapp.models.Message;

public class MessagePackage {
  Message message;
  Client client;

  public MessagePackage() {
  }

  public MessagePackage(Message message, Client client) {
    this.message = message;
    this.client = client;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
