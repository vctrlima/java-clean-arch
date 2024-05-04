package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.exception.ResourceNotFoundException;
import com.victor.cleanarch.data.protocol.db.DeleteCustomerByIdRepository;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteCustomerByIdUseCaseImplTest {

    @InjectMocks
    private DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase;

    @Mock
    private DeleteCustomerByIdRepository deleteCustomerByIdRepository;

    @Mock
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Test
    void deleteById_ExistentCustomer_CallEachRequirement1Time() {
        String id = "id";

        deleteCustomerByIdUseCase.deleteById(id);

        verify(findCustomerByIdUseCase, times(1)).findById(id);
        verify(deleteCustomerByIdRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteById_NotExistentCustomer_ThrowResourceNotFoundException() {
        String id = "id";
        String exceptionMessage = String.format("Customer with ID %s not found", id);
        when(findCustomerByIdUseCase.findById(id)).thenThrow(new ResourceNotFoundException(exceptionMessage));

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> deleteCustomerByIdUseCase.deleteById(id));

        assertEquals(exceptionMessage, exception.getMessage());
    }

}