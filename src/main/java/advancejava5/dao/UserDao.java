package advancejava5.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import java.util.HashMap;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import advancejava5.entity.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public List<User> validateUser(String username, String password) {
		List<User> userList = this.hibernateTemplate.loadAll(User.class);
		if(userList.isEmpty())
		{
			return null;
		}
		//System.out.println(userList);
	    /*for (User user : userList) 
	    {
	    	
	        if (user.getUsername().equals(username) && user.getPassword().equals(password)) 
	        {
	        	System.out.println(user.getUsername());
	            return user;
	        }
	    }
	    return null;*/
		return userList;
	} 
	/*@Transactional
	public User validateUser(String username, String password) {
		System.out.println("dao");
		System.out.println(username+password);
	    String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
	    Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
	    TypedQuery<User> query = session.createQuery(hql, User.class);
	    query.setParameter("username", username);
	    query.setParameter("password", password);
	    User user = query.getSingleResult();
	    System.out.println(user);
	    return user;
	}*/








}
	
