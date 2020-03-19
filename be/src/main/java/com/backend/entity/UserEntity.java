package com.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "self_education", catalog = "")
public class UserEntity {
    private int idUser;
    private String login;
    private String password;
    private Object role;
    private Collection<StudentEntity> studentsByIdUser;
    private Collection<TeacherEntity> teachersByIdUser;

    @Id
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, password, role);
    }

    @OneToMany(mappedBy = "userByIdUser")
    public Collection<StudentEntity> getStudentsByIdUser() {
        return studentsByIdUser;
    }

    public void setStudentsByIdUser(Collection<StudentEntity> studentsByIdUser) {
        this.studentsByIdUser = studentsByIdUser;
    }

    @OneToMany(mappedBy = "userByIdUser")
    public Collection<TeacherEntity> getTeachersByIdUser() {
        return teachersByIdUser;
    }

    public void setTeachersByIdUser(Collection<TeacherEntity> teachersByIdUser) {
        this.teachersByIdUser = teachersByIdUser;
    }
}
