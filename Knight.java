// Written by Tenzin Chonyi, chony003
// Written by Kalden Sopa, sopa0004

public class Knight {
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (!board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            return false;
        }
        int rowDiff = Math.abs(endRow - this.row);
        int colDiff = Math.abs(endCol - this.col);

        // Check if L shaped move
        return (rowDiff == 1 && colDiff == 2 || rowDiff == 2 && colDiff == 1);
    }
}
