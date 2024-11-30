package pieces;

class Bishop extends Piece {
    /**
     * Constructor for the Bishop class.
     * 
     * @param color The color of the bishop ("white" or "black").
     */

    public Bishop(String color) {super(color);}

 /**
     * Checks if the bishop's move is valid based on the rules of chess.
     * The bishop can move diagonally any number of squares.
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
        return Math.abs(startX - endX) == Math.abs(startY - endY); // Bishop moves diagonally
        
    }
/**
     * Returns the string representation of the bishop.
     * 
     * @return The string "wB" for white bishop or "bB" for black bishop.
     */
    
    @Override
    public String toString() {return color.equals("white") ? "wB" : "bB";}
}