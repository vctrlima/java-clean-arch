package com.victor.cleanarch.domain.usecase;

import com.victor.cleanarch.domain.entity.Customer;

public interface FindCustomerByIdUseCase {

    Customer findCustomerById(String id);

}
