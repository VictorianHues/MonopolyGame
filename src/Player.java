public class Player {
	private int bankAccount;
	private String name;
	private boolean isTurn;
	private int location;
	private static String[] Property = new String[32];
	private int propertyNum = 0;

	public Player(String n){
		this.name = n;
		this.bankAccount = 31;
	}

	public void addAccount(int add){
		bankAccount += add;
		System.out.println("Current Account Balance: " + bankAccount);
	}

	public void subAccount(int sub){
		if (sub > bankAccount){
			throw new IllegalArgumentException("Insufficient Funds");
		}
		bankAccount -= sub;
		System.out.println("Current Account Balance: " + bankAccount);
	}

	public void addProperty(String addProp) {
		Property[propertyNum] = addProp;
		propertyNum++;
	}

	public boolean checkProperty(String checkProp){
		for (int i = 0; i <= propertyNum; i++){
			if (Property[i] == checkProp) {
				return true;
			}
		}
		return false;
	}

	public int getBankAccount() {
		return bankAccount;
	}

	public String getName() {
		return name;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public int getLocation() {
		return location;
	}


	/* you will add several methods to this class as needed.*/

	/* Whenever you adjust the location, don't forget to check
	to see if you passed "Go".   The instructions explicitly said
	that this was the responsiblity of the player, so this
	functionality belongs here.

	(unless you are told to go "directly" to location, i.e. jail/restroom)
	 */
}
