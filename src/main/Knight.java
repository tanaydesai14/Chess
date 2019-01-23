package main;
/*
 * (X + 2, Y + 1), (X + 2, Y - 1), (X - 2, Y + 1), (X - 2, Y - 1),
(X + 1, Y + 2), (X + 1, Y - 2), (X - 1, Y + 2), (X - 1, Y - 2)
 * */
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Knight extends Piece {

	public Knight(String color) {
		super(color);
		if(color == "white"){
			this.icon = new ImageIcon(getClass().getResource("Images/white_knight.png"));
		}
		else{
			this.icon = new ImageIcon(getClass().getResource("Images/black_knight.png"));
		}
		
	}

	public boolean calculateValidity(int i,int j){
		if(this.sameColor(ChessBoard.buttons[i][j].getPiece())){
			return false;
		}
		else{
			if(i == this.x + 2 || i == this.x - 2){
				if(j == this.y + 1 || j == this.y - 1){
					return true;
				}
			}
			else if(i == this.x + 1 || i == this.x - 1){
				if(j == this.y + 2 || j == this.y - 2){
					return true;
				}
			}
		return false;
		}
	}
}
