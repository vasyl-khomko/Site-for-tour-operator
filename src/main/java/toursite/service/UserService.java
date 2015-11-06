package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import toursite.dao.UserDAO;
import toursite.model.NotConfirmedUser;
import toursite.model.Review;
import toursite.model.User;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface UserService {
    public void save(User user);
    public void update(User user);
    public User findByUsername(String username);
    public void register(NotConfirmedUser user);
    public void activate(String activationCode);
    public NotConfirmedUser findByEmail(String email);
    public void save(NotConfirmedUser user);
    public Page<NotConfirmedUser> findAllNotConfirmedUser(int page, int size);

}
