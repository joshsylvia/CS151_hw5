import javax.swing.JTextField;

public class CheckPosition {
	private int a[][];
	private int size;
	private int winner;
	private boolean won;
	Connect4GUI connect = new Connect4GUI();

	//constructor
	public CheckPosition(int x, int y) {
		a = new int[x][x];
		size = x;
		winner = y;
		won = false;
	}
	
	public void add(int x, int y, boolean player) {
		int play = player?1:2;
		a[x][y] = play;
	}
	
	public boolean checkWinner() {
		checkWinRow();
		checkWinColumn();
		checkWinDiag();
		if (won) {
			//update UI triggers from here
			System.out.println("Player won");
			connect.updateUI();
//			Connect4GUI.winner.removeAll();
//			Connect4GUI.winner.add(new JTextField("Game Over! you won!"));
		}
		return won;
	}
	
	
	/*
	 * check for winning by row
	 * @return void
	 */
	private void checkWinRow() {
		
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size-1; j++) {
				if (a[i][j] == a[i][j+1]) {
					if (a[i][j] != 0) {
						count++;
						if (count == winner-1) won = true;
					}
				}
			} 
			count = 0;
		}
		
	}
	
	/*
	 * check for winning by coloumn
	 * @return void
	 */
	private void checkWinColumn() {
		
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size-1; j++) {
				if (a[j][i] == a[j+1][i]) {
					if (a[j][i] != 0) {
						count++;
						if (count == winner-1) won = true;
					}
				}
			} 
			count = 0;
		}
				
	}
	
	/*
	 * check for winning by diagonal
	 * @return void
	 */
	private void checkWinDiag() {
		
		int count = 0;
		for (int i = 0; i < size-1; i++) {
			for (int j = 0; j < size-1; j++) {
				
				if (a[i][j] == a[i+1][j+1]) {
					if (a[i][j] != 0) {
						count++;
						if (count == winner-1) won = true;
					} //end if
				} //end if
			} // end j
//			count = 0;
		}
		
		/*
		count = 0;
		for (int i = size; i > 1; i--) {
			for (int j = size; j > 1; j--) {
				if (a[i][j] == a[i-1][j-1]) {
					if (a[i][j] != 0) {
						count++;
						if (count == winner-1) won = true;
					}
				}
			} 
			count = 0;
		}
		*/
	}
}
