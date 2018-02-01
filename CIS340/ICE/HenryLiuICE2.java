import javax.swing.JOptionPane;

public class HenryLiuICE2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare
		int gallons = 0;
		double value = 0;
		String custName = null;
		int custNumber = 0;
		int custType = 0;
		final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
		final double BASE_CHARGE_DUPLEX = 15.51;
		String output = "Water Bill";
		
		//input customer rate
		try{
		custType=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Customer Type \n1-Single Family \n2-Duplex"));
		if (custType!=1 && custType!=2)
			throw new Exception(); //control goes to catch clause
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,  "Invalid Customer Rate! \nIt must be 1 or 2");
			System.exit(0);
		}
		
		//obtain user input
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
		
		
		//calculation
		switch (custType){
		case 1: 
			if (gallons <= 7000) value = BASE_CHARGE_SINGLE_FAMILY + gallons*2.04/1000;
			else if (gallons <=13000) value = BASE_CHARGE_SINGLE_FAMILY +7000*2.04/1000 +(gallons-7000)*2.35/1000;
			else value = BASE_CHARGE_SINGLE_FAMILY+7000*2.04/1000 +6000*2.35/1000+(gallons-13000)*2.70/1000;
			output+="-Single-Type\n"
					+"--------------------------------------\n";
			break;
		case 2: 
			if(gallons <=9000) value = BASE_CHARGE_DUPLEX+gallons*1.97/1000;
			else if (gallons <=13000) value = BASE_CHARGE_DUPLEX +9000*1.97/1000 +(gallons-9000)*2.26/1000;
			else value = BASE_CHARGE_DUPLEX+9000*1.97/1000 +4000*2.26/1000+(gallons-13000)*2.60/1000;
			output+="-Duplex\n"
					+"--------------------------------------\n";
			break;
		}
				
		//display output
		output+="Customer Number: " +custNumber +"\nCustomer Name: " 
				+custName +"\nGallons: " 
				+gallons +"\nBill Value: $" +String.format("%.2f",  value);
		
		JOptionPane.showMessageDialog(null, output);
	}

}
