import java.util.Scanner;

public class GameInteraction {
	public static int count = 0;
	public static void main(String[] args) {

		Board b = new Board();
		Game g = new Game();
		Scanner s = new Scanner(System.in);
		String userR = "Y";

		while(userR.equalsIgnoreCase("Y")) {
			b = new Board();
			count = 0;

			while(b.checkP().equals("Game is in progress")) {
				if(count %2 == 0) {
					System.out.println(b);
					//System.out.println("Here is available move:" + b.availableMove());
					System.out.println("For example, if you want to play at position 11\nPlease enter '11' below and press enter key");
					System.out.println("Where do you want to play?");
					int i = s.nextInt();
					Move m = new Move((i/10)-1, (i%10)-1);
					while(!b.isValid(m)) {
						System.out.println("Invalid Move! Try again...");
						i = s.nextInt();
						m = new Move((i/10)-1, (i%10)-1);
					}
					b.play(m);
				}
				else{
					System.out.println(b);
					b.play(g.dictionary.getValue(b));
				}
				count++;
			}
			System.out.println(b);
			System.out.println(b.checkP());
			System.out.println("Do you want to play another game? (Y/N)");
			userR = s.next();
		}
	}
}
