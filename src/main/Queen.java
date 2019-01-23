package main;
/*
 * In XY Coordinates:
(X + n, Y + n), (X + n, Y - n), (X - n, Y + n), (X - n, Y - n),
(X + n, Y), (X - n, Y), (X, Y + n), (X, Y - n), where n is any positive integer ≠ 0
 * */
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Queen extends Piece {
	private Bishop bishop = new Bishop(this.color);
	private Rook rook = new Rook(this.color);
	public Queen(String color) {
		super(color);
		if(color == "white"){
			this.icon = new ImageIcon(getClass().getResource("Images/white_queen.png"));
		}
		else{
			this.icon = new ImageIcon(getClass().getResource("Images/black_queen.png"));
		}
	}
	public boolean calculateValidity(int i,int j){
			return (RookMoves(i, j) || BishopMoves(i, j));
			}
	

	public boolean BishopMoves(int i,int j){
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

	public boolean RookMoves(int i,int j){
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
