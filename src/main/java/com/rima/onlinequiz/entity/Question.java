package com.rima.onlinequiz.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode()
@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    private Long id;

    @Column(name = "QUESTION_TITLTE", nullable = false)
    private String questionTittle;

    @Column(name = "SUBJECT", nullable = false)
    private String subject;

    @Column(name = "QUESTION_TYPE", nullable = false)
    private String questionType;

    @ElementCollection
    private List<String> choices;

    @ElementCollection
    private List<String> correctAnswers;

}
