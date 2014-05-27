import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import aima.core.agent.Action;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.*;

/**
 * 
 */

/**
 * @author sammelnik
 * 
 */
public class gameBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		userInterface(); // calls the user interface
	}

	private static void userInterface() {
		System.out.println("HW 1 Sam Melnik 652620936");
		String input = ""; // user input
		board x = new board();// creates the board
		x.generate(); // generates a random board
		String[] run; // array to store the board
		Scanner user_input = new Scanner(System.in);
		while (true) {
			run = x.board; // copy the board to the temp var
			System.out.println(x + " <----Start State");
			instructions();
			input = user_input.next();// get user input
			if (input.equalsIgnoreCase("q")) {
				System.exit(0);
			} else if (input.equalsIgnoreCase("A")) {
				x.board = run; // copy generated board
				aStar(x);// run search
			} else if (input.equalsIgnoreCase("B")) {
				x.board = run;// copy generated board
				BFS(x); // run search
			} else if (input.equalsIgnoreCase("n")) {
				x.generate();// generate new board
				run = x.board;// copy board to array
			}
		}
	}

	private static void instructions() {
		System.out
				.println("Please enter a Value\nEnter \"A\" for Astar.\nEnter \"B\" for BFS.\nEnter \"N\" for a new test.\nEnter \"Q\" to quit. ");

	}

	public static void aStar(board x) {
		System.out.println("\n Astar (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(x,
					PuzzleFactory.getActionsFunction(),
					PuzzleFactory.getResultFunction(), new winning(),
					new cost());
			Search search = new AStarSearch(new TreeSearch(), new Function());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void BFS(board x) {
		System.out
				.println("\nGreedy Best First Search (ManhattanHeursitic)-->");
		try {
			Problem problem = new Problem(x,
					PuzzleFactory.getActionsFunction(),
					PuzzleFactory.getResultFunction(), new winning(),
					new cost());
			Search search = new BreadthFirstSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}
	}
}
