public abstract class PropertySquare extends MonopolySquare {
    private static int[] values = {5,4,4,3,3,2,2,1};
    private static String[] colors = {"empty","Purple","White","Magenta","Orange","Red","Yellow","Green","Blue"};
    private int currentValue;
    private String currentColor;

    public PropertySquare(int location){
        currentValue = values[16 - location];
        currentColor = colors[16 - location];
        
    }






}
