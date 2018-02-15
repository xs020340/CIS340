
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
//*********************************************************************
//* 																  *
//* CIS340 Spring 2018  Long Doan  									  *
//* 																  *
//* Program Assignment PA03 										  *
//* 																  *
//* Loops and Array			  				  						  *
//* 																  *
//* Date Created: 02.14.2018					    			      *
//* Saved in: LongDoanPA0301.java  									  *
//* 																  *
//*********************************************************************
//
public class LongDoanPA0301_getInput_Method {

	public static void getInput (int var, String description, String warning, String keyword) {
		int stop=JOptionPane.YES_OPTION;
		while (stop==JOptionPane.YES_OPTION){
			try {
				var=Integer.parseInt(JOptionPane.showInputDialog(description));
				if (var<0)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, warning);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter "+keyword+" ?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
	}
	
	public static void getInput (double var, String description, String warning, String keyword) {
		int stop=JOptionPane.YES_OPTION;
		while (stop==JOptionPane.YES_OPTION){
			try {
				var=Double.parseDouble(JOptionPane.showInputDialog(description));
				if (var<0)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, warning);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter "+keyword+" ?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
	}
	
	public static void getInput (String var, String description, String warning, String keyword) {
		int stop=JOptionPane.YES_OPTION;
		while (stop==JOptionPane.YES_OPTION){
			try {
				var=JOptionPane.showInputDialog(description);
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, warning);
				stop = JOptionPane.showConfirmDialog(null, "Re-enter "+keyword+" ?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		int count=0;
		String output = "";
		int stop = JOptionPane.YES_OPTION;
		// input of numbers of customers
		
		while (stop==JOptionPane.YES_OPTION){
			try {
				num=Integer.parseInt(JOptionPane.showInputDialog("Number of Customers."));
				if (num<0)
					throw new Exception();
				break;
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "Values must be above zero.");
				stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
				if (stop!=JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "Exit Program");
					System.exit(0);
				}
				continue;
			}
		}
		num=Integer.parseInt(JOptionPane.showInputDialog("Number of Customers."));
		
		// initialize arrays
		int [] custType = new int [num];
		int [] month = new int [num];
		String [] custName = new String [num];
		String [] custTypeStr = new String [num];
		String [] monthStr = new String [num];
		double [] energyUsed = new double [num];
		double [] billAmount = new double [num];
		
		final double BASE_RES=6.75, BASE_COM=10.75, RATE_RES_WINTER=0.04604, RATE_RES_SUMMER_1=0.04604,
				RATE_RES_SUMMER_2=0.09000, RATE_COM_WINTER=0.03920, RATE_COM_SUMMER=0.06450;
		
		for (count=0;count<num;count++){
			// real Input
			while (stop==JOptionPane.YES_OPTION){
				try {
					custType[count]=Integer.parseInt(JOptionPane.showInputDialog("Type of customer (0 for Residential; 1 for Commercial): "));
					if (custType[count]<0)
						System.exit(0);
					if (custType[count] != 0 && custType[count] != 1)
						throw new Exception();
					break;
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Wrong type of customer. (0 for Residential; 1 for Commercial) " , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
					stop = JOptionPane.showConfirmDialog(null, "Re-enter the value?");
					if (stop!=JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "Exit Program");
						System.exit(0);
					}
					continue;
				}
			}
			if (custType[count]==0){
				custTypeStr[count]="Residential";
			} else {
				custTypeStr[count]="Commercial";
			}
			
			while (stop==JOptionPane.YES_OPTION){
				try {
					custName[count]=JOptionPane.showInputDialog("Name of the customer - First Name Last Name: ");
					if (custName[count]=="")
						throw new Exception();
					break;
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Blank Name!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
					stop = JOptionPane.showConfirmDialog(null, "Re-enter the name?");
					if (stop!=JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "Exit Program");
						System.exit(0);
					}
					continue;
				}
			}
			while (stop==JOptionPane.YES_OPTION){
				try {
					energyUsed[count]=Double.parseDouble(JOptionPane.showInputDialog("Energy usage (kWh decimal value): "));
					if (energyUsed[count]<=0)
						throw new Exception();
					break;
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Invalid value!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
					stop = JOptionPane.showConfirmDialog(null, "Re-enter value?");
					if (stop!=JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "Exit Program");
						System.exit(0);
					}
					continue;
				}
			}
			while (stop==JOptionPane.YES_OPTION){
				try {
					month[count]=Integer.parseInt(JOptionPane.showInputDialog("Month for the bill (1 for Jan, 2 for Feb, etc): "));
					if (month[count]>12 || month[count]<1)
						throw new Exception();
					break;
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Invalid month!" , "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
					stop = JOptionPane.showConfirmDialog(null, "Re-enter month?");
					if (stop!=JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null, "Exit Program");
						System.exit(0);
					}
					continue;
				}
			}
			switch (month[count])
			{
			case 1:
				monthStr[count] = "Jan";
				break;
			case 2:
				monthStr[count] = "Feb";
				break;
			case 3:
				monthStr[count] = "Mar";
				break;
			case 4:
				monthStr[count] = "Apr";
				break;
			case 5:
				monthStr[count] = "May";
				break;
			case 6:
				monthStr[count] = "Jun";
				break;
			case 7:
				monthStr[count] = "Jul";
				break;
			case 8:
				monthStr[count] = "Aug";
				break;
			case 9:
				monthStr[count] = "Sep";
				break;
			case 10:
				monthStr[count] = "Oct";
				break;
			case 11:
				monthStr[count] = "Nov";
				break;
			case 12:
				monthStr[count] = "Dec";
				break;
			}
			// calculation of the bill
			if (custType [count] == 0){
				if (month[count]<=9 && month[count]>=6){
					if (energyUsed[count]<=500){
						billAmount[count]=BASE_RES+RATE_RES_SUMMER_1*energyUsed[count];
					} else if (energyUsed[count]>500){
						billAmount[count]=BASE_RES+RATE_RES_SUMMER_1*500+RATE_RES_SUMMER_2*(energyUsed[count]-500);
					}
				} else {
					billAmount[count]=BASE_RES+RATE_RES_WINTER*energyUsed[count];
				}
			} else if (custType[count] == 1){
				if (month[count]<=9 && month[count]>=6){
					billAmount[count]=BASE_COM+RATE_COM_SUMMER*energyUsed[count];
				} else {
					billAmount[count]=BASE_COM+RATE_COM_WINTER*energyUsed[count];
				}
			}
		}
		
		//output
		
		/*output = String.format("Name           Type of Customer    Energy Used  Month    Bill Amount\n");
		
		for (count=0;count<num;count++){
			output += String.format("%-15s %-20s %13.2f %-7s $ %.2f\n", 
					custName[count] ,custTypeStr[count], 
					energyUsed[count], monthStr[count], billAmount[count]);*/
	output = String.format("Name\t Type of Customer \t Energy Used \t Month \t  Bill Amount\n");
		
		for (count=0;count<num;count++){
			output += String.format("%s \t %s \t\t %.2f \t %s \t $ %.2f\n", 
					custName[count] ,custTypeStr[count], 
					energyUsed[count], monthStr[count], billAmount[count]);
		
		
		
		}
					JTextArea textArea = new JTextArea(output);
		
		JOptionPane.showMessageDialog(null,textArea);
		
	}

}
