package com.app.entities;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<UsersInfo> usersInfo;

    public Role(String name, List<UsersInfo> usersInfo) {
        this.name = name;
        this.usersInfo = usersInfo;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UsersInfo> getUsersInfo() {
        return usersInfo;
    }

    public void setUsersInfo(List<UsersInfo> usersInfo) {
        this.usersInfo = usersInfo;
    }
}