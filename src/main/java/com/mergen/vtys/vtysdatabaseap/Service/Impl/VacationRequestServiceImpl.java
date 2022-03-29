package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.VacationRequest;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.VacationAccrualRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.VacationRequestRepository;
import com.mergen.vtys.vtysdatabaseap.Service.VacationRequestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class VacationRequestServiceImpl implements VacationRequestService {
    private final VacationRequestRepository vacationRequestRepository;
    private  final UserDetailsRepository userDetailsRepository;
    private final VacationAccrualRepository vacationAccrualRepository;
    @Override
    public List<VacationRequest> getVacationRequestList()  {
        return (List<VacationRequest>) vacationRequestRepository.findAll();
    }
    @Override
    public Optional<VacationRequest> getVacationRequestById(Long id){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(id);
        if (vacationRequestOptional.isPresent()){
            return vacationRequestOptional;
        }
        else
            throw new IllegalArgumentException(id + " Fail" + " And Get Vacation by ID Fail!");

    }

    @Override
    public VacationRequest Create(VacationRequest model) throws ParseException {
        vacationRequestRepository.save(model);
        model.setId(model.getId());
        //   Optional<Payments> payments = paymentsRepository.findEmailAndPassword(model.getEmail(),model.getPassword());
        String start_date = userDetailsRepository.findById(model.getUser_detail_id()).get().getDate_of_start();
        System.out.print(model);
        model.setWork_start_date(start_date);
      //  vacationRequestRepository.save(model);
        EarnedVacationDays(model.getId());
        vacationRequestRepository.save(model);
        System.out.print(model);
        model.setEarned_vacation_days((EarnedVacationDays(model.getId())));
        System.out.print(model);
        model.setVacation_type(model.getVacation_type());
        model.setSicil_no(model.getSicil_no());
        model.setRecognizant(model.getRecognizant());

        vacationRequestRepository.save(model);

        //   model.setVacation_request_status(String.valueOf(vacationRequestRepository.GetVacationRequestSicilNo(model.getSicil_no())));
      //  vacationRequestRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id,VacationRequest model){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(id);
        if(vacationRequestOptional.isPresent()){
            vacationRequestRepository.save(model);
            return model.toString();
        }
        else
            throw  new IllegalArgumentException(model + " Update Option Fail!");
    }
    @Override
    public String Delete(Long id){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(id);

        if(vacationRequestOptional.isPresent()){
            vacationRequestRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }
    @Override
    public Long EarnedVacationDays(Long id) throws ParseException {
        String StringStartDate = getVacationRequestRepository().getById(id).getWork_start_date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(StringStartDate);
        Long EarnedVacationDay = Long.valueOf(0);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateNow = LocalDate.now();
        Long diff = YEARS.between(localDate, localDateNow);
        if (diff >= 1) {
//            Long vacation_numb = (diff / 365) * 14;
//            System.out.print("AAAAAAAAAAAAaaa "+ vacation_numb + " ");
            return diff*14;
        } else
            System.out.print("NEEEEEE  ");
            return 0L;

    }
    @Override
    public String GetDate_of_Start(@PathVariable() Long id){
        String string = vacationRequestRepository.GetDate_of_Start(id);

        return string;
    }

}

    