// package oramessaging.tests.controllers;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import org.springframework.test.web.servlet.MockMvc;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import org.springframework.test.web.servlet.setup.*;

// import oramessaging.controllers.MessageController;

// @RunWith(SpringJUnit4ClassRunner.class)
// @WebAppConfiguration
// @WebMvcTest(MessageController.class)
// public class MessageControllerTest {

//   @Autowired
//   private MockMvc mvc;

//   // @Test
//   // public void saveMessage_correct() throws Exception {
//   //   // this.mvc.perform(post("/chat",))
//   // }

//   @Test
//   public void getMessages_correct() throws Exception {
//     System.out.println("In the test!");
//     this.mvc.perform(
//       get("/chats")
//       .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
//       )
//     .andExpect(status().isOk())
//     .andExpect(content().contentType("application/json"));
//   }
// }