package com.techlabs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.User;

@Repository("userDao")
public class UserDao {

	@Autowired
	private SessionFactory factory;
	private Session session;
	
	public UserDao() {
		System.out.println("UserDao construtctor");
	}
	
	public void createUser(User user)
	{
		session=factory.getCurrentSession();
		session.save(user);
	}
	public String getRole(String accountNo)
	{
		return null;
	}
}
