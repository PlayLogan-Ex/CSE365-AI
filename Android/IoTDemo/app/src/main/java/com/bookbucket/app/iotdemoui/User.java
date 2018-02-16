package com.bookbucket.app.iotdemoui;

import java.io.Serializable;

/**
 * Created by Sakib on 7/30/2017.
 */
public class User implements Serializable {
    String firstName, lastName, email, password, address, profession, contactNo,  researchArea, hobby;

    public User (String firstName, String lastName, String email, String password,  String address, String profession, String contactNo, String researchArea, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.profession = profession;
        this.contactNo = contactNo;
        this.researchArea = researchArea;
        this.hobby = hobby;
    }


}
