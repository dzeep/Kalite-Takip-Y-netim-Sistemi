package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public List<Branch> getBranchList() {
        return (List<Branch>) branchRepository.findAll();
    }

    @Override
    public Optional<Branch> getBranchById(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            return branch;
        }
        throw new IllegalArgumentException(id + " Not Found!");
    }

    @Override
    public Branch Create(Branch model) {
        branchRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id, Branch model) {
        Optional<Branch> _branch = branchRepository.findById(id);
        if(_branch.isPresent()){
            branchRepository.save(model);
            return model.getBranch_name();
        }
        else
        throw  new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if(branch.isPresent()){
            branchRepository.deleteById(id);
            return id.toString();}
        else
        throw new IllegalArgumentException(" Delete Option Fail!");
    }
    @Override
    public List<Branch> FindByCompanyid(@Param("company_id") Long company_id) {
        try {
            return branchRepository.FindByCompanyid(company_id);
        } catch (Exception e) {
            throw new IllegalArgumentException(" Internal Server Error!");
        }
    }

}
