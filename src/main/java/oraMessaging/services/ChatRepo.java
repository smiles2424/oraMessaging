package oraMessaging.services;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import oraMessaging.models.Chat;

public interface ChatRepo extends CrudRepository<Chat, Long> {

    // List<Chat> findById(long id);
    
}
