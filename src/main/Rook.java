package main;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/*
 * In XY Coordinates:
(X + n, Y), (X - n, Y), (X, Y + n), (X, Y - n), where n is any positive integer ≠ 0
 * */
public class Rook extends Piece {

	public Rook(String color) {
		super(color);
		if(color == "white"){
			this.icon = new ImageIcon(getClass().getResource("Images/white_rook.png"));
		}
		else{
			this.icon = new ImageIcon(getClass().getResource("Images/black_rook.png"));
		}
	}
	public boolean calculateValidity(int i,int j){
		if(this.sameColor(ChessBoard.buttons[i][j].getPiece())){
			return false;
		}
		else{

			if(i == this.x){
				if( j >= 0 && j < 8){
					if(this.y > j){
						for(int jj = this.y - 1; jj > j ; jj--){
							if(ChessBoard.buttons[i][jj].hasPiece()){
								return false;
							}
						}
					}
					else{
						for(int jj = this.y + 1; jj < j ; jj++){
							if(ChessBoard.buttons[i][jj].hasPiece()){
								return false;
							}
						}
					}
					return true;
				}
			}
			else if(j == this.y){
				if( i >= 0 && i < 8){
					if(this.x > i){
						for(int ii = this.x - 1; ii > i ; ii--){
							if(ChessBoard.buttons[ii][j].hasPiece()){
								return false;
							}
						}
					}
					else{
						for(int ii = this.x + 1; ii < i ; ii++){
							if(ChessBoard.buttons[ii][j].hasPiece()){
								return false;
							}
						}
					}
					return true;
				}
				
			}
			
		return false;
		
		
	}
	}
}
