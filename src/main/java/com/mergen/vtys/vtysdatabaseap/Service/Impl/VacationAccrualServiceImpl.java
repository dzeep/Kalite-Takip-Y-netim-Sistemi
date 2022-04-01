package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Dto.VacationAccrualDto;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Model.VacationAccrual;
import com.mergen.vtys.vtysdatabaseap.Repository.VacationAccrualRepository;
import com.mergen.vtys.vtysdatabaseap.Service.VacationAccrualService;
import com.mergen.vtys.vtysdatabaseap.Service.VacationRequestService;
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
public class VacationAccrualServiceImpl implements VacationAccrualService {

    private final VacationAccrualRepository vacationAccrualRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<VacationAccrualDto> getVacationAccrualList()  {
        List<VacationAccrual> vacationAccrualList = (List<VacationAccrual>) vacationAccrualRepository.findAll();
        return vacationAccrualList.stream().map(vacationAccrual -> modelMapper.map(vacationAccrual, VacationAccrualDto.class)).collect(Collectors.toList());
    }
    @Override
    public VacationAccrualDto getVacationAccrualById(Long id){
        Optional<VacationAccrual> vacationAccrual = vacationAccrualRepository.findById(id);
        if (vacationAccrual.isPresent())
            return modelMapper.map(vacationAccrual.get(),VacationAccrualDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get Payments by ID Fail!");
    }

    @Override
    public VacationAccrualDto Create(VacationAccrualDto model){
        VacationAccrual vacationAccrual = modelMapper.map(model,VacationAccrual.class);
        Optional<VacationAccrual> _vacationAccrual = vacationAccrualRepository.findById(model.getId());
        if(_vacationAccrual.isEmpty())
            return modelMapper.map(vacationAccrualRepository.save(vacationAccrual),VacationAccrualDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id,VacationAccrualDto model){
        VacationAccrual vacationAccrual = modelMapper.map(model,VacationAccrual.class);
        Optional<VacationAccrual> _vacationAccrual = vacationAccrualRepository.findById(model.getId());
        if(_vacationAccrual.isPresent()){
            if(id.equals(model.getId())) {
                vacationAccrualRepository.save(vacationAccrual);
                return "ID:" + vacationAccrual.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<VacationAccrual> payments =vacationAccrualRepository.findById(id);
        if(payments.isPresent()){
            vacationAccrualRepository.deleteById(id);
            return (id +" deleted");}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }

}


    