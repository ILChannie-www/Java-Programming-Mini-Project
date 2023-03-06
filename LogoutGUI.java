
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
  * Title: LogoutGUI.java
  * Description: This class contains the definition of the result page of Wordle Game.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */

public class LogoutGUI{
    // The basic components of the home page.
	Boolean result=false;
	JButton closeButton=new JButton("Close the game");
	JButton tryButton=new JButton("      Try again      ");
	JFrame frame = new JFrame("Wordle-Result Page");
	JLabel re=new JLabel(" ",JLabel.CENTER);
	JLabel re2=new JLabel(" ",JLabel.CENTER);
	JLabel ans=new JLabel();
	JPanel jp2=new JPanel(new GridLayout(2,1));
	JPanel jp3=new JPanel(new FlowLayout());
	JPanel jp4=new JPanel(new GridLayout(2,1));
	JPanel jp5=new JPanel(new GridLayout(3,1));
	JPanel jpClose=new JPanel();
	JPanel jpTry=new JPanel();
	JPanel jpNorth=new JPanel();
	JPanel jpWest=new JPanel();
	JPanel jpSouth=new JPanel();
	
/** 
  * This method is the constructor of LogoutGUI.
  * @param The result of the game.
  *
  */
	public LogoutGUI(Boolean b){
		this.result=b;
	}
	
/**
  * This method establishes a new result page.
  * @param jp1    The picture of the result.
  * @param answer The answer of the game.
  */
	public void go(JPanel jp1,char[] answer){
		String Ans = new String(answer);
		
		// Show different text according to the result.
		if(result==false){
			re2.setText("What a pity!");
			re.setText("LOSE!");
		}
		else{
			re2.setText("Congratulations!");
			re.setText("WIN!");
		}
		
		// Edit the page layout.
		jp5.setPreferredSize(new Dimension(200,30));
		jp2.setPreferredSize(new Dimension(200,80));
		jp3.setPreferredSize(new Dimension(200,80));
		ans.setText("Answer: "+ Ans);
		ans.setFont(new Font("", Font.BOLD, 24));
		re.setFont(new Font("", Font.BOLD, 32));
		re2.setFont(new Font("", Font.BOLD, 24));
		jpTry.add(tryButton);
		jpClose.add(closeButton);
		jp2.add(re2);
		jp2.add(re);
		jp3.add(ans);
		jp4.add(jpTry);
		jp4.add(jpClose);
		jp5.add(jp2);
		jp5.add(jp3);
		jp5.add(jp4);
		closeButton.addActionListener(new CloseListener());
		tryButton.addActionListener(new TryListener());
		frame.getContentPane().add(jp1,"Center");
		frame.getContentPane().add(jp5,"East");
		frame.getContentPane().add(jpNorth,"North");
		frame.getContentPane().add(jpWest,"West");
		frame.getContentPane().add(jpSouth,"South");
		frame.setSize(650,600);
		frame.setVisible(true);
		
		// Edit the color of every component.
		jp2.setBackground(new Color(248,232,216));
		jp3.setBackground(new Color(248,232,216));
		jp4.setBackground(new Color(248,232,216));
		jp5.setBackground(new Color(248,232,216));
		jpClose.setBackground(new Color(248,232,216));
		jpTry.setBackground(new Color(248,232,216));
		re.setBackground(new Color(248,232,216));
		re2.setBackground(new Color(248,232,216));
		closeButton.setBackground(new Color(192,183,184));
		tryButton.setBackground(new Color(192,183,184));
		jpNorth.setBackground(new Color(248,232,216));
		jpWest.setBackground(new Color(248,232,216));
		jpSouth.setBackground(new Color(248,232,216));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "Close" is clicked.
  * It will over the project.
  *
  */
	class CloseListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.exit(0);             // Close the game.
		}
	}

/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "Try again" is clicked.
  * It will establish a new page for playing,
  * and close the result page.
  *
  */	
	class TryListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			PlayGUI gui=new PlayGUI();
			gui.go();                  // Create a new game page,
			frame.dispose();           // and close the result page.
		}
	}

}