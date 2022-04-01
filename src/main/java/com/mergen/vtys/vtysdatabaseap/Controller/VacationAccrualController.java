package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.VacationAccrualDto;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Model.VacationAccrual;

import com.mergen.vtys.vtysdatabaseap.Service.VacationAccrualService;
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
@RequestMapping("vacationaccrual")
@RequiredArgsConstructor
@Slf4j
public class VacationAccrualController {

    private VacationAccrualService vacationAccrualService;
    @Autowired
    public VacationAccrualController(VacationAccrualService vacationAccrualService) {
        this.vacationAccrualService = vacationAccrualService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<VacationAccrualDto>> getVacationAccrualList(){
        List<VacationAccrualDto> vacationAccruals = vacationAccrualService.getVacationAccrualList();
        log.info("All VacationAccruals Returned - {}",vacationAccruals);
        return ResponseEntity.ok(vacationAccruals);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<VacationAccrualDto> getVacationAccrualById(@PathVariable Long id){
        VacationAccrualDto status = vacationAccrualService.getVacationAccrualById(id);
        log.info("VacationAccrual Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "new")
    public ResponseEntity<VacationAccrualDto> createVacationAccrual(@RequestBody VacationAccrualDto vacationAccrualDto) throws ParseException {
        VacationAccrualDto status = vacationAccrualService.Create(vacationAccrualDto);
        log.info("VacationAccrual Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(vacationAccrualDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVacationAccrual(@PathVariable Long id,@RequestBody VacationAccrualDto vacationAccrualDto){
        String status = vacationAccrualService.Update(id,vacationAccrualDto);
        log.info("Vacation Accrual Updated - {}",status);
        return  ResponseEntity.ok(id + "th Vacation Accrual Updated");
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deleteVacationAccrual(@PathVariable Long id){
        String status =vacationAccrualService.Delete(id);
        log.info("VacationAccrual Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Vacation Accrual Deleted");
    }


}

    