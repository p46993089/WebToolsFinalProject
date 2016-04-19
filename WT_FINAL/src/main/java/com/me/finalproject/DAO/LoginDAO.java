package com.me.finalproject.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.finalproject.pojo.User;

public class LoginDAO extends DAO {
	public LoginDAO(){
	}
	public User getUserName(String username,String password) throws Exception{
		try{
			begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password",password);
            User user = (User) q.uniqueResult();
            commit();
            return user;
		}catch(HibernateException e){
			rollback();
			throw new Exception("User not found" + username,e);
		}
	}
	 public User checkUserNameUnique(String username) throws Exception{
		 try{
			 begin();
			 Query q = getSession().createQuery("from User where username = :username");
			 q.setString("username",username);
			 User user = (User) q.uniqueResult();
			 commit();
			 return user;
		 }catch(HibernateException e){
			 rollback();
			 throw new Exception("Username already taken" + username,e);
		 }
	 }
}
