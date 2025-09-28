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
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//*********************************************************
//----------------

//	Developed by Jack Fate.
//	Copyright 2008 Jack Fate(ZhanKaijie).
//	Some rights reserved.

//	You aren't allowed to remove the Copyright!
//------------------

//	For the full GPL please read "COPYING.txt"
//------------------

//	This program is free software: you can redistribute it and/or modify
//	it under the terms of the GNU General Public License as published by
//	the Free Software Foundation, either version 3 of the License, or
//	(at your option) any later version.

//	This program is distributed in the hope that it will be useful,
//	but WITHOUT ANY WARRANTY; without even the implied warranty of
//	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//	GNU General Public License for more details.

//	You should have received a copy of the GNU General Public License
//	along with this program.  If not, see <http://www.gnu.org/licenses/>.

//------------------
//
//*********************************************************

/**
 * 
 */

/**
 * @author Jack Fate
 * 
 */
public class Map extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JRadioButton jRadioButton4 = null;

	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;

	private JButton jButton = null;
	private final ButtonGroup g = new ButtonGroup(); // @jve:decl-index=0:
	private boolean noWall = true;
	private boolean wall = false;
	private boolean roadWall = false;
	
	// declare 2 new maps
	private boolean RoundAndRound = false;
	private boolean SSSuperRoad = false;
	Oursnake oursnake;
	
	//initialize map
	static int map = 1;

	/**
	 * @param owner
	 */
	public Map() {
		super();
		initialize();
	}
	
    /** 
     * Get map choice: "e" for  noWall, "n" for wall, "h" for 
     * roadWall, "h2" for RoundAndRound, "h3" for SSSuperRoad 
     */
	public void getchoice(final boolean e, final boolean n, final boolean h, final boolean h2, final boolean h3) {
		if (e == true) {
			map = 1;
		}
		if (n == true) {
			map = 2;
		}
		if (h == true) {
			map = 3;
		}
		if (h2 == true) {
			map = 4;
		}
		if (h3 == true) {
			map = 5;
		}

	}
	/**
	 * <<<<<<< Choice.java This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */	
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(260, 90, 120, 30));
			jButton.setText("Enter");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					getchoice(noWall, wall, roadWall, RoundAndRound, SSSuperRoad);
					Setdifficulce.checkmap();
					Game.begin();
					dispose();
				}
			});
		}
		return jButton;
	}
			

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(36, 30, 269, 18));
			jLabel.setText("RoadBlock And WallThrough");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(36, 60, 130, 18));
			jLabel1.setText("WallThrough");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(36, 90, 306, 18));
			jLabel2.setText("RoadBlock And No WallThrough");
			
			//declare a new jLabel for Round & Round
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(36, 120, 400, 18));
			jLabel3.setText("Round & Round");
			
			//declare a new jLabel for SSSuper Road
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(36, 150, 450, 18));
			jLabel4.setText("SSSuper Road");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJRadioButton(), null);
			jContentPane.add(getJRadioButton1(), null);
			jContentPane.add(getJRadioButton2(), null);
			
			//add a new JRadioButton for Round & Round
			jContentPane.add(getJRadioButton3(), null);
			
			//add a new JRadioButton for SSSuper Road
			jContentPane.add(getJRadioButton4(), null);
			
            jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			
			//add a new jLabel for Round & Round
			jContentPane.add(jLabel3, null);
			
			//add a new jLabel for SSSuper Road
			jContentPane.add(jLabel4, null);
			
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
	}


	/**
	 * This method initializes jRadioButton
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			g.add(jRadioButton);
			if (map == 1) {
				jRadioButton.setSelected(true);
			}
			jRadioButton.setBounds(new Rectangle(14, 30, 21, 21));
			jRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(final java.awt.event.ItemEvent e) {
					noWall = true;
					wall = false;
					roadWall = false;
					RoundAndRound = false;
					SSSuperRoad = false;
				}
			});
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			g.add(jRadioButton1);
			if (map == 2) {
				jRadioButton1.setSelected(true);
			}
			jRadioButton1.setBounds(new Rectangle(14, 60, 21, 21));
			jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(final java.awt.event.ItemEvent e) {
					noWall = false;
					wall = true;
					roadWall = false;
					RoundAndRound = false;
					SSSuperRoad = false;
				}
			});
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			g.add(jRadioButton2);
			if (map == 3) {
				jRadioButton2.setSelected(true);
			}
			jRadioButton2.setBounds(new Rectangle(14, 90, 21, 21));
			jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(final java.awt.event.ItemEvent e) {
					noWall = false;
					wall = false;
					roadWall = true;
					RoundAndRound = false;
					SSSuperRoad = false;
				}
			});
		}
		return jRadioButton2;
	}
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			g.add(jRadioButton3);
			if (map == 4) {
				jRadioButton3.setSelected(true);
			}
			jRadioButton3.setBounds(new Rectangle(14, 120, 21, 21));
			jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(final java.awt.event.ItemEvent e) {
					noWall = false;
					wall = false;
					roadWall = false;
					RoundAndRound = true;
					SSSuperRoad = false;
				}
			});
		}
		return jRadioButton3;
	}
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			g.add(jRadioButton4);
			if (map == 5) {
				jRadioButton4.setSelected(true);
			}
			jRadioButton4.setBounds(new Rectangle(14, 150, 21, 21));
			jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(final java.awt.event.ItemEvent e) {
					noWall = false;
					wall = false;
					roadWall = false;
					RoundAndRound = false;
					SSSuperRoad = true;
				}
			});
		}
		return jRadioButton4;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(420, 234);
		setTitle("Set Map");
		this.setLocation(450, 320);
		setContentPane(getJContentPane());
	}
} // @jve:decl-index=0:visual-constraint="10,10"

