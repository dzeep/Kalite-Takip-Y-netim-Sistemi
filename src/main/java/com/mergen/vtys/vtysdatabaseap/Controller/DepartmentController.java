package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.DepartmentDto;
import com.mergen.vtys.vtysdatabaseap.Service.DepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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
    public ResponseEntity<List<DepartmentDto>> getDepartmentList(){
        List<DepartmentDto> departmentList = departmentService.getDepartmentList();
        log.info("All Departments Returned - {}",departmentList);
       return ResponseEntity.ok(departmentList);
    }
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByID(@PathVariable Long id) {
        DepartmentDto status = departmentService.getDepartmentByID(id);
        log.info("Department Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) throws ParseException {
        DepartmentDto status = departmentService.Create(departmentDto);
        log.info("Department Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(departmentDto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto){
        String status = departmentService.Update(id,departmentDto);
        log.info("Department Updated Status - {}",status);
        return ResponseEntity.ok(departmentDto.getDepartment_name() + " updated!");
    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteDeparment(@PathVariable() Long id) {
        String status =departmentService.Delete(id);
        log.info("Department Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th Department deleted!");
    }
    @GetMapping(value = "/find/branch:{branch_id}")
    public ResponseEntity<List<DepartmentDto>> getBranchId(@PathVariable() Long branch_id) {
        List<DepartmentDto> status = departmentService.getDepartmentsByBranchId(branch_id);
        log.info("Department Got by Branch id Status - {}", status);
        return ResponseEntity.ok(status);
    }
}
