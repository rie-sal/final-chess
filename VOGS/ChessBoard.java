// ChessBoard class

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Vector;

public class ChessBoard {
    public static LinkedList<Piece> pieceList = new LinkedList<>();
    public static Piece selectedPiece=null;
    /**
     * Main method that initializes the chess game GUI, loads piece images, and sets up the board.
     * @param args Command-line arguments (not used).
     * @throws IOException If there is an issue loading images.
     */
    public static void main(String[] args) throws IOException{
        

        // Initialize unscaled images into separate variables for white and black pieces
        BufferedImage bigWKingImg = ImageIO.read(new File("source packages/chessgame/assets/w_king.png"));
        BufferedImage bigWQueenImg = ImageIO.read(new File("source packages/chessgame/assets/w_queen.png"));
        BufferedImage bigWBishopImg = ImageIO.read(new File("source packages/chessgame/assets/w_bishop.png"));
        BufferedImage bigWKnightImg = ImageIO.read(new File("source packages/chessgame/assets/w_knight.png"));
        BufferedImage bigWRookImg = ImageIO.read(new File("source packages/chessgame/assets/w_rook.png"));
        BufferedImage bigWPawnImg = ImageIO.read(new File("source packages/chessgame/assets/w_pawn.png"));
        BufferedImage bigBKingImg = ImageIO.read(new File("source packages/chessgame/assets/b_king.png"));
        BufferedImage bigBQueenImg = ImageIO.read(new File("source packages/chessgame/assets/b_queen.png"));
        BufferedImage bigBBishopImg = ImageIO.read(new File("source packages/chessgame/assets/b_bishop.png"));
        BufferedImage bigBKnightImg = ImageIO.read(new File("source packages/chessgame/assets/b_knight.png"));
        BufferedImage bigBRookImg = ImageIO.read(new File("source packages/chessgame/assets/b_rook.png"));
        BufferedImage bigBPawnImg = ImageIO.read(new File("source packages/chessgame/assets/b_pawn.png"));


        // Place each buffered image into image array and scale them down to fit inside a 64x64 space
        Image imgs[] = new Image[12];
        imgs[0] = bigWKingImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[1] = bigWQueenImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[2] = bigWBishopImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[3] = bigWKnightImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[4] = bigWRookImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[5] = bigWPawnImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[6] = bigBKingImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[7] = bigBQueenImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[8] = bigBBishopImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[9] = bigBKnightImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[10] = bigBRookImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);
        imgs[11] = bigBPawnImg.getScaledInstance(64,64, BufferedImage.SCALE_SMOOTH);


        // Initialize board to chess setup
        Piece bRook1 = new Piece(0,0,false,"rook",pieceList);
        Piece bKnight1 = new Piece(1,0,false,"knight",pieceList);
        Piece bBishop1 = new Piece(2,0,false,"bishop",pieceList);
        Piece bQueen = new Piece(3,0,false,"queen",pieceList);
        Piece bKing = new Piece(4,0,false,"king",pieceList);
        Piece bBishop2 = new Piece(5,0,false,"bishop",pieceList);
        Piece bKnight2 = new Piece(6,0,false,"knight",pieceList);
        Piece bRook2 = new Piece(7,0,false,"rook",pieceList);
        Piece bPawn1 = new Piece(0,1,false,"pawn",pieceList);
        Piece bPawn2 = new Piece(1,1,false,"pawn",pieceList);
        Piece bPawn3 = new Piece(2,1,false,"pawn",pieceList);
        Piece bPawn4 = new Piece(3,1,false,"pawn",pieceList);
        Piece bPawn5 = new Piece(4,1,false,"pawn",pieceList);
        Piece bPawn6 = new Piece(5,1,false,"pawn",pieceList);
        Piece bPawn7 = new Piece(6,1,false,"pawn",pieceList);
        Piece bPawn8 = new Piece(7,1,false,"pawn",pieceList);
        
        
        Piece wRook1 = new Piece(0,7,true,"rook",pieceList);
        Piece wKnight1 = new Piece(1,7,true,"knight",pieceList);
        Piece wBishop1 = new Piece(2,7,true,"bishop",pieceList);
        Piece wQueen = new Piece(3,7,true,"queen",pieceList);
        Piece wKing = new Piece(4,7,true,"king",pieceList);
        Piece wBishop2 = new Piece(5,7,true,"bishop",pieceList);
        Piece wKnight2 = new Piece(6,7,true,"knight",pieceList);
        Piece wRook2 = new Piece(7,7,true,"rook",pieceList);
        Piece wPawn1 = new Piece(0,6,true,"pawn",pieceList);
        Piece wPawn2 = new Piece(1,6,true,"pawn",pieceList);
        Piece wPawn3 = new Piece(2,6,true,"pawn",pieceList);
        Piece wPawn4 = new Piece(3,6,true,"pawn",pieceList);
        Piece wPawn5 = new Piece(4,6,true,"pawn",pieceList);
        Piece wPawn6 = new Piece(5,6,true,"pawn",pieceList);
        Piece wPawn7 = new Piece(6,6,true,"pawn",pieceList);
        Piece wPawn8 = new Piece(7,6,true,"pawn",pieceList);


        JFrame frame = new JFrame();
        
                        // JPanel for rendering the board and pieces

        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);

        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g){
                boolean white = true;
                for (int y = 0; y < 8; y++){
                    for (int x = 0; x < 8; x++){
                        if(white){
                            g.setColor(Color.white);
                        }
                        else{
                            g.setColor(Color.black);
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
                for(Piece p: pieceList){
                    int ind=0;
                    if(p.pieceType.equalsIgnoreCase("king")){
                        ind=0;
                    }
                    if(p.pieceType.equalsIgnoreCase("queen")){
                        ind=1;
                    }
                    if(p.pieceType.equalsIgnoreCase("bishop")){
                        ind=2;
                    }
                    if(p.pieceType.equalsIgnoreCase("knight")){
                        ind=3;
                    }
                    if(p.pieceType.equalsIgnoreCase("rook")){
                        ind=4;
                    }
                    if(p.pieceType.equalsIgnoreCase("pawn")){
                        ind=5;
                    }
                    if(!p.isWhite){
                        ind+=6;
                    }
                    g.drawImage(imgs[ind], p.xPos*64, p.yPos*64, this);
                }

        
            }

        };



    // private static Piece getPieceAt(int x, int y, LinkedList<Piece> pieceList) {
    //     for (Piece piece : pieceList) {
    //         if (piece.xPos == (x/64)*64 && piece.yPos == (y/64)*64){ return piece;}
    //     }
    //     return null;
    // }

    
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
    /**
     * Displays a popup window declaring the winner.
     * @param winner Name of the winner ("White" or "Black").
     */
    private static void displayPopup(String winner) {
        JFrame popup = new JFrame("game over");

        popup.setSize(200,100);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawString(winner + " wins!", 50, 50);
            }
        };
        popup.add(panel);
        popup.setVisible(true);
    }


Piece[][] board = new Piece[8][8];

public ChessBoard() {initializeBoard();}

Vector<String> capturedPiecesW = new Vector<>();
Vector<String> capturedPiecesB = new Vector<>();

/**
 *  The initializeBoard method initalizes the board and adds all the pieces of black
 *  and white to the board.
 * 
 * This method is always called by main as it is crucial to start the game. This method
 * is a void method and does not have any return value.
 * i
 */

    public void initializeBoard() {
        // Set up the black pieces
        board[0][0] = new Rook("black");
        board[0][1] = new Knight("black");
        board[0][2] = new Bishop("black");
        board[0][3] = new Queen("black");
        board[0][4] = new King("black");
        board[0][5] = new Bishop("black");
        board[0][6] = new Knight("black");
        board[0][7] = new Rook("black");
        for (int i = 0; i < 8; i++) {board[1][i] = new Pawn("black");}

        // Set up the white pieces
        board[7][0] = new Rook("white");
        board[7][1] = new Knight("white");
        board[7][2] = new Bishop("white");
        board[7][3] = new Queen("white");
        board[7][4] = new King("white");
        board[7][5] = new Bishop("white");
        board[7][6] = new Knight("white");
        board[7][7] = new Rook("white");
        for (int i = 0; i < 8; i++) {board[6][i] = new Pawn("white");}

    }
/**
 * This method prints the board when called by the main function.
 * This method is a void statement and has no return values. In addition this method
 * has no parameters.
 */

        public void printBoard() {
            // Om's work here: Print the chessboard and alternate ## to represent squares.
            System.out.println("  A  B  C  D  E  F  G  H");
            for (int i = 0; i < 8; i++) {
                System.out.print((8 - i) + " ");
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == null) {
                        if ((i + j) % 2 == 0) {
                            System.out.print("## ");
                        } else {
                            System.out.print("   ");
                        }
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                }
                System.out.println((8 - i));
            }
            System.out.println("  A  B  C  D  E  F  G  H");
            System.out.print("White's captured pieces: ");
            for(int i = 0; i < capturedPiecesW.size(); i++){
                System.out.print(capturedPiecesW.get(i)+", ");
                
            }
            System.out.println(); 
            System.out.print("Black's captured pieces: ");
            for(int i = 0; i < capturedPiecesB.size(); i++){
                System.out.print(capturedPiecesB.get(i)+", ");
            }
            System.out.println(); 
        }

/**
 *  The movePiece method takes input(the starting x and y cordinates of the the piece the user desires to move and then the cordinates the user wants to move the piece to).
 *  the method then carries out the move.
 * @return The movePiece method returns a bool value (true if the move is made, false if the move isnt made)
 *  The movePiece method takes in five paramaters
 *  @param startX: the x cordinate of the desired pieces starting position
 *  @param startY: the y cordinate of the desired pieces starting position
 *  @param endX: the x cordinate of the desired move's square
 *  @param endY: the y cordinate of the desired move's square
 *  @param currentPlayer: a string containing the player whos turn it currently is.
 */
    public boolean movePiece(int startX, int startY, int endX, int endY, String currentPlayer) {
        Piece piece = board[startX][startY];
        if (piece == null || !piece.color.equals(currentPlayer)) {return false;}
        if (piece.isValidMove(startX, startY, endX, endY, board) /* && checkPath(startX, startY, endX, endY, board)*/) {
            // Capture or move
            if (board[endX][endY] == null || !board[endX][endY].color.equals(currentPlayer)) {

                // add to vector list of taken pieces
                if (board[endX][endY] != null && !board[endX][endY].color.equals(currentPlayer)){
                    if (currentPlayer == "white"){
                        capturedPiecesB.add(board[endX][endY].toString());
                    }
                    else {capturedPiecesW.add(board[endX][endY].toString());
                    }
                    
                    //numTakenPieces++;
                } 
                    
                board[endX][endY] = piece;
                board[startX][startY] = null;
                return true;
            }
        }
        return false;
    }

   /**
     * Checks if the current player's king is in checkmate.
     * 
     * @param color The color of the current player ("white" or "black")
     * @return True if the player is in checkmate, false otherwise.
     */

    public boolean isCheckmated(String color){
        int[] kingPos = getKingPos(color);
        int row = kingPos[0];
        int col = kingPos[1];
        if (!isInCheck(board[row][col].color)) { return false; }

        /* to test with a fool's mate (fastest checkmate):
            f2 f3
            e7 e5
            g2 g4
            d8 h4
        */  // Check every move to see if the king can escape check


        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                // System.out.print(i + "" + j + ", ");

                //if (piece == null || !piece.color.equals(CurrentPlayer)) {return false;}
                 
                if (board[row][col].isValidMove(row, col, i, j, board)){
                    if (board[i][j] == null){
                        System.out.println("false, empty space");
                        return false;
                    }
                    if (!board[i][j].color.equals(board[row][col].color)){
                        System.out.println("false " + board[i][j].getClass());
                        return false;
                    }
                }                               
            }
        }
        System.out.println("True");
        return true;
    }
    /**
     * Gets the current position of the king for the given player color.
     * 
     * @param color The color of the current player ("white" or "black")
     * @return An integer array containing the x and y coordinates of the king
     */

    public int[] getKingPos(String color){
        int row = 0, col = 0;

        for(int x = 0; x<board.length; x++){
            for(int y = 0; y<board[0].length; y++){
                if(board[x][y] != null){
                    if(board[x][y].getClass().isInstance(new King("white")) && (board[x][y].color ==(color))){
                        row = x;
                        col = y;
                    }
                }
            }
        }
        int[] returnArray = new int[2];
        returnArray[0] = row;
        returnArray[1] = col;

        return returnArray;
    }
/**
     * Determines if a move would result in a stalemate.
     * 
     * @param color The color of the current player ("white" or "black")
     * @return True if no valid moves are possible and the player is not in check, false otherwise.
     */


    public boolean isStalemate(String color){
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                if (board[x][y] != null && board[x][y].color == color){
                    for (int a=0; a<8; a++){
                        for (int b=0; b<8; b++){
                            // System.out.println(x + "" + y + "" + a + "" + b);
                            if (board[x][y].isValidMove (x, y, a, b, board) && (x != a) && (y != b)){ return false; }
                        }
                    }                   
                }
            }
        }
        return true;// No valid moves, player is stalemated
    } 


   /* chatgpt's method
// New Stalemate detection method
    public boolean isStalemate(String currentPlayer) {
        // If the current player is not in check, check for valid moves
        if (!isInCheck(currentPlayer)) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (board[x][y] != null && board[x][y].color.equals(currentPlayer)) {
                        for (int a = 0; a < 8; a++) {
                            for (int b = 0; b < 8; b++) {
                                if (board[x][y].isValidMove(x, y, a, b, board)) {
                                    return false; // There is a valid move
                                }
                            }
                        }
                    }
                }
            }
            // No valid moves and not in check -> stalemate
            return true;
        }
        return false; // Not a stalemate
    } */


/*  public boolean isJeopardizingKing(int startX, int startY, int endX, int endY, String color) {
        // Get the position of the current player's king
        int[] kingPos = getKingPos(color);
        int kingX = kingPos[0];
        int kingY = kingPos[1];
    
        // Create a copy of the current board for simulation
        Piece[][] testBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                testBoard[i][j] = board[i][j]; // Copy each piece into testBoard
            }
        }
    
        // Simulate the move on the testBoard
        testBoard[endX][endY] = testBoard[startX][startY]; // Move the piece to the new position
        testBoard[startX][startY] = null;                  // Empty the starting position
    
        // Check if the king is in check after this move
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (testBoard[x][y] != null && !testBoard[x][y].color.equals(color)) {
                    // If the opponent's piece can move to the king's position, the king is in check
                    if (testBoard[x][y].isValidMove(x, y, kingX, kingY, testBoard)) {
                        return true; // This move would jeopardize the king
                    }
                }
            }
        }
    
        return false; // This move does not jeopardize the king
    }
    */

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

    /**
     * Checks if the current player's king is in check.
     * 
     * @param color The color of the current player ("white" or "black")
     * @return True if the king is in check, false otherwise.
     */
   public boolean isInCheck(String color) {
    int[] kingPos = getKingPos(color); // Get the position of the king
    int row = kingPos[0];
    int col = kingPos[1];

    // Check every piece on the board to see if it can move to the king's position
    for (int x = 0; x < board.length; x++) {
        for (int y = 0; y < board[0].length; y++) {
            if (board[x][y] != null) {
                // Check if the current piece can move to the king's position and it's an enemy piece
                if (board[x][y].isValidMove(x, y, row, col, board) && !board[x][y].color.equals(color)) {
                    return true; // King is in check
                }
            }
        }
    }
    return false; // King is not in check
}

}
