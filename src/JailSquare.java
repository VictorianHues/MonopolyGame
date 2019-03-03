public class JailSquare extends MonopolySquare{
    private Dice D = new Dice();
    private int minRoll = 1;

    public JailSquare(String name) {
        super(name);
    }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException { // Using rolling rules to get out of jail.
        if (P.getInJail()) {                                                        // Monopoly Junior Rules means this square has not actual function other than using a turn
            int newRoll = D.roll();
            if (newRoll > minRoll) {
                P.setInJail(false);
                TheBoard.movePlayer(P, D.roll());
                System.out.println(P + " rolled a " + newRoll + " and got out of Jail!");
            }
            else {
                System.out.println(P + " rolled a " + newRoll + " and is still in Jail!");
            }
        }
        // P.setInJail(false); // Uncomment this and comment everything else in LandOn for Monopoly Junior Rules
    }

    @Override
    public int getOwner() {
        return 0;
    }
}
