package toursite.service;

import toursite.model.Country;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface CountryService {
    public void save(Country country);
    public Country findById(int countryId);
    public List<Country> findAll();
}
