package edu.neu.csye6200.ca;

import java.math.BigDecimal;

import java.util.ArrayList;

/**
 * Define the 2 generation rules
 * @author JIANAN WEN
 * @id 001678266
 *
 */
public class CARule {
	
	
	
	//constructor
	public CARule(){
		
	}
	
	public static CAGeneration rule(CAGeneration cag, int k){      //k was used to decide which rule will be used to create next generation
		
		//get the previous generation
		ArrayList<CACell> previousGeneration = cag.getGeneration();
		ArrayList<CACell> nextGeneration = new ArrayList<CACell>();
		
		
		//get the lengh of previous length
		int previousLength = previousGeneration.size();
		
		for(int i=0;i<previousLength;i++){
			
			//when i=0, on the left edge, the next value equals to i=65,0,1
			if(i == 0){
				double left = previousGeneration.get(previousLength-1).getState();
				double middle = previousGeneration.get(i).getState();
				double right = previousGeneration.get(i+1).getState();
				
				if(k==1){
					nextGeneration.add(cellRule1(left, middle, right));	
				}
				
				if(k==2){
					nextGeneration.add(cellRule2(left, middle, right));	
				}
				
				if(k==3){
					nextGeneration.add(cellRule2(left, middle, right));	
				}
				
				
				
				
			}
			
			//when i=64, on the left edge, the next value equals to i=63,64,0
			if(i==previousLength-1){
				double left = previousGeneration.get(i-1).getState();
				double middle = previousGeneration.get(i).getState();
				double right = previousGeneration.get(0).getState();
				
				if(k==1){
					nextGeneration.add(cellRule1(left, middle, right));	
				}
				
				if(k==2){
					nextGeneration.add(cellRule2(left, middle, right));	
				}
				
				if(k==3){
					nextGeneration.add(cellRule2(left, middle, right));	
				}
				
			}
			
			//when the value of i is from 1 to 63
			if(i>0&&i<previousLength-1){
				double left = previousGeneration.get(i-1).getState();
				double middle = previousGeneration.get(i).getState();
				double right = previousGeneration.get(i+1).getState();
				
				if(k==1){
					nextGeneration.add(cellRule1(left, middle, right));	
				}
				
				if(k==2){
					nextGeneration.add(cellRule2(left, middle, right));	
				}
				
				if(k==3){
					nextGeneration.add(cellRule2(left, middle, right));	
				}
			}		
		}
		
		CAGeneration newGeneration = new CAGeneration(nextGeneration);
		
		return newGeneration;		
		
	}
	
	
	//rule1 that display two color in cavas: white and black
	private static CACell cellRule1(double left, double middle, double right){
		
		double nextState = 0.0;
		
		//next state = 0 when 0,0,0
		if(left==0.0&&middle==0.0&&right==0.0){
			nextState = 0.0;
		}
		
		//next state = 1 when 0,0,1
		if(left==0.0&&middle==0.0&&right==1.0){
			nextState = 1.0;
		}
		
		//next state = 0 when 0,1,0
		if(left==0.0&&middle==1.0&&right==0.0){
			nextState = 0.0;
		}
		
		//next state = 0 when 0,1,1
		if(left==0.0&&middle==1.0&&right==1.0){
			nextState = 0.0;
		}
		
		//next state = 1 when 1,0,0
		if(left==1.0&&middle==0.0&&right==0.0){
			nextState = 1.0;
		}
		
		//next state = 0 when 1,0,1
		if(left==1.0&&middle==0.0&&right==1.0){
			nextState = 0.0;
		}
		
		//next state = 1 when 1,1,0
		if(left==1.0&&middle==1.0&&right==0.0){
			nextState = 1.0;
		}
		
		//next state = 0 when 1,1,1
		if(left==1.0&&middle==1.0&&right==1.0){
			nextState = 0.0;
		}
		
		CACell newCell = new CACell(nextState);
		
		return newCell;
		
	}
	
	//rule2 that display much color in canvas using continuous state rule
	//the value of state will be kept one decimal
	private static CACell cellRule2(double left, double middle, double right){
		
		
		
		double nextState = 0.0;
		
		if(((left+middle+right)/3)*1.5 > 1.0){
			nextState = ((left+middle+right)/3)*1.5 - 1.0;
		}
		
		if(((left+middle+right)/3)*1.5 < 1.0){
			nextState = ((left+middle+right)/3)*1.5;
		}
		
		if(((left+middle+right)/3)*1.5 == 1.0){
			nextState = 0.0;
		}
		
		BigDecimal b = new BigDecimal(nextState);
		double nextState1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		CACell newCell = new CACell(nextState1);
		
		return newCell;
		
		
		
	}

}
