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

            System.out.println(currentPlayer + "'s turn. Enter move (e.g., 'E2 E4'):");
            
            board.frame.addMouseMotionListener(new MouseMotionListener() {
                
                @Override

                public void mouseDragged(MouseEvent e) 
                {
                    
                }
                
                //Changes mouse icon when hovering over a piece?
                @Override
                public void mouseMoved(MouseEvent e) 
                {
			
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
                    if (!click){ 
                        selectedX[0] = (e.getX())/64;
                        selectedY[0] = (e.getY())/64;
                    }
                }




                @Override
                public void mouseReleased(MouseEvent e) {
                    if (selectedX[0] == e.getX()/64 && selectedY[0] == e.getY()/64 && click == false){click = true;}
                    else if (click){click = false;}

                    if (board.movePiece(selectedY[0], selectedX[0], e.getY()/64 , e.getX()/64, currentPlayer[0])) {
                        currentPlayer[0] = currentPlayer[0].equals("white") ? "black" : "white";
                        if (board.isCheckmated(currentPlayer[0].equals("black") ? "black" : "white")){
                            board.displayPopup(currentPlayer[0].equals("white") ? "black" : "white");
                        }
                        if ( board.isInCheck(currentPlayer[0].equals("black") ? "black" : "white")){board.displayPopup2();} //System.out.println("King in check!");
                        board.frame.repaint();
                    } 
                    else if (!board.movePiece(selectedY[0], selectedX[0], e.getY()/64 , e.getX()/64, currentPlayer[0])) {System.out.println("Invalid move. Try again.");}
                    
                    board.frame.repaint();
			
                    if (!click){
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

        }

        scanner.close();
    }
}


