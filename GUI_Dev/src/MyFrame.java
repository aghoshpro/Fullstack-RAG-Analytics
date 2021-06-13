import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyFrame extends JFrame implements ActionListener{  // Child class "MyFrame" call Parent class "JFrame"
	
	/** My Frame
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	JButton button;
	JLabel label;
	
	/**
	 * 
	 */
	MyFrame(){   // Constructor
		
		ImageIcon img2 = new ImageIcon("click me.png");
		ImageIcon img3 = new ImageIcon("logo.png");
		
		// JButton = a java GUI component that functions when clicked on
		
	    button = new JButton();
		button.setBounds(180, 180,100, 100); // button size (x,y,width, height)
		button.addActionListener(this);
		button.setText("Click me !");
		button.setFocusable(false);   // Remove the box  around the button text
		button.setIcon(img2);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setBackground(Color.red);
		button.setFont(new Font("Adobe Devanagari", Font.BOLD, 17)); // Set font style
		button.setIconTextGap(10); 
		button.setBorder(BorderFactory.createEtchedBorder()); // 3D Style border
		
		//button.setEnabled(false); // to disable the button
		
		// JLabel = add text, images in GUI window 
		
		label = new JLabel();
		label.setIcon(img3);
		label.setBounds(150,300,150, 150);
		label.setVisible(false);
		
		
		// JFrame --------------------------------------------------------------------------------
		this.setTitle("Arka's GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application after close
		this.setResizable(true);   // Prevent this from being resized if false
		this.setSize(500, 500);    // set x-dim and y-dim of the window
		this.setLayout(null);      // allows manual placement of components if NULL
		this.add(button);
		this.add(label);
		this.setVisible(true);     // To show the window
		
		
		ImageIcon img = new ImageIcon("among-us-player-pink-512.png"); // Create a image icon
		this.setIconImage(img.getImage());  // Change icon of the this 

		//this.getContentPane().setBackground(new Color(255,0,65)); // set Background RGB color of window  
		this.getContentPane().setBackground(new Color(0xffe06e)); // set Background HEX color of window  

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== button) {
			System.out.println("I am clicked :)");
			//button.setEnabled(false); // to disable the button after one click
			label.setVisible(true);
		}
		
	}
}
