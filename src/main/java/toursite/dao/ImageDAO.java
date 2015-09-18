package toursite.dao;

import toursite.model.Category;
import toursite.model.Image;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ImageDAO {
    public Image findById(int imageId);
    public void save(Image image);
    public void delete(Image image);
}
