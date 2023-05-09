package advancejava5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import advancejava5.dao.UserDao;
import advancejava5.entity.User;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDao userDao;
	
	//@Override
	public String validateUser(String username, String password) {
	
		List<User> userList= userDao.validateUser(username, password);
		//User userList= (User) userDao.validateUser(username, password);
		System.out.println(userList);
		System.out.println("Service layer");
		if (userList != null && !userList.isEmpty()) {
	        for (User user : userList) {
	            System.out.println("inside loop");
	            String un = user.getUsername();
	            String ps = user.getPassword();
	            System.out.println(un + ps);
	            if (un.equalsIgnoreCase(username) && ps.equalsIgnoreCase(password)) {
	                System.out.println("Login successful");
	                // Return the username or perform further actions here
	                return un;
	            }
	        }
	    }
	    return null;
	}
	
}
