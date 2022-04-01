package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.CompanyDto;
import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Model.Company;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Repository.CompanyRepository;
import com.mergen.vtys.vtysdatabaseap.Service.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CompanyDto> getCompanyList() {
        List<Company> companyList = (List<Company>) companyRepository.findAll();
        return companyList.stream().map(company -> modelMapper.map(company, CompanyDto.class)).collect(Collectors.toList());
    }

    @Override
    public CompanyDto getCompanyByID(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent())
            return modelMapper.map(company.get(),CompanyDto.class);
        throw new IllegalArgumentException("ID:" + id + " Fail" + " And Get Payments by ID Fail!");
    }

    @Override
    public CompanyDto Create(CompanyDto model) {
        Company company = modelMapper.map(model,Company.class);
        Optional<Company> _company = companyRepository.findById(model.getId());
        if(_company.isEmpty())
            return modelMapper.map(companyRepository.save(company),CompanyDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id, CompanyDto model) {
        Company company = modelMapper.map(model,Company.class);
        Optional<Company> _company = companyRepository.findById(id);
        if(_company.isPresent()){
            if(id.equals(model.getId())) {
                companyRepository.save(company);
                return "ID:" + company.getId() + " Updated!";}}
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
