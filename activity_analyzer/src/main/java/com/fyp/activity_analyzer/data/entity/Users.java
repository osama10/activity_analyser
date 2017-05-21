package com.fyp.activity_analyzer.data.entity;

import javax.persistence.*;

/**
 * Created by haier_1 on 5/17/2017.
 */
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name ;

    @Column(name = "PASSWORD")
    private String password ;

    @Column(name = "EMAIL")
    private String email ;

    public Users() {
    }

    public Users(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
