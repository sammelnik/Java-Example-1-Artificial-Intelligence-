Sam Melnik	

How to Run the file:
	In order to run this code the aims core jar file needs to be imported.
	There are six java files that are used.
	board.java - is the object that stores the pieces.  can always for movement on the board.
	PuzzleFactory.java -  controls the actions taken and moves the pieces during the search
	winning.java	- is the goal test object
	Functions.java - is the heuristics I chose for the class.
	gameBoard.java - the driver and interface for the project.
	cost.java - provides the cost of each move.

Interface:   
	When the program starts up the top line states the start time. 	
	This is what it looks like:
		"B B R B R R   <----Start State
		Please enter a Value
		Enter "A" for Astar.
		Enter "B" for BFS.
		Enter "N" for a new test.
		Enter "Q" to quit. "
	A and B are used to generate the A* and BFS search.
	N is for a new puzzle. 
	and Q is to quit.

	When running the program  this is the sequence of user input needed to run three puzzles.  
	A,B,N,A,B,N,A,B 

Moves:
	There are a possibility of 6 moves that can happen
	They are:
		Move Left - space moves to the left
		Move Right - space moves to the right
		Move 2 to the Right - item two spots to the left of the space swaps with the space
		Move 2 to the Left - item two spots to the right of the space swaps with the space
		Move 3 to the Right - item three spots to the left of the space swaps with the space
		Move 3 to the Left - item three spots to the right of the space swaps with the space