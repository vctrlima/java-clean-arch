package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocol.db.InsertCustomerRepository;
import com.victor.cleanarch.data.protocol.remote.FindAddressByZipCode;
import com.victor.cleanarch.data.protocol.remote.SendDocumentForValidation;
import com.victor.cleanarch.domain.entity.Address;
import com.victor.cleanarch.domain.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InsertCustomerUseCaseImplTest {

    @InjectMocks
    private InsertCustomerUseCaseImpl insertCustomerUseCase;

    @Mock
    private FindAddressByZipCode findAddressByZipCode;

    @Mock
    private InsertCustomerRepository insertCustomerRepository;

    @Mock
    private SendDocumentForValidation sendDocumentForValidation;

    @Test
    void insert_NewCustomer_ReturnIt() {
        String id = "id";
        Customer entity = new Customer();
        entity.setId(id);
        Address address = new Address("street", "city", "state");
        String zipCode = "zipCode";
        Customer expectation = new Customer();
        expectation.setAddress(address);
        expectation.setDocument("document");
        when(findAddressByZipCode.find(zipCode)).thenReturn(address);
        when(insertCustomerRepository.insert(entity)).thenReturn(expectation);

        Customer customer = insertCustomerUseCase.insert(entity, zipCode);

        assertEquals(expectation, customer);
        verify(sendDocumentForValidation, times(1)).send(expectation.getDocument());
    }

}