package console;

import java.util.Map;

import user.UserInterface;

public class AdminConsoleCommands implements AdminConsoleCommandsInterface {
	private final UserInterface user;
	private final Map<Integer, UserInterface> userList;

	public AdminConsoleCommands(UserInterface user, Map<Integer, UserInterface> userList) {
		super();
		this.user = user;
		this.userList=userList;
	}
	
	@Override
	public boolean create(UserInterface create){
		if (!userList.isEmpty() && userList.get(create.getId())!=null) {
			return false;
		}
		userList.put(create.getId(), create);
		return true;
	}
	
	@Override
	public void displayAll() {
		System.out.println("All users");
		for (Integer user:userList.keySet()) {
			System.out.println(userList.get(user));
		}
	}
	
	@Override
	public void displayUser(Integer userId) {
		UserInterface user = userList.get(userId);
		String message = user==null? "User does not exist" : user.getUserDetails();
		System.out.println(message);
	}
	
	@Override
	public void editUser(Integer id, UserInterface updatedUser) {
		userList.get(id).update(id, updatedUser);
	}
	
	@Override
	public UserInterface delete(Integer userId) {
		return userList.remove(userId);
	}
}
