//Brandon Webb

import java.util.ArrayList;

/**
 * Represents the game board for the Battleship game. The game board is a grid of cells, and ships can be placed on
 * the board. Players can shoot at cells to attack enemy ships.
 */
public class Gameboard {
    private int rows; // Number of rows in the game board
    private int cols; // Number of columns in the game board
    private GridCell[][] grid; // 2D array representing the game board grid

    // Constructor to initialize the game board with the specified dimensions
    /**
     * Constructor to initialize the game board with the specified dimensions.
     *
     * @param rows The number of rows in the game board.
     * @param cols The number of columns in the game board.
     */
    public Gameboard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new GridCell[rows][cols];

        // Initialize the grid with GridCell instances
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new GridCell(i, j);
            }
        }
    }

    /**
     * Places a ship on the game board.
     *
     * @param x           The x-coordinate of the top-left corner of the ship.
     * @param y           The y-coordinate of the top-left corner of the ship.
     * @param size        The size of the ship (number of cells it occupies).
     * @param isHorizontal True if the ship is to be placed horizontally, false if vertically.
     * @return True if the ship is successfully placed, false otherwise (invalid placement or overlapping ships).
     */
    public boolean placeShip(int x, int y, int size, boolean isHorizontal) {
        // Check if the placement is valid
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false; // Out of bounds
        }

        if (isHorizontal) {
            if (y + size > cols) {
                return false; // Exceeds the board width
            }

            for (int j = y; j < y + size; j++) {
                if (grid[x][j].getState() == GridCell.CellState.SHIP) {
                    return false; // Overlaps with an existing ship
                }
            }

            // Place the ship horizontally
            for (int j = y; j < y + size; j++) {
                grid[x][j].setState(GridCell.CellState.SHIP);
            }
        } else {
            if (x + size > rows) {
                return false; // Exceeds the board height
            }

            for (int i = x; i < x + size; i++) {
                if (grid[i][y].getState() == GridCell.CellState.SHIP) {
                    return false; // Overlaps with an existing ship
                }
            }

            // Place the ship vertically
            for (int i = x; i < x + size; i++) {
                grid[i][y].setState(GridCell.CellState.SHIP);
            }
        }

        return true;
    }

    /**
     * Handles a shot at the specified cell coordinates (x, y).
     *
     * @param x The x-coordinate of the cell to be shot.
     * @param y The y-coordinate of the cell to be shot.
     * @return True if the shot is valid and successful (hit or miss), false otherwise (invalid shot).
     */
    public boolean shoot(int x, int y) {
        // Check if the shot is valid
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false; // Out of bounds
        }

        GridCell cell = grid[x][y];
        if (cell.getState() == GridCell.CellState.EMPTY || cell.getState() == GridCell.CellState.MISS) {
            cell.setState(GridCell.CellState.MISS);
            return true;
        } else if (cell.getState() == GridCell.CellState.SHIP) {
            cell.setState(GridCell.CellState.HIT);
            return true;
        }

        return false; // Invalid shot (cell already hit or sunk ship)
    }

    /**
     * Checks if the player has won the game.
     *
     * @return True if all ships on the game board are sunk (player has won), false otherwise.
     */
    public boolean hasPlayerWon() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].getState() == GridCell.CellState.SHIP) {
                    return false; // Not all ships are sunk, the player has not won yet
                }
            }
        }
        return true; // All ships are sunk, the player has won
    }

    /**
     * Retrieves the grid representation of the game board.
     *
     * @return A 2D array of GridCell objects representing the game board.
     */
    public GridCell[][] getGrid() {
        return grid;
    }
    /**
     * Retrieves the number of rows in the game board.
     *
     * @return The number of rows in the game board.
     */
    public int getRows(){
        return this.rows;
    }
    /**
     * Retrieves the number of columns in the game board.
     *
     * @return The number of columns in the game board.
     */
    public int getCols(){
        return this.cols;
    }
    /**
     * Retrieves the GridCell object at the specified cell coordinates (x, y).
     *
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     * @return The GridCell object at the specified coordinates.
     */
     public GridCell getGridCell(int x, int y) {
    	return grid[x][y];
    }
}
