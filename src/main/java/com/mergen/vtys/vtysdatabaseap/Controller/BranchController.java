package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Dto.BranchDto;
import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
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
@RequestMapping("branch")
@Slf4j
public class BranchController {

    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<BranchDto>> getBranchList() {
        List<BranchDto> branchList = branchService.getBranchList();
        log.info("All Branches Returned - {}",branchList);
        return ResponseEntity.ok(branchList);
    }

    @GetMapping(value = "list/{id}")
    public ResponseEntity<BranchDto> getBranchById(@PathVariable Long id) {
        BranchDto status = branchService.getBranchById(id);
        log.info("Branch Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/find/company:{company_id}")
    public ResponseEntity<List<BranchDto>> FindbyCompanyid(@PathVariable() Long company_id) {
        List<BranchDto> status = branchService.FindByCompanyid(company_id);
        log.info("Branch Got by Company_id Status - {}", status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "new")
    public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branchDto) throws ParseException {
        BranchDto status = branchService.Create(branchDto);
        log.info("Branch Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(branchDto);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updateBranch(@PathVariable Long id, @RequestBody BranchDto branchDto) {
        String status = branchService.Update(id,branchDto);
        log.info("Branch Updated Status - {}",status);
        return ResponseEntity.ok(branchDto.getBranch_name() + " updated!");
    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable() Long id) {
        String status = branchService.Delete(id);
        log.info("Branch Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Branch deleted!");
    }

}

    