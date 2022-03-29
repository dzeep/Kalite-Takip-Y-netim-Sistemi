package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Career;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.CareerRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.CareerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;

    @Override
    public List<Career> getCareerList() {
        return (List<Career>) careerRepository.findAll();
    }

    @Override
    public Optional<Career> getCareerById(Long id) {

        Optional<Career> career = careerRepository.findById(id);
        if (career.isPresent()){
            return career;
        }
        else
            throw new IllegalArgumentException(id + " Fail" + " And Get Career by ID Fail!");
    }

    @Override
    public Career Create(Career model) {
       // Optional<Career> career = careerRepository.findEmailAndPassword(model.getEmail(),model.getPassword());

      //  if (!career.isPresent()) {
            careerRepository.save(model);
            return model;
       // } else
         //   throw new IllegalArgumentException(model + " Already Exist!");
    }

    @Override
    public String Update(Long id, Career model) {
        Optional<Career> career = careerRepository.findById(id);
        if(career.isPresent()){
            careerRepository.save(model);
            return model.getAdmin_name();}
        else
            throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<Career> career = careerRepository.findById(id);

        if(career.isPresent()){
            careerRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }
}
