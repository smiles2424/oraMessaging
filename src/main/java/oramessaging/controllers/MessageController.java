package oramessaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

import oramessaging.models.Error;
import oramessaging.models.Message;
import oramessaging.models.Pager;
import oramessaging.models.Metadata;
import oramessaging.services.*;
import oramessaging.models.Response;

/**
 * Routes incoming requests for the Message entity. 
 * 
 * Is heavy on logic. Should move to a Service layer given the time.
 * 
 * TODO implement updated Message structure
 * 
 */
@RestController
public class MessageController {
  
  @Autowired
  private MessageRepo chatRepo;

    @RequestMapping(path = "/chat/{id}", method = RequestMethod.GET)
    public Message chat(@PathVariable("id") long id) {
        return chatRepo.findOne(id);
    }

    @RequestMapping(path="/chats", method=RequestMethod.GET)
    public Response<Iterable<Message>> getMessages(
      @RequestParam(value = "page", required = false) String pageNumber, 
      @RequestParam(value = "limit", required = false) String limit) {

      int page = 0, limiter = 5;
      if (pageNumber != null && !pageNumber.isEmpty())
        page = Integer.parseInt(pageNumber);
      if (limit != null && !limit.isEmpty())      
        limiter = Integer.parseInt(limit);
      System.out.println("Page:" + page + " and limit:" + limiter);
      PageRequest p = new PageRequest(page, limiter);

      //Finalize paginated data
      Page results = chatRepo.findAll(p);
      Pager pager = new Pager(page, limiter, results.getTotalPages(), (int)results.getTotalElements());
      Metadata meta = new Metadata(pager);
      Response<Iterable<Message>> res = new Response<Iterable<Message>>(results.getContent());
      res.setMetadata(meta);
      return res;

    }

    @RequestMapping(path="/chat", method=RequestMethod.POST)
    public Response<Message> saveMessage(@RequestBody Message chat) {
      Message c = null;
      String message = "Success";
      ArrayList<Error> errors = null;
      try {
        c = chatRepo.save(chat);
      } catch(ConstraintViolationException e){
        message = "Validation failed";
        errors = UserController.getAllErrors(e);
      }

      Response<Message> res = new Response<Message>(c);
      res.setMessage(message);
      res.setErrors(errors);
      return res;
    }
}
