package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`test`", schema = "`self_edu`")
public class TestEntity {
    private int idTest;
    private String testName;
    private Integer questionNumber;
    private LecturesEntity lecturesByLecId;

    @Id
    @Column(name = "`id_test`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Basic
    @Column(name = "`test_name`")
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Basic
    @Column(name = "`question_number`")
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
                Objects.equals(testName, that.testName) &&
                Objects.equals(questionNumber, that.questionNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTest, testName, questionNumber);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`lec_id`", referencedColumnName = "`id_lectures`", nullable = false)
    public LecturesEntity getLecturesByLecId() {
        return lecturesByLecId;
    }

    public void setLecturesByLecId(LecturesEntity lecturesByLecId) {
        this.lecturesByLecId = lecturesByLecId;
    }
}
