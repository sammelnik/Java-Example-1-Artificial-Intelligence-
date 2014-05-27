import aima.core.agent.Action;
import aima.core.search.framework.StepCostFunction;

/*
 *FIND THE COST 
 */
public class cost implements StepCostFunction {

	public double c(Object s, Action a, Object sDelta) {
		board board = (board) s;
		// board deltaBoard = (board) sDelta;
		if (board.left.equals(a)) {	//finds the value of the action and returns the cost of each move
			// System.out.println("1");
			return 1;
		} else if (board.left2.equals(a)) {
			// System.out.println("2");
			return 2;
		} else if (board.left3.equals(a)) {
			// System.out.println("2");
			return 3;
		} else if (board.right.equals(a)) {
			// System.out.println("1");
			return 1;
		} else if (board.right2.equals(a)) {
			// System.out.println("2");
			return 2;
		} else if (board.right3.equals(a)) {
			// System.out.println("3");
			return 3;
		}
		return 1;
	}

}
