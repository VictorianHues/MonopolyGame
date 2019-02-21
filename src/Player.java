public class Player {
	private int bankAccount;
	private String name;
	private boolean isTurn;
	private int location;

	public Player(String n){
		name = n;
		bankAccount = 31;
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

	/* you will add several methods to this class as needed.*/

	/* Whenever you adjust the location, don't forget to check
	to see if you passed "Go".   The instructions explicitly said
	that this was the responsiblity of the player, so this
	functionality belongs here.

	(unless you are told to go "directly" to location, i.e. jail/restroom)
	 */
}
