package edu.eci.escuelaing.ieti.services;
import edu.eci.escuelaing.ieti.model.User;
import java.util.List;

public interface UserService {
	public List<User> getAll();
	    
	public User getById(String userId);
	    
	public User create(User user);
	    
	public User update(User user);
	    
	public void remove(String userId);
}
