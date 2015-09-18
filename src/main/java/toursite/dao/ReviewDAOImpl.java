package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository("reviewDao")
public class ReviewDAOImpl implements ReviewDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void save(Review review) {
        sessionFactory.getCurrentSession().save(review);
    }

    @SuppressWarnings("unchecked")
    public List<Review> findByTourId(int tourId) {
        List<Review> reviews = sessionFactory.getCurrentSession()
                .createQuery("select r from Review r where r.tourId = :tourId")
                .setParameter("tourId", tourId)
                .list();
        return reviews;
    }
}
