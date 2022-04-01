package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.UserCareerDto;
import com.mergen.vtys.vtysdatabaseap.Model.UserCareer;
import com.mergen.vtys.vtysdatabaseap.Repository.UserCareerRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserCareerService;
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
public class UserCareerServiceImpl implements UserCareerService {
    private final UserCareerRepository userCareerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserCareerDto> getUserCareerList(){
        List<UserCareer> userCareerList = (List<UserCareer>) userCareerRepository.findAll();
        return userCareerList.stream().map(userCareer -> modelMapper.map(userCareer, UserCareerDto.class)).collect(Collectors.toList());
    }
    @Override
    public UserCareerDto getUserCareerByID(Long id) {
        Optional<UserCareer> userCareer = userCareerRepository.findById(id);
        if (userCareer.isPresent())
            return modelMapper.map(userCareer.get(), UserCareerDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get User Details by ID Fail!");
    }

    @Override
    public UserCareerDto Create(UserCareerDto model) {
        UserCareer userCareer = modelMapper.map(model,UserCareer.class);
        Optional<UserCareer> _userCareer = userCareerRepository.findById(model.getId());
        if(_userCareer.isEmpty())
            return modelMapper.map(userCareerRepository.save(userCareer), UserCareerDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String  Update(Long id, UserCareerDto model) {
        UserCareer userCareer = modelMapper.map(model,UserCareer.class);
        Optional<UserCareer> _userCareer = userCareerRepository.findById(id);
        if(_userCareer.isPresent()){
            if(id.equals(model.getId())) {
                userCareerRepository.save(userCareer);
                return "ID:" + userCareer.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<UserCareer> userCareer =userCareerRepository.findById(id);
        if(userCareer.isPresent()){
            userCareerRepository.deleteById(id);
            return (id +" deleted");}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }

}

