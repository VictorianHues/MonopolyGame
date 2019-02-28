public abstract class ChanceDeck{
private String name;
private int locationId;

	public ChanceDeck(String name, int locationId){
		this.name = name;
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return name;
	}

	public abstract void playCard(Player P, MonopolyBoard TheBoard) throws BankruptException;
}
