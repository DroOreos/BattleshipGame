//Brandon Webb
public class GridCell {
    private int x;
    private int y;
    private GridCell.CellState state;

    public enum CellState {
        EMPTY,
        SHIP,
        HIT,
        MISS
    }

    public GridCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.state = CellState.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
