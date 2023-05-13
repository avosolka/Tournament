import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void TestPlayer1Win() {
        Game game = new Game();
        Player Player1 = new Player(156, "Rick", 100);
        Player Player2 = new Player(122, "Morty", 98);
        game.register(Player1);
        game.register(Player2);

        int actual = game.round("Rick", "Morty");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestPlayer2Win() {
        Game game = new Game();
        Player Player1 = new Player(16, "Gem", 100);
        Player Player2 = new Player(22, "Run", 198);
        game.register(Player1);
        game.register(Player2);

        int actual = game.round("Gem", "Run");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestPlayer0Win() {
        Game game = new Game();
        Player Player1 = new Player(16, "Gem", 100);
        Player Player2 = new Player(22, "Wal", 100);
        game.register(Player1);
        game.register(Player2);

        int actual = game.round("Gem", "Wal");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestPlayer1NoRegistred() {
        Game game = new Game();
        Player Player1 = new Player(16, "Gem", 185);
        Player Player2 = new Player(22, "Wal", 100);

        game.register(Player2);

        Assertions.assertThrows(RuntimeException.class,
                () -> game.round("Gem", "Wal"));
    }

    @Test
    public void TestPlayer2NoRegistred() {
        Game game = new Game();
        Player Player1 = new Player(16, "Gem", 185);
        Player Player2 = new Player(22, "Wal", 100);

        game.register(Player1);

        Assertions.assertThrows(RuntimeException.class,
                () -> game.round("Gem", "Wal"));
    }

    @Test
    public void TestNoOneRegistred() {
        Game game = new Game();
        Player Player1 = new Player(16, "Gem", 185);
        Player Player2 = new Player(22, "Wal", 100);


        Assertions.assertThrows(RuntimeException.class,
                () -> game.round("Gem", "Wal"));
    }


}
