package toursite.dao;

import toursite.model.Country;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface CountryDAO {
    public void save(Country category);
    public Country findById(int categoryId);
    public List<Country> findAll();
}
