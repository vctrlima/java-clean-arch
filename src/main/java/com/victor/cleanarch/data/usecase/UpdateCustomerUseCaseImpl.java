package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocol.db.UpdateCustomerRepository;
import com.victor.cleanarch.data.protocol.remote.FindAddressByZipCode;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import com.victor.cleanarch.domain.usecase.UpdateCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    @Autowired
    private FindAddressByZipCode findAddressByZipCode;

    @Autowired
    private UpdateCustomerRepository updateCustomerRepository;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Override
    public Customer update(Customer customer, String zipCode) {
        customer.setAddress(findAddressByZipCode.find(zipCode));
        findCustomerByIdUseCase.findById(customer.getId());
        return updateCustomerRepository.update(customer);
    }

}
