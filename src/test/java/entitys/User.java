package entitys;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String email;
    private String name;
    private String sureName;
    private String gender;
    private String subGender;
    private String password;
    private Date birthdayDate;

    public User(){}
}
