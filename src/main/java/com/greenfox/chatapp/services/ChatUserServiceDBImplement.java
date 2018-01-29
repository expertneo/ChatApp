package com.greenfox.chatapp.services;

import com.greenfox.chatapp.models.ChatUser;
import com.greenfox.chatapp.repositories.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChatUserServiceDBImplement implements ChatUserService {

  @Autowired
  ChatUserRepository chatUserRepository;

  @Override
  public List<ChatUser> getAllUsers() {
    List<ChatUser> chatUsers = new ArrayList<>();
    chatUserRepository.findAll().forEach(chatUsers::add);
    return chatUsers;
  }

  @Override
  public ChatUser getChatUserById(int id) {
    return chatUserRepository.findOne(id);
  }

  @Override
  public ChatUser createChatUser(ChatUser chatUser) {
    chatUserRepository.save(chatUser);
    return chatUserRepository.findByName(chatUser.getName());
  }

  @Override
  public void setChatUserName(int id, String input) {
    ChatUser chatUser = chatUserRepository.findOne(id);
    chatUser.setName(input);
    chatUserRepository.save(chatUser);
  }

  @Override
  public void deleteChatUser(int id) {
    chatUserRepository.delete(id);
  }

  @Override
  public ChatUser getChatUserByName(String name) {
    return chatUserRepository.findByName(name);
  }

  @Override
  public ChatUser logIn(ChatUser chatUser) {
    List<ChatUser> chatUsers = new ArrayList<>();
    chatUserRepository.findAll().forEach(chatUsers::add);
    for (int i = 0; i < chatUsers.size(); i++) {
      if (chatUsers.get(i).equals(chatUser)) {
        return chatUserRepository.findByName(chatUser.getName());
      }
    }
    chatUserRepository.save(chatUser);
    return chatUser;
  }
}
