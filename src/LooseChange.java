public class LooseChange {

	private int balance;

	public LooseChange(){
		balance = 0;
	}

	public void addLooseChange(int add) {
		balance += add;
	}

	public void payOut(Player P) {
		P.addAccount(balance);
		balance = 0;
	}

	public int getBalance() {
		return balance;

	}
	/*Add some methods here*/
	// This is how my brother always cheated -- snitching money from the
	// loose change.   I'm not bitter.

}