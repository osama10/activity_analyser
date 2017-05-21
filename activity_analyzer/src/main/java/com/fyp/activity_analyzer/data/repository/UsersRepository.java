package com.fyp.activity_analyzer.data.repository;
import com.fyp.activity_analyzer.data.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by haier_1 on 5/17/2017.
 */

public interface UsersRepository extends CrudRepository<Users, Integer> {

    Users findByEmailAndPassword(String Email , String Password);

}
