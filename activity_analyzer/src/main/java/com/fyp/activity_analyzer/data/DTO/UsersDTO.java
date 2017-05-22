package com.fyp.activity_analyzer.data.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by haier_1 on 5/21/2017.
 */
public class UsersDTO {

    @NotNull
    @Size(max = 100)
    private String name ;

    @NotNull
    @Size(min = 8)
    private String password ;

    @NotNull
    private String email ;

    public UsersDTO() {
    }

    public UsersDTO(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
