package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Model.UserCareer;
import java.util.List;
import java.util.Optional;

public interface UserCareerService extends HelperService<UserCareer> {
    List<UserCareer> getUserCareerList();
    Optional<UserCareer> getUserCareerByID(Long id);
}
