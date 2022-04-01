package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserMDto;
import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ActiveToUserService extends HelperService<ActiveToUser> {
    List<ActiveToUser> getActivityList();
    Optional<ActiveToUser> getActivityById(Long id);
    List<Object> getUsersEnrolled(Long id);
    List<Long> getUsersEnrolledIDs(Long id);

    interface UserService extends HelperService<UserMDto>{
      // @Query(value = "SELECT * from user",nativeQuery = true)
      @Query("Select u From User u ")
      List<UserMDto> getUserMLists();
      UserMDto getUserMById(Long id);
      UserMDto getUserMByName(String name);
      UserMDto getUserMEmailAndPassword(String email,String password);

      // @Query(value = "SELECT * from User Where name=? and password=?", nativeQuery = true)
      UserMDto getUserMNameAndPassword(String name, String password);
       /* String createUser(User user);
        String updateUser(Long id, User user);
        String deleteUser(Long id);*/


    }
}
