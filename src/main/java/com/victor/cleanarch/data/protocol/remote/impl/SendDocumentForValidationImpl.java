package com.victor.cleanarch.data.protocol.remote.impl;

import com.victor.cleanarch.data.protocol.remote.SendDocumentForValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendDocumentForValidationImpl implements SendDocumentForValidation {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String document) {
        kafkaTemplate.send("tp-document-validation", document);
    }

}
