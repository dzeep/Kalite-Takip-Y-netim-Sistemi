package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentsController {

    private PaymentsService paymentsService;

    @Autowired
    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<PaymentsDto>> getPaymentList(){
        List<PaymentsDto> paymentsList = paymentsService.getPaymentsList();
        log.info("All Payments Returned - {}",paymentsList);
        return ResponseEntity.ok(paymentsList);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<PaymentsDto> getPaymentsById(@PathVariable Long id){
        PaymentsDto status = paymentsService.getPaymentsById(id);
        log.info("Payments Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "new")
    public ResponseEntity<PaymentsDto> createPayments(@RequestBody PaymentsDto paymentsDto) throws ParseException {
        PaymentsDto status = paymentsService.Create(paymentsDto);
        log.info("Payments Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(paymentsDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePayments(@PathVariable Long id,@RequestBody PaymentsDto paymentsDto){
        String status = paymentsService.Update(id,paymentsDto);
        log.info("Payments Updated - {}",status);
        return  ResponseEntity.ok(id + "th Payment Updated");
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deletePayments(@PathVariable Long id){
        String status = paymentsService.Delete(id);
        log.info("Payments Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Payments Deleted");
    }

}

    