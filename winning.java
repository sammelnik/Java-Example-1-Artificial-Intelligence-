import aima.core.search.framework.GoalTest;

public class winning implements GoalTest {
	//board goal = new board();

	public boolean isGoalState(Object state) {
		board board = (board) state;
		//System.out.println("Checking WINNER  " + board.toString() + "  "
		//		+ board.checkWinner());
		return board.checkWinner();//Compares the current state to goal state.
	}
}