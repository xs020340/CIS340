import javax.swing.JOptionPane;

public class HenryLiuICE1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//input variables
		String custNumber, custName;
		int gallons;
		double billValue;
		final double BASE_CHARGE = 16.33;
		String output = "Water Bill:\n";
		
		//obtain user input
		custNumber = JOptionPane.showInputDialog(null,
				"Enter customer number: ");
		custName = JOptionPane.showInputDialog(null,
				"Enter customer name: ");
		gallons = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter number of gallons: "));
		
		//calculation
		if  (gallons <= 7000) 
			billValue = BASE_CHARGE + gallons*2.53/1000;
		else if (gallons<=13000)
			billValue = BASE_CHARGE + 7000*2.53/1000 + (gallons-7000)*2.91/1000;
		else 
			billValue = BASE_CHARGE + 7000*2.53/1000 + 6000*2.91/1000 + (gallons-13000)*3.34/1000;
		
		//display output
		output+="Customer Number: " +custNumber +"\nCustomer Name: " 
				+custName +"\nGallons: " 
				+gallons +"\nBill Value: " +String.format("%.2f",  billValue);
		
		JOptionPane.showMessageDialog(null, output);
	}

}
