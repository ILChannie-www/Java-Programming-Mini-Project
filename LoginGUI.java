
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
  * Title: LoginGUI.java
  * Description: This class contains the definition of the home page of Wordle Game.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */

public class LoginGUI {

    // The basic components of the home page.
	JButton startButton=new JButton("Start the game");
	JButton ruleButton=new JButton("          Rule       ");
	JFrame frame = new JFrame("Wordle-Home Page");
	JPanel jp=new JPanel();
	JPanel jp2=new JPanel();
	JLabel jl1=new JLabel("Let's play",JLabel.CENTER);
	JLabel jl2=new JLabel("WORDLE",JLabel.CENTER);
	JPanel panel_small_1 =new JPanel();
	JPanel panel_small_2 =new JPanel();
	
/**
  * This method establishes a new home page.
  * 
  */
	public void go(){
		// Register new listener to button.
		startButton.addActionListener(new StartListener());
		ruleButton.addActionListener(new RuleListener());
		
		// Edit the page layout.
		jp.setLayout(new GridLayout(2,1));
		jp2.setLayout(new GridLayout(2,1));
		panel_small_1.setLayout(new FlowLayout());
		panel_small_1.add(ruleButton);
		panel_small_2.setLayout(new FlowLayout());
		panel_small_2.add(startButton);
		jp2.add(jl1);
		jp2.add(jl2);
		jp.add(panel_small_1);
		jp.add(panel_small_2);
		frame.getContentPane().add(jp,"South");
		frame.getContentPane().add(jp2,"Center");
		frame.setSize(400,400);
		frame.setVisible(true);
		
		// Edit font.
		Font f = new Font("宋体",1,40);
		jl1.setFont(f);
		jl2.setFont(f);
		
		// Edit the color of every component.
		jl1.setOpaque(true);
		jl2.setOpaque(true);
		panel_small_1.setOpaque(true);
		panel_small_2.setOpaque(true);
		jl1.setBackground(new Color(213,176,157));
		jl2.setBackground(new Color(213,176,157));
		panel_small_1.setBackground(new Color(213,176,157));
		panel_small_2.setBackground(new Color(213,176,157));
		startButton.setBackground(new Color(248,232,216));
		ruleButton.setBackground(new Color(248,232,216));
		jl1.setForeground(Color.white);
		jl2.setForeground(Color.white);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // The program stops when the window closes

	}
	
/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "Start" is clicked.
  * It will start a new game.
  *
  */
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			PlayGUI gui = new PlayGUI();
			gui.go();           // Create a new game page,
			frame.dispose();    // and close the home page.
		}
	}
	
/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "Rule" is clicked.
  * It will open the game rules page,
  * and close the home page.
  *
  */	
	class RuleListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			RuleGUI gui=new RuleGUI();
			gui.go();           // Create a new rule page,
			frame.dispose();    // and close the home page.
		}
	}
}
