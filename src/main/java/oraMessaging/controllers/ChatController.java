package oraMessaging.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import oraMessaging.models.*;

@RestController
public class ChatController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/chat")
    public Chat chat(@RequestParam(value="name", defaultValue="World") String name) {
        return new Chat(counter.incrementAndGet(),
                            String.format(template, name));
    }
}