package toursite.dao;

import toursite.model.Category;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface CategoryDAO {
    public void save(Category category);
    public Category findById(int categoryId);
    public List<Category> findAll();
}
