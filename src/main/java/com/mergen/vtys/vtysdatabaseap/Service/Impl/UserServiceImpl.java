package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.C.Security.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import com.mergen.vtys.vtysdatabaseap.Repository.UserMRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserMService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserMService {

    private final UserMRepository userMRepository;

    @Query(value = "SELECT * from user_m", nativeQuery = true)
    @Override
    public List<UserM> getUserLists(){return userMRepository.findAll();}


    @Override
    public Optional<UserM> getUserById(Long id){
        Optional<UserM> userM = userMRepository.findById(id);
        if (userM.isPresent()){
          return userM;
        }
        else
        throw new IllegalArgumentException(id + " Fail" + " And Get User by ID Fail!");

    }

    @Override
    public Optional<UserM> getUserByName(String name){
   Optional<UserM> userM = userMRepository.findByName(name);
    if (userM.isPresent()){
            return userM;
        }
        else
        throw new IllegalArgumentException(name + " Auth Fail");

    }

//    @Override
//    public Optional<User> getUserNameAndPassword(String name, String password) {
//        Optional<User> user = userRepository.findNameAndPassword(name,password);
//        if (user.isPresent()){
//            return user;
//        }
//        else
//        throw new IllegalArgumentException(name + password + " Auth Fail!");
//
//    }

/*
    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
*/


//    @Override
//    public Optional<User> getUserEmailAndPassword(String email, String password) {
//        Optional<User> user = userRepository.findEmailAndPassword(email,password);
//        if (user.isPresent()){
//            return user;
//        }
//        else
//            throw new IllegalArgumentException(email + password + " Auth Fail!");
//
//    }

    @Override
    public UserM Create(UserM model) {
        Optional<UserM> _userM = userMRepository.findByUsername(model.getUsername());

        if (!_userM.isPresent()) {
            userMRepository.save(model);
            return model;
        } else
            throw new IllegalArgumentException(model + " Already Exist!");
    }

    @Override
    public String Update(Long id, UserM model) {
    Optional<UserM> _userM = userMRepository.findById(id);
        if(_userM.isPresent()){
            userMRepository.save(model);
            return model.getUsername();}
        else
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
