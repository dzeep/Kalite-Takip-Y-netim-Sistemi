package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.VacationAccrual;
import com.mergen.vtys.vtysdatabaseap.Repository.VacationAccrualRepository;
import com.mergen.vtys.vtysdatabaseap.Service.VacationAccrualService;
import com.mergen.vtys.vtysdatabaseap.Service.VacationRequestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class VacationAccrualServiceImpl implements VacationAccrualService {
    private final VacationAccrualRepository vacationAccrualRepository;

    @Override
    public List<VacationAccrual> getVacationAccrualList()  {
        return (List<VacationAccrual>) vacationAccrualRepository.findAll();
    }
    @Override
    public Optional<VacationAccrual> getVacationAccrualById(Long id){
        Optional<VacationAccrual> vacationAccrual = vacationAccrualRepository.findById(id);
        if (vacationAccrual.isPresent()){
            return vacationAccrual;
        }
        else
            throw new IllegalArgumentException(id + " Fail" + " And Get Vacation Accrual by ID Fail!");

    }

    @Override
    public VacationAccrual Create(VacationAccrual model){
        //   Optional<Payments> payments = paymentsRepository.findEmailAndPassword(model.getEmail(),model.getPassword());

        // if (!payments.isPresent()) {
        vacationAccrualRepository.save(model);
        return model;
        //  } else
        //      throw new IllegalArgumentException(model + " Already Exist!");
    }

    @Override
    public String Update(Long id,VacationAccrual model){
        Optional<VacationAccrual> vacationAccruals = vacationAccrualRepository.findById(id);
        if(vacationAccruals .isPresent()){
            vacationAccrualRepository.save(model);
            return model.toString();
        }
        else
            throw  new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<VacationAccrual> vacationAccrual = vacationAccrualRepository.findById(id);

        if(vacationAccrual.isPresent()){
        vacationAccrualRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }

}


    