public class UtilitySquare extends MonopolySquare {
    private static int utilCost = 2;

    public UtilitySquare(String name) {
        super(name);
    }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException {
        System.out.println(P.getName() + " pays $2 to see the show");
        P.subAccount(utilCost);
    }
}
