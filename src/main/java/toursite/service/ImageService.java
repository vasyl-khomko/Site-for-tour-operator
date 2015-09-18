package toursite.service;

import toursite.model.Category;
import toursite.model.Image;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ImageService {
    public Image getDefaultUserImage();
    public void save(Image image);
    public void delete(Image image);
}
