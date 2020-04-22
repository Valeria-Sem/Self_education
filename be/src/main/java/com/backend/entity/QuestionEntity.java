package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`question`", schema = "`self_edu`")
public class QuestionEntity {
    private int idQuestion;
    private int testId;
    private String text;
    private TestEntity testByTestId;

    @Id
    @Column(name = "`id_question`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Basic
    @Column(name = "`test_id`")
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "`text`")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return idQuestion == that.idQuestion &&
                testId == that.testId &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, testId, text);
    }

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`test_id`", referencedColumnName = "`id_test`", nullable = false)
    public TestEntity getTestByTestId() {
        return testByTestId;
    }

    public void setTestByTestId(TestEntity testByTestId) {
        this.testByTestId = testByTestId;
    }
}
