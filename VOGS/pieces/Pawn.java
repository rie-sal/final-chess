package pieces;

public class Pawn extends Piece {
   /**
     * Constructor for the Pawn class.
     * 
     * @param color The color of the pawn ("white" or "black").
     */

    public Pawn(String color) {
        super(color);
    }
/**
     * Checks if the pawn's move is valid based on the rules of chess.
     * White pawns move upward (toward lower row numbers), black pawns move downward.
     * Pawns move forward one square, or two squares if it's their first move. They capture diagonally.
     * 
     * @param startX The x-coordinate of the starting position.
     * @param startY The y-coordinate of the starting position.
     * @param endX   The x-coordinate of the ending position.
     * @param endY   The y-coordinate of the ending position.
     * @param board  The current state of the chessboard.
     * @return True if the move is valid, false otherwise.
     */

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        if (!this.checkPath(startX, startY, endX, endY, board)){return false;}
        if (color.equals("white")) {
            // White pawns move up the board (to lower row numbers)
            if (startX == 6 && endX == 4 && startY == endY && board[endX][endY] == null) {
                return true; // Move two squares from starting position
            } else if (endX == startX - 1 && startY == endY && board[endX][endY] == null) {
                return true; // Move one square forward
            } else if (endX == startX - 1 && Math.abs(startY - endY) == 1 && board[endX][endY] != null) {
                return true; // Diagonal capture
            }
        } else {
            // Black pawns move down the board (to higher row numbers)
            if (startX == 1 && endX == 3 && startY == endY && board[endX][endY] == null) {
                return true; // Move two squares from starting position
            } else if (endX == startX + 1 && startY == endY && board[endX][endY] == null) {
                return true; // Move one square forward
            } else if (endX == startX + 1 && Math.abs(startY - endY) == 1 && board[endX][endY] != null) {
                return true; // Diagonal capture
            }
        }
        return false;
    }

    

/**
     * Returns the string representation of the pawn.
     * 
     * @return The string "wp" for white pawn or "bp" for black pawn.
     */
    
    @Override
    public String toString() {return color.equals("white") ? "wp" : "bp";}
}
