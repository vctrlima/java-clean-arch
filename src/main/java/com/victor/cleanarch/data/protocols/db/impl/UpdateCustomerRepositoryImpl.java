package com.victor.cleanarch.data.protocols.db.impl;

import com.victor.cleanarch.data.protocols.db.UpdateCustomerRepository;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateCustomerRepositoryImpl implements UpdateCustomerRepository {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

}
