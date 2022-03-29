package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
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
@RequestMapping(value = "userdetail")
@Slf4j
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserDetails>> getUserDetailsList() {
        List<UserDetails> userDetailsList = userDetailsService.getUserDetailsList();
        log.info("All User Details Returned - {}", userDetailsList);
        return ResponseEntity.ok(userDetailsList);
    }


    @GetMapping(value = "list/{id}")
    public ResponseEntity<Optional<UserDetails>> getUserDetailsById(@PathVariable Long id) {
        Optional<UserDetails> status = userDetailsService.getUserDetailsById(id);
        log.info("User Detail Got by Name Status - {}", status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails userDetails) throws ParseException {
        UserDetails status = userDetailsService.Create(userDetails);
        log.info("User Detail Added Status - {}", status);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updateUserDetails(@PathVariable Long id, @RequestBody UserDetails userDetails) {
        String status = userDetailsService.Update(id, userDetails);
        log.info("User Detail Updated Status - {}", status);
        return ResponseEntity.ok("TC: "+ userDetails.getTc_no()+ " updated!");
    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable() Long id) {
        String status = userDetailsService.Delete(id);
        log.info("User Detail Deleted Status - {}", status);
        return ResponseEntity.ok(id + " th deleted!");
    }

    @GetMapping(value = "/find/tc:{tc_no}")
    public ResponseEntity<Optional<UserDetails>> findByTcNo(@PathVariable() String tc_no) {
        Optional<UserDetails> status = userDetailsService.findTcNo(tc_no);
        log.info("User Detail Got by Tc_No Status - {}", status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/find/user:{user_id}")
    public ResponseEntity<Optional<UserDetails>> findbyUserId(@PathVariable() Long user_id) {
        Optional<UserDetails> status = userDetailsService.FindByUserid(user_id);
        log.info("User Detail Got by User_id Status - {}", status);
        return ResponseEntity.ok(status);
    }

}