package com.victor.cleanarch.data.protocols.db.impl;

import com.victor.cleanarch.data.protocols.db.DeleteCustomerByIdRepository;
import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdRepositoryImpl implements DeleteCustomerByIdRepository {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

}
