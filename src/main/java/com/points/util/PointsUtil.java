package com.points.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.points.model.Points;

public class PointsUtil {
	
	public static List<Points> getDataSet() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		// 1st Customer
		Points reward1 = new Points();
		reward1.setCustomerName("customer1");
		reward1.setPurchaseAmount(100);
		reward1.setCreatedDate(sdf.parse("13/03/2021"));
		
		Points reward2 = new Points();
		reward2.setCustomerName("customer1");
		reward2.setPurchaseAmount(40);
		reward2.setCreatedDate(sdf.parse("01/04/2021"));
		
		Points reward3 = new Points();
		reward3.setCustomerName("customer1");
		reward3.setPurchaseAmount(140);
		reward3.setCreatedDate(sdf.parse("02/04/2021"));
		
		// 2nd Customer
		Points c1 = new Points();
		c1.setCustomerName("customer2");
		c1.setPurchaseAmount(120);
		c1.setCreatedDate(sdf.parse("11/03/2021"));
		
		Points c2 = new Points();
		c2.setCustomerName("customer2");
		c2.setPurchaseAmount(130);
		c2.setCreatedDate(sdf.parse("01/04/2021"));
		
		
		List<Points> list = new ArrayList<>();
		list.add(reward1);
		list.add(reward2);
		list.add(reward3);
		list.add(c1);
		list.add(c2);
		
		return list;
	}

}
