public class Game {
	public DictionaryInterface<Board, Move> dictionary;
	
	public Game() {
		dictionary = new HashedDictionary<Board, Move>();
		generateAllPossibleBoards(new Board());
	}

	public void generateAllPossibleBoards(Board b){
		if(!(b.checkP().equals("Game is in progress")))
			return;
		if(dictionary.contains(b))
			return;
		if(b.availableMove().size() == 0)
			return;
		dictionary.add(b, getBestMove(b));
		for(Move m : b.availableMove()) {
			Board newBoard = new Board(b);
			newBoard.play(m);
			generateAllPossibleBoards(newBoard);
		}
	}

	private Move getBestMove(Board b) {
		char[][] board = b.getBoard();
		if(checkBestMove(board, 'O') != null) {
			return checkBestMove(board, 'O');
		}
		else if(GameInteraction.count == 0 && checkC(board) != null && board[1][1] == '-') {
				return new Move(1, 1);
		}
		else if(checkBestMove(board, 'X') != null) {
			return checkBestMove(board, 'X');
		}
		else if(checkC(board) != null)
			return checkC(board);
		return b.availableMove().get(0);
	}

	private Move checkBestMove(char[][] b, char player) {
		for(int i = 0; i<3; i++) {
			if(b[i][0] == player && b[i][1] == player && b[i][2] == '-') {
				return new Move(i, 2);
			}
			if(b[i][0] == player && b[i][2] == player && b[i][1] == '-') {
				return new Move(i, 1);
			}
			if(b[i][1] == player && b[i][2] == player && b[i][0] == '-') {
				return new Move(i, 0);
			}
			if(b[0][i] == player && b[1][i] == player && b[2][i] == '-') {
				return new Move(2, i);
			}
			if(b[0][i] == player && b[2][i] == player && b[1][i] == '-') {
				return new Move(1, i);
			}
			if(b[1][i] == player && b[2][i] == player && b[0][i] == '-') {
				return new Move(0, i);
			}
		}
		if(b[0][0] == player && b[1][1] == player && b[2][2] == '-') {
			return new Move(2, 2);
		}
		if(b[0][0] == player && b[2][2] == player && b[1][1] == '-') {
			return new Move(1, 1);
		}
		if(b[1][1] == player && b[2][2] == player && b[0][0] == '-') {
			return new Move(0, 0);
		}
		if(b[0][2] == player && b[1][1] == player && b[2][0] == '-') {
			return new Move(2, 0);
		}
		if(b[0][2] == player && b[2][0] == player && b[1][1] == '-') {
			return new Move(1, 1);
		}
		if(b[1][1] == player && b[2][0] == player && b[0][2] == '-') {
			return new Move(0, 2);
		}
		return null;
	}

	private Move checkC(char[][] b) {
		if(b[0][0] == '-') {
			return new Move(0,0);
		}
		if(b[0][2] == '-') {
			return new Move(0,2);
		}
		if(b[2][0] == '-') {
			return new Move(2,0);
		}
		if(b[2][2] == '-') {
			return new Move(2,2);
		}
		return null;
	}	
}
