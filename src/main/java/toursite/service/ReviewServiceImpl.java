package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.ReviewDAO;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewDAO reviewDAO;

    @Transactional
    public void save(Review review) {
        reviewDAO.save(review);
    }

    @Transactional
    public List<Review> findByTourId(int tourId) {
        return reviewDAO.findByTourId(tourId);
    }
}
