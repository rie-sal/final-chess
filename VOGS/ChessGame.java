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

import java.util.Scanner;
import pieces.*;
// import VOGS.ChessBoard; 


/**
 * main brings all of the methods together to bring the chess game to life and takes input
 * from the user in order to update the chess board after each input(turn)
 *  */
public class ChessGame{
public static void main(String[] args) throws IOException{

        ChessBoard board = new ChessBoard();
        Scanner scanner = new Scanner(System.in);
        final String[] currentPlayer = new String[1];
        currentPlayer[0] = "white";
        //int selectedX = -1;
        //int selectedY = -1;

        final int[] selectedX = new int[1];
        final int[] selectedY = new int[1];

        while (true) {
            // stalemate check
            if(board.isStalemate(currentPlayer[0].equals("black") ? "black" : "white")){System.out.println("Game over: stalemate.\n");}

            board.printBoard();
            
            if (board.isCheckmated(currentPlayer[0].equals("black") ? "black" : "white")){
                System.out.println("Game over: " + (currentPlayer[0].equals("white") ? "black" : "white") + " wins.");
                break;
            }
            // if ( board.isInCheck(currentPlayer[0].equals("black") ? "black" : "white")){System.out.println("King in check!");}

            System.out.println(currentPlayer + "'s turn. Enter move (e.g., 'E2 E4'):");
            
            // String move = scanner.nextLine().toUpperCase();
            // String[] moveParts = move.split(" ");
            // if (moveParts.length != 2) {
            //     System.out.println("Invalid move format. Please enter in the form 'E2 E4'.");
            //     continue;
            // }


            
            board.frame.addMouseMotionListener(new MouseMotionListener() {
                
                @Override

                public void mouseDragged(MouseEvent e) 
                {
                    // if(selectedPiece!=null){
                    //     selectedPiece.xPixelPos=e.getX()-32;
                    //     selectedPiece.yPixelPos=e.getY()-32;
                    //     frame.repaint();
                    // }
                    
                }
                
                //Changes mouse icon when hovering over a piece?
                @Override
                public void mouseMoved(MouseEvent e) 
                {
                    // // Piece pieceAt = getPieceAt(e.getX(), e.getY(), pieceList);
                    // Piece pieceAt = board [(e.getX())/64][(e.getY())/64 ];
                    // if (pieceAt != null) {
                    //     board.frame.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
                    // } else {
                    //     board.frame.setCursor(java.awt.Cursor.getDefaultCursor());
                    // }
                }
            });

            
            //Checks for click
            board.frame.addMouseListener(new MouseListener() {
                boolean click = false;
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                
                //Selects piece that the user clicks with their mouse
                @Override
                public void mousePressed(MouseEvent e) {
                // System.out.println((getPieceAt(e.getX(), e.getY(), pieceList).isWhite?"white ":"balck ")+getPieceAt(e.getX(), e.getY(), pieceList).pieceType);
                    if (!click){ 
                        // selectedPiece=getPieceAt(e.getX(), e.getY(), pieceList);
                        
                        selectedX[0] = (e.getX())/64;
                        selectedY[0] = (e.getY())/64;
                        
                        // selectedPiece = board [(e.getX())/64][ (e.getY())/64 ];
                    }
                }




                @Override
                public void mouseReleased(MouseEvent e) {
                    if (selectedX[0] == e.getX()/64 && selectedY[0] == e.getY()/64 && click == false){click = true;}
                    else if (click){click = false;}
                    //selectedPiece.move(e.getX()/64, e.getY()/64);
                    // movePiece(selectedX, selectedY, e.getX()/64, e.getY()/64, currentPlayer);

                    if (board.movePiece(selectedY[0], selectedX[0], e.getY()/64 , e.getX()/64, currentPlayer[0])) {
                        currentPlayer[0] = currentPlayer[0].equals("white") ? "black" : "white";
                        if (board.isCheckmated(currentPlayer[0].equals("black") ? "black" : "white")){
                            board.displayPopup(currentPlayer[0].equals("white") ? "black" : "white");
                            //break;
                        }
                        if ( board.isInCheck(currentPlayer[0].equals("black") ? "black" : "white")){board.displayPopup2();} //System.out.println("King in check!");
                        board.frame.repaint();
                    } 
                    else if (!board.movePiece(selectedY[0], selectedX[0], e.getY()/64 , e.getX()/64, currentPlayer[0])) {System.out.println("Invalid move. Try again.");}
                    
                    board.frame.repaint();
                    // try {board.printBoard();} catch (IOException e1) {}//e1.printStackTrace();
                    
                    
                    

                    // boolean[] kingsPresent = {false, false};
                    // for (Piece p: pieceList){
                    //     if (p.pieceType.equals("king")){
                    //         kingsPresent[p.isWhite ? 0 : 1 ] = true;
                    //     }
                    // }
                    // if (!kingsPresent[0]){displayPopup("black");}
                    // else if(!kingsPresent[1]){displayPopup("white");}

                    if (!click){
                        // selectedPiece = null;
                        selectedX[0] = -1;
                        selectedY[0] = -1;
                    }        
                }


                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

        

            // Now calculates startY, startX, endY, endX and using the converted uppercase letters
            // int startX = 8 - Character.getNumericValue(moveParts[0].charAt(1)); // 1-8 -> 7-0
            // int startY = moveParts[0].charAt(0) - 'A'; // A-H -> 0-7
            // int endX = 8 - Character.getNumericValue(moveParts[1].charAt(1));   // 1-8 -> 7-0
            // int endY = moveParts[1].charAt(0) - 'A';   // A-H -> 0-7
            
            
            
            // if valid move alternates the turn; changes the current player
            // if (board.movePiece(startX, startY, endX, endY, currentPlayer)) {
            //     currentPlayer = currentPlayer.equals("white") ? "black" : "white";
            // } 
	    //    else {System.out.println("Invalid move. Try again.");}
        }

        // win message
        //System.out.println((currentPlayer[0].equals("white") ? "black" : "white") + "wins.");       
    
        scanner.close();
    }
}


