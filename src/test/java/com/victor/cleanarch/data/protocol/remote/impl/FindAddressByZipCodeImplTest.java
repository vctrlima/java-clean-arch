package com.victor.cleanarch.data.protocol.remote.impl;

import com.victor.cleanarch.domain.entity.Address;
import com.victor.cleanarch.infra.client.FindAddressByZipCodeClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAddressByZipCodeImplTest {

    @InjectMocks
    private FindAddressByZipCodeImpl findAddressByZipCode;

    @Mock
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Test
    void find_ValidZipCode_ReturnExpectedAddress() {
        Address address = new Address();
        address.setCity("city");
        address.setState("state");
        address.setStreet("street");
        String zipCode = "zipCode";
        when(findAddressByZipCodeClient.find(zipCode)).thenReturn(address);

        Address result = findAddressByZipCode.find(zipCode);

        assertEquals(result, address);
    }

}