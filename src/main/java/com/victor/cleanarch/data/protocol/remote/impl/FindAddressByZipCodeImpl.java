package com.victor.cleanarch.data.protocol.remote.impl;

import com.victor.cleanarch.data.protocol.remote.FindAddressByZipCode;
import com.victor.cleanarch.domain.entity.Address;
import com.victor.cleanarch.infra.client.FindAddressByZipCodeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Override
    public Address find(String zipCode) {
        return findAddressByZipCodeClient.find(zipCode);
    }

}
