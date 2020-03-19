package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "self_education", catalog = "")
public class SubscriptionEntity {
    private int idSubscription;
    private int idStudent;
    private int idProduct;
    private Object status;
    private StudentEntity studentByIdStudent;
    private ProductEntity productByIdProduct;

    @Id
    @Column(name = "id_subscription")
    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    @Basic
    @Column(name = "id_student")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "status")
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return idSubscription == that.idSubscription &&
                idStudent == that.idStudent &&
                idProduct == that.idProduct &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubscription, idStudent, idProduct, status);
    }

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", nullable = false)
    public StudentEntity getStudentByIdStudent() {
        return studentByIdStudent;
    }

    public void setStudentByIdStudent(StudentEntity studentByIdStudent) {
        this.studentByIdStudent = studentByIdStudent;
    }

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false)
    public ProductEntity getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(ProductEntity productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }
}
