package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.PaymentsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class PaymentsServiceImpl  implements PaymentsService {

    private final PaymentsRepository paymentsRepository;

    @Override
    public List<Payments> getPaymentsList()  {
        return (List<Payments>) paymentsRepository.findAll();
    }
    @Override
    public Optional<Payments> getPaymentsById(Long id){
        Optional<Payments> payments = paymentsRepository.findById(id);
        if (payments.isPresent()){
            return payments;
        }
        else
            throw new IllegalArgumentException(id + " Fail" + " And Get Payment by ID Fail!");

    }

    @Override
    public Payments Create(Payments model){
     //   Optional<Payments> payments = paymentsRepository.findEmailAndPassword(model.getEmail(),model.getPassword());

       // if (!payments.isPresent()) {
            paymentsRepository.save(model);
            return model;
      //  } else
      //      throw new IllegalArgumentException(model + " Already Exist!");
    }

    @Override
    public String Update(Long id,Payments model){
        Optional<Payments> payments = paymentsRepository.findById(id);
        if(payments.isPresent()){
            paymentsRepository.save(model);
            return model.toString();
        }
        else
            throw  new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<Payments> payments = paymentsRepository.findById(id);

        if(payments.isPresent()){
            paymentsRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }

}

    