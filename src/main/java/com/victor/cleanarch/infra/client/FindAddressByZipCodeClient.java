package com.victor.cleanarch.infra.client;

import com.victor.cleanarch.domain.entity.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${victor.client.address.url}")
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    Address find(@PathVariable("zipCode") String zipCode);

}
