package main;
import javax.swing.*;
/*
 * This is the primary class in terms of the basic functionality and the characteristics of the chessboard.
 * It sets up the whole board with Square objects and puts piece in the relevant postions.
 * */
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ChessBoard extends JFrame implements MouseListener {
	private static boolean turnflag = true;
	private JPanel chessboard = new JPanel();  
	private JPanel sidepanel = new JPanel();
	private static Square temp = null;									//the temporary Square object is used for the transition of the piece from one chessboard square to another.
	public static Square[][] buttons = new Square[8][8]; 				//the data structure is made public as all the pieces would move as per the state of the chessboard.
	private JButton hint = new JButton("hint");
	private JLabel turn = new JLabel("white");
	
	public ChessBoard(){
		Container contentpane = getContentPane();
		
		contentpane.setLayout(new BorderLayout());
		contentpane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentpane.add(chessboard,BorderLayout.CENTER);
		contentpane.add(sidepanel,BorderLayout.EAST);
		
		turn.setSize(50,50);
		
		sidepanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,350));
		sidepanel.add(hint);
		sidepanel.add(turn);
		
		chessboard.setLayout(new GridLayout(0,8));
		
		setSquares();		
		setWhitePieces();
		setBlackPieces();
		setBoard();
		
		hint.addMouseListener(new Hint());			// the mouse listener of a whole another class has to be added to the hint button due to
													//the clear seperation of concerns in the basic functionality and the hints.
		
		setSize(500,500);
		setVisible(true);
	}
	
	
	public void setBoard(){
		for(int i = 7; i>=0 ; i--){
			for(int j = 7 ; j>=0 ; j--){
				chessboard.add(buttons[i][j]);
			}
		}
	}
	
	
	public void setSquares(){
		for(int i = 7; i >= 0; i--){
			for(int j = 7; j >= 0; j--){
				if(i % 2 == 0){
					if(j%2 == 0){
						buttons[i][j] = new Square(i, j, Color.WHITE);
						buttons[i][j].addMouseListener(this);
					}
					else{
						buttons[i][j] = new Square(i, j, Color.GREEN);
						buttons[i][j].addMouseListener(this);
					}
				}
				else{
					if(j%2 == 0){
						buttons[i][j] = new Square(i, j, Color.GREEN);
						buttons[i][j].addMouseListener(this);
					}
					else{
						buttons[i][j] = new Square(i, j, Color.WHITE);
						buttons[i][j].addMouseListener(this);
					}
				}
			}
		}

	}
	public void setWhitePieces(){
		
		buttons[0][2].setPiece(new Bishop("white"),0,2);
		buttons[0][5].setPiece(new Bishop("white"),0,5);
		buttons[0][0].setPiece(new Rook("white"),0,0);
		buttons[0][7].setPiece(new Rook("white"),0,7);
		buttons[0][1].setPiece(new Knight("white"),0,1);
		buttons[0][6].setPiece(new Knight("white"),0,6);
		buttons[0][3].setPiece(new King("white"),0,3);
		buttons[0][4].setPiece(new Queen("white"),0,4);
		
		for(int i = 0;i<8;i++){
		
			buttons[1][i].setPiece(new Pawn("white"),1,i);
		
		}
	}
	public void setBlackPieces(){
		
		buttons[7][2].setPiece(new Bishop("black"),7,2);
		buttons[7][5].setPiece(new Bishop("black"),7,5);
		buttons[7][0].setPiece(new Rook("black"),7,0);
		buttons[7][7].setPiece(new Rook("black"),7,7);
		buttons[7][1].setPiece(new Knight("black"),7,1);
		buttons[7][6].setPiece(new Knight("black"),7,6);
		buttons[7][3].setPiece(new King("black"),7,3);
		buttons[7][4].setPiece(new Queen("black"),7,4);
		
		for(int i = 0;i<8;i++){
			
			buttons[6][i].setPiece(new Pawn("black"),6,i);
		
		}
	}
		
	public void move(Square prev, Square next){
		if(prev!=next && prev.canMove(next)){				//the method which is concerned with the movement of the pieces; it first checks if a piece can
															//move to the desired square from its current one.
			prev.movePiece(next);
			changeTurn();
		}
	}
	public void changeTurn(){							//sets the text for the turn indicator of the GUI.
		if(turnflag){
			turnflag = false;
			turn.setText("black");
		}
		else{
			turnflag = true;
			turn.setText("white");
		}
	}
	public void possibleMoves(Square sq){
		if(sq.hasPiece()){										//highlights all the possible moves for a piece on-click.
			for(int i = 0; i < 8 ; i++){
				for(int j = 0; j < 8 ; j++){
					if(sq.canMove(buttons[i][j])){
						buttons[i][j].changeColor();
					}
				}
			}
			
		}
	}
	public void backToNormal(){								// changes the color of the highlighted squares back to the original.
		for(int i = 0; i < 8 ; i++){
			for(int j = 0; j < 8 ; j++){
				buttons[i][j].backToOriginal();
			}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e){								// all the squares send their events to this method. The first clicked square is assigned to the Square temp. 
		// TODO Auto-generated method stub
		Square sq =(Square)e.getComponent();
		
		if(temp == null){
			if(sq.hasPiece()){
				temp = sq;
				possibleMoves(temp);
			}
		}
		else{
				if(turnflag){
					if(temp.getPiece().getColor().equals("white")){
						move(temp,sq);
					}
					
				}
				else{
					if(temp.getPiece().getColor().equals("black")){
						move(temp,sq);
						
					}
				}
				temp = null;
				backToNormal();
			}
}
	
	public static boolean getTurn(){
		return turnflag;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


