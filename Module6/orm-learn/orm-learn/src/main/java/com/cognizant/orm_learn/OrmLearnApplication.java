package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;


@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        countryService = context.getBean(CountryService.class);

    
       testDeleteCountry();
    }

    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.debug("Countries : {}", countries);

        LOGGER.info("End");
    }

    private static void testFindCountry() throws CountryNotFoundException {

    LOGGER.info("Start");

    Country country = countryService.findCountryByCode("IN");

    LOGGER.debug("Country : {}", country);

    LOGGER.info("End");
}
private static void testAddCountry() throws CountryNotFoundException {

    LOGGER.info("Start");

    Country country = new Country();

    country.setCode("JP");
    country.setName("Japan");

    countryService.addCountry(country);

    Country newCountry = countryService.findCountryByCode("JP");

    LOGGER.debug("Country : {}", newCountry);

    LOGGER.info("End");
}

private static void testUpdateCountry() throws CountryNotFoundException {

    LOGGER.info("Start");

    countryService.updateCountry("JP", "Japan Updated");

    Country country = countryService.findCountryByCode("JP");

    LOGGER.debug("Country : {}", country);

    LOGGER.info("End");
}
private static void testDeleteCountry() {

    LOGGER.info("Start");

    countryService.deleteCountry("JP");

    LOGGER.info("Country deleted successfully");

    LOGGER.info("End");
}


}