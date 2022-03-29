package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Company;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.CompanyRepository;
import com.mergen.vtys.vtysdatabaseap.Service.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "company")
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Company>> getCompanyList() {
        List<Company> companyList = companyService.getCompanyList();
        log.info("All Companies Returned - {}", companyList);
        return ResponseEntity.ok(companyList);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Optional<Company>> getCompanyByID(@PathVariable Long id) {
        Optional<Company> status = companyService.getCompanyByID(id);
        log.info("Company Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) throws ParseException {
        Company status = companyService.Create(company);
        log.info("Company Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        String status = companyService.Update(id,company);
        log.info("Company Updated Status - {}",status);
        return ResponseEntity.ok(company.getCompany_name() + " updated!");
    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable() Long id) {
        String status = companyService.Delete(id);
        log.info("Company Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th Company deleted!");
    }
}





    