package com.greenfox.chatapp.controllers;

import com.greenfox.chatapp.models.ChatUser;
import com.greenfox.chatapp.models.LogError;
import com.greenfox.chatapp.models.Message;
import com.greenfox.chatapp.services.ChatUserService;
import com.greenfox.chatapp.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

  private ChatUser  loggedInChatUser;

  @Autowired
  ChatUserService chatUserService;

  @Autowired
  MessageService messageService;

  @GetMapping("/")
  public String mainPage(Model model) {
    if (loggedInChatUser == null) {
      model.addAttribute("chatUser", new ChatUser());
      return "enter";
    }
    model.addAttribute("chatUser", loggedInChatUser);
    model.addAttribute("messages", messageService.getAllMessages());
    model.addAttribute("message", new Message());
    return "main";
  }

  @GetMapping("/enter")
  public String enterPage(Model model) {
    model.addAttribute("chatUser", new ChatUser());
    return "enter";
  }

  @PostMapping("/enterChatUser")
  public String enterPagePost(Model model, @ModelAttribute ChatUser chatUser) {
    if (chatUser == null) {
      LogError logerror = new LogError("There is an error.");
      return "redirect:/";
    } else {
      loggedInChatUser = chatUserService.logIn(chatUser);
    }
    return "redirect:/";
  }

  @PostMapping("/submitMessage")
  public String submitNewMessage(Model model, @ModelAttribute Message message) {
    if (message != null) {
      Message messageNew = message;
      messageNew.setChatUser(loggedInChatUser);
      messageService.createMessage(messageNew);
    } else {
      LogError logError = new LogError("There is an error!");
    }
    return "redirect:/";
  }
}
