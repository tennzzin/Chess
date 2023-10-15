// Written by Tenzin Chonyi, chony003
// Written by Kalden Sopa, sopa0004

public class Queen {
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public Queen(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (!board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)) {
            return false;
        }

        // Check vertical, horizontal, or diagonal move
        if (board.verifyVertical(this.row, this.col, endRow, endCol) ||
                board.verifyHorizontal(this.row, this.col, endRow, endCol) ||
                board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
            return true;
        }
        return false;
    }
}
