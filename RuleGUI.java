
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
  * Title: RuleGUI.java
  * Description: This class contains the definition of the rule page of Wordle Game.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */

public class RuleGUI{
	// The basic components of the rule page.
	JButton startButton=new JButton("Let's Start->");
	JButton backButton=new JButton("<-Home Page");
	JFrame frame = new JFrame("Wordle-Rule Page");
	JLabel label=new JLabel();
	JTextArea textArea = new JTextArea();
	JPanel jp1=new JPanel();
	JLabel l=new JLabel("                                           ");
	
/**
  * This method establishes the page of rule.
  *
  */
	public void go(){
		// Register new listener to button.
		startButton.addActionListener(new StartListener());
		backButton.addActionListener(new BackListener());
		
		// Edit the color.
		jp1.setBackground(new Color(213,176,157));
		startButton.setBackground(new Color(192,183,184));
		backButton.setBackground(new Color(192,183,184));
		textArea.setBackground(new Color(248,232,216));
		
		// Edit the rule.
        textArea.setLineWrap(true);
        textArea.setFont(new Font(null, Font.PLAIN, 18));   
		textArea.setText("The aim of the game is to guess a hidden target 5-letter word within 6 attempts.");
		textArea.append("\nYour should try to guess the 5-letter word.");
		textArea.append("\nYou are allowed to make 6 guesses in total to discover the target word.");
		textArea.append("\nYou are given feedback after each attempt they make.");
		textArea.append("\nThe feedback is as follows:");
		textArea.append("\nThere are three colours that the cells containing the letters can be; green, yellow, or grey.");
		textArea.append("\n1.Green means the letter is contained in the word and is in that position.");
		textArea.append("\n2.Yellow means the letter is contained in the word but not in that position.");
		textArea.append("\n3.Grey means the letter is not contained in the word.");
		textArea.append("\nPlease note: you must enter five letter English words, all in lowercase.");
		textArea.append("If you enter four or six letters, or non English letters, the text box will show wrong input.");
		textArea.append("\nHave a good time :)");
		
		JScrollPane jsp = new JScrollPane(textArea);
		textArea.setCaretPosition(0);
		jsp.setBounds(13, 10, 350, 340);
		jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEditable(false);
		
		// Edit the page layout.
		jp1.setSize(380,380);
		jp1.add(backButton,BorderLayout.WEST);
		jp1.add(l,BorderLayout.CENTER);
		jp1.add(startButton,BorderLayout.EAST);
		frame.getContentPane().add(jp1,"South");
		frame.getContentPane().add(jsp,"Center");
		frame.setSize(400,450);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // The program stops when the window closes

	
	}
	
/**
  * This class is a subclass of ActionListener.
  * The method handels the event that the button "Start" is clicked.
  * It will establish a new page for playing,
  * and close the rule page.
  */
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			PlayGUI gui = new PlayGUI();
			gui.go();                   // Create a new game page,
			frame.dispose();            // and close the rule page.
		}
	}
	
/**
  * This class is a subclass of ActionListener.
  * The method handels the event that the button "Back" is clicked.
  * It will establish a new homepage,
  * and close the rule page.
  */
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			LoginGUI gui = new LoginGUI();
			gui.go();                     // Create a new home page,
			frame.dispose();              // and close the rule page.
		}
	}

}