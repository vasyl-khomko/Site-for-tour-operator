package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Category;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository
public class CategotyDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public void save(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @SuppressWarnings("unchecked")
    public Category findById(int categoryId) {
        Category category = (Category)sessionFactory.getCurrentSession()
                .createQuery("select c from Category c where c.categoryId = :categoryId")
                .setParameter("categoryId", categoryId)
                .uniqueResult();
        return category;
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        List<Category> categories = sessionFactory.getCurrentSession()
                .createQuery("select c from Category c")
                .list();
        return categories;
    }
}
