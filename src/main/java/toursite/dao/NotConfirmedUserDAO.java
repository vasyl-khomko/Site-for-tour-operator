package toursite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import toursite.model.NotConfirmedUser;
import toursite.model.User;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface NotConfirmedUserDAO extends JpaRepository<NotConfirmedUser, Integer> {
    public NotConfirmedUser findByEmail(String email);
    public NotConfirmedUser findByActivationCode(String activationCode);
}
