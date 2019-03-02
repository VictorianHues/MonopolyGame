public class MonopolyGame {
    private MonopolyBoard TheBoard;
	private Dice D = new Dice();

	public void play(int playerNum) {
		System.out.println("\tMonopolymorphism\n");

		TheBoard = new MonopolyBoard(playerNum);
        System.out.println("Board Built");
		while (!TheBoard.hasWinner()) {
            try {
                System.out.println("~~~~~~~~~~" + TheBoard.getCurrentPlayer().getName() + "'s Turn~~~~~~~~~~");
                System.out.println("~~~~~~~~~~(Bal:" + TheBoard.getCurrentPlayer().getBankAccount() +
                        " Props:" + TheBoard.getCurrentPlayer().getProperties()+ ")~~~~~~~~~~");
                TheBoard.movePlayer(TheBoard.getCurrentPlayer(), D.roll());
                TheBoard.nextTurn();
            } catch (BankruptException e) {
                System.out.println(TheBoard.findWinner().getName() + " is the WINNER");
            }
       }
	}


}
