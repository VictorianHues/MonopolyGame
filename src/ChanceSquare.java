public class ChanceSquare extends MonopolySquare{
    private Dice D = new Dice();

    public ChanceSquare(String name) { super(name); }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException {
        System.out.println("CHANCE!");
        P.setOnChance(true);
        TheBoard.pickChanceCard(P, D.roll());
    }

    @Override
    public int getOwner() {
        return -1;
    }
}
