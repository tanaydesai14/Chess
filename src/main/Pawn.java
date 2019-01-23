package main;
import java.awt.*;
import javax.swing.*;

public class Pawn extends Piece {
	private boolean firststep;
	private int firstx;
	private int firsty;
	private boolean firstflag = true;

	public Pawn(String color) {
		super(color);
		if(color == "white"){
			this.icon = new ImageIcon(getClass().getResource("Images/white_pawn.png"));
		}
		else{
			this.icon = new ImageIcon(getClass().getResource("Images/black_pawn.png"));
		}
		this.firststep = true;
	}
	public void setCoords(int i,int j){
		this.x = i;
		this.y = j;
		if(firstflag){
			this.firstx = i;
			this.firsty = j;
			firstflag = false;
		}
	}
	public boolean calculateValidity(int i,int j){
		if(this.sameColor(ChessBoard.buttons[i][j].getPiece())){
			return false;
		}
		else{
			if(this.x == this.firstx && this.y == this.firsty){
				if(this.color.equals("white")){
					if((i == this.x + 1) && (j == this.y + 1 || j == this.y - 1)){
						if(ChessBoard.buttons[i][j].hasPiece()){
							return true;
						}
						else{
							return false;
						}
					}
					else if(((i == this.x+1 && j==this.y) || ((i == this.x+2 && j==this.y))) && !ChessBoard.buttons[i][j].hasPiece()){
						return true;
					}
					else{
						return false;
					}
				
				}
				else{
					if((i == this.x - 1) && (j == this.y + 1 || j == this.y - 1)){
						if(ChessBoard.buttons[i][j].hasPiece()){
							return true;
						}
						else{
							return false;
						}
					}
					else if(((i == this.x-1 && j==this.y) || ((i == this.x-2 && j==this.y))) && !ChessBoard.buttons[i][j].hasPiece()){
						return true;
					}
					else{
						return false;
					}
				
				
				}
		
			}
			else{
				if(this.color.equals("white")){
					if((i == this.x + 1) && (j == this.y + 1 || j == this.y - 1)){
						if(ChessBoard.buttons[i][j].hasPiece()){
							return true;
						}
						else{
							return false;
						}
					}
					else if(((i == this.x+1 && j==this.y)) && !ChessBoard.buttons[i][j].hasPiece()){
						return true;
					}
					else{
						return false;
					}
				
				}
				else{
					if((i == this.x - 1) && (j == this.y + 1 || j == this.y - 1)){
						if(ChessBoard.buttons[i][j].hasPiece()){
							return true;
						}
						else{
							return false;
						}
					}
					else if(((i == this.x-1 && j==this.y)) && !ChessBoard.buttons[i][j].hasPiece()){
						return true;
					}
					else{
						return false;
					}
				
				
				}
		
			
			
		}
	

	}
	}
}
 