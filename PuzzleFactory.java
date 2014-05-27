import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

/**
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public class PuzzleFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}

	/*
	 * finds all the actions
	 */
	private static class EPActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			board board = (board) state;
			Set<Action> actions = new LinkedHashSet<Action>();
			int space = board.findSpace();//checks if move is able to be done, then adds the action
			if (board.check3Left(space + 3)) {
				actions.add(board.left3);
				// System.out.println("Left 3");
			}
			if (board.check3Right(space - 3)) {
				actions.add(board.right3);
				// System.out.println("right 3");
			}
			if (board.checkleft(space + 1)) {
				actions.add(board.left);
				// System.out.println("Left");
			}
			if (board.checkright(space - 1)) {
				actions.add(board.right);
				// System.out.println("right");
			}

			if (board.check2Left(space + 2)) {
				actions.add(board.left2);
				// System.out.println("Left 2");
			}
			if (board.check2Right(space - 2)) {
				actions.add(board.right2);
				// System.out.println("right 2");
			}
			return actions;
		}
	}

	/*
	 * moves the pieces
	 */
	private static class EPResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			board board = (board) s;
			int space = board.findSpace();
			if (board.left.equals(a) && board.checkleft(space)) {//Performs the move.
				board newBoard = new board(board);
				newBoard.moveLeft(space);
				System.out.println(newBoard.toString());
				return newBoard;
			} else if (board.left2.equals(a) && board.check2Left(space + 2)) {
				board newBoard = new board(board);
				newBoard.move2Left(space + 2);
				System.out.println(newBoard.toString());
				return newBoard;
			} else if (board.left3.equals(a) && board.check3Left(space + 3)) {
				board newBoard = new board(board);
				newBoard.move3Left(space + 3);
				System.out.println(newBoard.toString());
				return newBoard;
			} else if (board.right.equals(a) && board.checkright(space)) {
				board newBoard = new board(board);
				newBoard.moveRight(space);
				System.out.println(newBoard.toString());
				return newBoard;
			} else if (board.right2.equals(a) && board.check2Right(space - 2)) {
				board newBoard = new board(board);
				newBoard.move2Right(space - 2);
				System.out.println(newBoard.toString());
				return newBoard;
			} else if (board.right3.equals(a) && board.check3Right(space - 3)) {
				board newBoard = new board(board);
				newBoard.move3Right(space - 3);
				System.out.println(newBoard.toString());
				return newBoard;
			}
			// System.out.println("NoOp");
			return s;
		}
	}
}