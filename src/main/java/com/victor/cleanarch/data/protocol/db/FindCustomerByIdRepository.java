package com.victor.cleanarch.data.protocol.db;

import com.victor.cleanarch.domain.entity.Customer;

import java.util.Optional;

public interface FindCustomerByIdRepository {

    Optional<Customer> findById(String id);

}
