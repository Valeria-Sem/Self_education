package com.backend.entity;

import com.backend.entity.enums.SubStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "self_edu", catalog = "")
public class SubscriptionEntity {
    private int idSubscription;
    private SubStatus status;
    private StudentEntity studentByStudentId;

    @Id
    @Column(name = "id_subscription")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
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
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubscription, status);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", referencedColumnName = "id_student", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
}
