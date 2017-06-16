package oraMessaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import oraMessaging.models.*;
import oraMessaging.services.*;

@RestController
public class ChatController {
  @Autowired
  private ChatRepo chatRepo;

    @RequestMapping(path = "/chat/{id}", method = RequestMethod.GET)
    public Chat chat(@PathVariable("id") long id) {
        return chatRepo.findOne(id);
    }

    @RequestMapping(path="/chats", method=RequestMethod.GET)
    public Iterable<Chat> getChats(){
      return chatRepo.findAll();
    }

    @RequestMapping(path="/chat", method=RequestMethod.POST)
    public Chat saveChat(@RequestBody Chat chat){
      return chatRepo.save(chat);
    }
}