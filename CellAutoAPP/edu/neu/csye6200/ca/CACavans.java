package edu.neu.csye6200.ca;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JPanel;


/* Paint the generation set according to the generation sets
 * 
 * GenerationSet.java can produce two different generation sets, this file can
 * produce three different image with different color depending on two different sets
 * 
 * @author JIANAN WEN
 * @id 001678266
 *
 */


public class CACavans extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<CAGeneration> cavasSet = new ArrayList<CAGeneration>(); 
	
	public int showSetLength;
	
	public int numSet = 100;
	
	public int ruleNum = 1;
	
	
	//constructor
	public CACavans(){
		
	}
	

	@Override
	public void run() {
		
		cavasSet = new CAGenerationSet(ruleNum, numSet).getSet();
		
		synchronized (this) {
			
			while(CellAutoAPP.stopControl && CellAutoAPP.pauseControl){
				
					
				repaint();
				showSetLength++;
				if(showSetLength >= cavasSet.size()){
					break;			
				}
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
			
	}
	
	
	//paint the whole generation Set 
	public void paint(Graphics g){
		

		Graphics2D g2d = (Graphics2D) g;
		
		int cellSize = 8;  //the length of every cell
		int cellSize1 = 9; //the width between two cell
		
		if(ruleNum == 1 || ruleNum == 2){
			for(int j=0;j<showSetLength;j++){
				
				for(int i = 0; i< cavasSet.get(j).getGenerationLength();i++){
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.0){    
						Color color = new Color(255, 255, 255);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.1){    
						Color color = new Color(190, 255, 60);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.2){    
						Color color = new Color(240, 240, 240);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.3){    
						Color color = new Color(225, 225, 225);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.4){    
						Color color = new Color(205, 205, 205);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.5){    
						Color color = new Color(0, 0, 250);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.6){    
						Color color = new Color(175, 175, 175);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.7){    
						Color color = new Color(150, 150, 150);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.8){    
						Color color = new Color(250, 250, 0);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.9){    
						Color color = new Color(50, 50, 50);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 1.0){    
						Color color = new Color(0, 0, 0);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
				}
				
				
			}
			
		}
		
		/*
		 * ruleNum = 3, each cell will produce a random color 
		 */
		if(ruleNum == 3){
			for(int j=0;j<showSetLength;j++){
				
				for(int i = 0; i< cavasSet.get(j).getGenerationLength();i++){
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.0){    
						Color color = new Color(190, 190, 190);
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.1){    
						Color color = new Color(randomColor(0.1), randomColor(0.1), randomColor(0.1));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.2){    
						Color color = new Color(randomColor(0.2), randomColor(0.2), randomColor(0.2));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.3){    
						Color color = new Color(randomColor(0.3), randomColor(0.3), randomColor(0.3));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.4){    
						Color color = new Color(randomColor(0.4), randomColor(0.4), randomColor(0.4));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.5){    
						Color color = new Color(randomColor(0.5), randomColor(0.5), randomColor(0.5));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.6){    
						Color color = new Color(randomColor(0.6), randomColor(0.6), randomColor(0.6));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.7){    
						Color color = new Color(randomColor(0.7), randomColor(0.7), randomColor(0.7));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.8){    
						Color color = new Color(randomColor(0.8), randomColor(0.8), randomColor(0.8));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 0.9){    
						Color color = new Color(randomColor(0.9), randomColor(0.9), randomColor(0.9));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
					
					if(cavasSet.get(j).getGeneration().get(i).getState() == 1.0){    
						Color color = new Color(randomColor(1.0), randomColor(1.0), randomColor(1.0));
						paintCell(g2d,i*cellSize1,j*cellSize1,cellSize,color);
					}
					
				}
				
				
			}
		}
		
		
						
	}
	
	private void paintCell(Graphics2D g2d, int x, int y, int size, Color color){
		g2d.setColor(color);
		g2d.fillRect(x, y, size, size);
	}
	
	private int randomColor(double i){
		double randomNum = i * Math.random() * 255;
		BigDecimal b = new BigDecimal(randomNum);
		double randomColor1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		int randomColor = (int) randomColor1;
		
		return randomColor;
	}
	

	

}
