package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`product`", schema = "`self_edu`")
public class ProductEntity {
    private int idProduct;
    private String productName;
    private String description;
    private int price;
    private int courseId;
    private String img;
//    private CourseEntity courseByCourseId;

    @Id
    @Column(name = "`id_product`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Basic
    @Column(name = "`product_name`")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "`description`")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "`price`")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "`course_id`")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "`img`")
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
                price == that.price &&
                courseId == that.courseId &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(img, that.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, productName, description, price, img);
    }

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "course_id", referencedColumnName = "id_course", nullable = false)
//    public CourseEntity getCourseByCourseId() {
//        return courseByCourseId;
//    }
//
//    public void setCourseByCourseId(CourseEntity courseByCourseId) {
//        this.courseByCourseId = courseByCourseId;
//    }
}
