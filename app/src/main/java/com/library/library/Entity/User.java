package com.library.library.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "pwd")
    private String pwd;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "lastname")
    private String lastName;

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    @ColumnInfo(name = "birthdate")
    private String birthdate;

    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "connected")
    private boolean connected;

    public User() {
    }

    public User(String email, String pwd, String name, String lastName, String birthdate, String phone) {
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String  getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", phone=" + phone +
                '}';
    }
}

