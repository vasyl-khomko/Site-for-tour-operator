package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import toursite.dao.ConversationDAO;
import toursite.model.Conversation;

import java.util.List;

/**
 * Created by Vasyl on 14.10.2015.
 */
@Service
public class ConversionServiceImpl implements ConversationService {

    @Autowired
    private ConversationDAO conversationDAO;

    @Transactional
    public void create(int userId) {

    }

    @Transactional
    public List<Conversation> findByUserIdOne(int userId) {
        return conversationDAO.findByUserIdOne(userId);
    }

    @Transactional
    public List<Conversation> findByUserIdTwo(int userId) {
        return conversationDAO.findByUserIdTwo(userId);
    }
}
