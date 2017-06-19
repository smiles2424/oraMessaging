package oramessaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import oramessaging.models.*;
import oramessaging.services.*;

@RestController
public class ChatController {
  
  @Autowired
  private ChatRepo chatRepo;

    @RequestMapping(path = "/chat/{id}", method = RequestMethod.GET)
    public Chat chat(@PathVariable("id") long id) {
        return chatRepo.findOne(id);
    }

    @RequestMapping(path="/chats", method=RequestMethod.GET)
    public Response<Iterable<Chat>> getChats(
      @RequestParam(value = "page", required = false) String pageNumber, 
      @RequestParam(value = "limit", required = false) String limit) {

      int page = 0, limiter = 5;
      if (pageNumber != null && !pageNumber.isEmpty())
        page = Integer.parseInt(pageNumber);
      if (limit != null && !limit.isEmpty())      
        limiter = Integer.parseInt(limit);
      System.out.println("Page:"+page+" and limit:"+limiter);
      PageRequest p = new PageRequest(page, limiter);

      Page results = chatRepo.findAll(p);
      Pager pager = new Pager(page, limiter, results.getTotalPages(), (int)results.getTotalElements());
      Metadata meta = new Metadata(pager);
      Response<Iterable<Chat>> res = new Response<Iterable<Chat>>(results.getContent());
      res.setMetadata(meta);
      return res;

    }

    @RequestMapping(path="/chat", method=RequestMethod.POST)
    public Chat saveChat(@RequestBody Chat chat) {
      return chatRepo.save(chat);
    }
}
