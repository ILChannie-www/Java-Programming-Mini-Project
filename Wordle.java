
import java.io.*;

/**
  * Title: Wordle.java
  * Description: This class contains the main, and is the game launcher.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */

public class Wordle{
	
	public static void main(String[] args) {
		LoginGUI gui=new LoginGUI();
		gui.go();       // Create a new home page and play the game on it.
	}
	
}