package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Review;
import toursite.model.User;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository("userDao")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        User user = (User) sessionFactory.getCurrentSession()
                .createQuery("select u from User u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
        return user;
    }
}
