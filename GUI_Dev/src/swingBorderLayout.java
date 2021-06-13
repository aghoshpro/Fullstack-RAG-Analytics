import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class swingBorderLayout {

	public static void main(String[] args) {
		// Layout Manager = Defines the natural layout for components within a container
		
		// 3 common managers 
		
		// Border Layout = A BorderLayout places components in five areas -> NORTH, SOUTH, EAST, WEST & CENTER
		// All Extra Places are placed in central position
		
		// JPanel = a GUI component that functions as container to hold other component
		
				JPanel panel01 = new JPanel();
				JPanel panel02 = new JPanel();
				JPanel panel03 = new JPanel();
				JPanel panel04 = new JPanel();
				JPanel panel05 = new JPanel();
				
				panel01.setBackground(Color.red);
				panel02.setBackground(Color.green);
				panel03.setBackground(Color.yellow);
				panel04.setBackground(Color.pink);
				panel05.setBackground(Color.blue);
				
				panel01.setPreferredSize(new Dimension(100,100));
				panel02.setPreferredSize(new Dimension (100, 100));
				panel03.setPreferredSize(new Dimension(100,100));
				panel04.setPreferredSize(new Dimension (100, 100));
				panel05.setPreferredSize(new Dimension(100,100));
          
				// -------------- sub-panels ----------------------------
				JPanel panel06 = new JPanel();
				JPanel panel07 = new JPanel();
				JPanel panel08 = new JPanel();
				JPanel panel09 = new JPanel();
				JPanel panel10 = new JPanel();
				
				panel06.setBackground(Color.black);
				panel07.setBackground(Color.darkGray);
				panel08.setBackground(Color.gray);
				panel09.setBackground(Color.lightGray);
				panel10.setBackground(Color.white);
				
				panel05.setLayout(new BorderLayout(3,3));
				
				
				panel06.setPreferredSize(new Dimension(50,50));
				panel07.setPreferredSize(new Dimension (50,50));
				panel08.setPreferredSize(new Dimension(50,50));
				panel09.setPreferredSize(new Dimension (50,50));
				panel10.setPreferredSize(new Dimension(50,50));
          
				panel05.add(panel06, BorderLayout.NORTH);
				panel05.add(panel07, BorderLayout.WEST);
				panel05.add(panel08, BorderLayout.EAST);
				panel05.add(panel09, BorderLayout.SOUTH);
				panel05.add(panel10, BorderLayout.CENTER);
				
		// JFrame = GUI window to add components
		
				JFrame frame = new JFrame();
				frame.setTitle("Arka's GUI");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application after close
				frame.setSize(420, 420);    // set x-dim and y-dim of the window
				frame.setLayout(new BorderLayout(5, 5));      // Border with 5px margin on (width, height) 
				frame.setVisible(true);     // To show the window
				
				frame.add(panel01, BorderLayout.NORTH);
				frame.add(panel02, BorderLayout.WEST);
				frame.add(panel03, BorderLayout.EAST);
				frame.add(panel04, BorderLayout.SOUTH);
				frame.add(panel05, BorderLayout.CENTER);
			
				
   
	}

}
