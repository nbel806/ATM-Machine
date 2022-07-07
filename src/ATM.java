import java.util.ArrayList;

public class ATM {
	private int loggedInIndex;// the index of logged in user
	private ArrayList<String> accNames = new ArrayList<String>();
	private ArrayList<String> accPass = new ArrayList<String>();
	private ArrayList<Float> accBalance = new ArrayList<Float>();

	public ATM() {
		loggedInIndex = -1;// index for non logged in
	}

	public void createUser(String name, String pass) {// initialising
		accNames.add(name);
		accPass.add(pass);
		accBalance.add((float) 0.0);
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
			System.out.println("Balance is $" + accBalance.get(loggedInIndex));// returns balance
		}
	}

	public void withdraw() {

	}

}
