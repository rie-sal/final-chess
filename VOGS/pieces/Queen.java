package pieces;
import VOGS.ChessBoard;

public class Queen extends Piece {
    public Queen(String color) {super(color);}

    @Override
    /**
     * Constructor for the Queen class.
     * 
     * @param color The color of the queen ("white" or "black").
     */
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        if (!this.checkPath(startX, startY, endX, endY, board)){return false;}
        return (startX == endX || startY == endY || Math.abs(startX - endX) == Math.abs(startY - endY)); 
        // Queen moves like a Rook or Bishop
    }

 /**
     * Returns the string representation of the queen.
     * 
     * @return The string "wQ" for white queen or "bQ" for black queen.
     */
    
    @Override
    public String toString() {return color.equals("white") ? "wQ" : "bQ";}
}
