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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;



public class Game extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void begin() {
		Snake.run = true;
		final SnakeThread thread = new SnakeThread(snake);
		thread.start();
	}

	public static void sleep() throws InterruptedException {
		Snake.run = false;
		Thread.sleep(100);
	}

	// @jve:decl-index=0:visual-constraint="29,21"
	Node n, m; // @jve:decl-index=0:
	static Snake snake;
	static Setdifficulce dif;
	int rect_x;

	int rect_y;

	int start = 0;

	
	
	/**
	 * This method initializes
	 * 
	 */

	// final static BasicStroke stroke = new BasicStroke(2.0f);
	// //@jve:decl-index=0
	// :
	public Game() {
		super();
		initialize();

	}
	
    // To initialize colors the methods call the corresponding class

	public void draw(final Graphics2D g, final int x, final int y) {
		g.setColor(SetSnakeColor.SnakeColor);   
		drawNode(g, n);
	}

	public void draw1(final Graphics2D g, final int x, final int y) {
		g.setColor(SetWallColor.WallColor);   
		drawNode(g, n);
	}

	public void draw2(final Graphics2D g, final int x, final int y) {
		g.setColor(SetHeadColor.HeadColor);   
		drawNode(g, n);
	}

	public void drawNode(final Graphics2D g, final Node n) {
		// g.setColor(Color.RED);
		g.fillRect(n.x, n.y, 10, 10);
	}

	/**
	 * This method initializes this
	 * 
	 */

	private void initialize() {

		this.setSize(new Dimension(289, 445));
		setBackground(Color.white);
		setFocusable(true);
		addKeyListener(this);
		dif = new Setdifficulce();
		Setdifficulce.checkmap();
		snake = new Snake(this);

	}

	// declare the buttons which control the game
	
	@Override
	public void keyPressed(final KeyEvent e) {
		if (Snake.run) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				snake.changedir(snake.dir, 4);
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				snake.changedir(snake.dir, 2);
			}

			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				snake.changedir(snake.dir, 1);
			}

			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				snake.changedir(snake.dir, 3);
			}

			else if (e.getKeyCode() == KeyEvent.VK_S) {
				snake.changedir(snake.dir, 4);
			}

			else if (e.getKeyCode() == KeyEvent.VK_W) {
				snake.changedir(snake.dir, 2);
			}

			else if (e.getKeyCode() == KeyEvent.VK_A) {
				snake.changedir(snake.dir, 1);
			}

			else if (e.getKeyCode() == KeyEvent.VK_D) {
				snake.changedir(snake.dir, 3);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (start == 1) {
				if (!Snake.run) {
					begin();
				} else {
					try {
						sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		
			if (start == 0) {
				if (!Snake.run) {
					begin();
					Snake.sumNum = 0;
					start = 1;
					 
				} else { 
					try {
						sleep();
						 
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		
	}

	@Override
	public void keyReleased(final KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(final KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		final Graphics2D g2 = (Graphics2D) g;
		
		// To initialize the background color is calling the corresponding class 
		setBackground(SetBackgroundColor.BackgroundColor);   
		
		final LinkedList<Node> list1 = Setdifficulce.Walllist;
		final Iterator<Node> it1 = list1.iterator();
		while (it1.hasNext()) {
			n = it1.next();
			draw1(g2, n.x, n.y);
		}
		final LinkedList<Node> list = snake.snakeList;
		final Iterator<Node> it = list.iterator();
		while (it.hasNext()) {
			n = it.next();
			draw(g2, n.x, n.y);
		}
		n = snake.snakeList.getFirst();
		draw2(g2, n.x, n.y);
		
		// To initialize the food color is calling the corresponding class
	    g2.setColor(SetFoodColor.FoodColor);   
		
		final Node f = snake.food;
		drawNode(g2, f);

	}

} // @jve:decl-index=0:visual-constraint="98,45"



