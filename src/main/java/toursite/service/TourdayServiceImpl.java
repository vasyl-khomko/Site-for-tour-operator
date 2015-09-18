package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.ReviewDAO;
import toursite.dao.TourDAO;
import toursite.dao.TourdayDAO;
import toursite.model.Review;
import toursite.model.Tourday;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class TourdayServiceImpl implements TourdayService {
    @Autowired
    private TourdayDAO tourdayDAO;

    @Transactional
    public void saveOrUpdate(Tourday tourday) {
        tourdayDAO.saveOrUpdate(tourday);
    }

    @Transactional
    public void delete(Tourday tourday) {
        tourdayDAO.delete(tourday);
    }

    @Transactional
    public List<Tourday> findByTourId(int tourId) {
        return tourdayDAO.findByTourId(tourId);
    }
}
