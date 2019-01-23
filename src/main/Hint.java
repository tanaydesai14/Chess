package main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
 * This class handles the part 2 of the assignment. 
 * It is added as the mouselistener to the button hint in the sidepanel of the main GUI.
 */
public class Hint implements MouseListener {
	private String color;
	private ArrayList<HintThread> threadlist = new ArrayList<HintThread>();	//this is a list of all the threads created at each instance of the click on hint.
	private ArrayList<HintThread> finallist  = new ArrayList<HintThread>();	//this list of all the Squares which can move freely in the threadlist.
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(ChessBoard.getTurn())
			this.color = "white";
		else
			this.color = "black";
		for(int i = 0; i < 8 ; i++){		//a thread is created for each of the squares
			for(int j = 0; j < 8; j++){
			if(ChessBoard.buttons[i][j].hasPiece()){
				if(ChessBoard.getTurn()){
					if(ChessBoard.buttons[i][j].getPiece().getColor() == "white"){
						threadlist.add(new HintThread(ChessBoard.buttons[i][j]));
					}
				}
				else{
					if(ChessBoard.buttons[i][j].getPiece().getColor() == "black"){
						threadlist.add(new HintThread(ChessBoard.buttons[i][j]));
					}
				}
			
			}
			}
		}
		for(HintThread h : threadlist){
			h.start();
		}
		for(HintThread h : threadlist){
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(HintThread th : threadlist){
			if(th.hasbest)
				finallist.add(th);
		}
		
		Collections.sort(finallist,new ThreadComparator(color));
		System.out.println("Best move :  "+finallist.get(0).square.getXaxis()+" "+finallist.get(0).square.getYaxis()+"  "+finallist.get(0).bestmove.getXaxis()+" "+finallist.get(0).bestmove.getYaxis());
		ChessBoard.buttons[finallist.get(0).square.getXaxis()][finallist.get(0).square.getYaxis()].setBackground(Color.RED); //this is where the two participating squares of the best possible move are being
		ChessBoard.buttons[finallist.get(0).bestmove.getXaxis()][finallist.get(0).bestmove.getYaxis()].setBackground(Color.RED);//highlighted on the board.
		for(HintThread th : threadlist){
			th.square.flushList();
		}									//we have to flush the list for the next iteration
		threadlist.removeAll(threadlist);
		finallist.removeAll(finallist);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
