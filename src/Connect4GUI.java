
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connect4GUI extends JFrame implements Runnable {
	private int size;
	boolean isBlue = true;
	Connect4Controller control;
	Thread thread1 = new Thread(this, "Thread 1");
	Thread thread2 = new Thread(this, "Thread 2");
	static JPanel winner;
	Font font1 = new Font("SansSerif", Font.BOLD, 20);


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
		JTextField text = new JTextField("Congradulations! You won!");
		text.setSelectedTextColor(Color.BLACK);
		text.setPreferredSize(new Dimension(280, 100));
		text.setFont(font1);

		winner.add(text);
	
		thread1.start();
		//thread2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 100 ; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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

