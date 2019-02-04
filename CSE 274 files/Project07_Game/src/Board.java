import java.util.ArrayList;

public class Board {
	private char[][] board;
	private char curPlayer;

	public Board() {
		board = new char[3][3];
		curPlayer = 'X';
		newBoard();
	}

	public Board(Board b) {
		board = new char[3][3];
		curPlayer = b.curPlayer;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) 
				board[i][j] = b.board[i][j];
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if(!toString().equals(other.toString()))
			return false;
		return true;
	}
	public char getCurrentPlayer() {
		return curPlayer;
	}
	private void newBoard() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) 
				board[i][j] = '-';
	}
	public String toString() {
		String s = "";
		s += "+---+---+---+          +----+----+----+\n";
		for (int i = 0; i < 3; i++) {
			s += "| ";
			for (int j = 0; j < 3; j++) {
				s += board[i][j] + " | ";
			}
			s += "         | ";
			int j = 0 ;
			for (; j < 3; j++) {
				if(board[i][j] == '-') {
					s += (i+1) + "" + (j+1);
				}
				else {
					s += "  ";
				}
				s += " | ";
			}
			s += "\n+---+---+---+          +----+----+----+\n";
		}
		return s;
	}
	public boolean isBoardFull() {
		boolean result = true;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == '-') 
					result =  false;
		return result;
	}

	public ArrayList<Move> availableMove() {
		ArrayList<Move> free = new ArrayList<>();
		for(int i = 0; i<3; i++)
			for(int j = 0; j<3; j++)
				if(board[i][j] == '-')
					free.add(new Move(i,j));
		return free;
	}
	public void play(Move m) {
		if(isValid(m)) {
			board[m.getX()][m.getY()] = curPlayer;
			curPlayer = curPlayer == 'O'? 'X' : 'O';
		}
		else
			System.out.println("Not valid");
	}
	public boolean isValid(Move m) {
		if(board[m.getX()][m.getY()] == '-') {
			return true;
		}
		return false;
	}

	public String isWin() {
		String s = "";
		if(
				(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
				|| (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
				|| (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
				|| (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
				|| (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
				|| (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
				|| (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
				|| (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')){
			s =  "X won the game";
			//			System.out.println("Human won the game");
		}
		else if (
				(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
				|| (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')
				|| (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')
				|| (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
				|| (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
				|| (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
				|| (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
				|| (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')){
			s = "O won the game";
			//			System.out.println("Computer wow the game");
		}
		return s;
	}

	public String checkP() {
		if(!(isWin().equals(""))) {
			return isWin();
		}		
		if((isWin().equals("")) && isBoardFull()) {
			return "Draw Game!";
		}
		return "Game is in progress";
	}

	public char[][] getBoard() {
		return board;
	}
}
