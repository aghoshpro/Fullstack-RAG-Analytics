import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;	


public class swingGUI {

	public static void main(String[] args) {
		
		// Image 
		ImageIcon img = new ImageIcon("among-us-player-pink-512.png"); // Create a image icon
		ImageIcon img2 = new ImageIcon("Potter.png");
		Border border = BorderFactory.createLineBorder(Color.red, 10);
		
		// JLabel = add text, images in GUI window 

		JLabel label = new JLabel();   
		label.setText("Deathly Hallows");
		label.setIcon(img2);
		label.setHorizontalTextPosition(JLabel.CENTER);    // options: LEFT, RIGHT, CENTER of image icon
		label.setVerticalTextPosition(JLabel.BOTTOM);      // options: TOP, BOTTOM, CENTER of image icon
        label.setForeground(new Color(0x00a146));          // Set font color
        label.setFont(new Font("Adobe Devanagari", Font.BOLD, 20)); // Set font style
        label.setIconTextGap(20);      // Set text gap to image 
        		
        label.setBackground(Color.white); // Set background color
        label.setOpaque(true); // display bg color if true
        label.setBorder(border);
		
        label.setVerticalAlignment(JLabel.CENTER);   //set vertical position of icon+text within label area
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label area
		
        label.setBounds(100, 100, 250, 250); //x, y, width, height 
        
        
        // JFrame = GUI window to add components
		
		JFrame frame = new JFrame();
		frame.setTitle("Arka's GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application after close
		frame.setResizable(true);   // Prevent frame from being resized if false
		frame.setSize(500, 500);    // set (width, height) of the window w.r.to the screen
		frame.setLayout(null);      // set the default layout null and allows mannual layout using label
 		frame.setVisible(true);     // To show the window
		frame.setIconImage(img.getImage());  // Change icon of the frame 
		frame.add(label);           // Set add to display the text in GUI
		

		//frame.getContentPane().setBackground(new Color(255,0,65)); // set Background RGB color of window  
		frame.getContentPane().setBackground(new Color(0xffe06e)); // set Background HEX color of window  
      
		//frame.pack(); // pack all the exiting components in within the frame automatically and last use
		// ---------------------------------------- OR  --------------------------------------------
		
		//MyFrame myframe = new MyFrame();  // MyFrame is a Constructor
	}

}


