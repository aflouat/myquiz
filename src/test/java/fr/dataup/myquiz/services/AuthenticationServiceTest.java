package fr.dataup.myquiz.services;

import org.junit.jupiter.api.Test;

import fr.dataup.myquiz.entities.Player;
public class AuthenticationServiceTest {

    @Test
    public void shouldReturnTrueWhenPlayerIsAuthenticated() {
        Player  player = new Player();
        player.setAuthenticated(true);
        player.setId(1L);
        player.setNickname("Mohamed");
    }
        
}
