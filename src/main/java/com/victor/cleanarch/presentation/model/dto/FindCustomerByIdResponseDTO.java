package com.victor.cleanarch.presentation.model.dto;

import com.victor.cleanarch.domain.entity.Address;
import lombok.Data;

@Data
public class FindCustomerByIdResponseDTO {

    private String id;

    private String name;

    private String document;

    private Address address;

    private Boolean documentIsValid;

}
