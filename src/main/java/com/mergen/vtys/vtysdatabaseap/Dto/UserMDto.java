package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import lombok.Data;

import java.util.List;

@Data
public class UserMDto {

    private Long id;
    private String username;
    private String email ;
    private String title;
    private String cellphone;
    private List<ActiveToUser> activeToUsers;
    private List<UserDetails> userDetails;
}
