package com.mergen.vtys.vtysdatabaseap.Service.Impl;


import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Repository.TitleRepository;
import com.mergen.vtys.vtysdatabaseap.Service.TitleService;
import liquibase.pro.packaged.T;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {
    private final TitleRepository titleRepository;
    @Override
    public List<Title> getTitleList(){
        return titleRepository.findAll();
    }
    @Override
    public Optional<Title> getTitleByID(Long id) {
        Optional<Title>  title = Optional.ofNullable(titleRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Find by Id Internal Error")));
        return title;

    }

    @Override
    public Title Create(Title model) {
        titleRepository.save(model);
        return model;
    }

    @Override
    public String  Update(Long id, Title model) {
        try {
            titleRepository.save(model);
            return model.getTitle_name();
        }
        catch(Exception e){
            throw new IllegalArgumentException(" Internal Server Error!");
        }

    }

    @Override
    public String Delete(Long id) {
        Optional<Title> title_ = titleRepository.findById(id);

        if(title_.isPresent()){
            titleRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }


  @Override
  public List<Optional<Title>> getDepartmentId(@Param("department_id") Long department_id){
      List<Optional<Title>> titlelist = titleRepository.getDepartmentId(department_id);
     return titlelist;
  }




}