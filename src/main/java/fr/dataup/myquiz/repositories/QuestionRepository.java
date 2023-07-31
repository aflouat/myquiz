package fr.dataup.myquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dataup.myquiz.entities.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>{

}