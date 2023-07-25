
public class GridCell {
    private int x; // X coordinate of the cell on the game board
    private int y; // Y coordinate of the cell on the game board
    private CellState state; // The state of the cell

    // Enum to represent the state of the cell
    public enum CellState {
        EMPTY, // Cell has no ship
        SHIP, // Cell contains a ship
        HIT, // Cell has been hit by a shot
        MISS // Cell has been shot but has no ship
    }

    public GridCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = CellState.EMPTY; // Initialize the cell as empty by default
    }

     public int[] getCoor(){
		    	int[] returnArr = new int[2];
		    	returnArr[0]= this.x;
		    	returnArr[1]= this.y;
		    	return returnArr;

		    }

    // Getters and setters for the state
    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    // Additional methods as needed, e.g., to check if the cell contains a ship
}
