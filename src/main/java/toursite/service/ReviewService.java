package toursite.service;

import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ReviewService {
    public void save(Review review);
    public List<Review> findByTourId(int tourId);
}
