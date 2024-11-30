package pieces;
import VOGS.ChessBoard;


public abstract class Piece {
    public String color;
    // int xPixelPos, yPixelPos; 
    // LinkedList<Piece> pieceList;
    // for the captured piece list, i think ^^
    
    public Piece (String color) {
        this.color = color;
    }

    /** 
     * Checks if a path between two positions is clear for a piece to move through.
    
     * @param startX The x-coordinate of the starting position
     * @param startY The y-coordinate of the starting position
     * @param endX   The x-coordinate of the target position
     * @param endY   The y-coordinate of the target position
     * @param board  The current chessboard
     * @return True if the path is clear, false otherwise.
     */
    
   
    
    public boolean checkPath(int startX, int startY, int endX, int endY, Piece [][] board){
        
        if(startX == endX || startY == endY){
            if (startX < endX){
                for(int i = startX + 1; i < endX; i++){
                    if (board[i][startY] != null){
                        return false;
                    }
                }
            }
            else if (startX > endX){
                for(int i = endX + 1; i < startX; i++){
                    if (board[i][startY] != null){
                        return false;
                    }
                }
            }
            if (startY < endY){
                for(int i = startY + 1; i < endY; i++){
                    if (board[startX][i] != null){
                        return false;
                    }
                }
            }
            else if (startY > endY){
                for(int i = endY + 1; i < startY; i++){
                    if (board[startX][i] != null){
                        return false;
                    }
                }
            }
        }
        // diagonal
        else if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
            int dx = (endX > startX) ? 1 : -1;
            int dy = (endY > startY) ? 1 : -1;
    
            for (int i = 1; i < Math.abs(endX - startX); i++) {
                if (board[startX + i * dx][startY + i * dy] != null) return false;
            }
        }
        return true;    
    }



    // Add board as a parameter
    //Prototype for isValidMove for each indiviudal piece
    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);

/**
     * Abstract method to return a string representation of the piece.
     * 
     * @return The string representation of the piece.
     */
    
    @Override
    public abstract String toString();

    
}


