package com.greenfox.chatapp.controllers;

import com.greenfox.chatapp.models.*;
import com.greenfox.chatapp.models.REST.MessagePackage;
import com.greenfox.chatapp.services.ChatUserService;
import com.greenfox.chatapp.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class RestController {

  @Autowired
  ChatUserService chatUserService;

  @Autowired
  MessageService messageService;

  @PostMapping("/api/message/receive")
  public ResponseEntity<?> postJsonMessage(@RequestBody (required = false) MessagePackage
  messagePackage) {
    if (messagePackage == null || messagePackage.getClient() == null || messagePackage.getMessage
            () == null || messagePackage.getClient().getId().isEmpty()) {
      return ResponseEntity.status(401).body(new JsonResponseError("error", "Missing field(s): message" +
              ".timestamp, client.id"));
      //              or
      //              new ResponseEntity<>(new JsonResponseError("error", "Missing field(s): message" +
      //              ".timestamp, client.id"), HttpStatus.UNAUTHORIZED);
    } else if (chatUserService.getAllUsers().contains(chatUserService.getChatUserByName
            (messagePackage.getClient().getId()))){
      Message newMessage = new Message();
      newMessage.setText(messagePackage.getMessage().getText());
      newMessage.setChatUser(chatUserService.getChatUserByName
              (messagePackage.getClient().getId()));
      messageService.createMessage(newMessage);
      return ResponseEntity.status(200).body(new JsonResponse("ok"));
    } else {
      ChatUser newChatUser = new ChatUser();
      newChatUser.setName(messagePackage.getClient().getId());
      chatUserService.logIn(newChatUser);
      Message newMessage = new Message();
      newMessage.setText(messagePackage.getMessage().getText());
      newMessage.setChatUser(chatUserService.getChatUserByName
              (messagePackage.getClient().getId()));
      messageService.createMessage(newMessage);
      return ResponseEntity.status(200).body(new JsonResponse("ok"));
    }
  }
}
