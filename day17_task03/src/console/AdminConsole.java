package console;

import java.util.Scanner;

import domain.Role;
import user.UserInterface;

public class AdminConsole {
	private final AdminConsoleService commands;
	private final Scanner scan;

	public AdminConsole(AdminConsoleService commands, Scanner scan) {
		super();
		this.scan = scan;
		this.commands = commands;
	}

	public void menu() {
		displayOptions(commands.getAdmin());
		int option = -1;
		while ((option = scan.nextInt()) != 0) {
			switch (option) {
			case 1: {
				readUser(scan);
				break;
			}
			case 2: {
				commands.displayAll();
				break;
			}
			case 3: {
				System.out.println("Username: ");
				String userName = scan.nextLine();
				commands.displayUser(userName);
			}
			case 4: {
				System.out.println("Username: ");
				String userName = scan.nextLine();
				if (!commands.userExists(userName)) {
					System.out.println("user doesn't exist");
					break;
				}
				break;
			}
			case 5: {
				System.out.println("Username: ");
				String userName = scan.nextLine();
				commands.delete(userName);
				break;
			}
			}
			displayOptions(commands.getAdmin());
		}
	}

	private void readUser(Scanner scan) {
		System.out.println("Username:");
		String userName = scan.nextLine();
		if (commands.userExists(userName)) {
			System.out.println("Username already in use");
			return;
		}
		System.out.println(
				"Password must be 8 in length, must 1 number, must start with alphabetic letter:");
		String password = scan.nextLine();
		if (!isValidPassword(password)) {
			System.out.println("Invalid password");
		}
		System.out.println("Confirm password:");
		String passwordConfirm = scan.nextLine();
		if (!password.equals(passwordConfirm)) {
			System.out.println("Didn't confirm properly");
			return;
		}
		System.out.println("First name:");
		String firstName = scan.nextLine();
		System.out.println("Last name:");
		String lastName = scan.nextLine();
		System.out.println("Role: ");
		String role = scan.nextLine();
		if (Role.ADMIN.name().equalsIgnoreCase(role)) {
			//TODO: create admin
		} else if (Role.EDITOR.name().equalsIgnoreCase(role)) {
			//TODO: create editor
		} else {
			System.out.println("No user with given role");
		}

	}

	private boolean isValidPassword(String password) {
		return password.length() < 8 && Character.isAlphabetic(password.charAt(0))
				&& password.matches("(.*)[0-9](.*)");
	}

	public void displayOptions(UserInterface admin) {
		System.out.println("Welcome " + admin.getUserName() + " .");
		System.out.println("Options are");
		System.out.println("1 - Create user");
		System.out.println("2 - Display all users");
		System.out.println("3 - Display user with given UserName");
		System.out.println("4 - Update user's info with given userName");
		System.out.println("5 - Delete user with given userName");
		System.out.println("0 - Exit application");
	}
}
