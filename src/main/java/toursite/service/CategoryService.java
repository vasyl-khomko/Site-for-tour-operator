package toursite.service;

import toursite.model.Category;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface CategoryService {
    public void save(Category category);
    public Category findById(int categoryId);
    public List<Category> findAll();
}
