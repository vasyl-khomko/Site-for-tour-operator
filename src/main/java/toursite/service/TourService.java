package toursite.service;

import toursite.model.Tour;

import java.util.List;

/**
 * Created by Vasyl on 26.05.2015.
 */
public interface TourService {
    public Tour findById(int id);
    public List<Tour> listTours(int page);
    public void saveOrUpdate(Tour tour);
    public int pagesCount();
    public int count();
}
