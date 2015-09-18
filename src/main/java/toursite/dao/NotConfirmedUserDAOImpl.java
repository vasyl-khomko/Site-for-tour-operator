package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.NotConfirmedUser;
import toursite.model.User;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository
public class NotConfirmedUserDAOImpl implements NotConfirmedUserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void save(NotConfirmedUser user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public void update(NotConfirmedUser user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @SuppressWarnings("unchecked")
    public void delete(NotConfirmedUser user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @SuppressWarnings("unchecked")
    public NotConfirmedUser findById(int userId) {
        NotConfirmedUser user = (NotConfirmedUser) sessionFactory.getCurrentSession()
                .createQuery("select u from NotConfirmedUser u where u.notConfirmedUserId = :userId")
                .setParameter("userId", userId)
                .uniqueResult();
        return user;
    }

    @SuppressWarnings("unchecked")
    public NotConfirmedUser findByActivationCode(String activationCode) {
        NotConfirmedUser user = (NotConfirmedUser) sessionFactory.getCurrentSession()
                .createQuery("select u from NotConfirmedUser u where u.activationCode = :activationCode")
                .setParameter("activationCode", activationCode)
                .uniqueResult();
        return user;
    }

    @SuppressWarnings("unchecked")
    public NotConfirmedUser findByEmail(String email) {
        NotConfirmedUser user = (NotConfirmedUser) sessionFactory.getCurrentSession()
                .createQuery("select u from NotConfirmedUser u where u.email = :email")
                .setParameter("email", email)
                .uniqueResult();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<NotConfirmedUser> findAll(int firstResult, int maxResults) {
        List<NotConfirmedUser> tours = (List<NotConfirmedUser>) sessionFactory.getCurrentSession()
                .createCriteria(NotConfirmedUser.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults).list();
        return tours;
    }
}
