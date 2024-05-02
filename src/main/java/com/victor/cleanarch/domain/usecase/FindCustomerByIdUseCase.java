package com.victor.cleanarch.domain.usecase;

import com.victor.cleanarch.domain.entity.Customer;

import java.util.Optional;

public interface FindCustomerByIdUseCase {

    Optional<Customer> findCustomerById(String id);

}
