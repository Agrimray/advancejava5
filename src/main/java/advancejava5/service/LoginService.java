package advancejava5.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public String validateUser(String username,String password);
	
}
