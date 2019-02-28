import java.util.Random;

public class PropertySquare extends MonopolySquare {
    private int value;
    private int owner = -1;
    private boolean monopolyDouble;

    public PropertySquare(String name, int cost){
        super(name);
        this.value = cost;
    }

    @Override
    public void landOn(Player P, MonopolyBoard TheBoard) throws BankruptException {
        if (!P.getOnChance()) {
            if (P.getPurchasesLeft() != 0) { // If the player has purchases left
                if (owner < 0) { // If there is no current owner
                    System.out.println(P.getName() + ": Would like to buy this property?");
                    Random rand = new Random();
                    if (rand.nextBoolean()) { // Random Check for purchasing. Remove and replace for actual player interaction
                        System.out.println(P.getName() + " buys " + toString() + " for " + value);
                        P.subAccount(value);
                        P.addProperty(P.getLocation());
                        setOwner(P.getIdNum());

                        if (TheBoard.getPlayer(owner).checkProperty(P.getLocation()) && !monopolyDouble) {
                            monopolyDouble = true;
                        }
                    } else {
                        System.out.println(P.getName() + " does not buy " + toString() + " for " + value);
                    }
                } else if (owner != P.getIdNum()) { // If the owner is not the current player
                    int rent;

                    if (monopolyDouble) { // If the owner of the square also owns another of the same color
                        rent = getPrice() * 2;
                    } else {
                        rent = getPrice();
                    }
                    System.out.println(P.getName() + " loses " + rent + " landing on " + toString());
                    P.subAccount(rent);
                    TheBoard.getPlayer(owner).addAccount(rent);
                }
            } else {
                System.out.println(P.getName() + " cannot buy anymore properties!");
            }
        }
        else { // If the player is on the chance square. Only occurs when drawing a Free Property Card...
            TheBoard.getPlayer(owner).subProperty(P.getLocation());
            P.addProperty(P.getLocation());
            setOwner(P.getIdNum());
            if (TheBoard.getPlayer(owner).checkProperty(P.getLocation()) && !monopolyDouble) {
                monopolyDouble = true;
            }
        }
    }

    public void setOwner(int idNum) {
        this.owner= idNum;
    }

    public int getPrice() {
        return value;
    }

    @Override
    public int getOwner() {
        return owner;
    }
}
