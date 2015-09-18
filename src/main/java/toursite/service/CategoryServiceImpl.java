package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.CategoryDAO;
import toursite.dao.ReviewDAO;
import toursite.model.Category;
import toursite.model.Review;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Transactional
    public Category findById(int categoryId) {
        return categoryDAO.findById(categoryId);
    }

    @Transactional
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
