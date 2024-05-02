package com.victor.cleanarch.presentation.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerRequestDTO {
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String document;

    @NotBlank
    private String zipCode;

}
