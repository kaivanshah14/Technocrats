import java.util.ArrayList;
import java.util.Comparator;

public class CustomerHelper implements Comparator<Customer> {
	//static class sorting implements Comparator<Customer> {

		@Override
		public int compare(Customer o1, Customer o2) {
			if (o2.calculateTotalBill() == o1.calculateTotalBill()) {
				return o2.getCustomerId() - o1.getCustomerId();
			}
			if (o2.calculateTotalBill() > o1.calculateTotalBill())
				return 1;
			else
				return -1;
		}
		
		public void searchCustomerWithId(ArrayList<Customer>custList,int id) {
			for(Customer c:custList) {
				if(c.getCustomerId()==id) {
					System.out.println("=========================================================");
					System.out.println("The name of the customer is --> "+c.getCustomerName());
					System.out.println("The id of the customer is :---->"+c.getCustomerId());
					System.out.println("The area code of the customer is :---->"+c.getCustomerAreaCode());
					System.out.println("The units consumed of the customer is :---->"+c.getNumberofUnitsConsumed());
					System.out.println("The total bill of the customer is :---->"+c.getTotalBill());
					System.out.println("==========================================================");
				}
				else
					System.out.println("No such customer found");
			}
		}
	}


	
//}
