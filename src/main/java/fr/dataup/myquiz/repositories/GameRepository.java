package fr.dataup.myquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dataup.myquiz.entities.Game;
public interface GameRepository extends JpaRepository<Game,Long>{

}