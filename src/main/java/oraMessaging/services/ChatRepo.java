package oramessaging.services;

import org.springframework.data.repository.CrudRepository;
import oramessaging.models.Chat;

public interface ChatRepo extends CrudRepository<Chat, Long> {

}
