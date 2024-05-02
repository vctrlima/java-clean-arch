package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocols.db.DeleteCustomerByIdRepository;
import com.victor.cleanarch.domain.usecase.DeleteCustomerByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    @Autowired
    private DeleteCustomerByIdRepository deleteCustomerByIdRepository;

    @Override
    public void deleteById(String id) {
        deleteCustomerByIdRepository.deleteById(id);
    }

}
