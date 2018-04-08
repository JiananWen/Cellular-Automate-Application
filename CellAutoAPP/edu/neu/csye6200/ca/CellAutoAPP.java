package edu.neu.csye6200.ca;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * Main class for the CellAutoAPP application
 * @author JIANAN WEN
 * @id 001678266
 *
 */

public class CellAutoAPP extends CAAPP {
	
	
	private static Logger log = Logger.getLogger(CACavans.class.getName());
	
	private Thread cavasThread;
	
	//control stop and pause loop
	static boolean stopControl = true;
	static boolean pauseControl = true;
	
	private String[] rule = {"rule1", "rule2", "rule3"};

	
	//constructor
	public CellAutoAPP(){
		log.info("APP Started!");
		initGUI();	
	}
	
	//create frame
	public void initGUI(){
		frame = new JFrame();
		
		frame.setSize(1269, 600);
		frame.setTitle("Cellular Automate");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout());
		frame.add(getContentPanel(), BorderLayout.WEST);

		cavans = new CACavans();
		cavans.setPreferredSize(new Dimension(1200,10000));
		
		jsp = new JScrollPane();
		
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		jsp.setViewportView(cavans);
		
		frame.add(jsp, BorderLayout.CENTER);
		
		frame.setVisible(true);

	}
	
	
	//get the content panel 
	@Override
	public JPanel getContentPanel(){
		contentPanel = new JPanel();
		
		contentFill = new JPanel();
		contentFill.setBackground(Color.gray);
		
		GridBagLayout layout = new GridBagLayout();
		contentPanel.setLayout(layout);
		contentPanel.setBackground(Color.gray);
		
		
		startBtn = new JButton("Start");		
		 startBtn.addActionListener(this);
		
		stopBtn = new JButton("Stop");
		 stopBtn.addActionListener(this);
		 
		pauseBtn = new JButton("Pause");
		 pauseBtn.addActionListener(this);
		
		resumeBtn = new JButton("Resume");
		 resumeBtn.addActionListener(this);
		 
		
		ruleBox = new JComboBox<String>(rule);
		ruleBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(ruleBox.getSelectedItem() == "rule1"){
					cavans.ruleNum = 1;
					log.info("Rule1 was choosed");
				}
				
				if(ruleBox.getSelectedItem() == "rule2"){
					cavans.ruleNum = 2;
					log.info("Rule2 was choosed");
				}
				
				if(ruleBox.getSelectedItem() == "rule3"){
					cavans.ruleNum = 3;
					log.info("Rule3 was choosed");
				}
				
			}
		});
		

		numInform = new JLabel("Num of Generations:");
		numText = new JTextField(2);
		numText.setActionCommand("Num");
		numText.addActionListener(this);
		
		contentPanel.add(startBtn);
		contentPanel.add(stopBtn);
		contentPanel.add(pauseBtn);
		contentPanel.add(resumeBtn);
		contentPanel.add(ruleBox);
		contentPanel.add(numInform);
		contentPanel.add(numText);
		contentPanel.add(contentFill);
		
		contentPanel.setBackground(Color.gray);
		
		GridBagConstraints s= new GridBagConstraints();     // set the location of buttons and text area
		s.fill = GridBagConstraints.BOTH;
		
		
		s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(startBtn, s);
        

        s.gridwidth = 0;
        s.weightx = 0;
        s.weighty = 0;
        layout.setConstraints(stopBtn, s);
        
        s.gridwidth = 0;
        s.weightx = 0;
        s.weighty = 0;
        layout.setConstraints(pauseBtn, s);
        
        s.gridwidth = 0;
        s.weightx = 0;
        s.weighty = 0;
        layout.setConstraints(resumeBtn, s);
        
        s.gridwidth = 0;
        s.weightx = 0;
        s.weighty = 0;
        layout.setConstraints(ruleBox, s);
        
        s.gridwidth = 1;
        s.weightx = 0;
        s.weighty = 0;
        layout.setConstraints(numInform, s);
        
        s.gridwidth = 0;
        s.weightx = 0;
        s.weighty = 0;
        layout.setConstraints(numText, s);
        
        s.gridheight = 5;
        s.gridwidth=0;
        s.weighty = 1;
        layout.setConstraints(contentFill, s);
		
		
		return contentPanel;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("we receive an ActionEvent: " +e);
		
		if(e.getActionCommand().equalsIgnoreCase("Start")){
			log.info("Start Button was pressed");
			
			if(stopControl == false){
				stopControl = true;
			}
			
			if(pauseControl == false){
				pauseControl = true;
			}
			
			cavasThread = new Thread(cavans);
			cavans.showSetLength = 0;
			
			cavasThread.start();
				
		}
		
		if(e.getSource()==stopBtn){
			log.info("Stop Button was pressed");
			stopControl = false;

		}
		
		if(e.getSource()==pauseBtn){
			log.info("Pause Button was pressed");
			pauseControl = false;
			
		}
		
		if(e.getSource()==resumeBtn){
			log.info("Resume Button was pressed");
			
			cavasThread = new Thread(cavans);
			if(pauseControl == false) pauseControl = true;
			cavasThread.start();
			
		}
		
		if(e.getActionCommand().equals("Num")){
			log.info("Number of Generations has inputed");
			cavans.numSet = Integer.parseInt(numText.getText()) - 1;
							
		}
		
	}
	

	@Override
	public void windowOpened(WindowEvent e) {
		log.info("Window opened");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		log.info("Window iconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		log.info("Window deiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		log.info("Window activated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		log.info("Window deactivated");
		
	}
	
	/*
	 * CellAutoApp application starting point
	 */
	public static void main(String[] args){
		
		CellAutoAPP caapp = new CellAutoAPP();	
		log.info("CellAutoAPP started");
		System.out.println(caapp);
		
	}

	
}
