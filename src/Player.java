public class Player {
	private int bankAccount;
	private String name;
	private int idNum;
	private int location;
	private static int[] Property = new int[32];
	private int purchasesLeft = 12;

	private boolean inJail;
	private boolean onChance;

	public Player(int idNum, String n){
		this.name = n;
		this.idNum = idNum;
		this.location = 0;
		this.bankAccount = 31;
		this.inJail = false;
	}

	public void addAccount(int add){
		bankAccount += add;
		System.out.println(this.getName() + "'s Current Account Balance: " + bankAccount);
	}

	public void subAccount(int sub) throws BankruptException{
		if (sub > bankAccount){
			throw new BankruptException(this.getName() + " is BANKRUPT");
		}
		else {
			bankAccount -= sub;
			System.out.println(this.getName() + "'s Current Account Balance: " + bankAccount);
		}
	}

	public void addProperty(int addProp) {
		Property[Property.length+1] = addProp;
		purchasesLeft--;
	}

	public void subProperty(int subProp) {
		int[] PropertyCopy = new int[32];
		int j = 0;
		for (int i = 0; i < Property.length;i++) {
			if (Property[i] != subProp) {
				PropertyCopy[j] = Property[i];
				j++;
			}
		}
		Property = PropertyCopy;
		purchasesLeft++;
	}

	public boolean checkProperty(int checkProp){
		for (int i = 0; i <= Property.length; i++){
			if (Property[i] == (checkProp-1) || Property[i] == (checkProp+1)) {
				return true;
			}
		}
		return false;
	}

	public void setOnChance(boolean onChance) {
		this.onChance = onChance;
	}
	public boolean getOnChance() {  return onChance; }

	public void setLocation(int newLocation) {
		this.location = newLocation;
	}

	public int getPurchasesLeft() {return purchasesLeft; }

	public int getBankAccount() {
		return bankAccount;
	}

	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}

	public int getIdNum() {return idNum;}

	public boolean getInJail() {return inJail; }

	public void setInJail(boolean gotoJail) {
		this.inJail = gotoJail;
	}
}
