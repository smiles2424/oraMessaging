package oramessaging.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import oramessaging.models.Message;

/**
 * This class uses the Spring framework default implementation to pull Message objects
 * from the in-memory database.
 */
public interface MessageRepo extends PagingAndSortingRepository<Message, Long> {

}
