import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class HenryLiuICE4 {
		static final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
		static final double BASE_CHARGE_DUPLEX = 15.51;
		static String[] custInfo;
		static double[] billArr;
		
	public static void main(String[] args) {

		//declare
		int gallons = 0;
		String custName = null;
		int custNumber = 0;
		int custType = 0;
		String title="NUMBER\tNAME\tTYPE\tGALLON\tBILLVALUE\n";
		String customerType=null;
		String output1 = "", output2="";
		int noOfCustomers=0;
		
		
		//obtain user input-number of customers
		try {
			noOfCustomers=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of customers: "));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid Value!" + "\nEnter a valid value for number of customers!");
			System.exit(0);
		}
		
		//Initialize the arrays
		custInfo=new String[noOfCustomers];
		billArr=new double[noOfCustomers];
		
		for(int i=0;i<noOfCustomers;i++){
			//start for-loop
		
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
			
			if (custType==1)
				customerType="Single";
			else 
				customerType="Duplex";
			
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
				billArr[i]=singleFamilyBill(gallons);
				//output+="-Single-Type\n"
				//		+"--------------------------------------\n";
				break;
			case 2: 
				billArr[i]=duplexBill(gallons);
				//output+="-Duplex\n"
				//		+"--------------------------------------\n";
				break;
			}
			custInfo[i]=custNumber+"\t"+custName+"\t"+customerType+"\t"+gallons;
		
			//output1-before sorting
			output1+=custInfo[i]+"\t"+String.format("%.2f", billArr[i])+"\n";
			
			
		} // end for-loop
				
		
		//display output
		displayBill(title+output1,"WATERBILL, CALCULATOR(BEFORE SORTING)");
		
		sortBill();
		for (int i=0;i<noOfCustomers;i++){
			output2+=custInfo[i]+"\t"+String.format("%.2f", billArr[i])+"\n";
		}
		
		// display 2
		displayBill(title+output2, "WATERBILL CALCULATOR(AFTER SORTING)");
	}
	public static double singleFamilyBill(int gallons){
		double value=0;
		if (gallons <= 7000) value = BASE_CHARGE_SINGLE_FAMILY + gallons*2.04/1000;
		else if (gallons <=13000) value = BASE_CHARGE_SINGLE_FAMILY +7000*2.04/1000 +(gallons-7000)*2.35/1000;
		else value = BASE_CHARGE_SINGLE_FAMILY+7000*2.04/1000 +6000*2.35/1000+(gallons-13000)*2.70/1000;
		return value;
	}
	public static double duplexBill(int gallons){
		double value=0;
		if(gallons <=9000) value = BASE_CHARGE_DUPLEX+gallons*1.97/1000;
		else if (gallons <=13000) value = BASE_CHARGE_DUPLEX +9000*1.97/1000 +(gallons-9000)*2.26/1000;
		else value = BASE_CHARGE_DUPLEX+9000*1.97/1000 +4000*2.26/1000+(gallons-13000)*2.60/1000;
		return value;
	}
	public static void displayBill(String message, String title){
		JOptionPane.showMessageDialog(null, new JTextArea(message),title,JOptionPane.INFORMATION_MESSAGE);
	}
	public static void sortBill(){
		int i,j;
		for (i=0;i<billArr.length;i++){
			int currentMinIndex=i;
			double currentMin=billArr[i];
			String currentMinInfo=custInfo[i];
			for (j=i+1;j<billArr.length;j++){
				if(billArr[j]<currentMin){
					currentMin=billArr[j];
					currentMinInfo=custInfo[j];
					currentMinIndex=j;
				}
				}
			//swap
			if(currentMinIndex!=j){
				billArr[currentMinIndex]=billArr[i];
				billArr[i]=currentMin;
				
				custInfo[currentMinIndex]=custInfo[i];
				custInfo[i]=currentMinInfo;
			}
		}
	}
}
