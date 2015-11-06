package toursite.service;

import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional
    public Tour findOne(int tourId) {
        return tourDAO.findOne(tourId);
    }

    @Transactional
    public Page<Tour> findAll(PageRequest pageRequest) {
        return tourDAO.findAll(pageRequest);
    }

    @Transactional
    public void saveOrUpdate(Tour tour) {
        tourDAO.save(tour);
    }


}
