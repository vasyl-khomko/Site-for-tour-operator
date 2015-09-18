package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Review;
import toursite.model.Service;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository("serviceDao")
public class ServiceDAOImpl implements ServiceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Service> findByTourId(int tourId) {
        List<Service> services = sessionFactory.getCurrentSession()
                .createQuery("select s from Service s where s.tour = :tourId")
                .setParameter("tourId", tourId)
                .list();
        return services;
    }

    @SuppressWarnings("unchecked")
    public void add(Service service) {
        sessionFactory.getCurrentSession().save(service);
    }

    @SuppressWarnings("unchecked")
    public void delete(Service service) {
        sessionFactory.getCurrentSession().delete(service);
    }
}
