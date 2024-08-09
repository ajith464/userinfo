package com.example.userinfo.controller;

import com.example.userinfo.dto.UserInfoDto;
import com.example.userinfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ajith
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/addUser")
    public ResponseEntity<UserInfoDto> addUser(@RequestBody UserInfoDto userInfoDto) {
        UserInfoDto savedUser = userInfoService.addUser(userInfoDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserInfoDto> fetchUserById(@PathVariable Integer userId) {
        UserInfoDto userFromDb = userInfoService.fetchUserById(userId);
        return new ResponseEntity<>(userFromDb, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity deleteUserById(@PathVariable Integer userId) {
        userInfoService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserInfoDto> updateUserById(@PathVariable Integer userId, @RequestBody UserInfoDto userInfoDto) {
        userInfoService.updateUserById(userId, userInfoDto);
        userInfoDto.setUserId(userId);
        return new ResponseEntity<>(userInfoDto, HttpStatus.ACCEPTED);
    }


    // todo: push the codebase to remote Git Repo
    // todo: List All users end point - add pagination & caching
    // todo: add hibernate validations mechanism to validate the incoming request
    // todo: use Open API for API Documentation & Design first approach
    // todo: global exception handling - Controller Advise
    // todo: Secure end-points, authentication and authorization
    // todo: set up config server
    // todo: Junit test coverage
    // todo: configure test container for integration testing
    // todo: configure splunk

}
