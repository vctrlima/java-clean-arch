package com.victor.cleanarch.presentation.controller;

import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.DeleteCustomerByIdUseCase;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import com.victor.cleanarch.domain.usecase.InsertCustomerUseCase;
import com.victor.cleanarch.domain.usecase.UpdateCustomerUseCase;
import com.victor.cleanarch.presentation.model.dto.*;
import com.victor.cleanarch.presentation.model.mapper.CustomerMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<InsertCustomerResponseDTO> insert(@Valid @RequestBody InsertCustomerRequestDTO dto) {
        Customer customer = customerMapper.fromInsertRequestDTOtoEntity(dto);
        Customer entity = insertCustomerUseCase.insert(customer, dto.getZipCode());
        InsertCustomerResponseDTO response = customerMapper.fromEntityToInsertResponseDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindCustomerByIdResponseDTO> findById(@NotBlank @PathVariable String id) {
        Customer entity = findCustomerByIdUseCase.findById(id);
        FindCustomerByIdResponseDTO response = customerMapper.fromEntityToFindByIdResponseDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCustomerResponseDTO> update(@NotBlank @PathVariable String id, UpdateCustomerRequestDTO dto) {
        dto.setId(id);
        Customer customer = customerMapper.fromUpdateRequestDTOtoEntity(dto);
        Customer entity = updateCustomerUseCase.update(customer, dto.getZipCode());
        UpdateCustomerResponseDTO response = customerMapper.fromEntityToUpdateResponseDTO(entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@NotBlank @PathVariable String id) {
        deleteCustomerByIdUseCase.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
