package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import console.AdminConsole;
import console.AdminConsoleService;
import console.AdminConsoleServiceImpl;
import domain.Role;
import user.UserInterface;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, UserInterface> accounts = new HashMap<>();
		int attempts = 0;
		while (attempts < 4) {
			System.out.println("Username:");
			String username = scanner.nextLine();
			System.out.println("Password:");
			String password = scanner.nextLine();
			if (!login(accounts, username, password)) {
				attempts++;
				if (attempts < 4) {
					System.out.println("Bad username and/or password");
				} else {
					System.out.println("Too many attempts shutting down");
				}
			} else {
				System.out.println("Successful login");
				if (accounts.get(username).getRole() == Role.ADMIN) {
					AdminConsoleService service = new AdminConsoleServiceImpl(accounts.get(username), accounts);
					AdminConsole console = new AdminConsole(service, scanner);
					console.menu();
				} else if (accounts.get(username).getRole() == Role.EDITOR) {
					System.out.println("EDITOR CONSOLE COMING SOON!!!");
					attempts = 0;
				}
			}

		}
	}

	private static boolean login(Map<String, UserInterface> accounts, String userName, String password) {
		return accounts.containsKey(userName) && accounts.get(userName).getPassword().equals(password);
	}
}
