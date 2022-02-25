package user;

public interface UserInterface {
	
	void getPassword();
	
	String getUserName();
	
	String getUserDetails();
	
	UserInterface update(String userName, UserInterface updatedUser);

	UserInterface createAdmin(Integer id, String lastName, String password);

	UserInterface createEditor(Integer id, String lastName, String password);
}
