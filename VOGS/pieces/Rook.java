package pieces;

public class Rook extends Piece {
    public Rook(String color) {super(color);}


 /**
     * Checks if the rook's move is valid based on the rules of chess.
     * The rook can move horizontally or vertically any number of squares.
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
        return (startX == endX || startY == endY); // Rook moves in straight lines
    }


    /**
     * Returns the string representation of the rook.
     * 
     * @return The string "wR" for white rook or "bR" for black rook.
     */
    @Override
    public String toString() {return color.equals("white") ? "wR" : "bR";}
}
