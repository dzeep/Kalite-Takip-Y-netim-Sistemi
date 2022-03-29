package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Activity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ActivityService extends HelperService<Activity> {
    List<Activity> getActivityList();
    Optional<Activity> getActivityById(Long id);
    Optional<Activity> getActivityByName(String name);
}
