package com.backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "test", schema = "self_edu")
public class TestEntity {
    private int idTest;
    private int lecId;
    private String testName;
    private Integer questionNumber;
    private List<QuestionEntity> questions = new ArrayList<>();

    @Id
    @Column(name = "id_test")
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Basic
    @Column(name = "lec_id")
    public int getLecId() {
        return lecId;
    }

    public void setLecId(int lecId) {
        this.lecId = lecId;
    }

    @Basic
    @Column(name = "test_name")
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Basic
    @Column(name = "question_number")
    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return idTest == that.idTest &&
                lecId == that.lecId &&
                Objects.equals(testName, that.testName) &&
                Objects.equals(questionNumber, that.questionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTest, lecId, testName, questionNumber);
    }

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "test_id")
    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }
}
