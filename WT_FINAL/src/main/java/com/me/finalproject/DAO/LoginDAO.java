package com.me.finalproject.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.finalproject.pojo.Person;
import com.me.finalproject.pojo.User;
import com.me.finalproject.pojo.Warehouse;

public class LoginDAO extends DAO {
	public LoginDAO(){
	}
	public User getUserName(String username,String password) throws Exception{
		try{
			begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password and status = 'Y'");
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
	 public User saveUser(String firstName, String lastName,String username,String category) throws Exception{
		 
		 try{
			 begin();
			 User user = new User();
			 user.setFirstName(firstName);
			 user.setLastName(lastName);
			 user.setUsername(username);
			 user.setPassword("123456");
			 user.setCategory(category);
			 getSession().save(user);
			 commit();
			 return user;
		 }catch(HibernateException e){
			 rollback();
			 throw new Exception("user cannot be saved",e);
		 }
	 }
	 public Warehouse createWarehouse(String name,String address,String city,String state,String number,String type) throws Exception{
		 try{
			 begin();
			 Warehouse w = new Warehouse();
			 w.setWarehouseName(name);
			 w.setWarehouseType(type);
			 w.setAddress(address);
			 w.setCity(city);
			 w.setState(state);
			 w.setContactNumber(number);
			 getSession().save(w);
			 commit();
			 return w;
		 }catch(HibernateException e){
			rollback();
			throw new Exception("Warehouse cannot be created",e);
		 }
	 }
	 
	 public int updatePassword(String oldpassword,String newpassword,String username) throws Exception{
		
		 try{
			 begin();
			 Query query = getSession().createQuery("Update User set password= :password where username= :username");
			 query.setString("password",newpassword);
			 query.setString("username",username);
			 int result = query.executeUpdate();
			 commit();
			 return result;
		 }catch(HibernateException e){
			 rollback();
			 throw new Exception("Password cannot be updated",e);
		 }
	 }
	 
	 public int blockUser(String username) throws Exception{
		 try{
			 begin();
			 Query query = getSession().createQuery("update User u set u.status='N'  where u.username= :username");
			 query.setString("username",username);
			  int result = query.executeUpdate();
			 commit();
			 return result;
		 }catch(HibernateException e){
			rollback();
			throw new Exception("Cannot block User",e);
		 }
	 }
	 
}
