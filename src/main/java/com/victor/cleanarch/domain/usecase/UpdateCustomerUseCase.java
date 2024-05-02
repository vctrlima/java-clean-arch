package com.victor.cleanarch.domain.usecase;

import com.victor.cleanarch.domain.entity.Customer;

public interface UpdateCustomerUseCase {

    Customer update(Customer customer, String zipCode);

}
