 
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
  * Title: PlayGUI.java
  * Description: This class contains the definition of the page for playing.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */

public class PlayGUI{

    // The basic components of the home page.
	JFrame frame = new JFrame("Wordle-Play");
	JButton backButton=new JButton("Back to home page");
	JButton okButton=new JButton("OK");
	JButton ruleButton=new JButton("        Rule        ");
	JTextField text = new JTextField("Input your word",10);
	JPanel jp1 = new JPanel(new GridLayout(6,5,5,5));
	JPanel jp2=new JPanel(new GridLayout(3,1));
	JPanel jp3=new JPanel(new FlowLayout());
	JPanel jp4=new JPanel(new GridLayout(2,1));
	JPanel jp5=new JPanel();
	JPanel jpText=new JPanel();
	JPanel jpNorth=new JPanel();
	JPanel jpSouth=new JPanel();
	JPanel jpEast=new JPanel();
	JPanel jpBack=new JPanel();
	JPanel jpRule=new JPanel();
	JLabel[][] label=new JLabel[6][5];
	JLabel logo=new JLabel();
	
	Word w=new Word();         // The randomly selected word.
	char[] word=new char[7];
	int time=0;                // The times that the player tries.
	
/**
  * This method establishes a new page for playing.
  *
  */
	public void go(){
		
		try{
		// Register new listener to button.
		backButton.addActionListener(new BackListener());
		okButton.addActionListener(new OKListener());
		ruleButton.addActionListener(new RuleListener());
		
		// Edit the page layout.
		jp1.setPreferredSize(new Dimension(300,60));
		jp5.add(logo);
		jp3.add(jpText);
		jp3.add(okButton);
		jp4.add(jpRule);
		jp4.add(jpBack);
		jpText.setLayout(new FlowLayout());
		jpText.add(text);
		jpRule.setLayout(new FlowLayout());
		jpRule.add(ruleButton);
		jpBack.setLayout(new FlowLayout());
		jpBack.add(backButton);
		jp2.add(jp5);
		jp2.add(jp3);
		jp2.add(jp4);
		frame.getContentPane().add(jp1,"Center");
		frame.getContentPane().add(jpNorth,"North");
		frame.getContentPane().add(jp2,"East");
		frame.getContentPane().add(jpEast,"West");
		frame.getContentPane().add(jpSouth,"South");
		frame.setSize(650,600);
		frame.setVisible(true);
		
		// Set the answer area on the left
		Font f = new Font("宋体",1,27);
		for(int i=0;i<6;i++){
			for(int j=0;j<5;j++){
				int n=i*5+j+1;
				label[i][j]=new JLabel("      ",JLabel.CENTER);
				label[i][j].setFont(f);
				jp1.add(label[i][j]);
				label[i][j].setOpaque(true);
				label[i][j].setBackground(new Color(213,176,157));
			}
		}
		
		// Edit the color of every component.
		jp4.setBackground(new Color(248,232,216));
		jp3.setBackground(new Color(248,232,216));
		jp5.setBackground(new Color(248,232,216));
		jpNorth.setBackground(new Color(248,232,216));
		jpEast.setBackground(new Color(248,232,216));
		jp1.setBackground(new Color(248,232,216));
		jpSouth.setBackground(new Color(248,232,216));
		jpRule.setBackground(new Color(248,232,216));
		jpBack.setBackground(new Color(248,232,216));
		okButton.setBackground(new Color(192,183,184));
		ruleButton.setBackground(new Color(192,183,184));
		backButton.setBackground(new Color(192,183,184));
		
		// Select a word as the answer.
		word=w.Getword();
		System.out.println(word);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // The program stops when the window closes

		}
		catch(IOException e) {              // If find any error,
			e.printStackTrace();            // the error location and reason will be printed on the command line.
		}
		
	}
	
/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "Back" is clicked.
  * It will back to homepage, and close the playing page.
  *
  */
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.dispose();                  // Close the game page,
			LoginGUI gui=new LoginGUI();      // and go back to the home page.
			gui.go();
		}
	}
	
/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "OK" is clicked.
  * It will get the content in the TextField,
  * and check if the guess is right, 
  * and give a feed back on the window by different color.
  *
  */
	class OKListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			    text.setForeground(Color.BLACK);
				Guess g=new Guess(text.getText());       // Get text from the text area.
				int[] check = new int[7];
				int right=0;           // The number of right letters.
				g.Change();            // Check if the input of guess are all English letter.
				if(g.Change()==true&&g.Read("\\Mini project\\Word.txt")==true){     // If the input is an English word.
					check=g.Check(word);        // Check if the guess is right, or partial right, or wrong.
					
					// Print the guessed word on the screen and display the color according to whether it is correct.
					for(int m=0;m<5;m++){
						label[time][m].setText(" "+g.arr[m]);
						text.setText(null);
						label[time][m].setForeground(Color.white);
						if(check[m]==0) label[time][m].setBackground(new Color(97,106,117));    // If the letter isn't in the word, set background gray.
						else if(check[m]==1){
							label[time][m].setBackground(new Color(145,196,108));    // If the letter is right, set background green.
							right++;
						}
						else label[time][m].setBackground(new Color(255,225,132));   // If the letter is in the word but not in the location, set yellow.
					}
					if(right==5){                                  // If the 5 letters are all right,
						LogoutGUI gui=new LogoutGUI(true);         // the player win, and create a new game over page.
						gui.go(jp1,word);                          // Incoming the win result to the game over page.
						frame.setVisible(false);                   // Close the game page.
					}
					time++;                                        // If the player not win this time, the number of attempts plus one.
					
				}
				else{
					text.setText("Wrong input!");                  // If input isn't English word, show input error.
					text.setForeground(Color.RED);
				}
				if(time==6){                                        // If the player has tried 6 times,
					LogoutGUI gui=new LogoutGUI(false);             // the player false, and create a new game over page.
					gui.go(jp1,word);                               // Incoming the false result to the game over page.
					frame.setVisible(false);                        // Close the play page.
				}
		}
	}
	
/** 
  * This class is a subclass od ActionListener.
  * This method handels the event that the button "Rule" is clicked.
  * It will over the game,
  * and open the rule of Wordle.
  *
  */
	class RuleListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			RuleGUI gui=new RuleGUI();
			gui.go();                                 // Create a new rule page,
			frame.dispose();                          // and close the game page.
		}
	}
}