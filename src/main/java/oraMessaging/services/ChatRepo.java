package oramessaging.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import oramessaging.models.Chat;

public interface ChatRepo extends PagingAndSortingRepository<Chat, Long> {

}
