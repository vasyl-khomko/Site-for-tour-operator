package toursite.dao;

import toursite.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
