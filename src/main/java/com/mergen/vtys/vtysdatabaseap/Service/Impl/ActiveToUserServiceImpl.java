
package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.ActiveToUserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActiveToUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ActiveToUserServiceImpl implements ActiveToUserService {

    private final ActiveToUserRepository activeToUserRepository;

    @Override
    public List<ActiveToUser> getActivityList() {
        return (List<ActiveToUser>) activeToUserRepository.findAll();
    }

    @Override
    public Optional<ActiveToUser> getActivityById(Long id) {
        Optional<ActiveToUser> activeToUser = activeToUserRepository.findById(id);
        if (activeToUser.isPresent()) {
            return activeToUser;

        }
        else
            throw new IllegalArgumentException(" There Is No ActiveToUser!");
    }

    @Override
    public ActiveToUser Create(ActiveToUser model) {
        activeToUserRepository.save(model);
        return null;
    }

    @Override
    public String Update(Long id, ActiveToUser model) {

        Optional<ActiveToUser> activeToUser = activeToUserRepository.findById(id);
        if(activeToUser.isPresent()){
            activeToUserRepository.save(model);
            return "User ID:" + model.getUser_ids().toString() + " And Activity ID:" + model.getActivity_ids().toString() + " Updated!";}
        else
            throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<ActiveToUser> activeToUser = activeToUserRepository.findById(id);
        if(activeToUser.isPresent()){
            activeToUserRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }

    @Override
    public List<Object> getUsersEnrolled(Long id) {
        return activeToUserRepository.getUsersEnrolled(id);
    }

    @Override
    public List<Long> getUsersEnrolledIDs(Long id){ return  activeToUserRepository.getUsersEnrolledIDs(id);
    }
}

