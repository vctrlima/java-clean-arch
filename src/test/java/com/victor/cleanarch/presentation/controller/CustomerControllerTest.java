package com.victor.cleanarch.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victor.cleanarch.domain.entity.Customer;
import com.victor.cleanarch.domain.usecase.DeleteCustomerByIdUseCase;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import com.victor.cleanarch.domain.usecase.InsertCustomerUseCase;
import com.victor.cleanarch.domain.usecase.UpdateCustomerUseCase;
import com.victor.cleanarch.presentation.model.dto.*;
import com.victor.cleanarch.presentation.model.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InsertCustomerUseCase insertCustomerUseCase;

    @MockBean
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @MockBean
    private UpdateCustomerUseCase updateCustomerUseCase;

    @MockBean
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @MockBean
    private CustomerMapper customerMapper;

    @Test
    void insert_NewCustomer_ReturnCreated() throws Exception {
        InsertCustomerRequestDTO dto = new InsertCustomerRequestDTO();
        dto.setName("name");
        dto.setDocument("document");
        dto.setZipCode("zipCode");
        Customer entity = new Customer();
        entity.setId("id");
        entity.setName(dto.getName());
        entity.setDocument(dto.getDocument());
        entity.setDocumentIsValid(false);
        when(customerMapper.fromInsertRequestDTOtoEntity(dto)).thenReturn(entity);
        when(insertCustomerUseCase.insert(entity, dto.getZipCode())).thenReturn(entity);
        InsertCustomerResponseDTO response = new InsertCustomerResponseDTO();
        response.setId("id");
        response.setName(dto.getName());
        response.setDocument(dto.getDocument());
        response.setDocumentIsValid(false);
        when(customerMapper.fromEntityToInsertResponseDTO(entity)).thenReturn(response);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(response)));
    }

    @Test
    void findById_ExistentCustomer_ReturnOk() throws Exception {
        String id = "id";
        Customer customer = new Customer();
        customer.setId(id);
        when(findCustomerByIdUseCase.findById(id)).thenReturn(customer);
        FindCustomerByIdResponseDTO dto = new FindCustomerByIdResponseDTO();
        dto.setId(customer.getId());
        dto.setDocumentIsValid(false);
        when(customerMapper.fromEntityToFindByIdResponseDTO(customer)).thenReturn(dto);
        String url = String.format("/api/v1/customers/%s", id);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(get(url)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(customer)));
    }

    @Test
    void update_ExistentCustomer_ReturnOk() throws Exception {
        String id = "id";
        UpdateCustomerRequestDTO dto = new UpdateCustomerRequestDTO();
        dto.setId(id);
        dto.setName("name");
        dto.setDocument("document");
        dto.setZipCode("zipCode");
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDocument(dto.getDocument());
        entity.setDocumentIsValid(false);
        when(customerMapper.fromUpdateRequestDTOtoEntity(dto)).thenReturn(entity);
        when(updateCustomerUseCase.update(entity, dto.getZipCode())).thenReturn(entity);
        UpdateCustomerResponseDTO response = new UpdateCustomerResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDocument(entity.getDocument());
        response.setDocumentIsValid(entity.getDocumentIsValid());
        when(customerMapper.fromEntityToUpdateResponseDTO(entity)).thenReturn(response);
        String url = String.format("/api/v1/customers/%s", id);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(put(url).contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(entity)));
    }

    @Test
    void delete_ExistentCustomer_ReturnNoContent() throws Exception {
        String id = "id";
        String url = String.format("/api/v1/customers/%s", id);

        mockMvc.perform(delete(url)).andDo(print()).andExpect(status().isNoContent());
    }

}