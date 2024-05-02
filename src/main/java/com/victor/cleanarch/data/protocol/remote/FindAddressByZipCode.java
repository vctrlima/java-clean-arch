package com.victor.cleanarch.data.protocol.remote;

import com.victor.cleanarch.domain.entity.Address;

public interface FindAddressByZipCode {

    Address find(String zipCode);

}
