package Henry_ICE8;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ICE6 {
	
	static MyLinkedList<Customer> customers = new MyLinkedList<Customer>();

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		//declare variables
		int gallons=0;
		String custName=null;
		int custNumber=0;
		int custType=0;
		int reply=JOptionPane.YES_OPTION;
		
				
		//initialize nodes
		do 
		{
			//start for-loop
		
			//input customer type
			try{
			custType=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Customer Type \n1-Single Family \n2-Duplex"));
			if (custType!=1 && custType!=2)
				throw new Exception(); //control goes to catch clause
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,  "Invalid Customer Rate! \nIt must be 1 or 2");
				System.exit(0);
			}
			
			//obtain user number
			try {
			custNumber = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Enter customer number: "));
			if (String.valueOf(custNumber).length()!=6)
				throw new Exception(); //control goes to catch clause
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid 6-digit customer number!"
						,"ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			
			//input customer name
			custName=JOptionPane.showInputDialog(null, "Enter customer name: ");
			if (custName.isEmpty()){
				JOptionPane.showMessageDialog(null,  "Please enter a valid customer name!\nIt cannot be empty!");
				System.exit(0);
			}
			
			//input number of gallons
			try {
				gallons=Integer.parseInt(JOptionPane.showInputDialog(null, "enter number of gallons: "));
				if (gallons <0){
					throw new Exception(); //go to catch clause
				}
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Please enter a valid value for gallons!\nIt cannot be negative!", "ERROR_MESSAGE"
						,JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			addCustomer(custType, custNumber, custName, gallons);
			
			reply=JOptionPane.showConfirmDialog(null, "Would you like to continue?");
			
		} while(reply==JOptionPane.YES_OPTION); // end while-loop
		
		/*
		//delete an object
		int id=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer number to remove: "));		
		remove(id);
		*/
		
		displayBill();
		

	} //end main


	public static void addCustomer (int custType, int custNumber, String custName, int gallons) {
		Customer cust;
		if (custType==1)
			cust = new Customer(custName, custNumber, new SingleFamily(gallons));
		else
			cust = new Customer(custName, custNumber, new Duplex(gallons));
		//checking if the customer exists
		if (customers.findNode(cust.getCustNumber())==-1){
			int index=customers.findIndex(cust.getBill().getValue());
			customers.add(index, cust);
		} else {
			JOptionPane.showMessageDialog(null, "Customer exists!");
		}
		
		cust=null;
	} //end addCustomer
	
	public static void displayBill() {
		
		String output=customers.toString();
		JOptionPane.showMessageDialog(null, new JTextArea(output), "WATERBILL", JOptionPane.INFORMATION_MESSAGE);
	} //end displayBill()
	
	public static void remove (int id){
		if (customers.findNode(id)==-1)
			JOptionPane.showMessageDialog(null, "Customer not exists");
		else
			customers.remove(customers.findNode(id));
	}
}
