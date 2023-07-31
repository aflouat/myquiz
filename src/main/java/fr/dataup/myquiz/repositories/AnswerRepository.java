package fr.dataup.myquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dataup.myquiz.entities.Answer;
public interface AnswerRepository extends JpaRepository<Answer,Long>{

}