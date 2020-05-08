package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`passed_test`", schema = "`self_edu`")
public class PassedTestEntity {
    private int idPassedTest;
    private int studentId;
    private int idTest;
    private int mark;

//    private StudentEntity studentByStudentId;
//    private TestEntity testByIdTest;

    @Id
    @Column(name = "id_passed_test")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdPassedTest() {
        return idPassedTest;
    }

    public void setIdPassedTest(int idPassedTest) {
        this.idPassedTest = idPassedTest;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "id_test")
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Basic
    @Column(name = "mark")
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassedTestEntity that = (PassedTestEntity) o;
        return idPassedTest == that.idPassedTest &&
                studentId == that.studentId &&
                idTest == that.idTest &&
                mark == that.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassedTest, studentId, idTest,  mark);
    }

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "`student_id`", referencedColumnName = "`id_student`", nullable = false)
//    public StudentEntity getStudentByStudentId() {
//        return studentByStudentId;
//    }
//
//    public void setStudentByStudentId(StudentEntity studentByStudentId) {
//        this.studentByStudentId = studentByStudentId;
//    }
//
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "`id_test`", referencedColumnName = "`id_test`", nullable = false)
//    public TestEntity getTestByIdTest() {
//        return testByIdTest;
//    }
//
//    public void setTestByIdTest(TestEntity testByIdTest) {
//        this.testByIdTest = testByIdTest;
//    }
}
