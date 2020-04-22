package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`lectures`", schema = "`self_edu`")
public class LecturesEntity {
    private int idLectures;
    private int productId;
    private String lectureName;
    private String img;
    private String pdfFile;
    private ProductEntity productByProductId;

    @Id
    @Column(name = "`id_lectures`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdLectures() {
        return idLectures;
    }

    public void setIdLectures(int idLectures) {
        this.idLectures = idLectures;
    }

    @Basic
    @Column(name = "`product_id`")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "`lecture_name`")
    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    @Basic
    @Column(name = "`img`")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "`pdf_file`")
    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturesEntity that = (LecturesEntity) o;
        return idLectures == that.idLectures &&
                productId == that.productId &&
                Objects.equals(lectureName, that.lectureName) &&
                Objects.equals(img, that.img) &&
                Objects.equals(pdfFile, that.pdfFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLectures, productId, lectureName, img, pdfFile);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`product_id`", referencedColumnName = "`id_product`", nullable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
