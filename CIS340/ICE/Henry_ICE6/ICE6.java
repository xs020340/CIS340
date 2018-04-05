package Henry_ICE6;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ICE6 {
	
	static Customer[] customers;

	public static void main(String[] args) throws FileNotFoundException {
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
		
		readFromFile("inputWaterBill.txt");
		
		for(int i=0;i<noOfCustomers-3;i++){//-3 for the records in the file
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
		sortBill();
		writeToFile();
		

	} //end main

	public static void addCustomer (int custType, int custNumber, String custName, int gallons) {
		if (Customer.getNumOfCustomers()<customers.length){
			if (custType==1)
				customers[Customer.getNumOfCustomers()]=new Customer(custName, custNumber, new SingleFamily(gallons));
			else
				customers[Customer.getNumOfCustomers()]=new Customer(custName, custNumber, new Duplex(gallons));
		} else {
			JOptionPane.showMessageDialog(null, "The array is full");
		}
	} //end addCustomer
	
	public static void displayBill() {
		
		String output="Name\tNumber\tGallons\tBill\tBilldate\n";
		for (int i=0; i<customers.length; i++) {
			output+=customers[i].toString()+"\n";
		}
		JOptionPane.showMessageDialog(null, new JTextArea(output), "WATERBILL", JOptionPane.INFORMATION_MESSAGE);
	} //end displayBill()
	
	public static void readFromFile(String filename) throws FileNotFoundException{
		//create a new file instance
		File inputFile=new File(filename);
		
		//create a scanner
		Scanner in = new Scanner(inputFile);
		
		//read data from file
		while (in.hasNext()){
			String line=in.nextLine();
			String[] customer=line.split(",");
			addCustomer(Integer.parseInt(customer[0].trim()), 
					Integer.parseInt(customer[1].trim()), 
					customer[2].trim(), 
					Integer.parseInt(customer[3].trim())
					);
			
		}
		
		//close the scanner file
		in.close();
		
	}
	
	public static void sortBill(){
		Arrays.sort(customers);
	}
	
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
