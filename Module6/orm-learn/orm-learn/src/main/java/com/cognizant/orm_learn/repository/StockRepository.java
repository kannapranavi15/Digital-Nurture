package com.cognizant.orm_learn.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm_learn.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Facebook stocks in September 2019
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate startDate,
            LocalDate endDate);

    // Google stocks where closing price > given value
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            double close);

    // Top 3 highest transaction volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Lowest 3 Netflix stock prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(
            String code);

}