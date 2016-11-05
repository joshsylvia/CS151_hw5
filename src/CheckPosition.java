import javax.swing.JTextField;

public class CheckPosition {
	private int a[][];
	private int size;
	private int winner;
	private boolean won;
	Connect4Controller controller = new Connect4Controller();

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
			controller.updateUI();
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
	    int countA, countB;
	    countA = countB = 0;
	
		for(int i = 0; i <= size - winner; i++){
		    int row, col;
		    for( row = i, col = 0; row < size && col < size; row++, col++ ){
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++; 
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner)  won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    }
		}
		
		for(int  i = 1; i <= size - winner; i++){
		    int row, col;
		    for( row = 0, col = i; row < size && col < size; row++, col++ ) {
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++;
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner) won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    } 
		} 
	
		for(int i = size-1; i >= winner-1; i--){	
		    int row, col;
		    for( row = i, col = 0; row > 0 && col < size; row--, col++){
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++; 
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner)  won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    }
		}

		for(int  i = 1; i <= size-winner; i++){
		    int row, col;
		    for( row = size-1, col = i; row > 0 && col < size; row--, col++) {
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++;
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner) won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    } 
		} 
		
	} 
}
