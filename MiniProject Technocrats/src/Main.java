import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import CustomerHelper.sorting;

public class Main {
<<<<<<< HEAD
	public static void main(String[] args)  {
//		Customer c = new Customer(1, "A", "101", 57);
//		Customer c1 = new Customer(2, "B", "102", 120);
//		Customer c2 = new Customer(3, "C", "103", 357);
//		Customer c3 = new Customer(4, "Z", "105", -3);
//		System.out.println(c.calculateTotalBill() + " " + c);
//		System.out.println(c1.calculateTotalBill() + " " + c1);
//		System.out.println(c2.calculateTotalBill() + " " + c2);
//		System.out.println(c3.calculateTotalBill() + " " + c3);
		
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
		
=======
	public static void main(String[] args) {
		Customer c = new Customer(1, "A", "101", 57);
		Customer c1 = new Customer(2, "B", "102", 120);
		Customer c2 = new Customer(3, "C", "103", 357);
		Customer c3 = new Customer(3, "C", "103", -3);
		//hammad commit-1
		Customer c4 = new Customer(5, "E", "105", 0);
		
		
		
		System.out.println(c.calculateTotalBill() + " " + c);
		System.out.println(c1.calculateTotalBill() + " " + c1);
		System.out.println(c2.calculateTotalBill() + " " + c2);
		System.out.println(c3.calculateTotalBill() + " " + c3);
		System.out.println(c4.calculateTotalBill() + " " + c4);
		
		
		
		
	
>>>>>>> 1dc01f4978ec7f70718be007d00aa5cb90994810
	}
}
