
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connect4GUI extends JFrame  {
	private int size;
	Connect4Controller control;
	static JPanel winner;
	
	//consructor
	public Connect4GUI(int bsize, int win) {
		size = bsize;
		control = new Connect4Controller(bsize, win);
		showGUI();
	}

   //empty constructor
	public Connect4GUI() {
		
	}
	
	/*
	 * draws and displays the board.
	 * @return void
	 */
	private void showGUI() {

		JFrame theFrame = new JFrame("Connect 4");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
//		JPanel title = new JPanel(new GridLayout(1,size));

		JPanel gamePane = control.layout();
        
        winner = control.winner();
                        
//		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(gamePane, BorderLayout.CENTER);
		theFrame.add(winner, BorderLayout.SOUTH);
		//theFrame.pack();
		theFrame.setSize(600, 500);
		theFrame.setVisible(true);	
	
	}

	/*
	 * updates the board, when the game is over
	 * @return void
	 */
	public void updateUI() {
		
		Connect4GUI.winner.removeAll();
		JTextField text = new JTextField("Game Over! you won!");
		text.setSelectedTextColor(Color.BLACK);
		
		Connect4GUI.winner.add(text);
		
	}
	
}

