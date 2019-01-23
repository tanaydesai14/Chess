package main;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
/*This is the comparator for selecting the best possible move a side can make at each instance.
 *
 * The method correspond to the guidelines as below:
 * compare(): First condition
 * WhiteSecond, WhiteThird, WhiteFourth, WhiteFifth : conditions for white pieces
 * BlackSecond, BlackThird, BlackFourth, WhiteFifth : conditions for black pieces
 * */
public class ThreadComparator implements Comparator<HintThread> {
private String color;
	public ThreadComparator(String color){
		this.color = color;
	}
	
	
	@Override
	public int compare(HintThread one, HintThread two){
		if((one.bestmove.hasPiece() && two.bestmove.hasPiece()) || (!one.bestmove.hasPiece() && !two.bestmove.hasPiece())){
			if(color == "white"){
				return WhiteSecond(one,two);
			}
			else{
				return BlackSecond(one,two);
			}
		}
		else if(one.bestmove.hasPiece() && !two.bestmove.hasPiece()){
			return -1;
		}
		else if(!one.bestmove.hasPiece() && two.bestmove.hasPiece()){
			return 1;
		}
		else{
			return 0;
		}
	
	}
	public int WhiteSecond(HintThread one, HintThread two){
		if(one.bestmove.getYaxis() == two.bestmove.getYaxis()){
			return WhiteThird(one,two);
		}
		else if(one.bestmove.getYaxis() < two.bestmove.getYaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	public int BlackSecond(HintThread one, HintThread two){
		if(one.bestmove.getYaxis() == two.bestmove.getYaxis()){
			return BlackThird(one,two);
		}
		else if(one.bestmove.getYaxis() > two.bestmove.getYaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	public int WhiteThird(HintThread one, HintThread two){
		if(one.bestmove.getXaxis() == two.bestmove.getXaxis()){
			return WhiteFourth(one,two);
		}
		else if(one.bestmove.getXaxis() > two.bestmove.getXaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	public int BlackThird(HintThread one, HintThread two){
		if(one.bestmove.getXaxis() == two.bestmove.getXaxis()){
			return BlackFourth(one,two);
		}
		else if(one.bestmove.getXaxis() < two.bestmove.getXaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	public int WhiteFourth(HintThread one, HintThread two){
		if(one.square.getYaxis() == two.square.getYaxis()){
			return WhiteFifth(one,two);
		}
		else if(one.square.getYaxis() > two.square.getYaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	
	public int BlackFourth(HintThread one, HintThread two){
		if(one.square.getYaxis() == two.square.getYaxis()){
			return BlackFifth(one,two);
		}
		else if(one.square.getYaxis() < two.square.getYaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	public int WhiteFifth(HintThread one, HintThread two){
		if(one.square.getXaxis() == two.square.getYaxis()){
			return 0;
		}
		else if(one.square.getXaxis() < two.square.getXaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
	public int BlackFifth(HintThread one, HintThread two){
		if(one.square.getXaxis() == two.square.getYaxis()){
			return 0;
		}
		else if(one.square.getXaxis() > two.square.getXaxis()){
			return -1;
		}
		else{
			return 1;
		}
	}
//**************************************************************************************************************************************************
	
	@Override
	public Comparator<HintThread> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<HintThread> thenComparing(
			Comparator<? super HintThread> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<HintThread> thenComparing(
			Function<? super HintThread, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<HintThread> thenComparing(
			Function<? super HintThread, ? extends U> arg0,
			Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<HintThread> thenComparingDouble(
			ToDoubleFunction<? super HintThread> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<HintThread> thenComparingInt(
			ToIntFunction<? super HintThread> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<HintThread> thenComparingLong(
			ToLongFunction<? super HintThread> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}


