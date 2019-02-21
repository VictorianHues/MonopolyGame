import java.util.Random;

public class Dice {
    private int numSides;
    private int face;
    private static Random roller = new Random();

    public Dice() {
        numSides = 6;
        roll();
    }

    public Dice(int sides){
        numSides = sides;
        if (sides < 1){
            throw new IllegalArgumentException("Invalid");
        }
        roll();
    }

    public int roll() {
        face = roller.nextInt(numSides) + 1;
        return face;
    }
}
