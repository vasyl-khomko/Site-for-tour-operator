package toursite.dao;

import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ReviewDAO {
    public void save(Review review);
    public List<Review> findByTourId(int tourId);
}
