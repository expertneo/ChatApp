package com.greenfox.chatapp;

import com.greenfox.chatapp.models.ChatUser;
import com.greenfox.chatapp.models.Message;
import com.greenfox.chatapp.services.ChatUserService;
import com.greenfox.chatapp.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class ChatApplication implements CommandLineRunner {

	@Autowired
	ChatUserService chatUserService;

	@Autowired
	MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);

//		for (String env: args) {
//			String value = System.getenv(env);
//			if (value != null) {
//				System.out.format("%s=%s%n", env, value);
//			} else {
//				System.out.format("%s is" + " not assigned.%n", env);
//			}
//		}
	}

	@Override
	public void run(String... args) throws Exception {
		Message standardMessage = new Message();
		ChatUser dummyChatUser = new ChatUser();
		dummyChatUser.setName("App");
		standardMessage.setText("Hi There! Submit your message using the send button!");
		standardMessage.setChatUser(dummyChatUser);
		chatUserService.createChatUser(dummyChatUser);
		messageService.createMessage(standardMessage);
	}
}
