package com.fyp.activity_analyzer.services;

import com.fyp.activity_analyzer.commons.Constants;
import com.fyp.activity_analyzer.commons.Response;
import com.fyp.activity_analyzer.data.entity.Users;
import com.fyp.activity_analyzer.data.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haier_1 on 5/17/2017.
 */
@Service
public class UsersService {

    UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public Response getAuthentication(Users data){
        Response response = new Response();

        Users user = this.usersRepository.findByEmailAndPassword(data.getEmail() , data.getPassword());
        Map _data = new HashMap();
        _data.put(Constants.DATA , user);

        if(user != null){

            response.setDescription(Constants.SUCCESS_MESSAGE);
            response.setStatusCode(Constants.SUCCESS_CODE);
            response.setResponseBody(_data);

        }
        else {
            response.setDescription(Constants.FAILURE_MESSAGE);
            response.setStatusCode(Constants.FAILURE_CODE);
            response.setResponseBody(_data);
        }

        return response;
    }
}
