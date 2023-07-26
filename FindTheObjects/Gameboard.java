

public class Gameboard {
    private int rows; // Number of rows in the game board
    private int cols; // Number of columns in the game board
    private GridCell[][] grid; // 2D array representing the game board grid

    // Constructor to initialize the game board with the specified dimensions
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

    // Method to place a ship on the game board
    public void placeShip(int x, int y, int size, boolean isHorizontal) {
         size = 0;
        // Implement logic to place the ship on the grid
        // You may want to check if the placement is valid and handle overlapping ships
        // Update the states of the appropriate GridCell instances to represent the ship
    }

    // Method to handle a shot at the specified cell coordinates (x, y)
    public void shoot(int x, int y) {
        // Implement logic to handle the shot and update the state of the targeted GridCell
        // Determine if the shot was a hit or a miss
        // Check if a ship is sunk after the shot and notify the player if necessary
    }

    // Method to check if the player has won the game
    public boolean hasPlayerWon() {
        // Implement logic to check if all the ships on the game board have been sunk
        // Return true if the player has won, false otherwise
        return false;
    }

    // Additional methods as needed, e.g., to retrieve the state of a specific cell
    
    public int getRow() {
    	return this.rows;
    }
    public int getCol() {
    	return this.cols;
    }

}
