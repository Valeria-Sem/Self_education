package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`passed_test`", schema = "`self_edu`")
public class PassedTestEntity {
    private int idPassedTest;
    private int grade;
    private StudentEntity studentByStudentId;
    private TestEntity testByIdTest;

    @Id
    @Column(name = "id_passed_test")
    public int getIdPassedTest() {
        return idPassedTest;
    }

    public void setIdPassedTest(int idPassedTest) {
        this.idPassedTest = idPassedTest;
    }

    @Basic
    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassedTestEntity that = (PassedTestEntity) o;
        return idPassedTest == that.idPassedTest &&
                grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassedTest, grade);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`student_id`", referencedColumnName = "`id_student`", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`id_test`", referencedColumnName = "`id_test`", nullable = false)
    public TestEntity getTestByIdTest() {
        return testByIdTest;
    }

    public void setTestByIdTest(TestEntity testByIdTest) {
        this.testByIdTest = testByIdTest;
    }
}
