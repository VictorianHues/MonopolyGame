public class GoToJailSquare extends MonopolySquare{
    private static int jailCost = 3;

    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException {
        P.setInJail(true);
        P.setLocation(10);
        P.subAccount(jailCost);
        TheBoard.addLooseChange(jailCost);
        System.out.println(P.getName() + " goes directly to JAIL, pays $3, and does not collect $2");
    }

    @Override
    public int getOwner() {
        return -1;
    }
}
