package com.greenfox.chatapp.models;

import javax.persistence.*;

@Entity
@Table
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int messageId;

  String text;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name = "idChatUser")
  private ChatUser chatUser;

  public Message() {
  }

  public Message(String text, ChatUser chatUser) {
    this.text = text;
    this.chatUser = chatUser;
  }

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public ChatUser getChatUser() {
    return chatUser;
  }

  public void setChatUser(ChatUser chatUser) {
    this.chatUser = chatUser;
  }
}
