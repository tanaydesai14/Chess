package main;

import java.util.HashMap;
/*this is the thread class which calculates best possible move for each piece and 
 * provides it to the Hint container. Square corresponds to the current and bestmove corresponds to 
 * the desired square.
 * */
public class HintThread extends Thread {
	Square square;
	Square bestmove = null;
	boolean hasbest = false;
	public HintThread(Square square){
		this.square = square;
	}
	
	public void run() {
		this.square.calculateMove();
		if(this.square.Movable()){
			this.bestmove = this.square.getBestMove();
			this.hasbest = true;
		}
		
	}

}
