package com.victor.cleanarch.presentation.consumer.mapper;

import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.presentation.consumer.message.CustomerMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer fromMessageToEntity(CustomerMessage message);

}
