package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.ReviewDAO;
import toursite.dao.ServiceDAO;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceDAO serviceDAO;

    @Transactional
    public List<toursite.model.Service> findByTourId(int tourId) {
        return serviceDAO.findByTourId(tourId);
    }

    @Transactional
    public void add(toursite.model.Service service) {
        serviceDAO.add(service);
    }

    @Transactional
    public void delete(toursite.model.Service service) {
        serviceDAO.delete(service);
    }


}
