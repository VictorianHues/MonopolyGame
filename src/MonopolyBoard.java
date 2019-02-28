public class MonopolyBoard {
    private static String[] colors = {"Purple 1","Purple 2","White 1","White 2","Magenta 1","Magenta 2","Orange 1",
            "Orange 2","Red 1","Red 2","Yellow 1","Yellow 2","Green 1","Green 2","Blue 1","Blue 2"};
    private static int[] PropertyLocations = {2,3,6,7,11,12,14,15,18,19,22,23,27,28,30,31};
    private static int[] costs = {1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5};
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


        for(int i = 0;i < players.length;i++){
            players[i] = new Player(i,"Player " + (i + 1));
        }
        buildBoard();
        buildChanceDeck();
    }

    public void buildBoard() {
        int currentPropertyTracking = 0;
        int currentRailroadTracking = 0;

        for (int i = 0 ; i < 32 ; i++) {
            //System.out.println(i);
            if (i==0){ // Go
                board[i] = new GoSquare("GO");
            }
            else if (i == 1 || i == 4 || i == 9 || i == 17 || i == 20 || i == 25) { // Chance
                board[i] = new ChanceSquare("Chance");
            }
            else if (i == 5 || i == 13 || i == 21 || i == 29) { // Railroads
                board[i] = new RailroadSquare(railroads[currentRailroadTracking] + " Railroad");
                currentRailroadTracking++;
            }
            else if (i == 8 || i == 24){ // Fireworks or Watershow
                board[i] = new UtilitySquare("Utility");
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
                //System.out.println(colors[currentPropertyTracking] + costs[currentPropertyTracking]);
                currentPropertyTracking++;
            }
        }
    }

    public void buildChanceDeck() {
        int freeTracking = 0;
        for (int i = 0; i < 24; i++) {
            if (i < 16) {
                chanceCardDeck[i] = new GoToCard("Chance: Go to" + colors[i], PropertyLocations[i]);
            }
            else {
                chanceCardDeck[i] = new FreePropertyCard("Chance: Free Property at " +
                        colors[freeTracking], PropertyLocations[freeTracking]);
                freeTracking += 2;
            }
        }
    }

    public void pickChanceCard(Player P, int dieRoll) throws BankruptException {
        chanceCardDeck[dieRoll].playCard(P,this);
    }

    public MonopolySquare movePlayer(Player currentPlayer, int dieFace) throws BankruptException{
        int newLocation;

        if (currentPlayer.getInJail()) {
            newLocation = currentPlayer.getLocation();
            System.out.println(currentPlayer.getName() + " is in Jail!");
            board[newLocation].landOn(currentPlayer, this);
        }
        //else if (currentPlayer.checkChance()) { // If on a chance space. This is for when a Free Property Card is drawn...
        //    newLocation = ((currentPlayer.getLocation() + dieFace) % 32);
        //    board[newLocation].landOn(currentPlayer, this);
        //}
        else {
            newLocation = ((currentPlayer.getLocation() + dieFace) % 32);
            System.out.println("Rolls " + dieFace);
            System.out.println("Moves from " + board[currentPlayer.getLocation()].toString()
                    + " to " + board[newLocation].toString());
            players[turn].setLocation(newLocation);
            board[newLocation].landOn(currentPlayer, this);

            return board[newLocation];
        }

        return board[newLocation];
    }

    public boolean hasWinner() {
        for(Player player:players){
            if(player.getBankAccount() <= 0){ return true; }
        }
        return false;
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
        if(turn+1 >= players.length){
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

    public Player getPlayer(int index) { return players[index]; }

    public int getOwner(int squareLocation) { return board[squareLocation].getOwner(); }

    public String getLocationName(int squareLocation) { return board[squareLocation].toString(); }
}
