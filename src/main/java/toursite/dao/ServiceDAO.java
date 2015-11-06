package toursite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import toursite.model.Review;
import toursite.model.Service;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ServiceDAO extends JpaRepository<Service, Integer> {

}
