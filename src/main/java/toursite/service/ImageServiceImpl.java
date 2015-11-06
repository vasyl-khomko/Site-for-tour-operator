package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.CategoryDAO;
import toursite.dao.ImageDAO;
import toursite.model.Category;
import toursite.model.Image;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDAO imageDAO;

    @Transactional
    public Image getDefaultUserImage() {
        return imageDAO.findOne(1);
    }

    @Transactional
    public void save(Image image) {
        imageDAO.save(image);
    }

    @Transactional
    public void delete(Image image) {
        imageDAO.delete(image);
    }
}
