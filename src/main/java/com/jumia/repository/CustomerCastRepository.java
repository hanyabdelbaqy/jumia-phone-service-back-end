package com.jumia.repository;

import com.jumia.entity.Customer;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerCastRepository {

    List<Customer> findByUserFilter(String countryCode, String regex);
}
