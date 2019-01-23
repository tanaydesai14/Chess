package main;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
/*This class represents each square on the chessboard.
 * It extends JButton, and has its own color, coords, and a list of possible moves recorded for the purpose of hint.
 * 
 * */

public class Square extends JButton {
	private int x,y;
	private Piece piece;
	private Color original;
	private Square bestmove = null;
	final private Color HIGHLIGHT = Color.YELLOW;
	private ArrayList<Square> listofpossiblemoves = new ArrayList<Square>();
	public Square(int i,int j,Color color){
		this.x = i;
		this.y = j;
		this.setBackground(color);
		this.original = color;
		this.setPreferredSize(new Dimension(200,200));
		this.piece = null;
	}
	public void setPiece(Piece piece, int x,int y){
		this.piece = piece;
		this.setIcon(this.piece.getIcon());
		this.piece.setCoords(x,y);
	}
	public void removePiece(){
		this.piece = null;
		this.setIcon(null);
	}
	public void movePiece(Square sq){
			if(hasPiece()){
				sq.setPiece(this.piece,sq.x,sq.y);
				this.removePiece();
			}
	}
	public boolean hasPiece(){
		if(this.piece == null){
			return false;
		}
		else{
			return true;
		}
	}
	public void changeColor(){
		this.setBackground(HIGHLIGHT);
	}
	public void backToOriginal(){
		this.setBackground(this.original);
	}
	public void addToList(Square sq){
		this.listofpossiblemoves.add(sq);
	}
	public boolean canMove(Square sq){
		return this.piece.calculateValidity(sq.x,sq.y);			//this function checks whether the piece on THIS Square can in fact move to the desired square or not.
	}
	public void flushList(){											//flushes the list at end of each hint instance.
		this.listofpossiblemoves.removeAll(this.listofpossiblemoves);
	}
	public ArrayList<Square> getList(){
		return this.listofpossiblemoves;
	}
	public Piece getPiece(){
		return this.piece;
	}
	public int getXaxis(){
		return this.x;
	}
	public int getYaxis(){
		return this.y;
	}
	public void sortList(){																				//this method actually sets the best possible move for the piece residing on THIS square at any instant.
		if(this.Movable()){																				//which is to be sent to the main container for the selection of the best move overall.

			Collections.sort(listofpossiblemoves, new MoveComparator<>(this.getPiece().getColor()));
			this.bestmove = listofpossiblemoves.get(0);
		}
	}
	public Square getBestMove(){
		return bestmove;
	}
	public boolean Movable(){
		if(this.listofpossiblemoves.size() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	public void calculateMove(){														//generates the possible moves list.
		if(this.hasPiece()){
			for(int i = 0; i < 8 ; i++){
				for(int j = 0; j < 8 ; j++){
					if(this.canMove(ChessBoard.buttons[i][j])){
						this.addToList(ChessBoard.buttons[i][j]);
					}
				}
			}
			
		}
		sortList();
	}
	
}
