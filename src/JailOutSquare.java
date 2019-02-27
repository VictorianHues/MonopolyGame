public class JailOutSquare extends MonopolySquare{
    private Dice D = new Dice();
    private int minRoll = 1;

    public JailOutSquare(String name) {
        super(name);
    }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException {
        if (P.getInJail()) {
            int newRoll = D.roll();
            System.out.println(P + " rolled a " + newRoll + " and got out of Jail!");
            if (newRoll > minRoll) {
                P.setInJail(false);
                TheBoard.movePlayer(P, D.roll());
            }
            else {
                System.out.println(P + " rolled a " + newRoll + " and is still in Jail!");
            }
        }
        else {
            P.addAccount(0);
        }
    }



}
