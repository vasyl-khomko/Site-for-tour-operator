package toursite.dao;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Projections;
import toursite.model.Tour;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vasyl on 26.05.2015.
 */
@Repository("tourDao")
public class TourDAOImpl implements TourDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public Tour findById(int id) {
        Tour tour = (Tour) sessionFactory.getCurrentSession()
                .get(Tour.class, id);
        Hibernate.initialize(tour.getTourdays());
        Hibernate.initialize(tour.getServices());
        Hibernate.initialize(tour.getDates());
        Hibernate.initialize(tour.getCategories());
        Hibernate.initialize(tour.getCountries());

        return tour;
    }

    @SuppressWarnings("unchecked")
    public List<Tour> listTours(int firstResult, int maxResults) {
        List<Tour> tours = (List<Tour>) sessionFactory.getCurrentSession()
                .createCriteria(Tour.class)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults).list();
        return tours;
    }

    @SuppressWarnings("unchecked")
    public void saveOrUpdate(Tour tour){
        sessionFactory.getCurrentSession().saveOrUpdate(tour);
    }

    @SuppressWarnings("unchecked")
    public long countTours() {
        long countTours = (Long) sessionFactory.getCurrentSession()
                .createCriteria(Tour.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        return countTours;
    }


}
