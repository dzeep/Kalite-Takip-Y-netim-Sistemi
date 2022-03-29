package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserMService extends HelperService<UserM>{
  // @Query(value = "SELECT * from user",nativeQuery = true)
    @Query("Select u From User u ")
    List<UserM> getUserLists();
    Optional<UserM> getUserById(Long id);
    Optional<UserM> getUserByName(String name);

    //Optional<UserM> getUserEmailAndPassword(String email,String password);

/*   @Query(value = "SELECT * from User Where name=? and password=?", nativeQuery = true)
    Optional<UserM> getUserNameAndPassword(String name, String password);*/


   /* String createUser(User user);
    String updateUser(Long id, User user);
    String deleteUser(Long id);*/


 /*  Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);*/
}
