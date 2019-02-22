import java.util.Random;

public class PropertySquare extends MonopolySquare {
    private int value;
    private int owner = -1;

    public PropertySquare(String name, int cost){
        super(name);
        this.value = cost;
    }

    public void setOwner(int idNum) {
        this.owner= idNum;
    }

    public int getPrice() {
        return value;
    }

    @Override
    public void landOn(Player P, MonopolyGame board) {
        if (owner < 0) { // If there is no owner
            System.out.println(P.getName() + ": Would like to buy this property?");
            Random rand = new Random();
            if (rand.nextBoolean()) {
                System.out.println(P.getName() + " buys " + toString() + " for " + value);
                owner = P.getIdNum();
                P.subAccount(value);
                P.addProperty(name);
            } else {
                System.out.println(P.getName() + " does not buy " + toString() + " for " + value);
            }
        }
        else if (owner != P.getIdNum()) { // If the owner is not the current player
            int rent;

            if (board.getPlayer(owner).checkProperty(name)) { // If the owner of the square also owns another of the same color
                rent = value * 2;
            }
            else{
                rent = value;
            }
            System.out.println(P.getName() + " loses " + rent + " landing on " + toString());
            P.subAccount(rent);
            board.getPlayer(owner).addAccount(rent);


        }
    }



}
