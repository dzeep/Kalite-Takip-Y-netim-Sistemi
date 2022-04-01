package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.VacationRequestDto;
import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Model.VacationRequest;
import com.mergen.vtys.vtysdatabaseap.Service.VacationRequestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("vacationrequest")
@Slf4j
public class VacationRequestController {

    private VacationRequestService vacationRequestService;
    public VacationRequestController(VacationRequestService vacationRequestService) {
        this.vacationRequestService = vacationRequestService;
    }
    @GetMapping(value = "list")
    public ResponseEntity<List<VacationRequestDto>> getVacationRequestList(){
        List<VacationRequestDto> vacationRequestDtoList = vacationRequestService.getVacationRequestList();
        log.info("All Payments Returned - {}",vacationRequestDtoList);
        return ResponseEntity.ok(vacationRequestDtoList);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<VacationRequestDto> getVacationRequestById(@PathVariable Long id) {
        VacationRequestDto status = vacationRequestService.getVacationRequestById(id);
        log.info("Payments Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "new")
    public ResponseEntity<VacationRequestDto> createVacationRequest(@RequestBody VacationRequestDto vacationRequestDto) throws ParseException {
        VacationRequestDto status = vacationRequestService.Create(vacationRequestDto);
        log.info("Vacation Request SAVED Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(vacationRequestDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVacationRequest(@PathVariable Long id,@RequestBody VacationRequestDto vacationRequestDto){
        String status =vacationRequestService.Update(id,vacationRequestDto);
        log.info("Vacation Request Updated - {}",status);
        return  ResponseEntity.ok(id + "th Vacation Request Updated");
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String status = vacationRequestService.Delete(id);
        log.info("Vacation Request Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Payments Deleted");
    }



}

    