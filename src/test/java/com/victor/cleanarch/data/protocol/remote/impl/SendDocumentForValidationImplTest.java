package com.victor.cleanarch.data.protocol.remote.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SendDocumentForValidationImplTest {

    @InjectMocks
    private SendDocumentForValidationImpl sendDocumentForValidation;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void send_KafkaTopic_ShouldCallKafkaService1Time() {
        String document = "document";

        sendDocumentForValidation.send(document);

        verify(kafkaTemplate, times(1)).send("tp-document-validation", document);
    }

}