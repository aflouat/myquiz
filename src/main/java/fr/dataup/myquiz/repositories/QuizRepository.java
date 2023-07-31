package fr.dataup.myquiz.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.dataup.myquiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
//getQuizFirstByTitle
    Quiz getQuizFirstByTitle(String title);
}
