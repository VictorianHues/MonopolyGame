public class LooseChangeSquare extends MonopolySquare{
    public LooseChangeSquare(String name) { super(name); }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException { TheBoard.payOutLC(P); }

    @Override
    public int getOwner() {
        return -1;
    }
}
