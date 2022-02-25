package console;

import user.UserInterface;

public interface AdminConsoleCommandsInterface {

	boolean create(UserInterface create);

	void displayAll();

	void displayUser(Integer userId);

	void editUser(Integer id, UserInterface updatedUser);

	UserInterface delete(Integer userId);

}