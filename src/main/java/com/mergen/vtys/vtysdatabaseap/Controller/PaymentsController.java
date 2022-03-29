package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.Payments;
import com.mergen.vtys.vtysdatabaseap.Service.PaymentsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.ReactiveSortHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.OAEPParameterSpec;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Payments>> getPaymentList(){
        List<Payments> paymentsList = paymentsService.getPaymentsList();
        log.info("All Payments Returned - {}",paymentsList);
        return ResponseEntity.ok(paymentsList);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Optional<Payments>> getPaymentsById(@PathVariable Long id){
        Optional<Payments> status = paymentsService.getPaymentsById(id);
        log.info("Payments Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "new")
    public ResponseEntity<Payments> createPayments(@RequestBody Payments payments) throws ParseException {
        Payments status = paymentsService.Create(payments);
        log.info("Payments Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(payments);
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity<String> deletePayments(@PathVariable Long id){
        String status = paymentsService.Delete(id);
        log.info("Payments Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Payments Deleted");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePayments(@PathVariable Long id,@RequestBody Payments payments){
        String status = paymentsService.Update(id,payments);
        log.info("Payments Updated - {}",status);
        return  ResponseEntity.ok(id + "th Payment Updated");
    }



}

    