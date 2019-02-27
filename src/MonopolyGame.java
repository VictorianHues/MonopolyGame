public class MonopolyGame {
    private MonopolyBoard TheBoard;
	private Dice D = new Dice();

	public void play(int playerNum) {
		System.out.println("\tMonopolymorphism\n");

		TheBoard = new MonopolyBoard(playerNum);

		while (!TheBoard.hasWinner()) {
            try {
                TheBoard.movePlayer(TheBoard.getCurrentPlayer(), D.roll());
                TheBoard.nextTurn();
            } catch (BankruptException e) {
                System.out.println(TheBoard.findWinner() + " is the WINNER");
            }
        }
	}


}
