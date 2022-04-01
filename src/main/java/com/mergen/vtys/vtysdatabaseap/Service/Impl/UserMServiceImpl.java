package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.UserMDto;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import com.mergen.vtys.vtysdatabaseap.Repository.UserMRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserMService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class UserMServiceImpl implements UserMService {

    private final UserMRepository userMRepository;
    private final ModelMapper modelMapper;

    @Query(value = "SELECT * from userM", nativeQuery = true)
    @Override
    public List<UserMDto> getUserMLists(){
        List<UserM> userMList = (List<UserM>) userMRepository.findAll();
        return userMList.stream().map(userM -> modelMapper.map(userM,UserMDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserMDto getUserMById(Long id){
        Optional<UserM> userM = userMRepository.findById(id);
        if (userM.isPresent())
            return modelMapper.map(userM.get(),UserMDto.class);
        throw new IllegalArgumentException(id + " Fail" + " And Get User by ID Fail!");
    }

    @Override
    public UserMDto getUserMByName(String name){
        Optional<UserM> userM = userMRepository.findByName(name);
        if (userM.isPresent())
            return modelMapper.map(userM.get(),UserMDto.class);
        throw new IllegalArgumentException(name + " Auth Fail");
    }

    @Override
    public UserMDto getUserMNameAndPassword(String name, String password) {
        Optional<UserM> userM = userMRepository.findNameAndPassword(name,password);
        if (userM.isPresent())
            return modelMapper.map(userM.get(),UserMDto.class);
        throw new IllegalArgumentException(name + password + " Auth Fail!");
    }

    @Override
    public UserMDto getUserMEmailAndPassword(String email, String password) {
        Optional<UserM> userM = userMRepository.findEmailAndPassword(email,password);
        if (userM.isPresent())
            return modelMapper.map(userM.get(),UserMDto.class);
        throw new IllegalArgumentException(email + password + " Auth Fail!");
    }

    @Override
    public UserMDto Create(UserMDto model) {
        UserM userM = modelMapper.map(model,UserM.class);
        Optional<UserM> _userM = userMRepository.findEmailAndName(model.getEmail(), model.getUsername());
        if(_userM.isEmpty())
            return modelMapper.map(userMRepository.save(userM),UserMDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id, UserMDto model) {
        UserM userM = modelMapper.map(model,UserM.class);
        Optional<UserM> _userM = userMRepository.findById(id);
        if(_userM.isPresent()){
            if(id.equals(model.getId())) {
                userMRepository.save(userM);
                return userM.getUsername() + " Updated!";
            }
        }
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<UserM> userM = userMRepository.findById(id);
        if(userM.isPresent()){
            userMRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }
}
