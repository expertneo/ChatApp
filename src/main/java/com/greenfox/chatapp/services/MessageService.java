package com.greenfox.chatapp.services;

import com.greenfox.chatapp.models.ChatUser;
import com.greenfox.chatapp.models.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
  List<Message> getAllMessages();
  Message getMessageById(int id);
  Message createMessage(Message message);
  void setMessageText(int id,String input);
  void deleteMessage(int id);
  List<Message> getMessageByUser(ChatUser chatUser);
}
