package pieces;
import VOGS.ChessBoard;

public class King extends Piece {  
    public King(String color) {super(color);}
    
    /**
     * Checks if the king's move is valid based on the rules of chess.
     * 
     * @param startX The x-coordinate of the starting position.
     * @param startY The y-coordinate of the starting position.
     * @param endX   The x-coordinate of the ending position.
     * @param endY   The y-coordinate of the ending position.
     * @param board  The current state of the chessboard.
     * @return True if the move is valid, false otherwise.
     */
    @Override
    
  public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) 
    {
      if (!this.checkPath(startX, startY, endX, endY, board)){return false;}
      for(int x=0; x<8; x++){     //Iterating coloumns
      //System.out.print("- ");
        for(int y=0; y<8; y++){   // iterate through the rows
            if (board[x][y] != null && (board[x][y].getClass() != this.getClass()) && !board[x][y].color.equals(this.color))
                // current square is occupied by a piece that's not the king & not currentPlayer's color                
                {if (board[x][y].isValidMove(x, y, endX, endY, board)){ return false;}
            }
        }
      }
      //System.out.println();
      return ((Math.abs(startX - endX) <= 1) && (Math.abs(startY - endY) <= 1));
    }


		// King moves 1 square in any direction

    /**
     * Returns the string representation of the king.
     * 
     * @return The string "wK" for white king or "bK" for black king.
     */
    @Override

    public String toString() {return color.equals("white") ? "wK" : "bK";}
    
}
