package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Dto.UserCareerDto;
import com.mergen.vtys.vtysdatabaseap.Service.UserCareerService;
import lombok.Data;
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
@RequestMapping(value = "usercareer")
@Slf4j
public class UserCareerController {

    private final UserCareerService userCareerService;

    public UserCareerController(UserCareerService userCareerService) {
        this.userCareerService = userCareerService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserCareerDto>> getUserCareerList(){
        List<UserCareerDto> userCareerList = userCareerService.getUserCareerList();
        log.info("All Title Returned - {}",userCareerList);
        return ResponseEntity.ok(userCareerList);
    }
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<UserCareerDto> getUserCareerByID(@PathVariable Long id) {
        UserCareerDto status = userCareerService.getUserCareerByID(id);
        log.info("Title Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<UserCareerDto> createUserCareer(@RequestBody UserCareerDto userCareerDto) throws ParseException {
        UserCareerDto status = userCareerService.Create(userCareerDto);
        log.info("title Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(userCareerDto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUserCareer(@PathVariable Long id, @RequestBody UserCareerDto userCareerDto ){
        String status = userCareerService.Update(id,userCareerDto);
        log.info("UserCareer Updated Status - {}",status);
        return ResponseEntity.ok(userCareerDto.getId() + " updated!");
    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteTitle(@PathVariable() Long id) {
        String status =userCareerService.Delete(id);
        log.info("UserCareer Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th UserCareer deleted!");
    }
}


    