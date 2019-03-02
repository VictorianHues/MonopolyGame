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
        if (TheBoard.checkForMonopoly(P.getLocation(),owner) && !monopolyDouble) {
            monopolyDouble = true;
        }
        if (!P.getOnChance()) {
            if (P.getPurchases() < 12) { // If the player has purchases left
                if (owner < 0) { // If there is no current owner
                    System.out.println("Would " + P.getName() + " like to buy " + this.name + " for $" + this.value + "?");
                    Random rand = new Random();

                    if (rand.nextBoolean()) { // Random Check for purchasing. Remove and replace for actual player interaction
                        System.out.println(P.getName() + " buys " + toString() + " for $" + value);
                        P.subAccount(value);
                        P.addProperty(P.getLocation());
                        setOwner(P.getIdNum());
                        //   if (TheBoard.checkForMonopoly(P.getLocation(),owner) && !monopolyDouble) {
                        //       monopolyDouble = true;
                        //   }
                    } else {
                        System.out.println(P.getName() + " does not buy " + toString() + " for $" + value);
                    }
                } else if (owner != P.getIdNum()) { // If the owner is not the current player
                    int rent;

                    if (monopolyDouble) { // If the owner of the square also owns another of the same color
                        rent = getPrice() * 2;
                    } else {
                        rent = getPrice();
                    }
                    System.out.println(P.getName() + " loses $" + rent + " landing on " +
                            toString() + " owned by " + TheBoard.getPlayer(owner).getName());
                    P.subAccount(rent);
                    TheBoard.getPlayer(owner).addAccount(rent);
                }
                else { System.out.println(P.getName() + " is already owner of this Property"); }
            } else {
                System.out.println(P.getName() + " cannot buy anymore properties!");
            }
        }
        else { // If the player is on the chance square. Only occurs when drawing a Free Property Card...
            if (owner != P.getIdNum()) {
                if (owner >= 0) {
                    TheBoard.getPlayer(owner).subProperty(P.getLocation());
                }
                P.addProperty(P.getLocation());
                setOwner(P.getIdNum());
            }
            else  { System.out.println(P.getName() + " is already owner of this Property"); }
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
