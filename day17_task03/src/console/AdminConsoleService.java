package console;

import user.UserInterface;

public interface AdminConsoleService {

	boolean create(UserInterface create);

	void displayAll();

	void displayUser(String userName);

	void editUser(String userName, UserInterface updatedUser);

	UserInterface delete(String userName);

	boolean userExists(String userName);

}