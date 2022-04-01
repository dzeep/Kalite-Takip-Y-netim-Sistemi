package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserCareerDto;

import java.util.List;

public interface UserCareerService extends HelperService<UserCareerDto> {
    List<UserCareerDto> getUserCareerList();
    UserCareerDto getUserCareerByID(Long id);
}
