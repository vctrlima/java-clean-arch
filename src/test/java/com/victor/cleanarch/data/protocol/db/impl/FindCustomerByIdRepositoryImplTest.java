package com.victor.cleanarch.data.protocol.db.impl;

import com.victor.cleanarch.data.exception.ResourceNotFoundException;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCustomerByIdRepositoryImplTest {

    @InjectMocks
    private FindCustomerByIdRepositoryImpl findCustomerByIdRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void findById_ExistentCustomer_ReturnIt() {
        String id = "id";
        Customer entity = new Customer();
        entity.setId(id);
        when(customerRepository.findById(id)).thenReturn(Optional.of(entity));

        Customer customer = findCustomerByIdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found!"));

        assertEquals(entity, customer);
    }

}