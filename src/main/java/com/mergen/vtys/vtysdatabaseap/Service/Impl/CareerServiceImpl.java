package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.CareerDto;
import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Dto.UserMDto;
import com.mergen.vtys.vtysdatabaseap.Model.*;
import com.mergen.vtys.vtysdatabaseap.Repository.CareerRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.CareerService;
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
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CareerDto> getCareerList() {
        List<Career> careerList = (List<Career>) careerRepository.findAll();
        return careerList.stream().map(career -> modelMapper.map(career, CareerDto.class)).collect(Collectors.toList());
    }

    @Override
    public CareerDto getCareerById(Long id) {

        Optional<Career> career = careerRepository.findById(id);
        if (career.isPresent())
            return modelMapper.map(career.get(),CareerDto.class);
        throw new IllegalArgumentException(id + " Fail" + " And Get User by ID Fail!");
    }

    @Override
    public CareerDto Create(CareerDto model) {
        Career career = modelMapper.map(model,Career.class);
        Optional<Career> _career = careerRepository.findById(model.getId());
        if(_career.isEmpty())
            return modelMapper.map(careerRepository.save(career), CareerDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id, CareerDto model) {
        Career career = modelMapper.map(model,Career.class);
        Optional<Career> _career = careerRepository.findById(id);
        if(_career.isPresent()){
            if(id.equals(model.getId())) {
                 careerRepository.save(career);
                return "ID:" + career.getId() + " Updated!";}}
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
