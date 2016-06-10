//** This class packs the pong applet into a JFrame, giving it more security options and making it look nicer unlike Max's. **//

import java.awt.*;
import javax.swing.*;

public class MainPong extends JFrame {

	public static void main (String args[]) {
		//retrieve the local screen resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		final int screen_Width = dim.width;
		final int screen_Height = dim.height;

		//create a JFrame for the game to reside in
		JFrame frame = new JFrame();

		frame.setSize(screen_Width , screen_Height);

		//set properties for the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setLayout( null );

		frame.setVisible(true);


		//create a game instance
		Pong_Applet applet = new Pong_Applet();

		frame.add(applet);

		//Start the game!
		applet.init(screen_Width , screen_Height);
	}

}