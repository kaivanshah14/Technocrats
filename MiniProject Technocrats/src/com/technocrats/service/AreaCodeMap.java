package com.technocrats.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.technocrats.model.Customer;

public class AreaCodeMap {

	public HashMap<String, List<Customer>> getAreaCode(ArrayList<Customer> customerList) {
	HashMap<String, List<Customer>> mp = new HashMap<>();

		for(Customer customer:customerList)
		{
	
			if (mp.get(customer.getCustomerAreaCode()) == null) {
				List<Customer> ls = new ArrayList<>();
				ls.add(customer);
				mp.put(customer.getCustomerAreaCode(), ls);
			}
	
			else {
				mp.get(customer.getCustomerAreaCode()).add(customer);
			}
	
		}
		return mp;
	}

}