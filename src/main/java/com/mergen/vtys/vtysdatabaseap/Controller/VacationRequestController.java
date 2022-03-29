package com.mergen.vtys.vtysdatabaseap.Controller;

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
    public ResponseEntity<List<VacationRequest>> getVacationRequestList(){
        List<VacationRequest> vacationRequests = vacationRequestService.getVacationRequestList();
        log.info("All Payments Returned - {}",vacationRequests);
        return ResponseEntity.ok(vacationRequests);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Optional<VacationRequest>> getVacationRequestById(@PathVariable Long id) {
        Optional<VacationRequest> status = vacationRequestService.getVacationRequestById(id);
        log.info("Payments Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "new")
    public ResponseEntity<VacationRequest> createVacationRequest(@RequestBody VacationRequest vacationRequest) throws ParseException {

        VacationRequest status2 = vacationRequestService.Create(vacationRequest);
        log.info("Vacation Request SAVED Status - {}",status2);
        return  ResponseEntity.status(HttpStatus.CREATED).body(vacationRequest);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String status = vacationRequestService.Delete(id);
        log.info("Vacation Request Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Payments Deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVacationRequest(@PathVariable Long id,@RequestBody VacationRequest vacationRequest){
        String status =vacationRequestService.Update(id,vacationRequest);
        log.info("Vacation Request Updated - {}",status);
        return  ResponseEntity.ok(id + "th Vacation Request Updated");
    }


}

    