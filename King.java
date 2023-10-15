// Written by Tenzin Chonyi, chony003
// Written by Kalden Sopa, sopa0004

public class King {
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (!board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            return false;
        }

        // Check adjacent move
        return board.verifyAdjacent(this.row, this.col, endRow, endCol);
    }
}
