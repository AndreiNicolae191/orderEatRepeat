package com.app.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UsersInfo usersInfo;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Orders> order;

    public Users() {
    }

    public Users(String firstName, String lastName, UsersInfo usersInfo, List<Orders> order) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.usersInfo = usersInfo;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UsersInfo getUsersInfo() {
        return usersInfo;
    }

    public void setUsersInfo(UsersInfo usersInfo) {
        this.usersInfo = usersInfo;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders> order) {
        this.order = order;
    }
}