package com.me.finalproject;

import com.me.finalproject.DAO.OrderDAO;
import com.me.finalproject.pojo.Order;

public class TEST {
public static void main(String args[]){
	OrderDAO orderDAO = new OrderDAO();
	Order order = new Order();
	order.setOrderNumber("1");
	orderDAO.getSession().save(order);
	
}

}
