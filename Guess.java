 
import java.io.*;

/**
  * Title: Guess.java
  * Description: This class contains the definition of the player's guess.
  * @author: Xiaoyang Liu
  * @version: 1.0
  */

public class Guess{
	
    char[] arr;
	String str;
	
/** This method is the constructor of Guess.
  * @param The content that player input in the TextField
  *
  */
	public Guess(String s){
		this.arr=s.toCharArray();
		this.str=s;
	}
	
/** This method checks if the guess is an English word.
  * @param The name of the file which contains 5 letters-words.
  * @return Whether the guess is an English word.
  */
	 public Boolean Read(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
		
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            
            while ((tempString = reader.readLine()) != null) {
                if(tempString.equals(str)){         // If the word in this line equals the guess,
					return true;                    // return true.
				}
				else{
					line++;                         // If not equal, compare next line.
				}
            }
			if(reader.readLine()== null){
				return false;                       // If fail to read, return false.
			}
			
            reader.close();
			
        } catch (IOException e) {
            e.printStackTrace();                    // If find any error, print the error location and reason.
        } finally {
            if (reader != null) {
                try {
                    reader.close();                 // In any case, close the reader.
                } catch (IOException e1) {
                }
            }
        }
		
		return false;
    }

/**
  * This method checks if the letters of guess are all English letter.
  * @return Whether the letters are all English letters.
  *
  */
	public boolean Change(){
		if(arr.length==5){
			for(int i=0;i<arr.length;i++){
				if(arr[i]<97||arr[i]>122){
					return false;               // If any letter of the word isn't English, return false.
				}
				if(i==arr.length-1){            // If 5 letters are all English, return true.
					return true;
				}
			}
		}
		else return false;                       // If the length of input isn't five, return false.
		return true;
	}
	
/** This method checks if the guess is right, or partial right, or wrong.
  * @param The answer word.
  * @return Whether every letter of the guess is right.
  *
  */
	public int[] Check(char[] word){
		int[] check=new int[5];
		// Check if the letter is in the answer one by one.
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(arr[i]==word[j]&&i==j){
					check[i]=1;     // If in the right location, set 1.
					break;
				}
				else if(arr[i]==word[j]&&(i!=j)){
					check[i]=2;     // If in the wrong location, set 2.
				}
				else if(j==5&&check[i]!=1&&check[i]!=2){
					check[i]=0;     // If not in, set 0.
				}
				else{
					continue;
				}
			}
		}
		return check;
	}

}