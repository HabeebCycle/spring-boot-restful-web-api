package com.cycle.habeeb.springbootrestapi.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static List<User> userList = new ArrayList<>();
	private static int userCount = 3;
	static {
		userList.add(new User(1, "Habeeb", new Date()));
		userList.add(new User(2, "Tunde", new Date()));
		userList.add(new User(3, "Adedayo", new Date()));
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		userList.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : userList) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
