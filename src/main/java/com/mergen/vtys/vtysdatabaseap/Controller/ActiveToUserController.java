package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Service.ActiveToUserService;
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
@RequestMapping("activetouser")
@Slf4j
public class ActiveToUserController {

    private ActiveToUserService activeToUserService;

    public ActiveToUserController(ActiveToUserService activeToUserService) {
        this.activeToUserService = activeToUserService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<List<ActiveToUser>> getActivityList() {
        List<ActiveToUser> activeToUserList =  activeToUserService.getActivityList();
        log.info("All ActiveToUsers Returned - {}",activeToUserList);
        return ResponseEntity.ok(activeToUserList);
    }

    @GetMapping(value = "list/{id}")
    public ResponseEntity<Optional<ActiveToUser>> getActivityById(@PathVariable Long id) {
        Optional<ActiveToUser> status = activeToUserService.getActivityById(id);
        log.info("ActiveToUser Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Object>> getUsersEnrolled(@PathVariable Long id){
        List<Object> objectList = activeToUserService.getUsersEnrolled(id);
        log.info("All Enrolled Users Returned - {}",objectList);
        return ResponseEntity.ok(objectList);
    }

    @GetMapping(value = "/activity/enrolled/{id}")
    public ResponseEntity<List<Long>> getUsersEnrolledIDs(@PathVariable Long id){
        List<Long> longList = activeToUserService.getUsersEnrolledIDs(id);
        log.info("All Enrolled Users Returned by ID - {}",longList);
        return ResponseEntity.ok(longList);
    }

    @PostMapping(value = "new")
    public ResponseEntity<ActiveToUser> CreateActiveoUser(@RequestBody ActiveToUser activetouser) throws ParseException {
        ActiveToUser status = activeToUserService.Create(activetouser);
        log.info("ActiveToUser Added Status - {}",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(activetouser);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updateActiveToUser(@PathVariable Long id, @RequestBody ActiveToUser activetouser) {
        String status = activeToUserService.Update(id,activetouser);
        log.info("ActiveToUser Updated Status - {}",status);
        return ResponseEntity.ok("ActiveToUser updated!");
    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteActivityToUser(@PathVariable() Long id) {
        String status = activeToUserService.Delete(id);
        log.info("ActiveToUser Deleted Status - {}",status);
        return ResponseEntity.ok(id + "ActiveToUser deleted!");
    }
}

    