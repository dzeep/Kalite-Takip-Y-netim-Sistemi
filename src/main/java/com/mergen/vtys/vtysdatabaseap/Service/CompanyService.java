package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.CompanyDto;
import com.mergen.vtys.vtysdatabaseap.Model.Company;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CompanyService extends HelperService<CompanyDto> {
    List<CompanyDto> getCompanyList();
    CompanyDto getCompanyByID(Long id);
}
