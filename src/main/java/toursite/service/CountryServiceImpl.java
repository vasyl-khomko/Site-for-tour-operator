package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.CountryDAO;
import toursite.model.Country;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDAO countryDAO;

    @Transactional
    public void save(Country country) {
        countryDAO.save(country);
    }

    @Transactional
    public Country findById(int countryId) {
        return countryDAO.findById(countryId);
    }

    @Transactional
    public List<Country> findAll() {
        return countryDAO.findAll();
    }
}
