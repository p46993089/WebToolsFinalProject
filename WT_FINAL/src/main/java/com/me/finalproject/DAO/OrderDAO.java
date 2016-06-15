package com.me.finalproject.DAO;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.web.multipart.MultipartFile;

import com.me.finalproject.pojo.Order;
import com.me.finalproject.pojo.User;

public class OrderDAO extends DAO {

	public Order saveOrder(Order order) {
	
		try{
			begin();
			getSession().saveOrUpdate(order);
			commit();
			return order;
		}catch(Exception e){
			throw new HibernateException("Could Not Save",e);
		}
	}
	public List getUsers() throws Exception{
		try{
			begin();
			Query query = getSession().createQuery(" from User where category= 'VENDOR' and status='Y' ");
		
			List userList = query.list();
			commit();
			return userList;
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}
	public List getOrders(String vendorname){
		try{
			begin();
			Query query = getSession().createQuery("from Order where vendorName = :vendorName");
			query.setString("vendorName",vendorname);
			List orders = query.list();
			commit();
			return orders;
		}catch(HibernateException e){
			rollback();
			return null;
		}
	}
	public List getOrderVendorWise(String vendorname){
		try{
			begin();
			Query query = getSession().createQuery("from Order where vendorName= :vendorName and vendorAcceptFlag is null");
			query.setParameter("vendorName",vendorname);
			List orders = query.list();
			commit();
			return orders;
		}catch(HibernateException e){
			rollback();
			System.out.println(e);
			return null;
		}
	}
	
	public int exceuteVendorExcelUpload(String orderNumber,String vendorFlag,Date vendorAcceptDate,Date vendorRequestedQCdate,String QcName){
	try{
		begin();
		Query q = getSession().createQuery("update Order set vendorAcceptFlag= :vendorAcceptFlag,vendorAcceptDate = :vendorAcceptDate,vendorRequestedQCdate= :vendorRequestedQCdate"
				+ ",qcName = :qcName where orderNumber = :orderNumber");
		q.setString("vendorAcceptFlag", vendorFlag);
		q.setDate("vendorAcceptDate", vendorAcceptDate);
		q.setDate("vendorRequestedQCdate", vendorRequestedQCdate);
		q.setString("qcName",QcName);
		q.setString("orderNumber", orderNumber);
		int result = q.executeUpdate();
		commit();
		return result;
		
	}catch(HibernateException e){
		rollback();
		System.out.println(e);
		return -1;
	}
	}
	public List getOrderQCWise(String qcName){
		try{
			begin();
			Query query = getSession().createQuery("from Order where qcName = :qcName and qcAcceptFlag is null");
			query.setString("qcName", qcName);
			List qc = query.list();
			commit();
			return qc;
			
		}catch(HibernateException e){
			rollback();
			return null;
		}
	}
	public int insertQCUpdate(String orderNumber,Date qcDate,String qcAcceptFlag){
		try{
			begin();
			Query query = getSession().createQuery("update Order set qcDoneDate= :qcDoneDate,qcAcceptFlag= :qcAcceptFlag where orderNumber = :orderNumber");
			query.setDate("qcDoneDate", qcDate);
			query.setString("qcAcceptFlag",qcAcceptFlag);
			query.setString("orderNumber", orderNumber);
			int result = query.executeUpdate();
			commit();
			return result;
			
		}catch(Exception e){
			rollback();
			System.out.println(e);
			return -1;
		}
	}
	public List getDispatchDetails(String vendorname){
		try{
			begin();
			Query query = getSession().createQuery("from Order where vendorName= :vendorName and vendorDispatchFlag is null and qcAcceptFlag='Y'");
			query.setParameter("vendorName",vendorname);
			List orders = query.list();
			commit();
			return orders;
		}catch(HibernateException e){
			rollback();
			System.out.println(e);
			return null;
		}
	}
	
	public int executeDispatchDetails(String dispatchFlag,Date dispatchDate,Date fgReceiptDate,String warehousename,String orderNumber){
		try{
			begin();
	Query query = getSession().createQuery("update Order set vendorDispatchFlag= :vendorDispatchFlag,vendorDispatchDate =:vendorDispatchDate,warehouseEmployee =:warehouseEmployee,fgReceiptDate= :fgReceiptDate where orderNumber= :orderNumber and qcAcceptFlag='Y'");
		query.setString("vendorDispatchFlag",dispatchFlag);
		query.setString("warehouseEmployee", warehousename);
		query.setDate("vendorDispatchDate", dispatchDate);
		query.setDate("fgReceiptDate", fgReceiptDate);
		query.setString("orderNumber", orderNumber);
		int result = query.executeUpdate();
		commit();
		return result;
		}catch(HibernateException e){
			rollback();
			return -1;
		}
	}
	
}