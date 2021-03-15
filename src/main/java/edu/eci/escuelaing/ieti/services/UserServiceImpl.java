/**
 * 
 */
package edu.eci.escuelaing.ieti.services;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.eci.escuelaing.ieti.model.User;

/**
 * @author yeisson Gualdron
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private ConcurrentHashMap<String,User> usersList;
	
	public UserServiceImpl() {
		usersList = new ConcurrentHashMap<>();
	}
	
	@Override
	public List<User> getAll() {
		Iterator it = usersList.entrySet().iterator();
		ArrayList<User> users = new ArrayList<>();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			users.add((User)e.getValue());
		}

		return users;
	}

	@Override
	public User getById(String userId) {
		
		return usersList.get(userId);
	}

	@Override
	public User create(User user) {
		usersList.put(user.getId(), user);
		
		return usersList.get(user.getId());
	}

	@Override
	public User update(User user) {
		usersList.replace(user.getId(), user);
		
		return usersList.get(user.getId());
	}

	@Override
	public void remove(String userId) {
		
		usersList.remove(userId);
	}

}
