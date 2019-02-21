import java.util.Random;

public class PropertySquare extends MonopolySquare {
    private int value;
    private String owner = "X";

    public PropertySquare(String name, int cost){
        super(name);
        this.value = cost;
    }

    public void setOwner(String owner) {
        this.owner= owner;
    }

    public int getPrice() {
        return value;
    }

    @Override
    public void landOn(Player P) {
        if (owner == "X") {
            System.out.println(P.getName() + ": Would like to buy this property?");
            Random rand = new Random();
            if (rand.nextBoolean()) {
                System.out.println(P.getName() + " buys " + toString() + " for " + value);
                owner = P.getName();
                P.subAccount(value);
            } else {
                System.out.println(P.getName() + " does not buy " + toString() + " for " + value);
            }
        }
        else if (owner != P.getName()) {
            int rent;
            if (P.checkProperty(toString())) {
                rent = value * 2;
            }
            else{
                rent = value;
            }
            System.out.println(P.getName() + " loses " + value + " landing on " + toString());

        }
    }



}
