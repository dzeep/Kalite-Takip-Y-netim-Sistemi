package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.ActivityEvaluation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ActivityEvaluationService extends HelperService<ActivityEvaluation>{
    List<ActivityEvaluation> getActivityEvaluationList();
    Optional<ActivityEvaluation> getActivityEvaluationById(Long id);
    /*String createActivityEvaluation(ActivityEvaluation activityEvaluation);
    String updateActivityEvaluation(Long id, ActivityEvaluation activityEvaluation);
    String deleteActivityEvaluation(Long id);*/
}
