import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomerApplication {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		int i=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Customer Application by Team Technocrats");
		System.out.println("----------------------------------------------------");
		
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
						System.out.println();
						System.out.println();
					}
					else {
						throw new CustomerException();
					}
				}
				catch(Exception e) {
					System.out.print(e);
					System.out.println();
					System.out.println();
				}
			}
			else {
				System.out.print("You entered '1' now exiting program");
				break;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("List of customers entered:");
		if(customerList.isEmpty()) System.out.println("No customers added");
		else {
			Collections.sort(customerList,new CustomerHelper());
			for(Customer customer:customerList) {
				System.out.println(customer);
			}
		}
		
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("Serializing Customer Data....");
		try {
			Serialize.serialize(customerList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Customer Data serialized, now attempting deserialization");
		System.out.println("Deserializing Customer Data....");
		try {
			@SuppressWarnings("unchecked")
			ArrayList<Customer> ls2 = (ArrayList<Customer>)Serialize.deserialize();
			
			for(Customer customer: ls2)
				System.out.println(customer);
		} catch (IOException | ClassNotFoundException e) {	
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println("Searching Customers with Area Code A1");
		CustomerHelper.searchByAreaCode(customerList, "A1");
		
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println("Customer List with Same Area Codes:");
		AreaCodeMap.getAreaCode(customerList);
	}

}
