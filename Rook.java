public class Rook {
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (!board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            return false;
        }
        if (this.row == endRow) {
            return (board.verifyHorizontal(this.row, this.col, endRow, endCol));
        }
        if (this.col == endCol) {
            return (board.verifyVertical(this.row, this.col, endRow, endCol));
        }
        return false;
    }
}

// Written by Tenzin Chonyi, chony003