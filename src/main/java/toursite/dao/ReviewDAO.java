package toursite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ReviewDAO extends JpaRepository<Review, Integer> {
    public List<Review> findByTourId(int tourId);
}
