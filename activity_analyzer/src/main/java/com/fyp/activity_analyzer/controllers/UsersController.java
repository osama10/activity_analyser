package com.fyp.activity_analyzer.controllers;

import com.fyp.activity_analyzer.data.DTO.ResponseDTO;
import com.fyp.activity_analyzer.data.DTO.UsersDTO;
import com.fyp.activity_analyzer.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseDTO login(@RequestParam Map<String,String> requestParams){

        UsersDTO usersDTO = new UsersDTO("",requestParams.get("pass") , requestParams.get("email"));

        return usersService.getAuthentication(usersDTO);
    }

    @RequestMapping(method=RequestMethod.POST , value = "/signup" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO signUp(@RequestBody @Validated UsersDTO usersDTO){

         return  usersService.saveUsers(usersDTO);
    }

}
