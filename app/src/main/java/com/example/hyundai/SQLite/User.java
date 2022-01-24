package com.example.hyundai.SQLite;

import java.util.Date;

public class User {

    //public String id;
    public String npk;
    public String username;
    public String password;
    public String name;
    public String usergroup;
    /*public String rfid_tag;
    public Integer department_id;
    public Integer op_skill;
    public Date last_login;
    public String status;
    public Date created_at;
    public Date updated_at;*/

    public User(String name, String npk, String username, String password, String usergroup) {

        //this.id = id;
        this.npk = npk;
        this.username = username;
        this.password = password;
        this.name = name;
        this.usergroup = usergroup;
        /*this.rfid_tag = rfid_tag;
        this.department_id = department_id;
        this.op_skill = op_skill;
        this.last_login = last_login;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;*/

    }

   /* public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

    public String getNpk() {
        return npk;
    }

    public void setNpk(String npk) {
        this.npk = npk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUsergroup() { return usergroup; }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    /*public String getRfid_tag() {
        return rfid_tag;
    }

    public void setRfid_tag(String rfid_tag) {
        this.rfid_tag = rfid_tag;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Integer getOp_skill() {
        return op_skill;
    }

    public void setOp_skill(Integer op_skill) {
        this.op_skill = op_skill;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }*/
}
