package com.victor.cleanarch.presentation.model.mapper;

import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.presentation.model.dto.FindCustomerByIdResponseDTO;
import com.victor.cleanarch.presentation.model.dto.InsertCustomerRequestDTO;
import com.victor.cleanarch.presentation.model.dto.InsertCustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "documentIsValid", ignore = true)
    Customer fromInsertRequestDTOtoEntity(InsertCustomerRequestDTO dto);

    InsertCustomerResponseDTO fromEntityToInsertResponseDTO(Customer entity);

    FindCustomerByIdResponseDTO fromEntityToFindByIdResponseDTO(Customer entity);
}
