package user;

public interface UserInterface {
	
	void getPassword();
	
	String getUserDetails();
	
	UserInterface update(Integer id, UserInterface updatedUser);

	UserInterface createAdmin(Integer id, String lastName, String password);

	UserInterface createEditor(Integer id, String lastName, String password);
}
