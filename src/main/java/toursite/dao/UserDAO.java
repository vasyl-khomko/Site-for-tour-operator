package toursite.dao;

import toursite.model.Review;
import toursite.model.User;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface UserDAO {
    public void save(User user);
    public void update(User user);
    public User findByUsername(String username);
}
