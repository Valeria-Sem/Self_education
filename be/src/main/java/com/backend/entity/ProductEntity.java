package com.backend.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "self_education", catalog = "")
public class ProductEntity {
    private int idProduct;
//    private int idTeacher;
    private String name;
    private String description;
    private int price;
//    private int idSubject;
    private String img;
    private TeacherEntity teacherByIdTeacher;
    private SubjectEntity subjectByIdSubject;

    @Id
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

//    @Basic
//    @Column(name = "id_teacher")
//    public int getIdTeacher() {
//        return idTeacher;
//    }
//
//    public void setIdTeacher(int idTeacher) {
//        this.idTeacher = idTeacher;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return idProduct == that.idProduct &&
//                idTeacher == that.idTeacher &&
                price == that.price &&
//                idSubject == that.idSubject &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(img, that.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, description, price, img);
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
    @JoinColumn(name = "id_subject", referencedColumnName = "id_subject", nullable = false)
    public SubjectEntity getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(SubjectEntity subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }
}
