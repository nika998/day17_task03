package console;

import java.util.Map;

import user.UserInterface;

public class AdminConsoleCommands {
	private final UserInterface user;
	private final Map<Integer, UserInterface> userList;

	public AdminConsoleCommands(UserInterface user, Map<Integer, UserInterface> userList) {
		super();
		this.user = user;
		this.userList=userList;
	}
	
	public boolean create(UserInterface create){
		if (!userList.isEmpty() && userList.get(create.getId())!=null) {
			return false;
		}
		userList.put(create.getId(), create);
		return true;
	}
	
	public void displayAll() {
		System.out.println("All users");
		for (Integer user:userList.keySet()) {
			System.out.println(userList.get(user));
		}
	}
	
	public void displayUser(Integer userId) {
		UserInterface user = userList.get(userId);
		String message = user==null? "User does not exist" : user.getUserDetails();
		System.out.println(message);
	}
	
	public void editUser(Integer id, UserInterface updatedUser) {
		userList.get(id).update(id, updatedUser);
	}
	
	public UserInterface delete(Integer userId) {
		return userList.remove(userId);
	}
}
