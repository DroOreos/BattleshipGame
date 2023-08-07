//Brandon Webb

import java.util.ArrayList;

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

  // Method to handle a shot at the specified cell coordinates (x, y)
  public boolean shoot(int x, int y) {
      // Check if the shot is valid
      if (x < 0 || y < 0 || x >= rows || y >= cols) {
          return false; // Out of bounds
      }

      GridCell cell = grid[x][y];
      if (cell.getState() == GridCell.CellState.EMPTY ) {
          cell.setState(GridCell.CellState.MISS);
          return true;
      } else if (cell.getState() == GridCell.CellState.SHIP) {
          cell.setState(GridCell.CellState.HIT);
          return true;
      }

      return false; // Invalid shot (cell already hit or sunk ship)
  }

  // Method to check if the player has won the game
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

  // Getter for the grid variable
  public GridCell[][] getGrid() {
      return grid;
  }

  public int getRows(){
      return this.rows;
  }

  public int getCols(){
      return this.cols;
  }

   public GridCell getGridCell(int x, int y) {
  	return grid[x][y];
  }
}
