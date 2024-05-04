package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocol.db.UpdateCustomerRepository;
import com.victor.cleanarch.data.protocol.remote.FindAddressByZipCode;
import com.victor.cleanarch.domain.entity.Address;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateCustomerUseCaseImplTest {

    @InjectMocks
    private UpdateCustomerUseCaseImpl updateCustomerUseCase;

    @Mock
    private FindAddressByZipCode findAddressByZipCode;

    @Mock
    private UpdateCustomerRepository updateCustomerRepository;

    @Mock
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Test
    void update_ExistentCustomer_ReturnIt() {
        String id = "id";
        Customer entity = new Customer();
        entity.setId(id);
        Address address = new Address("street", "city", "state");
        String zipCode = "zipCode";
        Customer expectation = new Customer();
        expectation.setAddress(address);
        expectation.setDocument("document");
        when(findAddressByZipCode.find(zipCode)).thenReturn(address);
        when(updateCustomerRepository.update(entity)).thenReturn(expectation);

        Customer customer = updateCustomerUseCase.update(entity, zipCode);

        assertEquals(expectation, customer);
        verify(findCustomerByIdUseCase, times(1)).findById(entity.getId());
    }
}