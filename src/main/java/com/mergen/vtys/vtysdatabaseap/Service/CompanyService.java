package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Company;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CompanyService extends HelperService<Company> {
    List<Company> getCompanyList();
    Optional<Company> getCompanyByID(Long id);
   /* String createCompany(Company company);
    String updateCompany(Long id, Company company);
    String deleteCompany(Long id);*/
}
