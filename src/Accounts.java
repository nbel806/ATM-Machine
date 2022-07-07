
public class Accounts {
	private String accName;
	private String accPass;
	private double accBalance;

	public Accounts(String Name, String Pass) {
		accName = Name;
		accPass = Pass;
		accBalance = 0;
	}

	public double getBalance() {
		return accBalance;
	}

	public String getAccPass() {
		return accPass;
	}
}
