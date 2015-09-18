package toursite.service;

import toursite.model.Review;
import toursite.model.Service;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ServiceService {
    public List<Service> findByTourId(int tourId);
    public void add(Service service);
    public void delete(Service service);
}
