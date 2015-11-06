package toursite.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import toursite.model.Tour;

import java.util.List;

/**
 * Created by Vasyl on 26.05.2015.
 */
public interface TourService {
    public Tour findOne(int id);
    public Page<Tour> findAll(PageRequest pageRequest);
    public void saveOrUpdate(Tour tour);
}
