package com.backend.transferOfObjects;

import com.backend.entity.enums.SubStatus;

public class ReportModel {
    private int idSubscription;
    private int studentId;
    private String name;
    private String surname;
    private String patronymic;


    public ReportModel(){
    }

    public ReportModel(int idSubscription, int studentId, String name, String surname, String patronymic){
        this.idSubscription = idSubscription;
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }


    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
