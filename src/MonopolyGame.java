public class MonopolyGame {
	private MonopolySquare[] board = new MonopolySquare[32];
	private LooseChange lc;
	private ChanceDeck chanceCardDeck;
	private int turn;
	private int playerNum;
	private int currentPropertyTracking = 0;
	private Player[] players;
	private static String[] colors = {"Purple","Purple","White","White","Magenta","Magenta","Orange",
			"Orange","Red","Red","Yellow","Yellow","Green","Green","Blue","Blue"};
	private static int[] costs = {1,1,2,2,3,3,4,4,5};
	private boolean endGame;
	private int currentPlayer = 0;


	public void play(int playerNum) {
		players = new Player[playerNum];
		this.playerNum = playerNum;

		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i,"Player " + (i + 1));
		}
		buildBoard();



		try {
			players[turn].movePlayer();
			board[players[turn].movePlayer()].landOn(players[turn], board);
			nextTurn();


		}
		catch (BankruptException e) {
			findWinner();
		}

		System.out.println("Playing game");  // remove this.
	}

	public void buildBoard() {

		for (int i = 0 ; i< 32 ; i++) {
			if (i==0){ // Go

			}
			else if (i == 1 || i == 4 || i == 9 || i == 17 || i == 20 || i == 25) { // Chance


			}
			else if (i == 5 || i == 13 || i == 21 || i == 29) { // Railroads


			}
			else if (i == 8 || i == 24){ // Fireworks or Watershow


			}
			else if (i == 10){ // Jail


			}
			else if (i == 16) { // Loose Change


			}
			else if (i == 26) { // Get out of Jail


			}
			else { // Properties. Iterates through two lists of colors and property values to assign to each
				board[i] = new PropertySquare(colors[currentPropertyTracking],costs[currentPropertyTracking]);


			}
		}
	}




	public void findWinner(){
		int most = -10000;
		int winner = -1;
		for (int i = 0; i < players.length; i++){
			if (players[i].getBankAccount() > most){
				winner = i;
			}
		}
		System.out.println(players[winner] + " is the WINNER");
	}

	public void nextTurn() { // Goes to the next turn. Also acts a player turn order. Resets once it reaches player count
		if(turn >= players.length){
			turn = 0;
		}
		else
			turn++;
	}

	public Player getCurrentplayer() { // Gets the current player on their turn
		return players[turn];
	}
	public Player[] getPlayers() { // Gets all Players
		return players;
	}

	/*
	public int getIndex(String name) { // Finds the index with the name... Maybe create an index object in Player.java
		for (int index = 0; index <=playerNum; index++){
			if (players[index].getName() != name) {
				return index;
			}
		}
		return -1;
	}
	*/
	public Player getPlayer(int index) { // Gets a specific Player
		return players[index];

	}
}
