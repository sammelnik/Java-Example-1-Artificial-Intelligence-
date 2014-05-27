import aima.core.search.framework.HeuristicFunction;

/*
 * CALCULATES THE HEURISTIC
 */
public class Function implements HeuristicFunction {

	public double h(Object state) {
		board board = (board) state;// get board
		int retVal = 0; // store value to return
		retVal = findB(board) + findR(board);// functions to get the heuristic
		return retVal;

	}

	/*
	 * finds all the values of R
	 */
	private int findR(board board) {
		int storeValue = 0;
		int[] rPos = { 0, 0, 0 }; // Array stores the position of R
		int position = 0;
		for (int i = 6; i >= 0; i--) {// finds all the R's
			if (board.board[i].equals("R")) {
				rPos[position] = i;
				position = position + 1;
			}
		}
		storeValue = rPos[0] - 6 + (rPos[1] - 5) + (rPos[2] - 4);// calculates
																	// the
																	// distance
		storeValue = Math.abs(storeValue);// converts to positive nubmer
		return storeValue;
	}

	/*
	 * finds all the values of B
	 */
	private int findB(board board) {
		int storeValue = 0;
		int[] rPos = { 0, 0, 0 };// array to store position of B's
		int position = 0;
		for (int i = 0; i < 7; i++) {// loop through values
			if (board.board[i].equals("B")) {
				rPos[position] = i;
				position = position + 1;
			}
		}
		// System.out.println(rPos[0] + " " + rPos[1] + " " + rPos[2]);
		storeValue = rPos[0] + (rPos[1] - 1) + (rPos[2] - 2);// calculate the
																// distance
		return storeValue;
	}
}
