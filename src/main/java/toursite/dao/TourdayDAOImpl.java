package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Review;
import toursite.model.Tourday;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository("tourdayDao")
public class TourdayDAOImpl implements TourdayDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void saveOrUpdate(Tourday tourday) {
        sessionFactory.getCurrentSession().saveOrUpdate(tourday);
    }

    public void delete(Tourday tourday) {
        sessionFactory.getCurrentSession().delete(tourday);
    }

    @SuppressWarnings("unchecked")
    public List<Tourday> findByTourId(int tourId) {
        List<Tourday> tourdays = sessionFactory.getCurrentSession()
                .createQuery("select r from Review r where r.tourId = :tourId")
                .setParameter("tourId", tourId)
                .list();
        return tourdays;
    }
}
