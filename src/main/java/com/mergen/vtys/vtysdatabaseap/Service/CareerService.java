package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Career;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface CareerService extends HelperService<Career> {
    List<Career> getCareerList();
    Optional<Career> getCareerById(Long id);
}
