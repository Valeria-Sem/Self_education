package com.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "teacher", schema = "self_education", catalog = "")
public class TeacherEntity {
    private int idTeacher;
//    private int idUser;
    private String name;
    private String surname;
//    private int idSubject;
    private UserEntity userByIdUser;
    private SubjectEntity subjectByIdSubject;

    @Id
    @Column(name = "id_teacher")
    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

//    @Basic
//    @Column(name = "id_user")
//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    @Basic
//    @Column(name = "id_subject")
//    public int getIdSubject() {
//        return idSubject;
//    }
//
//    public void setIdSubject(int idSubject) {
//        this.idSubject = idSubject;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return idTeacher == that.idTeacher &&
//                idUser == that.idUser &&
//                idSubject == that.idSubject &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacher, name, surname);
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject", nullable = false)
    public SubjectEntity getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(SubjectEntity subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }

}
