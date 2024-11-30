package pieces;
import VOGS.ChessBoard;

public class Knight extends Piece {
    public Knight(String color) {super(color);}

/**
     * Checks if the knight's move is valid based on the rules of chess.
     * The knight moves in an "L" shape: two squares in one direction and then one
     * square perpendicular to that.
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
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2); // Knight moves in "L" shape
    }

    @Override
    public String toString() {return color.equals("white") ? "wN" : "bN";}
}
