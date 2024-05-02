package com.victor.cleanarch.data.protocols.db;

import com.victor.cleanarch.domain.entity.Customer;

public interface InsertCustomerRepository {

    Customer insert(Customer customer);

}
