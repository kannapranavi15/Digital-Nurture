package com.cognizant.orm_learn.repository;
import com.cognizant.orm_learn.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}