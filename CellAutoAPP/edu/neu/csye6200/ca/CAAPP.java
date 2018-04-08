package edu.neu.csye6200.ca;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

/**
 * An abstract application class
 * @author JIANAN WEN
 * @id 001678266
 *
 */

public abstract class CAAPP implements ActionListener, WindowListener{
	
	
	//set the components 
	protected JFrame frame = null;
	protected JScrollPane jsp = null;
	protected CACavans cavans = null;	
	protected JPanel contentPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JButton pauseBtn = null;
	protected JButton resumeBtn = null;
	protected JComboBox<String> ruleBox = null;
	protected JLabel numInform = null;
	protected JTextField numText = null;
	protected JPanel contentFill = null;
	

	public CAAPP() {
		
	}
	
	public abstract JPanel getContentPanel();
    
    


}
