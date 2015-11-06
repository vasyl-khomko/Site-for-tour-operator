package toursite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import toursite.model.Conversation;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ConversationDAO extends JpaRepository<Conversation, Integer> {
    List<Conversation> findByUserIdOne(int userId);
    List<Conversation> findByUserIdTwo(int userId);
}
