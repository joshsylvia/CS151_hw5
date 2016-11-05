
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connect4GUI extends JFrame implements Runnable {
	boolean isBlue;
	Connect4Controller control;
	Thread thread1 = new Thread(this, "Thread 1");
	protected static JPanel winner;
	Font font1 = new Font("SansSerif", Font.BOLD, 20);


	/*
	 * Connect4GUI constructor
	 * @param x set size and y sets size of win
	 */	 
	public Connect4GUI(int size, int win) {
		isBlue = true;
		control = new Connect4Controller(size, win);
		showGUI();
	}

	/*
	 * Connect4GUI default constructor
	 */	
	public Connect4GUI() {
	}

	/*
	 * showGUI draws and displays the board.
	 * @return void
	 */
	private void showGUI() {

		JFrame theFrame = new JFrame("Connect 4");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());

		JPanel gamePane = control.layout();
		winner = control.status();

		theFrame.add(gamePane, BorderLayout.CENTER);
		theFrame.add(winner, BorderLayout.SOUTH);
		theFrame.setSize(600, 500);
		theFrame.setVisible(true);	
	}

	/*
	 * updates the board, when the game is over
	 * @return void
	 */
	public void updateUI() {
		Connect4GUI.winner.removeAll();
		JTextField text = new JTextField("Congradulations! You won!");
		text.setSelectedTextColor(Color.BLACK);
		text.setPreferredSize(new Dimension(280, 100));
		text.setFont(font1);

		winner.add(text);
		thread1.start();
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (isBlue){
				winner.setBackground(Color.blue);
				isBlue = false ;
			}else{
				isBlue = true ;
				winner.setBackground(Color.red);
				
			}
		}
		System.out.println("inside run!");	
	}

}

