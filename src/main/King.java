package main;
/*
 * (X + 1, Y + 1), (X + 1, Y - 1), (X - 1, Y + 1), (X - 1, Y - 1),
(X + 1, Y), (X - 1, Y), (X, Y + 1), (X, Y - 1)
 * */
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class King extends Piece {
	private int xplus1 = this.x + 1;
	private int yplus1 = this.y + 1;
	private int xminus1 = this.x - 1;
	private int yminus1 = this.y - 1;
	public King(String color) {
		super(color);
		if(color == "white"){
			this.icon = new ImageIcon(getClass().getResource("Images/white_king.png"));
		}
		else{
			this.icon = new ImageIcon(getClass().getResource("Images/black_king.png"));
		}
	}
	public boolean calculateValidity(int i,int j){
		if(this.sameColor(ChessBoard.buttons[i][j].getPiece())){
			return false;
		}
		else{
			if(i == this.x || i == this.x + 1 || i == this.x-1){
				if(j == this.y || j == this.y-1 || j == this.y+1){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		
		
		
		}
	}
}
