package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Role;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void save(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @SuppressWarnings("unchecked")
    public Role findById(int roleId) {
        Role role = (Role)sessionFactory.getCurrentSession()
                .createQuery("select c from Role c where c.roleId = :roleId")
                .setParameter("roleId", roleId)
                .uniqueResult();
        return role;
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        List<Role> categories = sessionFactory.getCurrentSession()
                .createQuery("select c from Role c")
                .list();
        return categories;
    }
}
