package oramessaging.services;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import oramessaging.models.Chat;

public interface ChatRepo extends CrudRepository<Chat, Long> {

    // List<Chat> findById(long id);
    
}
