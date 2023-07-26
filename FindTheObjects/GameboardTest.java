public class GameboardTest {
    public static void main(String[] args) {
        testShipPlacement();
        testShooting();
        testWinningCondition();
    }

    public static void testShipPlacement() {
        Gameboard gameboard = new Gameboard(8, 8);

        // Place a horizontal ship of size 3 at (2, 3)
        boolean result1 = gameboard.placeShip(2, 3, 3, true);
        assert result1 == true : "Failed to place ship horizontally.";

        // Place a vertical ship of size 2 at (5, 5)
        boolean result2 = gameboard.placeShip(5, 5, 2, false);
        assert result2 == true : "Failed to place ship vertically.";

        // Ensure the grid state reflects the ship placement
        GridCell.CellState[][] expectedGridState = {
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.SHIP, GridCell.CellState.SHIP, GridCell.CellState.SHIP, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.SHIP, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.SHIP, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY}
        };
        
        GridCell[][] actualGrid = gameboard.getGrid();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assert actualGrid[i][j].getState() == expectedGridState[i][j] : "Incorrect grid state.";
            }
        }
    }

    public static void testShooting() {
        Gameboard gameboard = new Gameboard(8, 8);

        // Place a horizontal ship of size 3 at (2, 3)
        gameboard.placeShip(2, 3, 3, true);

        // Shoot at (2, 3), (2, 4), and (2, 5)
        gameboard.shoot(2, 3); // Hit
        gameboard.shoot(2, 4); // Hit
        gameboard.shoot(2, 5); // Hit

        // Ensure the grid state reflects the hits and misses
        GridCell.CellState[][] expectedGridState = {
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.HIT, GridCell.CellState.HIT, GridCell.CellState.HIT, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.SHIP, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.SHIP, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY},
            {GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY, GridCell.CellState.EMPTY}
        };

        GridCell[][] actualGrid = gameboard.getGrid();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assert actualGrid[i][j].getState() == expectedGridState[i][j] : "Incorrect grid state after shooting.";
            }
        }
    }

    public static void testWinningCondition() {
        Gameboard gameboard = new Gameboard(8, 8);

        // Place a horizontal ship of size 3 at (2, 3)
        gameboard.placeShip(2, 3, 3, true);

        // Shoot at (2, 3), (2, 4), and (2, 5)
        gameboard.shoot(2, 3); // Hit
        gameboard.shoot(2, 4); // Hit
        gameboard.shoot(2, 5); // Hit

        // All ships are sunk; the player has won
        assert gameboard.hasPlayerWon() == true : "Winning condition not met.";
    }
}
