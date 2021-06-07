import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class swingPanels {

	public static void main(String[] args) {
		
		// JPanel = a GUI component that functions as container to hold other component
		
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,150,150);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(150,0,150,150);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0,150,150,150);
		
		JPanel yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.yellow);
		yellowPanel.setBounds(150,150,150,150);
		
		
		
		
		
		
		
		
		
		// JFrame = GUI window to add components
		
		JFrame frame = new JFrame();
		frame.setTitle("Arka's GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application after close
		frame.setResizable(true);  // Prevent frame from being resized if false
		frame.setSize(420, 420);    // set x-dim and y-dim of the window
		frame.setLayout(null);      // allows manual placement of components if NULL
		frame.setVisible(true);     // To show the window
		
		frame.add(redPanel);
		frame.add(bluePanel); // MUST add the new component   
		frame.add(greenPanel);
		frame.add(yellowPanel);
		ImageIcon img = new ImageIcon("among-us-player-pink-512.png"); // Create a image icon
		frame.setIconImage(img.getImage());  // Change icon of the frame 

		//frame.getContentPane().setBackground(new Color(255,0,65)); // set Background RGB color of window  
		frame.getContentPane().setBackground(new Color(0x000000)); // set Background HEX color of window
		
	}

}
