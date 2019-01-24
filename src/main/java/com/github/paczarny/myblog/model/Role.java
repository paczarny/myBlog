package com.github.paczarny.myblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Long id;
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<User> userList;

    public Role(String role) {
        this.role=role;
    }

    public Role(){}

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getRoleList() {
        return userList;
    }

    public void setRoleList(List<User> roleList) {
        this.userList = roleList;
    }
}
