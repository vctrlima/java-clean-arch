package com.victor.cleanarch.data.protocol.db;

import com.victor.cleanarch.domain.entity.Customer;

public interface UpdateCustomerRepository {

    Customer update(Customer customer);

}
