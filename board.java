import java.util.Arrays;
import java.util.Random;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

class board {
	public String[] board = new String[7];
	public int moves;
	public Action left = new DynamicAction("left");
	public Action right = new DynamicAction("right");
	public Action left2 = new DynamicAction("Left2");
	public Action left3 = new DynamicAction("Left3");
	public Action right2 = new DynamicAction("Right2");
	public Action right3 = new DynamicAction("Right3");

	board() {
		//placePieces();
	}

	public board(board newBoard) {
		// super();

		this.moves = newBoard.moves;
		this.board = new String[7];
		for (int i = 0; i < 7; i++) {
			this.board[i] = newBoard.board[i];
		}
		//System.out.println("OLD  " + this.toString());
		//System.out.println("NEW  " + newBoard.toString());
	}

	int getInt() {
		return moves;
	}

	void moveRight(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 0 && pos <= 5) {
				String temp = board[pos];
				board[pos] = board[pos + 1];
				board[pos + 1] = temp;
				moves++;
			}
		}
	}

	void moveLeft(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 1 && pos <= 6) {
				String temp = board[pos];
				board[pos] = board[pos - 1];
				board[pos - 1] = temp;
				moves++;
			}
		}
	}

	boolean check2Left(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 2 && pos <= 6) {
				if (board[pos - 2].equals(" ")) {
					return true;
				}
			}
		}
		return false;
	}

	boolean check3Left(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 3 && pos <= 6) {
				if (board[pos - 3].equals(" ")) {
					return true;
				}
			}
		}
		return false;
	}

	boolean check2Right(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 0 && pos <= 4) {
				if (board[pos + 2].equals(" ")) {
					return true;
				}
			}
		}
		return false;
	}

	boolean check3Right(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 0 && pos <= 3) {
				if (board[pos + 3].equals(" ")) {
					return true;
				}
			}
		}
		return false;
	}

	void move2Left(int pos) {
		if (check2Left(pos)) {
			String temp = board[pos];
			board[pos] = board[pos - 2];
			board[pos - 2] = temp;
			moves = moves + 2;
		}
	}

	void move3Left(int pos) {
		if (check3Left(pos)) {
			String temp = board[pos];
			board[pos] = board[pos - 3];
			board[pos - 3] = temp;
			moves = moves + 3;
		}
	}

	void move2Right(int pos) {
		if (check2Right(pos)) {
			String temp = board[pos];
			board[pos] = board[pos + 2];
			board[pos + 2] = temp;
			moves = moves + 2;
		}
	}

	void move3Right(int pos) {
		if (check3Right(pos)) {
			String temp = board[pos];
			board[pos] = board[pos + 3];
			board[pos + 3] = temp;
			moves = moves + 3;
		}
	}

	boolean checkright(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 0 && pos <= 5) {
				return true;
			}
		}
		return false;
	}

	boolean checkleft(int pos) {
		if (pos >= 0 && pos <= 6) {
			if (pos >= 1 && pos <= 6) {
				return true;
			}
		}
		return false;
	}

	void generate() {
		placePieces();
		Random rnd = new Random();
		for (int i = board.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			String a = board[index];
			board[index] = board[i];
			board[i] = a;
		}
	}

	int findSpace() {
		for (int i = 0; i < board.length; i++) {
			if (board[i].equals(" ")) {
				return i;
			}
		}
		return 0;
	}

	public String toString() {
		return board[0] + " " + board[1] + " " + board[2] + " " + board[3]
				+ " " + board[4] + " " + board[5] + " " + board[6];
	}

	void placePieces() {
		board[0] = "R";
		board[1] = "R";
		board[2] = "R";
		board[3] = " ";
		board[4] = "B";
		board[5] = "B";
		board[6] = "B";
	}

	void simple() {
		board[0] = "B";
		board[1] = "B";
		board[2] = "R";
		board[3] = " ";
		board[4] = "B";
		board[5] = "R";
		board[6] = "R";
	}

	boolean checkWinner() {
		String goal[] = { "B", "B", "B", " ", "R", "R", "R" };
		//System.out.println("Board " + this.toString());
		if (Arrays.equals(board, goal)) {
			//System.out.println("TRUE");
			return true;
		}
		//System.out.println("FALSE");
		return false;
	}
}