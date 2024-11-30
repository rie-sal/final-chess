

import java.util.Scanner;
import pieces.*;
import VOGS.ChessBoard; 

/**
 * main brings all of the methods together to bring the chess game to life and takes input
 * from the user in order to update the chess board after each input(turn)
 *  */
    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();
        Scanner scanner = new Scanner(System.in);
        String currentPlayer = "white";
        
        while (true) {
            // stalemate check
            if(board.isStalemate(currentPlayer.equals("black") ? "black" : "white"))  
                {System.out.println("Game over: stalemate.\n");board.printBoard(); break;}
            board.printBoard();
            if (board.isCheckmated(currentPlayer.equals("black") ? "black" : "white")){
                System.out.println("Game over: " + (currentPlayer.equals("white") ? "black" : "white") + " wins.");
                break;
            }
           if ( board.isInCheck(currentPlayer.equals("black") ? "black" : "white")){
                System.out.println("King in check!");
            }
            System.out.println(currentPlayer + "'s turn. Enter move (e.g., 'E2 E4'):");
            
            String move = scanner.nextLine().toUpperCase();
            String[] moveParts = move.split(" ");
            if (moveParts.length != 2) {
                System.out.println("Invalid move format. Please enter in the form 'E2 E4'.");
                continue;
            }
        

            // Now calculates startY, startX, endY, endX and using the converted uppercase letters
            int startX = 8 - Character.getNumericValue(moveParts[0].charAt(1)); // 1-8 -> 7-0
            int startY = moveParts[0].charAt(0) - 'A'; // A-H -> 0-7
            int endX = 8 - Character.getNumericValue(moveParts[1].charAt(1));   // 1-8 -> 7-0
            int endY = moveParts[1].charAt(0) - 'A';   // A-H -> 0-7
        //

            // if valid move alternates the turn; changes the current player
            if (board.movePiece(startX, startY, endX, endY, currentPlayer)) {
                currentPlayer = currentPlayer.equals("white") ? "black" : "white";
            } 
	       else {System.out.println("Invalid move. Try again.");}
        }

        // win message
        System.out.println((currentPlayer.equals("white") ? "black" : "white") + "wins.");       
    
        scanner.close();
    }
