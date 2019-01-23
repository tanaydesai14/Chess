package main;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
/*
 * This comparator is for first selecting the best possible move for all the pieces of one side. It works with
 * the first three conditions given in the guidelines.
 * */
public class MoveComparator<T> implements Comparator<Square> {
	private String color;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public MoveComparator(String color){
		this.color = color;
	}
	@Override
	public int compare(Square one, Square two) {
		
		if ((one.hasPiece() && two.hasPiece()) ||(!one.hasPiece() && !two.hasPiece())){
			
			if(color == "white"){
			
				return WhiteThird(one,two);
			
			}
			
			else{
				
				return BlackThird(one,two);
			
			}
		
		}
	
		else if(one.hasPiece() && !two.hasPiece()){
			
			return -1;
		
		}
		
		else{
		
			return 1;
		
		}
		
	}
	public int WhiteSecond(Square one,Square two){
		
		if(one.getXaxis() == two.getXaxis()){
		
			return 0;
		
		}
		
		else if(one.getXaxis() > two.getXaxis()){
		
			return -1;
		
		}
		
		else{
		
			return 1;
		
		}
	}
	public int WhiteThird(Square one, Square two){
		
		if(one.getYaxis() == two.getYaxis()){
		
			return WhiteSecond(one,two);
		
		}
		
		else if(one.getYaxis() < two.getYaxis()){
		
			return -1;
		
		}
		
		else{
		
			return 1;
		}
	}
	public int BlackSecond(Square one, Square two){
		
		if(one.getXaxis() == two.getXaxis()){
		
			return 0;
		
		}
		
		else if(one.getXaxis() < two.getXaxis()){
		
			return -1;
		
		}
		
		else{
		
			return 1;
		
		}
	}
	
	
	public int BlackThird(Square one, Square two){
		
		if(one.getYaxis() == two.getYaxis()){
		
			return BlackSecond(one,two);
		
		}
		
		else if(one.getYaxis() > two.getYaxis()){
		
			return -1;
		
		}
		
		else{
		
			return 1;
		
		}
	}

	@Override
	public Comparator<Square> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Square> thenComparing(Comparator<? super Square> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<Square> thenComparing(
			Function<? super Square, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<Square> thenComparing(
			Function<? super Square, ? extends U> arg0,
			Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Square> thenComparingDouble(
			ToDoubleFunction<? super Square> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Square> thenComparingInt(
			ToIntFunction<? super Square> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<Square> thenComparingLong(
			ToLongFunction<? super Square> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
