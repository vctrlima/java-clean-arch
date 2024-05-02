package com.victor.cleanarch.domain.usecase;

import com.victor.cleanarch.domain.entity.Customer;

public interface InsertCustomerUseCase {

    Customer insert(Customer customer, String zipCode);

}
