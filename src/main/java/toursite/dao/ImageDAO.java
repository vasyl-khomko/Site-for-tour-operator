package toursite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import toursite.model.Category;
import toursite.model.Country;
import toursite.model.Image;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface ImageDAO extends JpaRepository<Image, Integer> {

}
