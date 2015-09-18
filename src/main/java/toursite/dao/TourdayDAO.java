package toursite.dao;

import toursite.model.Review;
import toursite.model.Tourday;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface TourdayDAO {
    public void saveOrUpdate(Tourday tourday);
    public void delete(Tourday tourday);
    public List<Tourday> findByTourId(int tourId);
}
