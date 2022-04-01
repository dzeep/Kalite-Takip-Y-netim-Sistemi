package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Repository.PaymentsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class PaymentsServiceImpl  implements PaymentsService {

    private final PaymentsRepository paymentsRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PaymentsDto> getPaymentsList()  {
        List<Payments> paymentsList = (List<Payments>) paymentsRepository.findAll();
        return paymentsList.stream().map(payments -> modelMapper.map(payments, PaymentsDto.class)).collect(Collectors.toList());
    }
    @Override
    public PaymentsDto getPaymentsById(Long id){
        Optional<Payments> payments = paymentsRepository.findById(id);
        if (payments.isPresent())
            return modelMapper.map(payments.get(),PaymentsDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get Payments by ID Fail!");
    }

    @Override
    public PaymentsDto Create(PaymentsDto model){
        Payments payments = modelMapper.map(model,Payments.class);
        Optional<Payments> _payments = paymentsRepository.findById(model.getId());
        if(_payments.isEmpty())
            return modelMapper.map(paymentsRepository.save(payments),PaymentsDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id,PaymentsDto model){
        Payments payments = modelMapper.map(model,Payments.class);
        Optional<Payments> _payments = paymentsRepository.findById(id);
        if(_payments.isPresent()){
            if(id.equals(model.getId())) {
                paymentsRepository.save(payments);
                return "ID:" + payments.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<Payments> payments =paymentsRepository.findById(id);
        if(payments.isPresent()){
            paymentsRepository.deleteById(id);
            return (id +" deleted");}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }
}

    