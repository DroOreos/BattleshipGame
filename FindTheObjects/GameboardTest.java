//Brandon Webb
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameboardTest {

    @Test
    public void testShipPlacement() {
        Gameboard gameboard = new Gameboard(8, 8);

        boolean result1 = gameboard.placeShip(2, 3, 3, true);
        assertTrue(result1, "Failed to place ship horizontally.");

        boolean result2 = gameboard.placeShip(5, 5, 2, false);
        assertTrue(result2, "Failed to place ship vertically.");

        GridCell.CellState[][] expectedGridState = { /* your expected grid state here */ };
        GridCell[][] actualGrid = gameboard.getGrid();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(expectedGridState[i][j], actualGrid[i][j].getState(), "Incorrect grid state.");
            }
        }
    }

    @Test
    public void testShooting() {
        Gameboard gameboard = new Gameboard(8, 8);
        gameboard.placeShip(2, 3, 3, true);

        gameboard.shoot(2, 3); // Hit
        gameboard.shoot(2, 4); // Hit
        gameboard.shoot(2, 5); // Hit

        GridCell.CellState[][] expectedGridState = { /* your expected grid state here */ };
        GridCell[][] actualGrid = gameboard.getGrid();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertEquals(expectedGridState[i][j], actualGrid[i][j].getState(), "Incorrect grid state after shooting.");
            }
        }
    }

    @Test
    public void testWinningCondition() {
        Gameboard gameboard = new Gameboard(8, 8);
        gameboard.placeShip(2, 3, 3, true);

        gameboard.shoot(2, 3); // Hit
        gameboard.shoot(2, 4); // Hit
        gameboard.shoot(2, 5); // Hit

        assertTrue(gameboard.hasPlayerWon(), "Winning condition not met.");
    }
}
