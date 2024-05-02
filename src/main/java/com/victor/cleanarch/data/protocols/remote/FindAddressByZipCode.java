package com.victor.cleanarch.data.protocols.remote;

import com.victor.cleanarch.domain.entity.Address;

public interface FindAddressByZipCode {

    Address find(String zipCode);

}
