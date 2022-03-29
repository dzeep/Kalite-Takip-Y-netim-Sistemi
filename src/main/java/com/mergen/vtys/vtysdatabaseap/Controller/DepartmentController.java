package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.Company;
import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Service.DepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "department")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Department>> getDepartmentList(){
        List<Department> departmentList = departmentService.getDepartmentList();
        log.info("All Departments Returned - {}",departmentList);
       return ResponseEntity.ok(departmentList);
    }
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentByID(@PathVariable Long id) {
        Optional<Department> status = departmentService.getDepartmentByID(id);
        log.info("Department Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) throws ParseException {
        Department status = departmentService.Create(department);
        log.info("deparment Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        String status = departmentService.Update(id,department);
        log.info("Department Updated Status - {}",status);
        return ResponseEntity.ok(department.getDepartment_name() + " updated!");
    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteDeparment(@PathVariable() Long id) {
        String status =departmentService.Delete(id);
        log.info("Department Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th Department deleted!");
    }
    @GetMapping(value = "/find/branch:{branch_id}")
    public ResponseEntity<List<Optional<Department>>> getBranchId(@PathVariable() Long branch_id) {
        List<Optional<Department>> status = departmentService.getBranchId(branch_id);
        log.info("Department Got by Branch id Status - {}", status);
        return ResponseEntity.ok(status);
    }
}
