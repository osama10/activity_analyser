package com.fyp.activity_analyzer.services;

import com.fyp.activity_analyzer.commons.Constants;
import com.fyp.activity_analyzer.data.DTO.ResponseDTO;
import com.fyp.activity_analyzer.data.DTO.UsersDTO;
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

    public ResponseDTO getAuthentication(UsersDTO data){
        ResponseDTO responseDTO = new ResponseDTO();

        Users user = this.usersRepository.findByEmailAndPassword(data.getEmail() , data.getPassword());
        Map _data = new HashMap();
        _data.put(Constants.DATA , user.getId());

        if(user != null){

            responseDTO.setDescription(Constants.SUCCESS_MESSAGE);
            responseDTO.setStatusCode(Constants.SUCCESS_CODE);
            responseDTO.setResponseBody(_data);

        }
        else {
            responseDTO.setDescription(Constants.FAILURE_MESSAGE);
            responseDTO.setStatusCode(Constants.FAILURE_CODE);
            responseDTO.setResponseBody(_data);
        }

        return responseDTO;
    }

    public ResponseDTO saveUsers(UsersDTO usersDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        Users user = new Users(usersDTO.getName() , usersDTO.getPassword() , usersDTO.getEmail());

        this.usersRepository.save(user);

        Map _data = new HashMap();
        _data.put(Constants.DATA , Constants.SIGNUP_SUCCESSFULL);

        responseDTO.setStatusCode(Constants.SUCCESS_CODE);
        responseDTO.setDescription(Constants.SUCCESS_MESSAGE);
        responseDTO.setResponseBody(_data);

        return responseDTO;
    }

}
