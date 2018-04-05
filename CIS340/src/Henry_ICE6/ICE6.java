package Henry_ICE6;

import javax.swing.JOptionPane;
import java.io.*;

public class ICE6 {
	
	static Customer[] customers;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare variables
		int gallons=0;
		String custName=null;
		int custNumber=0;
		int custType=0;
		int noOfCustomers=0;
		
		//obtain user input-number of customers
		try {
			noOfCustomers=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of customers: "));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid Value!" + "\nEnter a valid value for number of customers!");
			System.exit(0);
		}
		
		//initialize array with size
		customers=new Customer[noOfCustomers];
		
		for(int i=0;i<noOfCustomers;i++){
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
			
		} // end for-loop
		
		displayBill();
		try {
			writeToFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	} //end main

	public static void addCustomer (int custType, int custNumber, String custName, int gallons) {
		
		Waterbill bill = new Waterbill(gallons, custType);
		customers[Customer.getNumOfCustomers()]= new Customer(custName, custNumber, bill);
		
	} //end addCustomer
	
	public static void displayBill() {
		String output="";
		for (int i=0; i<customers.length; i++) {
			output+=customers[i].toString()+"\n";
		}
		JOptionPane.showMessageDialog(null, output, "WATERBILL", JOptionPane.INFORMATION_MESSAGE);
	} //end displayBill()
	
	public static void writeToFile() throws FileNotFoundException {
		String fileOutput="";
		File myfile=new File("billdetails.txt");
		
		PrintWriter outputFile=new PrintWriter(myfile);
		
		for (int i=0; i<customers.length; i++) {
			fileOutput+=customers[i].toString()+"\n";
		}
		
		outputFile.print(fileOutput);
		outputFile.close();
		
	}

}
