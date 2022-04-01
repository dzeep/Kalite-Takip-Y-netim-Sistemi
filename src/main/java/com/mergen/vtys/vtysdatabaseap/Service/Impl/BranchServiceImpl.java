package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.BranchDto;
import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BranchDto> getBranchList() {
        List<Branch> branchList = (List<Branch>) branchRepository.findAll();
        return branchList.stream().map(branch -> modelMapper.map(branch, BranchDto.class)).collect(Collectors.toList());
    }

    @Override
    public BranchDto getBranchById(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent())
            return modelMapper.map(branch.get(),BranchDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get Payments by ID Fail!");
    }

    @Override
    public List<BranchDto> FindByCompanyid(@Param("company_id") Long company_id) {
        List<Branch> branchList = (List<Branch>) branchRepository.FindByCompanyID(company_id);
        return branchList.stream().map(branch -> modelMapper.map(branch, BranchDto.class)).collect(Collectors.toList());
    }

    @Override
    public BranchDto Create(BranchDto model) {
        Branch branch = modelMapper.map(model,Branch.class);
        Optional<Branch> _branch = branchRepository.findById(model.getId());
        if(_branch.isEmpty())
            return modelMapper.map(branchRepository.save(branch),BranchDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id, BranchDto model) {
        Branch branch = modelMapper.map(model,Branch.class);
        Optional<Branch> _branch = branchRepository.findById(id);
        if(_branch.isPresent()){
            if(id.equals(model.getId())) {
                branchRepository.save(branch);
                return "ID:" + branch.getId() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
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

}
