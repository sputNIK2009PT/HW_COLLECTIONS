package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(13, "sputNIK", 6);
    Player player2 = new Player(84, "Dante13", 5);
    Player player3 = new Player(2, "Kratos", 8);
    Player player4 = new Player(23, "Batman", 6);

    @Test
    public void testRoundFirstWins() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(1, game.round("Kratos", "Dante13"));
    }

    @Test
    public void testRoundSecondWins() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(2, game.round("Dante13", "Batman"));
    }

    @Test
    public void testRoundEquals() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(0, game.round("Batman", "sputNIK"));
    }

    @Test
    public void testRoundFirstNotRegistrated() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Rayden", "sputNIK");
        });
    }

    @Test
    public void testRoundSecondNotRegistrated() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dante13", "NotDante13");
        });
    }

    @Test
    public void testRoundBothNotRegistrated() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Rayden", "NotDante13");
        });
    }
}