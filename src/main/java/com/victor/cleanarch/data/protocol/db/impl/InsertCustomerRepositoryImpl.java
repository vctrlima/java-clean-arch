package com.victor.cleanarch.data.protocol.db.impl;

import com.victor.cleanarch.data.protocol.db.InsertCustomerRepository;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerRepositoryImpl implements InsertCustomerRepository {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

}
