package com.mergen.vtys.vtysdatabaseap.Controller;



import com.mergen.vtys.vtysdatabaseap.C.Security.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
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
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {
    private final ActivityService activityService;

    private final UserMService userMService;

    private  final UserDetailsService userDetailsService;



    @GetMapping(value = "/list")
public ResponseEntity<List<UserM>> getUserList(){
        List<UserM> userList = userMService.getUserLists();
        log.info("All Users Returned - {}", userList);
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Optional<UserM>> getUserById(@PathVariable Long id){
        Optional<UserM> status = userMService.getUserById(id);
        log.info("User Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Optional<UserM>> getUsersCheck(@PathVariable("name") String name){
        Optional<UserM> status = userMService.getUserByName(name);
        log.info("User Got by Name Status - {}",status);
        return  ResponseEntity.ok(status) ;
    }

 /*   @GetMapping(value ="/{name}/{password}")
    public ResponseEntity<Optional<UserM>> getUsersCheck(
            @PathVariable("name") String name,@PathVariable("password") String password) {
        Optional<UserM> status = userMService.getUserNameAndPassword(name,password);
        log.info("User Got by Name And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }*/
//    @GetMapping(value ="/check/{email}/{password}")
//    public ResponseEntity<Optional<UserM>> getUsersCheckByMailandPass(
//            @PathVariable("email") String email,@PathVariable("password") String password) {
//        Optional<User> status = userMService.getUserEmailAndPassword(email,password);
//        log.info("User Got by E-mail And Password Status - {}",status);
//        return ResponseEntity.ok(status);
//    }


    @PostMapping(value = "/new")
    public ResponseEntity<UserM> createUser(@RequestBody UserM userM) throws ParseException {

        UserM status = userMService.Create(userM);
        log.info("User Added Status - {}",status);
        UserDetails userDetails = new UserDetails();
        userDetails.setId(userM.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(userM);
    }



    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserM userM) {

        String status = userMService.Update(id, userM);
        log.info("User Updated Status - {}",status);
        return ResponseEntity.ok(userM.getUsername() + " updated!");

    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable() Long id){
        String status = userMService.Delete(id);
        log.info("User Deleted Status - {}",status);
        return ResponseEntity.ok(id + " th deleted!");
    }
    }
