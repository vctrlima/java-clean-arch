package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocols.db.FindCustomerByIdRepository;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    @Autowired
    private FindCustomerByIdRepository findCustomerByIdRepository;

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return findCustomerByIdRepository.findById(id);
    }

}
