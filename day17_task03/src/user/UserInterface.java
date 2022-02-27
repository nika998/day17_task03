package user;

import domain.Role;

public interface UserInterface {
	
	String getPassword();
	
	String getUserName();
	
	String getUserDetails();
	
	Role getRole();
	
	UserInterface update(String userName, UserInterface updatedUser);

	UserInterface createAdmin(Integer id, String lastName, String password);

	UserInterface createEditor(Integer id, String lastName, String password);
}
