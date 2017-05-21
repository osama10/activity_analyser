package com.fyp.activity_analyzer.controllers;

import com.fyp.activity_analyzer.commons.Response;
import com.fyp.activity_analyzer.data.entity.Users;
import com.fyp.activity_analyzer.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by haier_1 on 5/17/2017.
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public Response login(@RequestParam Map<String,String> requestParams){

        Users users = new Users("",requestParams.get("pass") , requestParams.get("email"));

        return usersService.getAuthentication(users);
    }
}
