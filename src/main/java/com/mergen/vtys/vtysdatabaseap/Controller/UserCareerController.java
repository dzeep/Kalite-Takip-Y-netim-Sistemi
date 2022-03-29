package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Model.UserCareer;
import com.mergen.vtys.vtysdatabaseap.Service.TitleService;
import com.mergen.vtys.vtysdatabaseap.Service.UserCareerService;
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
@RequestMapping(value = "usercareer")
@Slf4j
public class UserCareerController {

    private final UserCareerService userCareerService;

    public UserCareerController(UserCareerService userCareerService) {
        this.userCareerService = userCareerService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserCareer>> getUserCareerList(){
        List<UserCareer> userCareerList = userCareerService.getUserCareerList();
        log.info("All Title Returned - {}",userCareerList);
        return ResponseEntity.ok(userCareerList);
    }
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Optional<UserCareer>> getUserCareerByID(@PathVariable Long id) {
        Optional<UserCareer> status = userCareerService.getUserCareerByID(id);
        log.info("Title Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<UserCareer> createUserCrareer(@RequestBody UserCareer usercareer) throws ParseException {
         UserCareer status = userCareerService.Create(usercareer);
        log.info("title Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(usercareer);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUserCareer(@PathVariable Long id, @RequestBody UserCareer userCareer ){
        String status = userCareerService.Update(id,userCareer);
        log.info("UserCareer Updated Status - {}",status);
        return ResponseEntity.ok(userCareer.getId() + " updated!");
    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteTitle(@PathVariable() Long id) {
        String status =userCareerService.Delete(id);
        log.info("UserCareer Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th UserCareer deleted!");
    }
}


    