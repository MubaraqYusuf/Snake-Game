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
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SetBackgroundColor extends JDialog{
	
	/**
	 * This class extends JDialog and appears a color selector 
	 * User picks the color he wants to add for background
	 */
	
	private static final long serialVersionUID = 1L;
	
	//initialize BackgroundColor
	static Color BackgroundColor = Color.WHITE;
	
	Color selectedcolor = null;
	
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JLabel jLabel = null;

	/**
	 * @param mouseAdapter
	 */
	public SetBackgroundColor() {
		super();
		initialize();
	}
	
	/**
	 * <<<<<<< Choice.java This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(82, 48, 100, 30));
			jButton.setText("Enter");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(final java.awt.event.ActionEvent e) {
					Game.begin();
					dispose();
				}
			});
		}
		return jButton;
	}
	
	//presents the color selector
	public JPanel getJContentPane() { 
		if (jContentPane == null) {
			selectedcolor = JColorChooser.showDialog(null, "Change Background Color", BackgroundColor);
			
			//get the selected color
			if (selectedcolor != null) {
		    	BackgroundColor = selectedcolor;
			    jLabel = new JLabel();
			    jLabel.setBounds(new Rectangle(22, 10, 250, 30));
			    jLabel.setText("Press Enter to play with the new color!!"); }
			
			//if no color has been selected
			else {		   
		    	jLabel = new JLabel();
			    jLabel.setBounds(new Rectangle(22, 10, 250, 30));
			    jLabel.setText("Press Enter to play with the previous color!!");
			}
			
			jContentPane = new JPanel();
		    jContentPane.setLayout(null);
		   	jContentPane.add(getJButton(), null);
			jContentPane.add(jLabel, null);
	    }
	    
        return jContentPane;
       
	   }
	
	  /**
	   * This method initializes this
	   * 
	   * @return void
	   */  
	   private void initialize() {
			this.setSize(295, 125);
			setTitle("Change Background Color");
			this.setLocation(500, 380);
			setContentPane(getJContentPane());
	   }
	  
}

	





