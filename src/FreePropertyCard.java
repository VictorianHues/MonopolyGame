public class FreePropertyCard extends ChanceDeck {
    private int locationId;
    private Dice D = new Dice(2);
    private String color;

    public FreePropertyCard(String name, int locationId) {
        super(name, locationId);
        this.locationId = locationId;
        String[] nameParts = name.split(" ");
        color = nameParts[4];
    }


    @Override
    public void playCard(Player P, MonopolyBoard TheBoard) throws BankruptException {
        int startingLocation = P.getLocation();
        int owner1 = TheBoard.getOwner(locationId);
        int owner2 = TheBoard.getOwner(locationId + 1);
        int property;

        System.out.println(P.getName() + " draws " + this.toString());
        System.out.println(P.toString() + " gets a free property in " + color);

        P.setOnChance(true);

        if (P.getPurchases() < 12) {// Check if player has tokens left
            if (owner1 != owner2) { // Check for Monopoly
                System.out.println(TheBoard.getPlayer(owner1).toString() + " and " +
                        TheBoard.getPlayer(owner2).toString() + " own these properties");
                if(owner1 != P.getIdNum() && owner2 != P.getIdNum()) { // If both aren't owned by the current player
                    property = ((locationId-1)+D.roll());
                }
                else if (owner1 == P.getIdNum() && owner2 != P.getIdNum()) { // If one is owned by the current player
                    property = locationId;
                }
                else { // If one is owned by the current player
                    property = locationId+1;
                }
                System.out.println(P.getName() + " receives " + TheBoard.getLocationName(property));
                TheBoard.movePlayer(P, Math.abs(property-startingLocation));
                P.setLocation(startingLocation);
            } else { System.out.println("These Properties are part of a Monopoly owned by " +
                        TheBoard.getPlayer(owner1).toString()); }

        } else { System.out.println(P.toString() + " doesn't have any purchases left"); }
        P.setOnChance(false);
    }
}
