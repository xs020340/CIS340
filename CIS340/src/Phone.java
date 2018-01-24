import javax.swing.JOptionPane;

public class Phone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double bill = 0.00;
		int minutes = 0;
		//boolean stop = false;
		int stop = JOptionPane.YES_OPTION;
		
		while (stop==JOptionPane.YES_OPTION){
		try{		
		//Display input box requesting input for number of minutes
		String minutesString = JOptionPane.showInputDialog(
				null, "Enter Cell Phone Minutes");

		//Convert minutesString to double variable minutes
		minutes = Integer.parseInt(minutesString);
		
		//stop = !stop;
		
		stop = 0;
		
		} catch (Exception ex) {
			stop = JOptionPane.showConfirmDialog(null, "Invalid Input, would you like to enter agian?");
			if (stop==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "exit program");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, stop);
		} // end of try-catch
		} // end while
		
		//Calculate cell phone bill
		if (minutes < 200.0)
			bill = 19.99;
		else
			bill = 19.99 + ((minutes - 200.0) * 0.1);

		//Output cell phone bill
		String output = "Your bill is $ " + String.format("%.2f" , bill);
		JOptionPane.showMessageDialog(null,output);




	}

}
