public class Bishop {
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
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

        return rowDiff == colDiff && board.verifyDiagonal(this.row, this.col, endRow, endCol);
    }
}

// Written by Tenzin Chonyi, chony003