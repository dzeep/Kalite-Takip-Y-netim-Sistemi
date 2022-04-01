package com.mergen.vtys.vtysdatabaseap.Service.Controller;



import com.mergen.vtys.vtysdatabaseap.Dto.UserMDto;
import com.mergen.vtys.vtysdatabaseap.Repository.UserMRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import com.mergen.vtys.vtysdatabaseap.Service.UserMService;
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
@RequestMapping(value = "user_m")
@Slf4j
public class UserMController {

    private final ActivityService activityService;

    private final UserMRepository userMRepository;

    private final UserMService userMService;

    private  final UserDetailsService userDetailsService;


    public UserMController(UserMService userMService, ActivityService activityService, UserMRepository userMRepository, UserDetailsService userDetailsService) {
        this.userMService = userMService;
        this.activityService = activityService;
        this.userMRepository = userMRepository;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserMDto>> getUserMList(){
        List<UserMDto> userMList = userMService.getUserMLists();
        log.info("All Users Returned - {}", userMList);
        return ResponseEntity.ok(userMList);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<UserMDto> getUserMById(@PathVariable Long id){
        UserMDto status = userMService.getUserMById(id);
        log.info("UserM Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<UserMDto> getUserMsCheck(@PathVariable("name") String name){
        UserMDto status = userMService.getUserMByName(name);
        log.info("UserM Got by Name Status - {}",status);
        return  ResponseEntity.ok(status) ;
    }

    @GetMapping(value ="/np:{name}/{password}")
    public ResponseEntity<UserMDto> getUserMsCheck(
            @PathVariable("name") String name,@PathVariable("password") String password) {
        UserMDto status = userMService.getUserMNameAndPassword(name,password);
        log.info("UserM Got by Name And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value ="/ep:{email}/{password}")
    public ResponseEntity<UserMDto> getUserMsCheckByMailandPass(
            @PathVariable("email") String email,@PathVariable("password") String password) {
        UserMDto status = userMService.getUserMEmailAndPassword(email,password);
        log.info("UserM Got by E-mail And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<UserMDto> createUserM(@RequestBody UserMDto userMDto) throws ParseException {
        UserMDto status = userMService.Create(userMDto);
        log.info("UserM Added Status - {}",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMDto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUserM(@PathVariable Long id, @RequestBody UserMDto userMDto) {

        String status = userMService.Update(id, userMDto);
        log.info("UserM Updated Status - {}",status);
        return ResponseEntity.ok(userMDto.getUsername() + " updated!");
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteUserM(@PathVariable() Long id){
        String status = userMService.Delete(id);
        log.info("UserM Deleted Status - {}",status);
        return ResponseEntity.ok(id + " th deleted!");
    }
}
