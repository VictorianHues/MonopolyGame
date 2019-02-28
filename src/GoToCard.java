public class GoToCard extends ChanceDeck {
    private int locationId;

    public GoToCard(String name, int locationId) {
        super(name, locationId);
        this.locationId = locationId;
    }

    public void playCard(Player P, MonopolyBoard TheBoard) throws BankruptException{
        System.out.println(P.getName() + " draws " + this.toString());
        P.setLocation(locationId);
        TheBoard.movePlayer(P, 0);
    }

}
