package com.greenfox.chatapp.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class ChatUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int idChatUser;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "chatUser")
  private List<Message> messages = new ArrayList<>();

  private String name;

  public ChatUser() {
  }

  public ChatUser(List<Message> messages, String name) {
    this.messages = messages;
    this.name = name;
  }

  public int getIdChatUser() {
    return idChatUser;
  }

  public void setIdChatUser(int idChatUser) {
    this.idChatUser = idChatUser;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    ChatUser otherChatUser = (ChatUser) obj;
    return this.name.equals(otherChatUser.name);
  }

  public boolean valid() {
    if (this.name.isEmpty() || this.name.equals(null)) {
      return true;
    }
    return false;
  }
}
