package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocol.db.InsertCustomerRepository;
import com.victor.cleanarch.data.protocol.remote.FindAddressByZipCode;
import com.victor.cleanarch.data.protocol.remote.SendDocumentForValidation;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.InsertCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    @Autowired
    private FindAddressByZipCode findAddressByZipCode;

    @Autowired
    private InsertCustomerRepository insertCustomerRepository;

    @Autowired
    private SendDocumentForValidation sendDocumentForValidation;

    @Override
    public Customer insert(Customer customer, String zipCode) {
        customer.setAddress(findAddressByZipCode.find(zipCode));
        Customer entity = insertCustomerRepository.insert(customer);
        sendDocumentForValidation.send(entity.getDocument());
        return entity;
    }

}
