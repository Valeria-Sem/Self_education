package com.backend.transferOfObjects;

public class TestingModel {
    private int idPassedTest;
    private int studentId;
    private int idTest;
    private int mark;
    private boolean isExist;

    public TestingModel(boolean isExist){
        this.isExist = isExist;
    }

    public TestingModel(int idPassedTest, int studentId, int idTest, int mark, boolean isExist){
        this.idPassedTest = idPassedTest;
        this.studentId = studentId;
        this.idTest = idTest;
        this.mark = mark;
        this.isExist = isExist;
    }

    public int getIdPassedTest() {
        return idPassedTest;
    }

    public void setIdPassedTest(int idPassedTest) {
        this.idPassedTest = idPassedTest;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean getIsExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
