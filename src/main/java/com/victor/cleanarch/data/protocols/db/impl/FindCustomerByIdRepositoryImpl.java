package com.victor.cleanarch.data.protocols.db.impl;

import com.victor.cleanarch.data.protocols.db.FindCustomerByIdRepository;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdRepositoryImpl implements FindCustomerByIdRepository {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

}
