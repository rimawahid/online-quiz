package com.rima.onlinequiz.repository;

import com.rima.onlinequiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
