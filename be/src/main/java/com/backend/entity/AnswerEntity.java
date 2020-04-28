package com.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer", schema = "self_edu")
public class AnswerEntity {
    private int idAnswer;
    private int questionId;
    private String answerText;
    private byte isRight;

    @Id
    @Column(name = "id_answer")
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Basic
    @Column(name = "question_id")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "answer_text")
    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Basic
    @Column(name = "is_right")
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
                questionId == that.questionId &&
                isRight == that.isRight &&
                Objects.equals(answerText, that.answerText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnswer, questionId, answerText, isRight);
    }
}
