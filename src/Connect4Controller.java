
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connect4Controller implements ActionListener {
	
	protected static JButton b[][];
	CheckPosition model;
	private int size;
	private boolean player1;
	boolean isOdd = true;
	private boolean validMove;
	Connect4GUI view = new Connect4GUI();

	/*
	 * Connect4Controller constructor
	 * @param x set size and y sets size of win
	 */
	public Connect4Controller(int size, int win) {
		model = new CheckPosition(size, win);
		this.size = size; 
		b = new JButton[size][size];
		player1 = true;
	}
	
	/*
	 * CheckPosition constructor
	 */
	public Connect4Controller() {
	}

	/*
	 * returns a JPanel to be used by the game as the game panel with the buttons
	 * @param none
	 * @return JPanel
	 */
	public JPanel layout() {
		JPanel n = new JPanel(new GridLayout(size,size));
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				b[i][j]= new JButton("");
				b[i][j].setActionCommand("" + count);					
				b[i][j].addActionListener(this);
				n.add(b[i][j]);
				count++;
				}
			}
		return n;
	}
	
	/*
	 * required method since the class implements action listener
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton b = (JButton) ae.getSource();
		if(isOdd){
			b.setForeground(Color.BLUE);
			isOdd = false;
		}else{
			b.setForeground(Color.RED);
			isOdd = true;
		}
		String position = ae.getActionCommand();
		int pos = Integer.valueOf(position);
		dropPiece(pos);
	}
	
	/*
	 * dropPiece will allow a move if valid.
	 * @param is position of selected mouse click 
	 * @return void
	 */	
	private void dropPiece(int pos) {
		int row = (pos)/ size;
		int column = pos % size;
		
		int move = checkRow(row, column);
		if (validMove) {
			if (player1) {
				b[move][column].setText("A");
				player1 = false;
			} else {
				b[move][column].setText("B");
				player1 = true;
			}
		validMove = false;
		}
		model.add(move, column, player1);
		model.checkWinner();

	}
	
	/*
	 * checkRow will check the next valid move in a column
	 * @param is position of selected mouse click 
	 * @return void
	 */	
	private int checkRow(int row, int col) {
		int r = 0; 
		for (int i = 0; i < size; i++) {
			if (!b[i][col].getText().equals("A") && !b[i][col].getText().equals("B")) {
				r = i;
				validMove = true;
			}
		}
		return r;
	}
	
	/*
	 * status returns the current status of the game.
	 * @param none
	 * @return JPanel
	 */
	public JPanel status() {
		JPanel win = new JPanel(new FlowLayout());
		JLabel status = new JLabel("");
		status.setText("GAMEOVER? false");
		win.add(status);	
		return win;
	}

	/*
	 * Updates User Interface
	 * @param none
	 */
	public void updateUI() {
		view.updateUI();
	}
}
