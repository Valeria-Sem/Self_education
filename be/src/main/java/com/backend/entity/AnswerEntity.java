package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "`answer`", schema = "`self_edu`")
public class AnswerEntity {
    private int idAnswer;
    private String answerText;
    private byte isRight;
    private QuestionEntity questionByQuestionId;

    @Id
    @Column(name = "`id_answer`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Basic
    @Column(name = "`answer_text`")
    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Basic
    @Column(name = "`is_right`")
    public byte getIsRight() {
        return isRight;
    }

    public void setIsRight(byte isRight) {
        this.isRight = isRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return idAnswer == that.idAnswer &&
                isRight == that.isRight &&
                Objects.equals(answerText, that.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnswer, answerText, isRight);
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "`question_id`", referencedColumnName = "`id_question`", nullable = false)
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
}
