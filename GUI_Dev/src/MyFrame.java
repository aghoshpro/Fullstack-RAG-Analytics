import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MyFrame extends JFrame{  // Child class "MyFrame" call Parent class "JFrame"
	
	MyFrame(){   // Constructor
		
		this.setTitle("Arka's GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application after close
		this.setResizable(true);  // Prevent this from being resized if false
		this.setSize(420, 420);    // set x-dim and y-dim of the window
		this.setVisible(true);     // To show the window
		
		ImageIcon img = new ImageIcon("among-us-player-pink-512.png"); // Create a image icon
		this.setIconImage(img.getImage());  // Change icon of the this 

		//this.getContentPane().setBackground(new Color(255,0,65)); // set Background RGB color of window  
		this.getContentPane().setBackground(new Color(0xffe06e)); // set Background HEX color of window  

		
	}
}
