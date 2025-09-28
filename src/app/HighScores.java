/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author LENOVO
 */
import java.io.*;

import javax.swing.JOptionPane;

public class HighScores {
	
	/*
	 * This class creates a file and sane in it the high score 
	 */
	
	// declaration and initiation of variables 
	static int maxScore = 0;
	static String maxScoreName = "Nobody";
	
	static int maxScoreHours = 0;
	static int maxScoreMinutes = 0;
	static int maxScoreSeconds = 0;

	/*
	 * This class registers the high scores in file
	 */
    public static void regigterMaxHighScore(int sumNum, int hours, int minutes, int seconds){
		
		 try {
	            // creation of file		 
	            File f = new File("SuperSnake.txt");
	            RandomAccessFile raf = new RandomAccessFile(f, "rw");
	            
	            // registers the first high score if it is the first time in which file is used
	            if (f.length() == 0){
           	        maxScoreName = JOptionPane.showInputDialog(null, "Congratulations!! Enter your name..", "High Scores", 1);
	            	
           	        // in case the player doesn't complete his/her name
	            	if (maxScoreName == null){
	            		maxScoreName = "Unknown";
	            	}
	            	
	            	// writes the new high score's info to file 
           	        raf.writeChar(sumNum);
           		    raf.writeUTF(maxScoreName);
           		    raf.writeChar(hours);
           		    raf.writeChar(minutes);
           		    raf.writeChar(seconds);
	            }
	            
	            else{ 
	            	
	            	// checks if the score breaks the high score and registers it in file
	            	if (maxScore < sumNum){ 
	             	    maxScoreName = JOptionPane.showInputDialog(null, "Congratulations!! Enter your name..", "High Scores", 1);
		            	maxScore = sumNum;
		            	
	           	        // in case the player doesn't complete his/her name
		            	if (maxScoreName == null){
		            		maxScoreName = "Unknown";
		            	}
		            	
		            	// drives file's pointer to begin
	            		raf.seek(0);
	            		
	            		// writes the new high score's info to file 
	            		raf.writeChar(maxScore);
	            		raf.writeUTF(maxScoreName);
	           		    raf.writeChar(hours);
	           		    raf.writeChar(minutes);
	           		    raf.writeChar(seconds);	            	
	                }

	            raf.close();
	          }
	        } catch (IOException e) {
	        }
	  
    }

    /*
     * This class find the max high score in file 
     */
    public static void findMaxHighScore(){
		
		 try {
	            File f = new File("SuperSnake.txt");
	            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            	
	            // drives file's pointer to begin
	            raf.seek(0);
	            
	            // reads the already registered info about high score to shows them in panel
            	maxScore = raf.readChar();
            	maxScoreName = raf.readUTF();
            	maxScoreHours = raf.readChar();
            	maxScoreMinutes =raf.readChar();
            	maxScoreSeconds = raf.readChar();
            	
	            raf.close(); 
	            
	        } catch (IOException e) { 
       }
    }
}



