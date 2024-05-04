package com.victor.cleanarch.data.protocol.db.impl;

import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InsertCustomerRepositoryImplTest {

    @InjectMocks
    private InsertCustomerRepositoryImpl insertCustomerRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void insert_SaveNewCustomer_ReturnIt() {
        String id = "id";
        Customer entity = new Customer();
        entity.setId(id);
        when(customerRepository.save(entity)).thenReturn(entity);

        Customer customer = insertCustomerRepository.insert(entity);

        assertEquals(entity, customer);
    }

}