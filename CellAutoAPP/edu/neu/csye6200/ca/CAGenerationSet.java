package edu.neu.csye6200.ca;

import java.util.ArrayList;

/**
 * Create generation set: this file can produce two different sets according to different rules
 * @author JIANAN WEN
 * @id 001678266
 *
 */
public class CAGenerationSet {
	
	private ArrayList<CAGeneration> generationSet = new ArrayList<CAGeneration>();

	private int ruleNum=1;       //used to decide which rule will be used    1: cellRule1    2:cellRule2
	private int setLength = 100;  //used to decide the length of the whole set
	
	
	//constructor
	public CAGenerationSet(int ruleNum, int setLength){
		this.ruleNum = ruleNum;
		this.setLength = setLength;
		createSet();
	}
	
	
	public void createSet() {
		
		CAGeneration previousGeneration = new CAGeneration();
		generationSet.add(previousGeneration);
		
		
		for(int i=0;i<setLength;i++){
			
			CAGeneration nextGeneration = createNextGeneration(previousGeneration, ruleNum);
			generationSet.add(nextGeneration);
			previousGeneration = nextGeneration;
		}
			
	}
		
		
	//create next generation and add it into generationSet	and return the next generation
	public CAGeneration createNextGeneration(CAGeneration cag, int k){
		

		CAGeneration previousGeneration = cag;
		CAGeneration nextGeneration;
			
		nextGeneration = CARule.rule(previousGeneration,k);
		
		return nextGeneration;
		
	}
	
	
	
	//display the whole generation set
	public void show(){
		
		for(int j=0;j<generationSet.size();j++){
			
			for(int i=0;i<generationSet.get(j).getGenerationLength();i++){
				System.out.print(generationSet.get(j).getGeneration().get(i).getState() + " ");
			}
			System.out.println("");
		}
			
	}
	
	
	//get generation set
	public ArrayList<CAGeneration> getSet(){
		return generationSet;
	}




	
	

}
