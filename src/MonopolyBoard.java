public class MonopolyBoard {
    private static String[] colors = {"Purple","Purple","White","White","Magenta","Magenta","Orange",
            "Orange","Red","Red","Yellow","Yellow","Green","Green","Blue","Blue"};
    private static int[] costs = {1,1,2,2,3,3,4,4,5};
    private static String[] railroads = {"Yellow","Green","Blue","Red"};


    private MonopolySquare[] board = new MonopolySquare[32];
    private LooseChange lc;
    private ChanceDeck[] chanceCardDeck;
    private Player[] players;

    private int turn;


    public MonopolyBoard(int playerNum) {
        chanceCardDeck = new ChanceDeck[24];
        players = new Player[playerNum];
        lc = new LooseChange();
        int currentPropertyTracking = 0;
        int currentRailroadTracking = 0;

        for(int i = 0;i < players.length;i++){
            players[i] = new Player(i,"Player " + (i + 1));
        }

        for (int i = 0 ; i< 32 ; i++) {
            if (i==0){ // Go
                board[i] = new GoSquare("GO");
            }
            else if (i == 1 || i == 4 || i == 9 || i == 17 || i == 20 || i == 25) { // Chance


            }
            else if (i == 5 || i == 13 || i == 21 || i == 29) { // Railroads
                board[i] = new RailroadSquare(railroads[currentRailroadTracking] + " Railroad");
                currentRailroadTracking++;
            }
            else if (i == 8 || i == 24){ // Fireworks or Watershow
                board[i] = new UtilitySquare("Utility 1");
            }
            else if (i == 10){ // Jail
                board[i] = new JailOutSquare("GO");
            }
            else if (i == 16) { // Loose Change
                board[i] = new LooseChangeSquare("Loose Change");
            }
            else if (i == 26) { // Go to Jail
                board[i] = new JailSquare("Jail");
            }
            else { // Properties. Iterates through two lists of colors and property values to assign to each
                board[i] = new PropertySquare(colors[currentPropertyTracking],costs[currentPropertyTracking]);
                currentPropertyTracking++;
            }
        }
    }

    public MonopolySquare movePlayer(Player currentPlayer, int dieFace) throws BankruptException{
        int newLocation;

        if (currentPlayer.getInJail()) {
            newLocation = currentPlayer.getLocation();
            System.out.println(currentPlayer.getName() + " is in Jail!");
            board[newLocation].landOn(currentPlayer, this);
        }
        else {
            newLocation = ((currentPlayer.getLocation() + dieFace) % 32);
            System.out.println(currentPlayer.getName() + " moves from " + board[currentPlayer.getLocation()].toString());
            players[turn].setLocation(newLocation);
            System.out.println(" to location " + board[newLocation].toString());
            board[newLocation].landOn(currentPlayer, this);
            return board[newLocation];
        }

        return board[newLocation];
    }

    public boolean hasWinner() {
        int play = 0;
        for(Player player:players){
            if(player.getBankAccount() < 0){
                play++;
            }
        }
        return play <= 1;


    }

    public Player findWinner(){
        int most = -10000;
        int winner = -1;
        for (int i = 0; i < players.length; i++){
            if (players[i].getBankAccount() > most){
                winner = i;
            }
        }
        return players[winner];
    }

    public void nextTurn() { // Goes to the next turn. Also acts a player turn order. Resets once it reaches player count
        if(turn >= players.length){
            turn = 0;
        }
        else
            turn++;
    }

    public void addLooseChange(int add) {
        lc.addLooseChange(add);
    }
    public void payOutLC(Player P) {
        System.out.println(lc.getBalance() + " is paid out to " + P.getName());
        lc.payOut(P);
    }


    public Player getCurrentPlayer() { // Gets the current player on their turn
        return players[turn];
    }

    public Player[] getPlayers() { // Gets all Players
        return players;
    }

    public Player getPlayer(int index) { return players[index]; }
}
