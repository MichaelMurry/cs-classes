public class Board {
	// construct a board from an n-by-n array of blocks
	public Board(int[][] blocks) {}

	// board dimension n
	public int dimension() {}

	// number of blocks out of place
	public int hamming() {}

	// sum of Manhattan distances between blocks and goal
	public int manhattan() {}

	// is this board the goal board?
	public boolean isGoal() {}

	// a board that is obtained by exchanging any pair of blocks
	public Board twin() {}

	// does this board equal y?
	public boolean equals(Object y) {}

	// all neighboring boards
	public Iterable<Board> neighbors() {}

	// string representation of the board 
	public String toString() {}

	// unit tests
	public static void main(String[] args)
}