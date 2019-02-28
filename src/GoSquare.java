public class GoSquare extends MonopolySquare{
    private static int GoBonus = 2;
    public GoSquare(String name) { super(name); }

    public void landOn(Player P, MonopolyBoard TheBoard) {
        P.addAccount(GoBonus);
    }

    @Override
    public int getOwner() {
        return -1;
    }
}
