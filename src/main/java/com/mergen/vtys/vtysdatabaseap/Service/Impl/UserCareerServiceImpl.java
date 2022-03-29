package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Model.UserCareer;
import com.mergen.vtys.vtysdatabaseap.Repository.UserCareerRepository;
import com.mergen.vtys.vtysdatabaseap.Service.TitleService;
import com.mergen.vtys.vtysdatabaseap.Service.UserCareerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserCareerServiceImpl implements UserCareerService {
    private final UserCareerRepository userCareerRepository;
    @Override
    public List<UserCareer> getUserCareerList(){
        return userCareerRepository.findAll();
    }
    @Override
    public Optional<UserCareer> getUserCareerByID(Long id) {
        Optional<UserCareer>  title = Optional.ofNullable(userCareerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Find by Id Internal Error")));
        return title;

    }

    @Override
    public UserCareer Create(UserCareer model) {
        userCareerRepository.save(model);
        return model;
    }

    @Override
    public String  Update(Long id, UserCareer model) {
        try {
            userCareerRepository.save(model);
            return model.getCareer_id().toString();
        }
        catch(Exception e){
            throw new IllegalArgumentException(" Internal Server Error!");
        }

    }

    @Override
    public String Delete(Long id) {
        Optional<UserCareer> userCareer =userCareerRepository.findById(id);

        if(userCareer.isPresent()){
            userCareerRepository.deleteById(id);
            return (id +" deleted");}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }



}

    