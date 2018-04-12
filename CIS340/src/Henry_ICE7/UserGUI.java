package Henry_ICE7;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;



public class UserGUI extends JFrame implements ActionListener{
	
	private Customer[] customers;
	private String fileName;
	
	// declare all GUI components below
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblGallons;
	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtGallons;
	
	private JButton btnAdd;
	private JButton btnClose;
	private JButton btnSave;
	private JButton btnSort;
	
	private JTextArea textArea;
	private JScrollPane jp;
	
	JRadioButton singleFamily;
	JRadioButton duplex;
	ButtonGroup group;
	

		      	
	// constructor
		UserGUI(String fileName, int noOfCustomers){
			
			customers = new Customer[noOfCustomers];
	        this.fileName = fileName;
	       
			initComponent();
			doTheLayout();
			
			// add buttons to the action listeners
			btnAdd.addActionListener(this);
			btnSave.addActionListener(this);
			btnSort.addActionListener(this);
			btnClose.addActionListener(this);
			

			
			// call read data from file
			 try {
					readFromFile(fileName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

		private void initComponent(){
			
			// Initialize the GUI components
			// labels and text fields
			 lblName = new JLabel ("Name: ");
			 lblNumber = new JLabel("Number: ");
			 lblGallons = new JLabel("Gallons: ");
			 
			 txtName = new JTextField(20);
			 txtNumber = new JTextField(10);
			 txtGallons = new JTextField(10);
			 
			 
		      
		   // radio buttons
		     singleFamily = new JRadioButton("SingleFamily", true);
		     duplex = new JRadioButton("Duplex");
		     group = new ButtonGroup();
		     group.add(singleFamily);
		     group.add(duplex);
		     
		      
		   // define text area and add it to scroll pane   
		   textArea = new JTextArea("Program Output\n", 10, 48);
		   textArea.setEditable(false);
		   
		   jp=new JScrollPane(textArea);
		   		      
		      // buttons
		   btnAdd = new JButton("Add");
		   btnClose = new JButton("Close");
		   btnSave = new JButton("Save");
		   btnSort = new JButton("Sort");
	  
		}

	   private void doTheLayout(){
			// Organize the components into GUI window
		   JPanel top = new JPanel();
		   JPanel center = new JPanel();
		   JPanel centerTop = new JPanel();
		   JPanel centerBottom = new JPanel();
		   JPanel bottom = new JPanel();
		   
		      // add components to the top panel
		   top.add(lblName);
		   top.add(txtName);
		   top.add(singleFamily);
		   top.add(duplex);
		   
		   center.setLayout(new BorderLayout());
   
		      // add components to the centerTop panel
		   centerTop.add(lblNumber);
		   centerTop.add(txtNumber);
		   centerTop.add(lblGallons);
		   centerTop.add(txtGallons);
		      
		     // add components to the centerBottom panel
		   centerBottom.add(btnAdd);
		   centerBottom.add(btnSort);
		   centerBottom.add(btnSave);
		   centerBottom.add(btnClose);
		   		    
		      // add panels centerTop and centerBottom to the center panel
		   center.add(centerTop, BorderLayout.CENTER);
		   center.add(centerBottom, BorderLayout.SOUTH);
		   
		      
		      // add scroll pane to the bottom panel
		   bottom.add(jp);
		   
		      //add the panels to the GUI content pane
		   this.add(top, "North");
		   this.add(center, "Center");
		   this.add(bottom, "South");
		   
		 
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// use if statement to call proper methods to process events
	        if (e.getSource() == btnAdd)
	        	btnAddClicked();
	        else if (e.getSource() == btnSort)
	        	sortButtonClicked();
	        else if (e.getSource() == btnSave)
				try {
					saveButtonClicked();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        else 
	        	btnCloseClicked();
	        
	        
		}

		private void btnCloseClicked() {
			// exit program
			System.exit(0);
		}

		private void btnAddClicked(){
			// code to be executed once the add button is clicked
			// validation .... 
			
			String name = "";
			int number = 0;
			int gallons = 0;
			
			try {
    			name = txtName.getText().trim();
    			if (name.length() == 0)
    				throw new Exception();
    		}catch (Exception ex){
    	    	  JOptionPane.showMessageDialog(txtName, "Invalid Input");
    	    	  txtName.setText("");
    	    	  return;
    	      }
			
			
			try {
    			if (txtNumber.getText().trim().length() != 6)
    				throw new Exception();
    			else
    				number = Integer.parseInt(txtNumber.getText().trim());
    		}catch (Exception ex){
    	    	  JOptionPane.showMessageDialog(txtNumber, "Invalid Input");
    	    	  txtNumber.setText("");
    	    	  return;
    	      }
			
			try {
    			gallons = Integer.parseInt(txtGallons.getText().trim());
    		}catch (Exception ex){
    	    	  JOptionPane.showMessageDialog(txtGallons, "Invalid Input");
    	    	  txtGallons.setText("");
    	    	  return;
    	      }
			
			
			
			if (singleFamily.isSelected())
				addCustomer(name,number, gallons,1);
			else if (duplex.isSelected())
				addCustomer(name, number, gallons,2);
			
			// clear text fields from data
			txtName.setText("");
			txtNumber.setText("");
			txtGallons.setText("");

		}

		private void saveButtonClicked() throws FileNotFoundException{
			// code to be executed once the save button is clicked
			
			selectionSort();
			writeToFile();
			display();
		}
		
		
		private void sortButtonClicked(){
			// code to be executed once the close button is clicked
			selectionSort();
			display();
			
		}
	
		public void addCustomer(String name, int number, int gallons, int status){
			
			if (Customer.getNumOfCustomers() < customers.length) {
			if (status == 1)
			customers[Customer.getNumOfCustomers()] =
					new Customer(name, number, new SingleFamily(gallons));
			else if (status == 2)
				customers[Customer.getNumOfCustomers()] =
				new Customer(name, number, new Duplex(gallons));
			} else 
				JOptionPane.showMessageDialog(null, "The array of customers is full");
			
			display();
				
		}

	private void display(){
		
		String message = "Water Bill: \n" + "Name\t" + "Number\t" + "Gallons\t" + "Bill\t" + "Bill Date"; ;
		for (int i = 0; i < Customer.getNumOfCustomers(); i++)
		   message+="\n" + customers[i].toString();
		
		message+= "\nAverage Bill Values: " + String.format("%.2f", avg());
		
		// display message to the text area
		textArea.setText(message);
		
	}
	
	private void selectionSort() {
		
		 for (int i = 0; i < Customer.getNumOfCustomers() -1; i++) {
		      // Find the minimum in the customers[i..customers.length-1]
		      Customer currentMin = customers[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < Customer.getNumOfCustomers(); j++) {
		        if (currentMin.compareTo(customers[j]) > 0) {
		          currentMin = customers[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap customers[i] with customers[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        customers[currentMinIndex] = customers[i];
		        customers[i] = currentMin;
		      }
		    }
	}
	
	private void writeToFile() throws FileNotFoundException {
		File file = new File("outputWaterBill.txt");

	    // Create a file
	    PrintWriter output = new PrintWriter(file);
		

		for (int i =0; i < Customer.getNumOfCustomers(); i++)
			output.println(customers[i].toString());

	    // Close the file
	    output.close();
	}
	
	
	private void readFromFile(String filename) throws FileNotFoundException {
		
		// Create a File instance
	    java.io.File file = new java.io.File(fileName);

	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);

	    // Read data from a file
	    while (input.hasNext()) {
	      String line = input.nextLine();
	      String[] customer = line.split(",");
	      addCustomer(customer[0], Integer.parseInt(customer[1].trim()), Integer.parseInt(customer[2].trim()),Integer.parseInt(customer[3].trim()));	  
	      
	    }

	    // Close the file
	    input.close();
	  }

	private double avg(){
		double sum =0;
		for (int i = 0; i < Customer.getNumOfCustomers(); i++)
			sum+=customers[i].getBill().getValue();
		
		return sum/Customer.getNumOfCustomers() ;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		        //declare variables
				int numberOfcustomers = 0;
				
				// inputs
				numberOfcustomers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of Customers:"));

				UserGUI frame = new UserGUI("inputWaterBill.txt", numberOfcustomers);
				frame.setTitle("User Water Bill Application");
			    frame.pack();
			    frame.setLocationRelativeTo(null); // Center the frame
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setVisible(true);

	
	}// end main
	

}
