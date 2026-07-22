package com.cognizant.orm_learn.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

    Optional<Country> result = countryRepository.findById(countryCode);

    if (result.isEmpty()) {
        throw new CountryNotFoundException("Country not found");
    }

    return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }


    @Transactional
public void updateCountry(String code, String name) throws CountryNotFoundException {

    Optional<Country> result = countryRepository.findById(code);

    if (result.isEmpty()) {
        throw new CountryNotFoundException("Country not found");
    }

    Country country = result.get();
    country.setName(name);

    countryRepository.save(country);
}
@Transactional
public void deleteCountry(String code) {
    countryRepository.deleteById(code);
}


}