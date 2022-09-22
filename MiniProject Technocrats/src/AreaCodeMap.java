import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class AreaCodeMap {

	public static void getAreaCode(ArrayList<Customer> customerList) {
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
		
		for(Entry<String, List<Customer>> entry: mp.entrySet()) {
			System.out.println("AreaCode: "+entry.getKey()+",Customers= "+entry.getValue());
		}
	}

}