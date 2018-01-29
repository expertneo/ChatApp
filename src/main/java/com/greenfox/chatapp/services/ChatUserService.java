package com.greenfox.chatapp.services;

import com.greenfox.chatapp.models.ChatUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatUserService {
  List<ChatUser> getAllUsers();
  ChatUser getChatUserById(int id);
  ChatUser createChatUser(ChatUser chatUser);
  void setChatUserName(int id,String input);
  void deleteChatUser(int id);
  ChatUser getChatUserByName(String name);

  ChatUser logIn(ChatUser chatUser);
}
