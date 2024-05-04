package com.victor.cleanarch.presentation.consumer;

import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.UpdateCustomerUseCase;
import com.victor.cleanarch.presentation.consumer.mapper.CustomerMessageMapper;
import com.victor.cleanarch.presentation.consumer.message.CustomerMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReceiveValidatedDocumentConsumerTest {

    @InjectMocks
    private ReceiveValidatedDocumentConsumer receiveValidatedDocumentConsumer;

    @Mock
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Mock
    private CustomerMessageMapper customerMessageMapper;

    @Test
    void receive_CustomerMessage_CallRequirementsWithRightParams() {
        CustomerMessage customerMessage = new CustomerMessage();
        customerMessage.setId("id");
        customerMessage.setZipCode("zipCode");
        Customer customer = new Customer();
        customer.setId(customerMessage.getId());
        when(customerMessageMapper.fromMessageToEntity(customerMessage)).thenReturn(customer);

        receiveValidatedDocumentConsumer.receive(customerMessage);

        verify(updateCustomerUseCase, times(1)).update(customer, customerMessage.getZipCode());
    }

}