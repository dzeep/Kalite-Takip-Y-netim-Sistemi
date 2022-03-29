package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Company;
import com.mergen.vtys.vtysdatabaseap.Repository.CompanyRepository;
import com.mergen.vtys.vtysdatabaseap.Service.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanyList() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyByID(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            return  company;
        }
        else
        throw new IllegalArgumentException(" Internal Server Error" + " And Get Company by ID Fail!");

    }

    @Override
    public Company Create(Company model) {
        companyRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id, Company model) {
        Optional<Company> _company = companyRepository.findById(id);
        if(_company.isPresent()){
            companyRepository.save(model);
            return model.getCompany_name();}
        else
            throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            companyRepository.deleteById(id);
            return id.toString();}
        else
        throw new  IllegalArgumentException(" Delete Option Fail!");
    }
}
