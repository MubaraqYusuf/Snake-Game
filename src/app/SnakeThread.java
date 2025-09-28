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

public class SnakeThread extends Thread {
	Snake snake;
	static int seconds;
	static int minutes=0;
	static int hours=0;
	long time = System.currentTimeMillis();
	
	public SnakeThread(final Snake s) {
		snake = s;
	}
	
	
	@Override
	public void run() {
		Snake.run = true;
		
		//the chronometer runs only while the snake is moving
		while (Snake.run) {
			try { 
				
				    //counts seconds while the snake is moving + seconds while the snake was moving(in case the user pause the game)
				    seconds= (int)((System.currentTimeMillis()-time)/1000)+Oursnake.secondtimer+(Oursnake.minutetimer*60)+(Oursnake.hourtimer*3600);
				    
				    //converts seconds to minutes
				    minutes= (int)seconds / 60;
				    
				    //converts minutes to hours
					hours= (int)minutes/ 60;
					
					//calculates the seconds
					seconds=seconds -(minutes*60)- (hours*3600);
									
			    	snake.move();
				    sleep((long) (Speed.speed * 100));
				
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Snake.run = false;
		
	}
}

