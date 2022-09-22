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
	}
	
//}
