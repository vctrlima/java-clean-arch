package com.victor.cleanarch.presentation.consumer;

import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.UpdateCustomerUseCase;
import com.victor.cleanarch.presentation.consumer.mapper.CustomerMessageMapper;
import com.victor.cleanarch.presentation.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedDocumentConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-document-validated", groupId = "victor")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.fromMessageToEntity(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }

}
