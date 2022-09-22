import java.util.ArrayList;
import java.util.Scanner;

public class CustomerApplication {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		int i=0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Enter 0 to add a customer and 1 to exit: ");
			if(sc.nextInt()==0) {
				System.out.println();
				System.out.println("Enter customer details:");
				System.out.println("------------");
				System.out.print("Enter customer ID: ");
				int customerId = sc.nextInt();
				System.out.print("Enter customer Name: ");
				String customerName = sc.next();
				System.out.print("Enter customer Area Code: ");
				String customerAreaCode = sc.next();
				System.out.print("Enter customer Number of Units Consumed: ");
				int numberofUnitsConsumed = sc.nextInt();
				try {
					if(numberofUnitsConsumed>0) {
						System.out.println();
						customerList.add(new Customer(customerId, customerName, customerAreaCode, numberofUnitsConsumed));
						customerList.get(i).calculateTotalBill();
						System.out.println("New customer added with following details:");
						System.out.println(customerList.get(i));
						System.out.print("------------");
						i++;
					}
					else {
						throw new CustomerException();
					}
				}
				catch(Exception e) {
					System.out.print(e);
				}
			}
			else {
				System.out.print("You entered '1' now exiting program");
				break;
			}
			System.out.println();
			System.out.println();
		}
	}

}
