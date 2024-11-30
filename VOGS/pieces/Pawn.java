package pieces;
import VOGS.ChessBoard;

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
    public boolean isValidMove(int startXPixel, int startYPixel, int endXPixel, int endYPixel, Piece[][] board) {
        // Convert from pixel coordinates to board coordinates
        int startX = startXPixel / 64;  // Board row (X)
        int startY = startYPixel / 64;  // Board column (Y)
        int endX = endXPixel / 64;      // Board row (X)
        int endY = endYPixel / 64;      // Board column (Y)
    
        if (!this.checkPath(startX, startY, endX, endY, board)) {
            return false;
        }
    
        // Pawn movement logic
        if (color.equals("white")) {
            if (startX == 6 && endX == 4 && startY == endY && board[endX][endY] == null) {
                return true; // Move two squares from starting position
            } else if (endX == startX - 1 && startY == endY && board[endX][endY] == null) {
                return true; // Move one square forward
            } else if (endX == startX - 1 && Math.abs(startY - endY) == 1 && board[endX][endY] != null) {
                return true; // Diagonal capture
            }
        } else {
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
