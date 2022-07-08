import java.util.ArrayList;

public class ATM {
	private int loggedInIndex;// the index of logged in user
	private ArrayList<String> accNames = new ArrayList<String>();
	private ArrayList<String> accPass = new ArrayList<String>();
	private ArrayList<Float> accBalance = new ArrayList<Float>();

	public ATM() {
		loggedInIndex = -1;// index for non logged in
	}

	public void createUser(String name, String pass) {// Initializing
		accNames.add(name);
		accPass.add(pass);
		accBalance.add((float) 0.0);
		System.out.println("User Created balance is $0.0");
	}

	public void login(String name, String pass) {
		if (accNames.contains(name)) {
			loggedInIndex = accNames.indexOf(name);
		} else {
			System.out.println("UserName doesnt exsist");// Account doesn't exist so will break for new name
			loggedInIndex = -1;
			return;
		}

		if (accPass.get(loggedInIndex).equals(pass)) {// Checks password is correct

		} else {
			System.out.println("Wrong Password");
			loggedInIndex = -1;
		}
	}

	public void logout() {// changes the index to the logged out index
		loggedInIndex = -1;
	}

	public void Balance() {
		if (loggedInIndex == -1) { // checks its not logged out
			System.out.println("Not logged in");
			return;
		} else {
			System.out.println("Current balance is $" + accBalance.get(loggedInIndex));// returns balance
		}
	}

	public void withdraw(float amount) {// takes out amount entered
		if (loggedInIndex == -1) { // checks its not logged out
			System.out.println("Not logged in");
			return;
		} else {
			if (accBalance.get(loggedInIndex) >= amount) {
				System.out.println("Withdrew $" + amount);
				accBalance.set(loggedInIndex, (accBalance.get(loggedInIndex) - amount));// removes amount from balance
				this.Balance();
			} else {
				System.out.println("Balance not enough");
			}
		}

	}

	public void deposit(float amount) {// deposits amount entered
		if (loggedInIndex == -1) { // checks its not logged out
			System.out.println("Not logged in");
			return;
		} else {
			System.out.println("Depostied $" + amount);
			accBalance.set(loggedInIndex, (accBalance.get(loggedInIndex) + amount));// adds amount to balance
			this.Balance();
		}

	}

	public void transfer(float amount, String accName) {// shifts amount from logged ijn acc to desired acc
		int moneyToIndex;
		if (accNames.contains(accName)) {
			moneyToIndex = accNames.indexOf(accName);
		} else {
			System.out.println("UserName doesnt exsist");// Account doesn't exist so will break for new name
			loggedInIndex = -1;
			return;
		}
		if (accBalance.get(loggedInIndex) >= amount) {
			accBalance.set(loggedInIndex, (accBalance.get(loggedInIndex) - amount));// removes amount from sending acc
			accBalance.set(moneyToIndex, (accBalance.get(moneyToIndex) + amount));// adds amount to desired acc
			System.out.println("Transfered $" + amount);
			this.Balance();
		} else {
			System.out.println("Could not transfer, not enough money in account");
			System.out.println("Deposit money and try again");
			this.Balance();
		}
	}

}
