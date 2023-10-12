public class Board {

    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        board = new Piece[8][8];
    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not 
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        // Create piece
        Piece piece = getPiece(startRow, startCol);

        // If legal, move piece and set old spot to null
        if (piece.isMoveLegal(this, endRow, endCol)) {
            board[endRow][endCol] = piece;
            board[startRow][startCol] = null;
            piece.setPosition(endRow, endCol);
            return true;
        } else {
            return false;
        }
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean whiteKing = false;
        boolean blackKing = false;

        // Iterate through the board to find each King
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.toString().equals("\u2654")) {
                    whiteKing = true;
                }
                if (piece != null && piece.toString().equals("\u265a")) {
                    blackKing = true;
                }
            }
        }

        // Worst case scenario
        if (whiteKing && blackKing) {
            return false;
        }
        return true;
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for(int i = 0; i < 8; i++){
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for(int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for(int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = null;
            }
        }
    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        // Check the bounds
        if (startRow >= 0 && startRow < 8 && startCol >= 0 && startCol < 8 &&
                endRow >= 0 && endRow < 8 && endCol >= 0 && endCol < 8) {

            // Check if destination valid
            if (board[startRow][startCol] != null) {
                if (board[startRow][startCol].getIsBlack() == isBlack) {
                    if (board[endRow][endCol] == null || board[endRow][endCol].getIsBlack() != isBlack) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        // Calculate difference
        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        return rowDiff <= 1 && colDiff <= 1;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        // Check if in same row
        if (startRow != endRow) {
            return false;
        }

        int colLeft = 0;
        int colRight = 0;
        if (startCol < endCol) {
            colRight = 1; // Moving right
        } else {
            colLeft = -1; // Moving left
        }

        // Check if path right open
        if (startCol < endCol) {
            for (int col = startCol + colRight; col < endCol; col += colRight) {
                if (board[startRow][col] != null) {
                    return false;
                }
            }
        }

        // Check if path left open
        if (startCol > endCol) {
            for (int col = startCol + colLeft; col > endCol; col += colLeft) {
                if (board[startRow][col] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        // Check if in same column
        if (startCol != endCol) {
            return false;
        }

        int rowUp = 0;
        int rowDown = 0;
        if (startRow < endRow) {
            rowUp = 1; // Moving up
        } else {
            rowDown = -1; // Moving down
        }

        // Check if path up open
        if (startRow < endRow) {
            for (int row = startRow + rowUp; row < endRow; row += rowUp) {
                if (board[row][startCol] != null) {
                    return false;
                }
            }
        }

        // Check if path down open
        if (startRow > endRow) {
            for (int row = startRow + rowDown; row > endRow; row += rowDown) {
                if (board[row][startCol] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
       if (startRow == endRow && startCol == endCol) {
           return true;
       }

        // Check if row and column difference are equal
        int rowDiff = endRow - startRow;
        int colDiff = endCol - startCol;
        if (Math.abs(rowDiff) != Math.abs(colDiff)) {
            return false;
        }

        // Determine diagonal path
        int rowStep = 0;
        int colStep = 0;
        if (rowDiff > 0) {
            rowStep = 1;
        } else {
            rowStep = -1;
        }
        if (colDiff > 0) {
            colStep = 1;
        } else {
            colStep = -1;
        }

        // Check diagonal path
        int row = startRow + rowStep;;
        int col = startCol + colStep;
        while (row != endRow || col != endCol) {
            if (board[row][col] != null) {
                return false;
            }
            row += rowStep;
            col += colStep;
        }
        return true;
    }
}
