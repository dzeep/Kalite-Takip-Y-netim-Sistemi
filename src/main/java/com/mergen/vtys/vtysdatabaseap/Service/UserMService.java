package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserMDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMService extends HelperService<UserMDto>{
    @Query("select u from user_m u ")
    List<UserMDto> getUserMLists();
    UserMDto getUserMById(Long id);
    UserMDto getUserMByName(String name);
    UserMDto getUserMEmailAndPassword(String email,String password);
    UserMDto getUserMNameAndPassword(String name, String password);
}
