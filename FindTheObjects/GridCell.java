//Brandon Webb


/**
 * Represents a single cell in the game board grid. Each cell can have one of the following states:
 * EMPTY - The cell contains no ship.
 * SHIP - The cell contains a part of a ship.
 * HIT - The cell has been hit by a shot.
 * MISS - The cell was shot at, but there was no ship.
 */
public class GridCell {
    private int x;
    private int y;
    private GridCell.CellState state;
    /**
     * Enumerates the possible states of a cell.
     */
    public enum CellState {
        EMPTY,
        SHIP,
        HIT,
        MISS
    }
    /**
     * Constructs a new GridCell instance with the specified coordinates (x, y).
     *
     * @param x The x-coordinate of the cell on the game board.
     * @param y The y-coordinate of the cell on the game board.
     */
    public GridCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = CellState.EMPTY;
    }
    /**
     * Retrieves the x-coordinate of the cell on the game board.
     *
     * @return The x-coordinate of the cell.
     */
    public int getX() {
        return x;
    }
    /**
     * Retrieves the y-coordinate of the cell on the game board.
     *
     * @return The y-coordinate of the cell.
     */
    public int getY() {
        return y;
    }
    /**
     * Retrieves the current state of the cell.
     *
     * @return The current state of the cell (EMPTY, SHIP, HIT, or MISS).
     */
    public CellState getState() {
        return state;
    }
    /**
     * Sets the state of the cell to the specified state.
     *
     * @param state The new state to set for the cell (EMPTY, SHIP, HIT, or MISS).
     */
    public void setState(CellState state) {
        this.state = state;
    }
}
