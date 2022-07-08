import java.util.Scanner;

public class Main {
	private static final String menu = "menu";
	private static final String balance = "balance";
	private static final String logout = "logout";
	private static final String off = "off";
	private static final String newacc = "new";
	private static final String login = "login";
	private static final String withdraw = "withdraw";
	private static final String deposit = "deposit";
	private static final String transfer = "transfer";

	private final ATM atm;
	public static Scanner scanner = new Scanner(System.in);

	public Main(ATM atm1) {
		this.atm = atm1;
	}

	public static void main(String[] args) {
		Main atm1 = new Main(new ATM());
		atm1.start();
	}

	private void start() {
		System.out.println("Welcome to ATM, log in or create and account to start");
		printMenu();
		String command;
		do {
			System.out.print("ATM>");
			command = scanner.nextLine().trim();
		} while (processCommand(command));

	}

	private boolean processCommand(String command) {
		if (command.contains(" ")) {
			return processCommand(command.split(" "));
		}
		switch (command) {
		case menu:
			printMenu();
			break;
		case balance:
			atm.Balance();
			break;
		case logout:
			atm.logout();
			System.out.println("LoggedOut");
			start();
			break;
		case off:
			System.out.println("ATM turning off");
			return false;
		case newacc:
			getNewAcc();
			break;
		case login:
			getLogin();
			break;
		case withdraw:
			getWithdraw();
			break;
		case deposit:
			getDeposit();
			break;
		case transfer:
			getTransfer();
			break;
		default:
			System.out.println("Error, command not found");
		}
		return true;

	}

	private void getNewAcc() {
		String userName;
		String userNameAgain;
		boolean complete = false;
		while (!complete) {
			System.out.println("To create a new account follow steps");
			System.out.println("New UserName: ");
			userName = scanner.nextLine().trim();
			System.out.println("Confirm New UserName: ");
			userNameAgain = scanner.nextLine().trim();
			if (userName.equals(userNameAgain)) {
				complete = true;
			}
		}

	}

	private void printMenu() {
		System.out.println("menu     shows main menu" + System.lineSeparator()
				+ "new      creates new user with password and username" + System.lineSeparator()
				+ "login    logs user into their acc" + System.lineSeparator() + "balance  displays current balance"
				+ System.lineSeparator() + "withdraw removes chosen amount from acc" + System.lineSeparator()
				+ "deposit  adds the chosen amount to acc" + System.lineSeparator()
				+ "transfer transfers specified acc from logged in acc to desired acc" + System.lineSeparator()
				+ "logout   logs the current user out" + System.lineSeparator() + "off      turns off ATM");
	}

}