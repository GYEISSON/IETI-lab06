package edu.eci.escuelaing.ieti.services;
import edu.eci.escuelaing.ieti.model.User;
import java.util.List;

public interface UserService {
	List<User> getAll();
	    
	    User getById(String userId);
	    
	    User create(User user);
	    
	    User update(User user);
	    
	    void remove(String userId);
}
