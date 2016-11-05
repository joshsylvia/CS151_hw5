
public class CheckPosition {
	private int a[][];
	private int size;
	private int win;
	private boolean won;
	Connect4Controller controller = new Connect4Controller();

	/*
	 * CheckPosition constructor
	 * @param x set size and y sets size of win
	 */
	public CheckPosition(int size, int win) {
		a = new int[size][size];
		this.size = size;
		this.win = win;
		won = false;
	}
	
	/*
	 * add adds move to the winning board
	 * @param x and y selects position of player and player 
	 * sets position.
	 */
	public void add(int x, int y, boolean player) {
		int play = player?1:2;
		a[x][y] = play;
	}
	
	/*
	 * check for winning by row
	 * @return return
	 */
	public boolean checkWinner() {
		checkWinRow();
		checkWinColumn();
		checkWinDiag();
		if (won) {
			controller.updateUI();
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
						if (count == win-1) won = true;
					}
				}
			} 
			count = 0;
		}
	}
	
	/*
	 * check for winning by column
	 * @return void
	 */
	private void checkWinColumn() {
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size-1; j++) {
				if (a[j][i] == a[j+1][i]) {
					if (a[j][i] != 0) {
						count++;
						if (count == win-1) won = true;
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
	
		for(int i = 0; i <= size - win; i++){
		    int row, col;
		    for( row = i, col = 0; row < size && col < size; row++, col++ ){
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++; 
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= win || countB >= win)  won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    }
		}
		
		for(int  i = 1; i <= size - win; i++){
		    int row, col;
		    for( row = 0, col = i; row < size && col < size; row++, col++ ) {
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++;
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= win || countB >= win) won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    } 
		} 
	
		for(int i = size-1; i >= win-1; i--){	
		    int row, col;
		    for( row = i, col = 0; row > 0 && col < size; row--, col++){
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++; 
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= win || countB >= win)  won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    }
		}

		for(int  i = 1; i <= size-win; i++){
		    int row, col;
		    for( row = size-1, col = i; row > 0 && col < size; row--, col++) {
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++;
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= win || countB >= win) won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    } 
		} 
	} 
}
