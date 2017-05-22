package com.fyp.activity_analyzer.controllers;

import com.fyp.activity_analyzer.commons.Response;
import com.fyp.activity_analyzer.data.DTO.UsersDTO;
import com.fyp.activity_analyzer.data.entity.Users;
import com.fyp.activity_analyzer.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by haier_1 on 5/17/2017.
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET , value = "/login")
    public Response login(@RequestParam Map<String,String> requestParams){

        Users users = new Users("",requestParams.get("pass") , requestParams.get("email"));

        return usersService.getAuthentication(users);
    }

    @RequestMapping(method=RequestMethod.POST , value = "/signup" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response signUp(@RequestBody @Validated UsersDTO usersDTO){

        Users user =  new Users(usersDTO.getName() ,usersDTO.getPassword() , usersDTO.getEmail());
         return  usersService.saveUsers(user);
    }

}
