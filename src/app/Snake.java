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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;


public class Snake {
	
	public static boolean run = false;
	
	Game panel;
	Node n;
	Node food;
	Setdifficulce dif;
	static int array = 5;
	public static int number = 0;
	int x, y, food_x, food_y;
	int dir = 3;
	LinkedList<Node> snakeList = new LinkedList<Node>();
	int maxX, maxY;
	int flag = 0;
	
	static int sumNum = 0;
	static int maxNum = 0;
	
	// declaration of the variables about your high score
	static int yourhighscore;
	static int yourhighscorehours;
	static int yourhighscoreminutes;
	static int yourhighscoreseconds;
	
	public Snake(final Game p) {
		panel = p;
		maxX = panel.getWidth();
		maxY = panel.getHeight();
		createsnake();
		food = createfood();
		Setdifficulce.all[food.x][food.y] = true;
	}

	public void changedir(final int s_dir, final int c_dir) {
		if (((s_dir == 4) && (c_dir == 2)) || ((c_dir == 4) && (s_dir == 2))) {
		} else {
			if (((s_dir == 3) && (c_dir == 1))
					|| ((c_dir == 3) && (s_dir == 1))) {
			} else {
				dir = c_dir;
			}
		}
	}

	public Node createfood() {
		final Random r = new Random();
		do {
			x = r.nextInt(maxX - 1);
			y = r.nextInt(maxY - 1);
		} while ((Setdifficulce.all[x][y] == true)
				|| (((Math.abs(x - food_x)) % 12 != 0) || ((Math
						.abs(y - food_y)) % 12 != 0)));
		return new Node(x, y);
	}

	public void createsnakeNode(final int x, final int y) {
		Node p;
		if ((x == food.x) && (y == food.y)) {
			n = food;
			snakeList.addFirst(n);
			panel.repaint();
			food = createfood();
			Setdifficulce.all[food.x][food.y] = true;
		} else {
			n = new Node(x, y);
			snakeList.addFirst(n);
		}
		Setdifficulce.all[n.x][n.y] = true;
		p = snakeList.getLast();
		snakeList.removeLast();
		Setdifficulce.all[p.x][p.y] = false;
	}

	public void move() {

		final Node n = snakeList.getFirst();
		int x = n.x;
		int y = n.y;
		if (dir == 3) 
		{
			x += 12;
		} else if (dir == 4)
		{
			y += 12;
		} else if (dir == 1)
		{
			x -= 12;
		} else if (dir == 2)
		{
			y -= 12;
		}
		if ((x == food.x) && (y == food.y) && Setdifficulce.all[x][y]) {
			snakeList.addFirst(food);
			panel.repaint();
			food = createfood();
			Setdifficulce.all[food.x][food.y] = true;
			++sumNum;
			Speed.speed = risespeed (Speed.speed);
		}

		else if ((x > maxX - 1) || (y > maxY - 1) || (x < 0) || (y < 0)) {
			switch (dir) {
			case 1:
				x = maxX - 1;
				createsnakeNode(x, y);
				break;
			case 2:
				y = maxY - 1;
				createsnakeNode(x, y);
				break;
			case 3:
				x = 0;
				createsnakeNode(x, y);
				break;
			case 4:
				y = 0;
				createsnakeNode(x, y);
				break;
			}

		} else if (Setdifficulce.all[x][y]) {
			Snake.number = snakeList.size() - 5;
			if (Snake.number == 0) {
				JOptionPane.showMessageDialog(null, "Oh no...You've got no food idiot! Try again!!", "Game Over",
						JOptionPane.DEFAULT_OPTION);
			} else {
				JOptionPane.showMessageDialog(null, "Sorry! Game over! You got : " + number + " food"
						+ "\nYour snake doesn't want any more!", "Game Over",
						JOptionPane.DEFAULT_OPTION);
				
				HighScores.regigterMaxHighScore(sumNum, SnakeThread.hours, SnakeThread.minutes, SnakeThread.seconds);
			}
			snakeList.clear();
			
			Setdifficulce.Walllist.clear();
			dif = new Setdifficulce();
			Setdifficulce.checkmap();
			Setdifficulce.all[food.x][food.y] = true;
			createsnake();
			panel.repaint();
			Snake.run = false;
			panel.start = 0;
			dir = 3;

			// calculate your high score
			if (sumNum > yourhighscore) {
				yourhighscore = sumNum;
			    yourhighscorehours = SnakeThread.hours;
			    yourhighscoreminutes = SnakeThread.minutes;
			    yourhighscoreseconds = SnakeThread.seconds;
			}
			
			// declare the score and timer to zero after the game over
			sumNum = 0;
			SnakeThread.hours = 0;
			SnakeThread.minutes = 0;
			SnakeThread.seconds = 0;
			
			// increase the speed for automatic option
			Speed.speed = risespeed (Speed.speed);

		} else {
			createsnakeNode(x, y);
		}

		panel.repaint();
	}
	
	public void createsnake() {
		do {
			flag = 0;
			do {
				x = (int) (Math.random() * (maxX + 1));
			} while ((x >= maxX - array * 24) || ((maxX - 1 - x) % 12 != 0)
					|| (x % 12 != 0));
			food_x = x;
			do {
				y = (int) (Math.random() * (maxY + 1));
			} while (((maxY - 1 - y) % 12 != 0) || (y % 12 != 0));
			food_y = y;
			for (int i = 0; i < array; i++) {
				final int s = x + 12 * (i + 1);
				final int s1 = y;
				if (Setdifficulce.all[s][s1] == true) {
					flag = 1;
					final LinkedList<Node> list = snakeList;
					final Iterator<Node> it = list.iterator();
					Node n1;
					while (it.hasNext()) {
						n1 = it.next();
						Setdifficulce.all[n1.x][n1.y] = false;
					}
					if (snakeList.size() != 0) {
						n1 = snakeList.getFirst();
						Setdifficulce.all[n1.x][n1.y] = true;
					}
					snakeList.clear();
				Speed.speed = risespeed (Speed.speed);

					break;
				}
				snakeList.addFirst(new Node(s, s1));
				Setdifficulce.all[s][s1] = true;
			}
		} while (flag == 1);
	}

	// This is the method which control the speed of snake
	public double risespeed (double risespeed) {
		if (sumNum % 5 == 0 && risespeed >= 0.4 && Speed.auto == true) {
			risespeed = risespeed - 0.2;
		}
		
		else {
			if (sumNum == 0) {
				risespeed = 1.8;
			}
		}
		
		return risespeed;	
	}
		
}

