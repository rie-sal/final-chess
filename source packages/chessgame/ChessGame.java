package chessgame;


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

/**
 * Main class for the Chess Game, displaying a chessboard and enabling basic piece interaction.
 * The board uses an 8x8 grid, and each piece can be selected and moved by clicking or dragging.
 */

public class ChessGame {
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

        // Mouse listener for selecting and moving pieces
        frame.add(pn);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece!=null){
                    selectedPiece.xPixelPos=e.getX()-32;
                    selectedPiece.yPixelPos=e.getY()-32;
                    frame.repaint();
                }
            }
            //Changes mouse icon when hovering over a piece
            @Override
            public void mouseMoved(MouseEvent e) {
                Piece pieceAt = getPieceAt(e.getX(), e.getY(), pieceList);
                if (pieceAt != null) {
                    frame.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
                } else {
                    frame.setCursor(java.awt.Cursor.getDefaultCursor());
                }
            }
        });

        
        //Checks for click
        frame.addMouseListener(new MouseListener() {
            boolean click = false;
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            
            //Selects piece that the user clicks with their mouse
            @Override
            public void mousePressed(MouseEvent e) {
            // System.out.println((getPieceAt(e.getX(), e.getY(), pieceList).isWhite?"white ":"balck ")+getPieceAt(e.getX(), e.getY(), pieceList).pieceType);
                if (!click){ 
                    selectedPiece=getPieceAt(e.getX(), e.getY(), pieceList);
                }
                
            }
            //Checks the position of a piece after the mouse is released and checks to see if both kings are still present in order to determine if the game is over or not
            @Override
            public void mouseReleased(MouseEvent e) {
                    
                    if (selectedPiece.xPos == e.getX()/64 && selectedPiece.yPos == e.getY()/64 && click == false){
                        click = true;
                    }
                    else if (click){
                        click = false;
                    }
                    selectedPiece.move(e.getX()/64, e.getY()/64);
                    frame.repaint();
                    

                    boolean[] kingsPresent = {false, false};
                    for (Piece p: pieceList){
                        if (p.pieceType.equals("king")){
                            kingsPresent[p.isWhite ? 0 : 1 ] = true;
                        }
                    }
                    if (!kingsPresent[0]){displayPopup("black");}
                    else if(!kingsPresent[1]){displayPopup("white");}

                    if (!click){
                        selectedPiece = null;
                    }        
            }


            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        frame.add(pn);
        frame.setSize(512, 512);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
}
