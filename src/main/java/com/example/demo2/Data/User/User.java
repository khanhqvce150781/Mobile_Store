package com.example.demo2.Data.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, name = "user_name")
    private String user_Name;

    @Column(length = 15, nullable = false, name = "password")
    private String password;
    private Boolean user_role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUser_role() {
        return user_role;
    }

    public void setUser_role(Boolean user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_Name='" + user_Name + '\'' +
                ", password='" + password + '\'' +
                ", user_role=" + user_role +
                '}';
    }
}
