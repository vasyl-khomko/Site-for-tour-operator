package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Country;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository
public class CountryDAOImpl implements CountryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void save(Country country) {
        sessionFactory.getCurrentSession().save(country);
    }

    @SuppressWarnings("unchecked")
    public Country findById(int countryId) {
        Country country = (Country)sessionFactory.getCurrentSession()
                .createQuery("select c from Country c where c.countryId = :countryId")
                .setParameter("countryId", countryId)
                .uniqueResult();
        return country;
    }

    @SuppressWarnings("unchecked")
    public List<Country> findAll() {
        List<Country> categories = sessionFactory.getCurrentSession()
                .createQuery("select c from Country c")
                .list();
        return categories;
    }
}
