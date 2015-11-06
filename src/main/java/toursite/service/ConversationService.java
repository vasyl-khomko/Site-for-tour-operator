package toursite.service;

import toursite.model.Conversation;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ConversationService {
    public void create(int userId);
    public List<Conversation> findByUserIdOne(int userId);
    public List<Conversation> findByUserIdTwo(int userId);
}
