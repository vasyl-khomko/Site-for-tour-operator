package toursite.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import toursite.model.Category;
import toursite.model.Image;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Repository
public class ImageDAOImpl implements ImageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public Image findById(int imageId) {
        return (Image) sessionFactory.getCurrentSession()
                .createQuery("select i from Image i where i.imageId = :imageId")
                .setParameter("imageId", imageId)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void save(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }


    @SuppressWarnings("unchecked")
    public void save(Image image) {
        sessionFactory.getCurrentSession().save(image);
    }

    @SuppressWarnings("unchecked")
    public void delete(Image image) {
        sessionFactory.getCurrentSession().delete(image);
    }
}
