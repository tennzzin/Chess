import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Create new board
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Fen.load("rnbqkbnr/pppppppP/8/8/8/8/PPPPPPPP/RNBQKBNR", board);

        // Keeps check of whose turn it is
        int count = 0;

        // Play game until King is captured
        while (!board.isGameOver()) {

            // Print the board and ask for user input
            System.out.println(board);
            if (count % 2 == 0) {
                System.out.println("It is White's turn.");
            } else {
                System.out.println("It is Black's turn");
            }
            System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])");
            String[] line = scanner.nextLine().split(" ");
            int startRow = Integer.parseInt(line[0]);
            int startCol = Integer.parseInt(line[1]);
            int endRow = Integer.parseInt(line[2]);
            int endCol = Integer.parseInt(line[3]);

            // White turn
            if (count % 2 == 0) {
                if (!board.getPiece(startRow, startCol).getIsBlack() && board.movePiece(startRow, startCol, endRow, endCol)) {
                    System.out.println("Move successful.");
                    boolean colorPiece = board.getPiece(endRow, endCol).getIsBlack();
                    board.getPiece(endRow, endCol).promotePawn(endRow, colorPiece);
                    count += 1;
                } else {
                    System.out.println("Invalid move. Try again.");
                }

            // Black Turn
            } else {
                if (board.getPiece(startRow, startCol).getIsBlack() && board.movePiece(startRow, startCol, endRow, endCol)) {
                    System.out.println("Move successful.");
                    boolean colorPiece = board.getPiece(endRow, endCol).getIsBlack();
                    board.getPiece(endRow, endCol).promotePawn(endRow, colorPiece);
                    count += 1;
                } else {
                    System.out.println("Invalid move. Try again.");
                }

            }
        }

        // Check count when game ends
        if ((count - 1) % 2 == 0) {
            System.out.println("\nWhite won!");
        } else {
            System.out.println("\nBlack won!");
        }
    }
}
