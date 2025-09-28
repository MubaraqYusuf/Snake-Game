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
import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class Oursnake extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final Oursnake thisClass = new Oursnake();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setLocation(400, 175);
				thisClass.setVisible(true);
			}
		});
	}
	
	// declare the objects of menu bar
	private JMenuBar jJMenuBar = null;

	private JMenu jMenu1 = null;
	private JMenu jMenu2 = null;
	private JMenu jMenu3 = null;
	private JMenu jMenu4 = null;
	private JMenu jMenu5 = null;
	private JMenu jMenu6 = null;
	private JMenu jMenu7 = null;

	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	private JMenuItem jMenuItem4 = null;
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;
	
	// declare the objects of right panel
    private JTextField fieldYourScore1;
    private JTextField fieldYourScore2;
    private JTextField fieldYourHighScore1;
    private JTextField fieldYourHighScore2;
    private JTextField fieldBestHighScore1;
    private JTextField fieldBestHighScore2;
    private JTextField fieldBestHighScore3;
	private JLabel actionLabel;
	private JLabel actionLabel1;
	private JLabel actionLabel2;
	
	//declare the variables when the timer is pause
	static boolean pause= false;
	static int secondtimer = 0;
	static int minutetimer = 0;
	static int hourtimer = 0;

	
	/**
	 * This is the default constructor
	 */
	public Oursnake() {
		super();
		
		initialize();
		final Container c = getContentPane();
		final Game panel = new Game();
		c.setLayout(new BorderLayout());
		c.add(panel, BorderLayout.CENTER);
		
	    Border raisedetched;
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		
        // initialization of the objects of right panel
        
        actionLabel = new JLabel("Your Score");
        actionLabel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
        actionLabel.setFont(new Font("sansserif", Font.BOLD, 14));
        
        fieldYourHighScore1 = new JTextField(8);       
        fieldYourHighScore1.setEditable(false);
        fieldYourHighScore1.setBorder(raisedetched);
        fieldYourHighScore1.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldYourHighScore1.setHorizontalAlignment(JTextField.CENTER);
        
        fieldYourHighScore2 = new JTextField(10);       
        fieldYourHighScore2.setEditable(false);
        fieldYourHighScore2.setBorder(raisedetched);
        fieldYourHighScore2.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldYourHighScore2.setHorizontalAlignment(JTextField.CENTER);
        
        actionLabel1 = new JLabel("Your High Score");
        actionLabel1.setBorder(BorderFactory.createEmptyBorder(35,10,10,10)); 
        actionLabel1.setFont(new Font("sansserif", Font.BOLD, 14));
		
        fieldYourScore1 = new JTextField(8);       
        fieldYourScore1.setEditable(false);
        fieldYourScore1.setBorder(raisedetched);
        fieldYourScore1.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldYourScore1.setHorizontalAlignment(JTextField.CENTER);
        
        fieldYourScore2 = new JTextField(10);       
        fieldYourScore2.setEditable(false);
        fieldYourScore2.setBorder(raisedetched);
        fieldYourScore2.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldYourScore2.setHorizontalAlignment(JTextField.CENTER);
        
        actionLabel2 = new JLabel(" The Best High Score");
        actionLabel2.setBorder(BorderFactory.createEmptyBorder(35,10,10,10)); 
        actionLabel2.setFont(new Font("sansserif", Font.BOLD, 14));
        
        fieldBestHighScore1 = new JTextField(10); 
        fieldBestHighScore1.setEditable(false);
        fieldBestHighScore1.setBorder(raisedetched);
        fieldBestHighScore1.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldBestHighScore1.setHorizontalAlignment(JTextField.CENTER);

        fieldBestHighScore2 = new JTextField(8);  
        fieldBestHighScore2.setEditable(false);
        fieldBestHighScore2.setBorder(raisedetched);
        fieldBestHighScore2.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldBestHighScore2.setHorizontalAlignment(JTextField.CENTER);
        
        fieldBestHighScore3 = new JTextField(10);  
        fieldBestHighScore3.setEditable(false);
        fieldBestHighScore3.setBorder(raisedetched);
        fieldBestHighScore3.setFont(new Font("sansserif", Font.HANGING_BASELINE, 14));
        fieldBestHighScore3.setHorizontalAlignment(JTextField.CENTER);
       
        // creates the right panel and adds the objects 
        JPanel rightPane = new JPanel();
        rightPane.add(actionLabel);
        rightPane.add(fieldYourScore1);
        rightPane.add(fieldYourScore2);
        rightPane.add(actionLabel1);
        rightPane.add(fieldYourHighScore1);
        rightPane.add(fieldYourHighScore2);
        rightPane.add(actionLabel2);
        rightPane.add(fieldBestHighScore1);
        rightPane.add(fieldBestHighScore2);
        rightPane.add(fieldBestHighScore3);
       
        
        rightPane.setPreferredSize(new Dimension(170, 150));
        rightPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Game Info"),
                                BorderFactory.createEmptyBorder(10,5,5,5)),
                                rightPane.getBorder()));
    	add(rightPane, BorderLayout.EAST);
    	
        javax.swing.Timer t = new javax.swing.Timer(100, new ClockListener());
        t.start();
	}
	
	// this class updates the right panel
    class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {    

    		fieldYourScore1.setText("Score: "+Snake.sumNum);
    		fieldYourScore2.setText("Timer: "+SnakeThread.hours+":"+SnakeThread.minutes+":"+SnakeThread.seconds);
            
    		fieldYourHighScore1.setText("Score: "+Snake.yourhighscore);
    		fieldYourHighScore2.setText("Timer: "+Snake.yourhighscorehours+":"+Snake.yourhighscoreminutes+":"+Snake.yourhighscoreseconds);
            
            HighScores.findMaxHighScore();
            
            fieldBestHighScore1.setText("Name: "+HighScores.maxScoreName);
            fieldBestHighScore2.setText("Score: "+HighScores.maxScore);
            fieldBestHighScore3.setText("Timer: "+HighScores.maxScoreHours+":"+HighScores.maxScoreMinutes+":"+HighScores.maxScoreSeconds);
    	}
    }
    
	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new Dimension(20, 25));
            jJMenuBar.add(getJMenu1());
            jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu3());
			jJMenuBar.add(getJMenu4());
			jJMenuBar.add(getJMenu5());
			jJMenuBar.add(getJMenu6()); 
			jJMenuBar.add(getJMenu7()); 
			
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu1
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setPreferredSize(new Dimension(50, 25));
			jMenu1.setText("Game");
			jMenu1.add(getJMenuItem7());
			jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
				public void menuCanceled(final javax.swing.event.MenuEvent e) {
				}

				public void menuDeselected(final javax.swing.event.MenuEvent e) {
				}

				public void menuSelected(final javax.swing.event.MenuEvent e) {
					Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
				    try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenu1;
	}
	
	/**
	 * This method initializes jMenu2
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setPreferredSize(new Dimension(50, 25));
			jMenu2.setText("Pause");
			jMenu2.setSize(new Dimension(70, 25));
			jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(final java.awt.event.MouseEvent e) {
					Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(
							null,"Press ENTER to continue the game!!",
							"Pause",
							JOptionPane.INFORMATION_MESSAGE);
					Game.begin();
				}
			});
		}
		return jMenu2;
	}
	
	/**
	 * This method initializes jMenu3
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu3() {
		if (jMenu3 == null) {
			jMenu3 = new JMenu();
			jMenu3.setPreferredSize(new Dimension(90, 25));
			jMenu3.setText("Set Difficulty");
			jMenu3.add(getJMenuItem());
			jMenu3.add(getJMenuItem1());
			jMenu3.addMenuListener(new javax.swing.event.MenuListener() {
				public void menuCanceled(final javax.swing.event.MenuEvent e) {
				}

				public void menuDeselected(final javax.swing.event.MenuEvent e) {
				}

				public void menuSelected(final javax.swing.event.MenuEvent e) {
					Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
					
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
			});
		}
		return jMenu3;
	}
	
	/**
	 * This method initializes jMenu4
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu4() {
		if (jMenu4 == null) {
			jMenu4 = new JMenu();
			jMenu4.setPreferredSize(new Dimension(100, 25));
			jMenu4.setText("Change Colors");
			jMenu4.add(getJMenuItem2());
			jMenu4.add(getJMenuItem3());
			jMenu4.add(getJMenuItem4());
			jMenu4.add(getJMenuItem5());
			jMenu4.add(getJMenuItem6());
			jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
				public void menuCanceled(final javax.swing.event.MenuEvent e) {
				}

				public void menuDeselected(final javax.swing.event.MenuEvent e) {
				}

				public void menuSelected(final javax.swing.event.MenuEvent e) {
					Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jMenu4;
	}
	
	/**
	 * This method initializes jMenu5
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu5() {
		if (jMenu5 == null) {
			jMenu5 = new JMenu();
			jMenu5.setPreferredSize(new Dimension(90, 25));
			jMenu5.setText("High Scores");
			jMenu5.setSize(new Dimension(70, 25));
			jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(final java.awt.event.MouseEvent e) {
					Snake.run = false;Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (Snake.sumNum >= Snake.maxNum) {
						Snake.maxNum = Snake.sumNum;
					}
					JOptionPane
							.showMessageDialog(null,
									"The best high score is : "
											+ HighScores.maxScore + "\nIt's made by "+HighScores.maxScoreName+"\nCould you break it??",
									"Show Score",
									JOptionPane.INFORMATION_MESSAGE);
					Game.begin();
				}
			});
		}
		return jMenu5;
	}
	
	/**
	 * This method initializes jMenu6
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu6() {
		if (jMenu6 == null) {
			jMenu6 = new JMenu();
			jMenu6.setPreferredSize(new Dimension(45, 25));
			jMenu6.setSize(new Dimension(70, 25));
			jMenu6.setText("Help");
			jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(final java.awt.event.MouseEvent e) {
					Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
				    try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane
							.showMessageDialog(
									null,"*Press ENTER to start the game\n*With UP, DOWN, LEFT, RIGHT (W, S, A, D) you can control the snake\n*Press SPACE to pause the game",
									"Help Tips",
									JOptionPane.INFORMATION_MESSAGE);
					// TODO Auto-generated Event stub mouseClicked()
					Game.begin();
				}
			});

		}
		return jMenu6;
	}

	/**
	 * This method initializes jMenu7
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu7() {
		if (jMenu7 == null) {
			jMenu7 = new JMenu();
			jMenu7.setPreferredSize(new Dimension(60, 25));
			jMenu7.setText("About");
			jMenu7.setSize(new Dimension(70, 25));
			jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(final java.awt.event.MouseEvent e) {
					Snake.run = false;
					pause=true;
				    secondtimer=(int)SnakeThread.seconds;
				    minutetimer=(int)SnakeThread.minutes;
				    hourtimer=(int)SnakeThread.hours;
				    try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,
							"Team: Change Its Light\nUpdate is made by Sunshine", "About",
							JOptionPane.INFORMATION_MESSAGE);
					// TODO Auto-generated Event stub mouseClicked()
					Game.begin();
				}
			});
		}
		return jMenu7;
	}

	/**
	 * This method initializes jMenuItem about Speed
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Set Speed");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					openspeed();
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem1 about Map
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Set Map");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					openmap();
				}
			});
		}
		return jMenuItem1;
	}
	
	/**
	 * This method initializes jMenuItem2 about Snake Color
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Change Snake Color");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					snakecolor();
				}
			});
		}
		return jMenuItem2;
	}
	
	/**
	 * This method initializes jMenuItem3 about Wall Color
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Change Wall Color");
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					wallcolor();
				}
			});
		}
		return jMenuItem3;
	}
	
	/**
	 * This method initializes jMenuItem4 about Head Color
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4= new JMenuItem();
			jMenuItem4.setText("Change Head Color");
			jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					headcolor ();
				}
			});
		}
		return jMenuItem4;
	}

	/**
	 * This method initializes jMenuItem5 about Background Color
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5= new JMenuItem();
			jMenuItem5.setText("Change Background Color");
			jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					backgroundcolor ();
				}
			});
		}
		return jMenuItem5;
	}
	
	/**
	 * This method initializes jMenuItem6 about Food Color
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem6() {
		if (jMenuItem6 == null) {
			jMenuItem6= new JMenuItem();
			jMenuItem6.setText("Change Food Color");
			jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					foodcolor ();
				}
			});
		}
		return jMenuItem6;
	}
	
	/**
	 * This method initializes jMenuItem7 about Exit
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7= new JMenuItem();
			jMenuItem7.setText("Exit");
			jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Snake.run = false;
					try {
						Game.sleep();
					} catch (final InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int xa = 0;
					xa = JOptionPane.showConfirmDialog(null, "Do you really want to abort this game?", "Exit", DISPOSE_ON_CLOSE, 2);
					
					if (xa == 0){
					   dispose();
					   System.exit(0);
					}
					else { 
						Game.begin();
					}
					
				}
			});
		}
		return jMenuItem7;
	}
	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 600); // size of the window-before: (304, 507)
		setResizable(false);
		setJMenuBar(getJJMenuBar());
		setTitle("SuperSnake");
	}

	public void openmap() {
		final Map mymap = new Map();
		mymap.setModal(true);
		mymap.setVisible(true);
	}

	public void openspeed() {
		final Speed myspeed = new Speed();
		myspeed.setModal(true);
		myspeed.setVisible(true);
	}
	
	public void snakecolor() {
		final SetSnakeColor mysnakecolor = new SetSnakeColor();
		mysnakecolor.setModal(true);
		mysnakecolor.setVisible(true);
			
	}
	
	public void wallcolor() {
		final SetWallColor mywallcolor = new SetWallColor();
		mywallcolor.setModal(true);
		mywallcolor.setVisible(true);
			
	}
	
	public void headcolor() {
		final SetHeadColor myheadcolor = new SetHeadColor();
		myheadcolor.setModal(true);
		myheadcolor.setVisible(true);
			
	}
	
	public void backgroundcolor() {
		final SetBackgroundColor mybackgroundcolor = new SetBackgroundColor();
		mybackgroundcolor.setModal(true);
		mybackgroundcolor.setVisible(true);
			
	}
	
	public void foodcolor() {
		final SetFoodColor myfoodcolor = new SetFoodColor();
		myfoodcolor.setModal(true);
		myfoodcolor.setVisible(true);
			
	}
	
} // @jve:decl-index=0:visual-constraint="10,10"

