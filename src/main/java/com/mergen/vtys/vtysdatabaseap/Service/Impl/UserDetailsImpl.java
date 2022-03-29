package com.mergen.vtys.vtysdatabaseap.Service.Impl;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;


    @Override
    public Optional<UserDetails> getUserDetailsById(Long id){
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id).orElseThrow(() -> new IllegalStateException("Find by Id Internal Error")));

        return userDetails;
    }


    @Override
    public UserDetails Create(UserDetails model) {

        if(userDetailsRepository.existsByEmail(model.getTc_no())){
            throw new IllegalArgumentException("TC No Saved Before");
        }
        else
        userDetailsRepository.save(model);

        return model;
    }

    @Override
    public String  Update(Long id, UserDetails model) {
        Optional<UserDetails> _userDetails = userDetailsRepository.findById(id);
        if (_userDetails.isPresent()) {
            if (id == model.getId()) {
                model.setId(_userDetails.get().getId());
                userDetailsRepository.save(model);
                return model.getTc_no() + " Updated!";
            }
        }
         throw new IllegalArgumentException("Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);

        if(userDetails.isPresent()){
            userDetailsRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }

    @Override
    public List<UserDetails> getUserDetailsList() {
        return userDetailsRepository.findAll();
    }

    @Override
    public   Optional<UserDetails>findTcNo(String tc_no){
        return Optional.ofNullable(userDetailsRepository.findTcNo(tc_no)
                .orElseThrow(() -> new IllegalStateException("Find by Tc_no Internal Error")));
    }

    @Override
    public  Optional<UserDetails>FindByUserid(Long user_id){
        return Optional.ofNullable(userDetailsRepository.FindByUserid(user_id)
                .orElseThrow(() -> new IllegalStateException("Find by  User_Id Internal Error")));
    }
}