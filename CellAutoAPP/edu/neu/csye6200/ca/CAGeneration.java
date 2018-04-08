package edu.neu.csye6200.ca;

import java.util.ArrayList;

/**
 * Create first generation and define the format of every generation
 * @author JIANAN WEN
 * @id 001678266
 *
 */
public class CAGeneration {
	
	private ArrayList<CACell> generation = new ArrayList<CACell>();
	private int generation_length = 121;
	private int generation_middle = (generation_length - 1)/2;
	
	//constructor
	public CAGeneration(){
		createFirstGeneration();
	}
	
	//constructor
	public CAGeneration(ArrayList<CACell> generation){
		this.generation = generation;
		
	}
	
	//create first generation: the middle is 1 others is 0
	private void createFirstGeneration(){
		for(int i=0;i<generation_length;i++){
			
			if(i == generation_middle){
				generation.add(new CACell(1.0));
			}else{
				generation.add(new CACell(0.0));
			}
		}
		
	}
	
	
	//get generation
	public ArrayList<CACell> getGeneration(){
		return generation;
	}
	
	
	//get the length of the generation
	public int getGenerationLength(){
		return generation_length;
	}
	
	//display generation
	public  void print(){
		for(int i =0;i<generation.size();i++){
			System.out.print(generation.get(i).getState() + " ");
		}
		System.out.println("");
	}
	

}
