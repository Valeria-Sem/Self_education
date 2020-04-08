package com.backend.paginationModel;

import com.backend.entity.StudentEntity;

import java.util.List;

public class PageStudentModel {

    private int countOfElements;
    private List<StudentEntity> studentEntities;

    public PageStudentModel(){}

    public PageStudentModel(int countOfElements, List<StudentEntity> studentEntities){
        this.countOfElements = countOfElements;
        this.studentEntities = studentEntities;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
