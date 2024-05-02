package com.victor.cleanarch.data.usecase;

import com.victor.cleanarch.data.protocols.db.DeleteCustomerByIdRepository;
import com.victor.cleanarch.domain.usecase.DeleteCustomerByIdUseCase;
import com.victor.cleanarch.domain.usecase.FindCustomerByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    @Autowired
    private DeleteCustomerByIdRepository deleteCustomerByIdRepository;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Override
    public void deleteById(String id) {
        findCustomerByIdUseCase.findById(id);
        deleteCustomerByIdRepository.deleteById(id);
    }

}
