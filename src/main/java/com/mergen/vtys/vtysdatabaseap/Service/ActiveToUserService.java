package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ActiveToUserService extends HelperService<ActiveToUser> {
    List<ActiveToUser> getActivityList();
    Optional<ActiveToUser> getActivityById(Long id);
    List<Object> getUsersEnrolled(Long id);
    List<Long> getUsersEnrolledIDs(Long id);
}
