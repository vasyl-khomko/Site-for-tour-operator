package toursite.service;

import toursite.model.Image;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ImageService {
    public Image getDefaultUserImage();
    public void save(Image image);
    public void delete(Image image);
}
