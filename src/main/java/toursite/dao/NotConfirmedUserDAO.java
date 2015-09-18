package toursite.dao;

import toursite.model.NotConfirmedUser;
import toursite.model.User;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface NotConfirmedUserDAO {
    public void save(NotConfirmedUser user);
    public void update(NotConfirmedUser user);
    public void delete(NotConfirmedUser user);
    public NotConfirmedUser findById(int userId);
    public NotConfirmedUser findByActivationCode(String activationCode);
    public NotConfirmedUser findByEmail(String email);
    public List<NotConfirmedUser> findAll(int firstResult, int maxResults);
}
