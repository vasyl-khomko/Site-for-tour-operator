package toursite.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import toursite.model.Tour;
import toursite.dao.TourDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vasyl on 26.05.2015.
 */
@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourDAO tourDAO;

    private int numberToursOnPage = 6;

    @Transactional
    public Tour findById(int id) {
        return tourDAO.findById(id);
    }

    @Transactional
    public List<Tour> listTours(int pageNumber) {
        int firstResult = (pageNumber - 1) * numberToursOnPage;
        return tourDAO.listTours(firstResult, numberToursOnPage);
    }

    @Transactional
    public void saveOrUpdate(Tour tour) {
        tourDAO.saveOrUpdate(tour);
    }

    @Transactional
    public int pagesCount() {
        long toursCount = tourDAO.countTours();
        return (int)toursCount / numberToursOnPage +
                ((toursCount % numberToursOnPage > 0) ? 1: 0);
    }

    private int count = 0;
    @Scope("session")
    public int count() {
        return count++;
    }

}
