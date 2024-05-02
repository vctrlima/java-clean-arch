package com.victor.cleanarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;

    private String name;

    private String document;

    private Address address;

    private Boolean documentIsValid;

    public Customer() {
        this.documentIsValid = false;
    }

}
