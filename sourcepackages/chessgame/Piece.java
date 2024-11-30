package chessgame;
import java.util.LinkedList;

/**
* class used for representing a piece on the board. contains the x-cordinate, y-cordinate, team/color, type of piece it is, the pieces on the board, and pixel cordinates
*/
public class Piece{
    int xPos;
    int yPos;
    boolean isWhite;
    String pieceType;
    LinkedList<Piece> pieceList;
    int xPixelPos;
    int yPixelPos;
/** 
*Makes a new piece given the information passed through the method, and then adds the piece to the linked list of pieces on the board.
*
*@param x, x cordinate
*@param y, y cordinate
*@param isWhite, boolean to determine if the piece is on team white or not (white if true, black if false)
*@param type, the type of piece
*@param pieceList, list of pieces on the board
*
*/
    public Piece(int x, int y, boolean isWhite, String type, LinkedList<Piece> pieceList){
        this.xPos = x;
        this.yPos = y;
        this.xPixelPos = this.xPos * 64;
        this.yPixelPos = this.yPos * 64;
        this.isWhite = isWhite;
        this.pieceType = type;
        this.pieceList = pieceList;
        pieceList.add(this);
    }

    /**
    * Moves a piece to the desired destination using the xDest and yDest parameters. This method checks that there is not another piece of the same color in desired spot.
    * if there is a piece of the opposite color in desired spot, this method makes use of the kill method to capture said piece.
    * @param xDest, the x cordinate of the desired destination
    * @param yDest, the y cordinate of the desired destination
    */
    public void move(int xDest,int yDest){
        if(getPieceAt(xDest*64, yDest*64, pieceList)!=null){
            if(getPieceAt(xDest*64, yDest*64, pieceList).isWhite!=isWhite){
                getPieceAt(xDest*64, yDest*64, pieceList).kill();
            }
            else{
                xPixelPos=this.xPos*64;
                yPixelPos=this.yPos*64;
                return;
            }
        }
        this.xPos=xDest;
        this.yPos=yDest;
        xPixelPos=xDest*64;
        yPixelPos=yDest*64;
    }

    /**
    * Method for removing captured pieces from the board.
    */
    public void kill(){
        pieceList.remove(this);
    }
    /** 
    *finds the piece at the cordinates passed through the method and returns the piece found if there is a piece at the position returns null otherwise.
    *
    *@param x, the x cordinate
    *@param y, the y cordinate
    *@param, pieceList, the linked list containing all the pieces on the board.
    *
    * @return the piece found or null if no piece is found
    */
    public static Piece getPieceAt(int x,int y, LinkedList<Piece> pieceList){
        int xPos=x/64;
        int yPos=y/64;
        for(Piece p: pieceList){
            if(p.xPos==xPos&&p.yPos==yPos){
                return p;
            }
        }
        return null;
    }
}
