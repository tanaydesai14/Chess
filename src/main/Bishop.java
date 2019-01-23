package main;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/*
 * In XY Coordinates:
(X + n, Y + n), (X + n, Y - n), (X - n, Y + n), (X - n, Y - n), where n is any positive integer ≠ 0
 * */
public class Bishop extends Piece {

	public Bishop(String color) {
		super(color);
		if(color == "white"){
			this.icon = new ImageIcon(getClass().getResource("Images/white_bishop.png"));
		}
		else{
			this.icon = new ImageIcon(getClass().getResource("Images/black_bishop.png"));
		}
	}
	
	public boolean calculateValidity(int i,int j){
		if(this.sameColor(ChessBoard.buttons[i][j].getPiece())){
			return false;
		}
		else{
			if((this.x + this.y == i + j) || (this.x - this.y == i - j)){
				if(this.x > i){
					int ii = this.x - 1;
					if(this.y > j){
							int jj = this.y - 1;
							while(ii > i || jj > j){
								if(ChessBoard.buttons[ii][jj].hasPiece())
									return false;
								ii--;
								jj--;
						}
					}
					else{
						int jj = this.y + 1;
						while(ii > i || jj < j){
							if(ChessBoard.buttons[ii][jj].hasPiece())
								return false;
							ii--;
							jj++;
					}
					}
				}
				else{
					int ii = this.x + 1;
					if(this.y > j){
						int jj = this.y - 1;
						while(ii < i || jj > j){
							if(ChessBoard.buttons[ii][jj].hasPiece())
								return false;
							ii++;
							jj--;
					}
					}
					else{
						int jj = this.y + 1;
						while(ii < i || jj < j){
							if(ChessBoard.buttons[ii][jj].hasPiece())
								return false;
							ii++;
							jj++;
					}
					}
				}
				return true;
			}
			else{
				return false;
			}
		
		}
}

}