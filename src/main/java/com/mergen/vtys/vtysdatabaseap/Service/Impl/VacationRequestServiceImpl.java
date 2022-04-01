package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Dto.VacationRequestDto;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Model.VacationRequest;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.VacationRequestRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import com.mergen.vtys.vtysdatabaseap.Service.VacationRequestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import static java.time.temporal.ChronoUnit.DAYS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class VacationRequestServiceImpl implements VacationRequestService {

    private final VacationRequestRepository vacationRequestRepository;
    private  final UserDetailsRepository userDetailsRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<VacationRequestDto> getVacationRequestList()  {
        List<VacationRequest> vacationRequestList = (List<VacationRequest>) vacationRequestRepository.findAll();
        return vacationRequestList.stream().map(vacationRequest -> modelMapper.map(vacationRequest, VacationRequestDto.class)).collect(Collectors.toList());
    }
    @Override
    public VacationRequestDto getVacationRequestById(Long id){
        Optional<VacationRequest> vacationRequest = vacationRequestRepository.findById(id);
        if (vacationRequest.isPresent())
            return modelMapper.map(vacationRequest.get(),VacationRequestDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get Payments by ID Fail!");
    }

    @Override
    public String EarnedVacationDays(Long id) throws ParseException {
        String StringStartDate=  getVacationRequestRepository().getById(id).getWork_start_date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(StringStartDate);
        Long EarnedVacationDay= Long.valueOf(0);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateNow = LocalDate.now();
        int diff = (int) DAYS.between( localDate,  localDateNow);
        if(diff>=365){
            int vacation_numb = diff / 365;
            vacationRequestRepository.getById(id).setWorking_day_number(vacation_numb*14);
        }
        return "";
    }

    @Override
    public String GetDate_of_Start(@PathVariable() Long id){
        return vacationRequestRepository.GetDate_of_Start(id);
    }

    @Override
    public VacationRequestDto Create(VacationRequestDto model) throws ParseException {
        VacationRequest vacationRequest = modelMapper.map(model,VacationRequest.class);
        Optional<VacationRequest> _vacationRequest = vacationRequestRepository.findById(model.getId());
        if(_vacationRequest.isEmpty())
            return modelMapper.map(vacationRequestRepository.save(vacationRequest),VacationRequestDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id,VacationRequestDto model){
        VacationRequest vacationRequest = modelMapper.map(model,VacationRequest.class);
        Optional<VacationRequest> _vacationRequest = vacationRequestRepository.findById(id);
        if(_vacationRequest.isPresent()){
            if(id.equals(model.getId())) {
                vacationRequestRepository.save(vacationRequest);
                return "ID:" + vacationRequest.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<VacationRequest> vacationRequest = vacationRequestRepository.findById(id);
        if(vacationRequest.isPresent()){
            vacationRequestRepository.deleteById(id);
            return (id +" deleted");}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }

}

    