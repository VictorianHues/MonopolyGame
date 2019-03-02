public class RailroadSquare extends MonopolySquare{
    private Dice D = new Dice();

    public RailroadSquare(String name) {
        super(name);
    }

    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException{
        System.out.println("Ride the Railroad!");
        TheBoard.movePlayer(P, D.roll());
    }

    @Override
    public int getOwner() {
        return -1;
    }
}
