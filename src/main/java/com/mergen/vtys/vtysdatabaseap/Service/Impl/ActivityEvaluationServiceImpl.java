package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.ActivityEvaluation;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityEvaluationRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityEvaluationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ActivityEvaluationServiceImpl implements ActivityEvaluationService {

    private final ActivityEvaluationRepository activityEvaluationRepository;

    @Override
    public List<ActivityEvaluation> getActivityEvaluationList() {
        try {

            return (List<ActivityEvaluation>) activityEvaluationRepository.findAll();
        }
        catch(Exception e){
                throw new IllegalArgumentException(" Internal Server Error!");
            }
        }

    @Override
    public Optional<ActivityEvaluation> getActivityEvaluationById(Long id) {
        Optional<ActivityEvaluation> activityEvaluation = activityEvaluationRepository.findById(id);
        return activityEvaluation.isPresent() ? activityEvaluation : null;
    }

    @Override
    public ActivityEvaluation Create(ActivityEvaluation model) {
        activityEvaluationRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id, ActivityEvaluation model) {
        Optional<ActivityEvaluation> _activityEvaluation = activityEvaluationRepository.findById(id);
        if(_activityEvaluation.isPresent()){
            activityEvaluationRepository.save(model);
            return model.getEvaluation();}
       throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<ActivityEvaluation> activityEvaluation = activityEvaluationRepository.findById(id);
        if(activityEvaluation.isPresent()){
            activityEvaluationRepository.deleteById(id);
            return id.toString();}
        throw  new IllegalArgumentException(" Delete Option Fail!");
    }
}
