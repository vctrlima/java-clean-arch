package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocol.db.FindCustomerByIdRepository;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import com.victor.cleanarch.data.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    @Autowired
    private FindCustomerByIdRepository findCustomerByIdRepository;

    @Override
    public Customer findById(String id) {
        return findCustomerByIdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Customer with ID %s not found", id)));
    }

}
