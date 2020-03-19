package com.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject", schema = "self_education", catalog = "")
public class SubjectEntity {
    private int idSubject;
    private String name;
    private Collection<ProductEntity> productsByIdSubject;
    private Collection<TeacherEntity> teachersByIdSubject;

    @Id
    @Column(name = "id_subject")
    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return idSubject == that.idSubject &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, name);
    }

    @OneToMany(mappedBy = "subjectByIdSubject")
    public Collection<ProductEntity> getProductsByIdSubject() {
        return productsByIdSubject;
    }

    public void setProductsByIdSubject(Collection<ProductEntity> productsByIdSubject) {
        this.productsByIdSubject = productsByIdSubject;
    }

    @OneToMany(mappedBy = "subjectByIdSubject")
    public Collection<TeacherEntity> getTeachersByIdSubject() {
        return teachersByIdSubject;
    }

    public void setTeachersByIdSubject(Collection<TeacherEntity> teachersByIdSubject) {
        this.teachersByIdSubject = teachersByIdSubject;
    }
}
