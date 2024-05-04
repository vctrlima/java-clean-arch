package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.exception.ResourceNotFoundException;
import com.victor.cleanarch.data.protocol.db.FindCustomerByIdRepository;
import com.victor.cleanarch.domain.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCustomerByIdUseCaseImplTest {

    @InjectMocks
    private FindCustomerByIdUseCaseImpl findCustomerByIdUseCase;

    @Mock
    private FindCustomerByIdRepository findCustomerByIdRepository;

    @Test
    void findById_ExistentCustomer_ReturnIt() {
        String id = "id";
        Customer entity = new Customer();
        entity.setId(id);
        when(findCustomerByIdRepository.findById(id)).thenReturn(Optional.of(entity));

        Customer customer = findCustomerByIdUseCase.findById(id);

        assertEquals(entity, customer);
    }

    @Test
    void findById_NotExistentCustomer_ThrowsResourceNotFoundException() {
        String id = "id";
        when(findCustomerByIdRepository.findById(id)).thenReturn(Optional.empty());
        String exceptionMessage = String.format("Customer with ID %s not found", id);

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            findCustomerByIdUseCase.findById(id);
        });

        assertEquals(exceptionMessage, exception.getMessage());
    }

}