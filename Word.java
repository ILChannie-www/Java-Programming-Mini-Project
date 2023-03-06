
import java.io.*;

/**
  * Title: Word.java
  * Description: This class contains the definition of the answer.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */
  
public class Word{

/**
  * This method randomly gets a word from the file.
  * @return The word.
  */
    public char[] Getword() throws IOException {
		
		String fileName ="\\Mini project\\Word.txt";    // This file contains about 900 five-letter words.
        FileReader fileReader = new FileReader(fileName);
		char[] chars = new char[7];
		int length=this.getFileLine(fileName);                            // Get the number of lines of the file,
		int randomWithMathRandom = (int) (Math.random() * (length-5));    // so that randomly select a number less than the length.
		fileReader.skip(randomWithMathRandom*7);       // Skip the lines before the selected line.
        fileReader.read(chars,0,7);                    // Read the selected line.

		return chars;                                  // Return the randomly selected word.
		
    }

/**
  * This method randomly selects a line from the file.
  * @param The name of the file contains words.
  * @return The number of the line.
  *
  */
	public static int getFileLine(String fileName){
		int line = 0;
		try {
				FileReader fr = new FileReader(new File(fileName));
				LineNumberReader lnr = new LineNumberReader(fr);
				lnr.skip(Long.MAX_VALUE);
				
				line = lnr.getLineNumber();
				lnr.close();
		} catch (IOException e) {           // If find any error,
				                            // the error location and reason will be printed
				e.printStackTrace();        // on the command line.
		}
		return line;                        // Return the number of lines of the file.
	}

}