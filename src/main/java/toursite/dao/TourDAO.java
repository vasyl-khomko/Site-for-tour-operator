package toursite.dao;

import toursite.model.Review;
import toursite.model.Tour;
import java.util.List;

/**
 * Created by Vasyl on 26.05.2015.
 */
public interface TourDAO {
    public Tour findById(int id);
    public List<Tour> listTours(int firstResult, int maxResults);
    public void saveOrUpdate(Tour tour);
    public long countTours();
}
