import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
	public static void main(String[] args)  {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Customers: ");
		int n=sc.nextInt();
		ArrayList<Customer> customerList=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the user Id : ");
			int customerId=sc.nextInt();
			System.out.println("Enter the user Name : ");
			String customerName=sc.next();
			System.out.println("Enter the user postal code : ");
			String customerPostalCode=sc.next();
			System.out.println("Enter the Number of units : ");
			int noOfUnits=sc.nextInt();
			if(noOfUnits>=0)
			customerList.add(new Customer(customerId,customerName,customerPostalCode,noOfUnits));
			else
				System.out.println("Number of Units cant be negative......");
		}
		Collections.sort(customerList,new CustomerHelper());
		for(Customer customer:customerList) {
			System.out.println(customer);
		}
		
		
		
		
		try {
			Serialize.serialize(customerList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Deserialized ....");
		try {
			@SuppressWarnings("unchecked")
			ArrayList<Customer> ls2 = (ArrayList<Customer>)Serialize.deserialize();
			
			for(Customer customer: ls2)
				System.out.println(customer);
			
		}
		
		catch (IOException | ClassNotFoundException e) {	
			e.printStackTrace();
		}
		
		
		//sc.close();
		
	}
}
