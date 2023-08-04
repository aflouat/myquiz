package fr.dataup.myquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dataup.myquiz.entities.Player;
public interface PlayerRepository extends JpaRepository<Player,Long>{

    Player findByNickname(String playerNickname);

}