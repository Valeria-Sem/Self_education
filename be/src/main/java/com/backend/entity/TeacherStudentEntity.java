package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher_student", schema = "self_education", catalog = "")
public class TeacherStudentEntity {
    private int idTeacherStudent;
    private int idTeacher;
    private int idStudent;
    private TeacherEntity teacherByIdTeacher;
    private StudentEntity studentByIdStudent;

    @Id
    @Column(name = "id_teacher_student")
    public int getIdTeacherStudent() {
        return idTeacherStudent;
    }

    public void setIdTeacherStudent(int idTeacherStudent) {
        this.idTeacherStudent = idTeacherStudent;
    }

    @Basic
    @Column(name = "id_teacher")
    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Basic
    @Column(name = "id_student")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherStudentEntity that = (TeacherStudentEntity) o;
        return idTeacherStudent == that.idTeacherStudent &&
                idTeacher == that.idTeacher &&
                idStudent == that.idStudent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTeacherStudent, idTeacher, idStudent);
    }

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id_teacher", nullable = false)
    public TeacherEntity getTeacherByIdTeacher() {
        return teacherByIdTeacher;
    }

    public void setTeacherByIdTeacher(TeacherEntity teacherByIdTeacher) {
        this.teacherByIdTeacher = teacherByIdTeacher;
    }

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", nullable = false)
    public StudentEntity getStudentByIdStudent() {
        return studentByIdStudent;
    }

    public void setStudentByIdStudent(StudentEntity studentByIdStudent) {
        this.studentByIdStudent = studentByIdStudent;
    }
}
