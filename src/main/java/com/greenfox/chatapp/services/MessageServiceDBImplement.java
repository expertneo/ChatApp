package com.greenfox.chatapp.services;

import com.greenfox.chatapp.models.ChatUser;
import com.greenfox.chatapp.models.Message;
import com.greenfox.chatapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MessageServiceDBImplement implements MessageService {

  @Autowired
  MessageRepository messageRepository;

  @Override
  public List<Message> getAllMessages() {
    List<Message> messages = new ArrayList<>();
    messageRepository.findAll().forEach(messages::add);
    return messages;
  }

  @Override
  public Message getMessageById(int id) {
    return messageRepository.findOne(id);
  }

  @Override
  public Message createMessage(Message message) {
    return messageRepository.save(message);
  }

  @Override
  public void setMessageText(int id, String input) {
    Message message = messageRepository.findOne(id);
    message.setText(input);
    messageRepository.save(message);
  }

  @Override
  public void deleteMessage(int id) {
    messageRepository.delete(id);
  }

  @Override
  public List<Message> getMessageByUser(ChatUser chatUser) {
    List<Message> messagesForTheUser = new ArrayList<>();
    List<Message> fullList = new ArrayList<>();
    messageRepository.findAll().forEach(fullList::add);
    for (int i = 0; i < fullList.size(); i++) {
      if (fullList.get(i).getChatUser().equals(chatUser)) {
        messagesForTheUser.add(fullList.get(i));
      }
    }
    return messagesForTheUser;
  }
}
