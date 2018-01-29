package com.greenfox.chatapp.repositories;

import com.greenfox.chatapp.models.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, Integer> {
  ChatUser findByName(String name);
}
