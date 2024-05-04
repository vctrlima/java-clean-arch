package com.victor.cleanarch.data.protocol.db.impl;

import com.victor.cleanarch.infra.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerByIdRepositoryImplTest {

    @InjectMocks
    private DeleteCustomerByIdRepositoryImpl deleteCustomerByIdRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void delete_ExistentCustomer_CallRepository1Time() {
        String id = "id";

        deleteCustomerByIdRepository.deleteById(id);

        verify(customerRepository, times(1)).deleteById(id);
    }

}