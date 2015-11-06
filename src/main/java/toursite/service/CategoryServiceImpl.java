package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import toursite.dao.CategoryDAO;
import toursite.model.Category;

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
        PageRequest p = new PageRequest(1, 5);
        categoryDAO.findAll(p);
        return categoryDAO.getOne(categoryId);
    }

    @Transactional
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
