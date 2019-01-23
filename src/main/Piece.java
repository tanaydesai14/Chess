package main;
import java.awt.*;
/*This is an abstract class which is to be inherited by all the pieces on the chessboard. A Piece would have its own coord, icon and color.
 * 
 * */
import javax.swing.*;
public abstract class Piece {
	protected int x,y;
	protected Icon icon;
	protected String color;
	public Piece(String color){
		this.color = color;
	}
	public Piece(Piece p){
		this.icon = p.icon;
		this.color = p.color;
	}
	public Icon getIcon(){
		return this.icon;
	}
	
	public void setCoords(int x,int y){
		this.x = x;
		this.y = y;
	}
	public boolean sameColor(Piece piece){
		if(piece == null){
			return false;
		}
		else{
			if(this.color.equals(piece.color)){
				return true;
			}
			else{
				return false;
			}
		}
	}
	public boolean calculateValidity(int i,int j){				//this method would calculate whether it is valid to move to a certain square for THIS Piece.
		return false;											//It communicates with the canMove method of the class Square.
	}
	public String getColor(){
		return this.color;
	}
	
	

	}

