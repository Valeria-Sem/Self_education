package com.backend.entity;

import com.backend.entity.enums.SubStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "self_education", catalog = "")
public class SubscriptionEntity {
    private int idSubscription;
    private int idStudent;
    private int idProduct;
    private SubStatus status;

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
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public SubStatus getStatus() {
        return status;
    }

    public void setStatus(SubStatus status) {
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
}
