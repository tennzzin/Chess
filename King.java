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

        return board.verifyAdjacent(this.row, this.col, endRow, endCol);
    }
}

// Written by Tenzin Chonyi, chony003