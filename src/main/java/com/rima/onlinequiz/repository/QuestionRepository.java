package com.rima.onlinequiz.repository;

import com.rima.onlinequiz.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    String distinctSubject = "select distinct Q.subject  from question q";

    @Query(value = distinctSubject, nativeQuery = true)
    List<String> findDistinctSubject();

    Page findBySubject(String subject, Pageable pageable);
}
