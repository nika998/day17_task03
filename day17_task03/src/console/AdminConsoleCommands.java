package console;

import java.util.Map;

import user.UserInterface;

public class AdminConsoleCommands implements AdminConsoleCommandsInterface {
	private final UserInterface admin;
	private final Map<String, UserInterface> userList;

	public AdminConsoleCommands(UserInterface user, Map<String, UserInterface> userList) {
		super();
		this.admin = user;
		this.userList=userList;
	}
	
	@Override
	public boolean create(UserInterface create){
		if (!userList.isEmpty() && userList.get(create.getUserName())!=null) {
			return false;
		}
		userList.put(create.getUserName(), create);
		return true;
	}
	
	@Override
	public void displayAll() {
		System.out.println("All users");
		for (String user:userList.keySet()) {
			System.out.println(userList.get(user));
		}
	}
	
	@Override
	public void displayUser(String userName) {
		UserInterface user = userList.get(userName);
		String message = user==null? "User does not exist" : user.getUserDetails();
		System.out.println(message);
	}
	
	@Override
	public void editUser(String userName, UserInterface updatedUser) {
		userList.get(userName).update(userName, updatedUser);
	}
	
	@Override
	public UserInterface delete(String  userName) {
		return userList.remove(userName);
	}
}
