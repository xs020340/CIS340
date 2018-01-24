
import javax.swing.*;

public class TestAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare Variables
		double testScore = 0, hightScore = 0, lowScore = 100, sum = 0;
		int count = 0, btw90_100 = 0, btw80_89 = 0, btw70_79 = 0, btw60_69 = 0, bl60 = 0;
		String strHightScore = "", strLowScore = "";
		
		//Excute while loop
		while(true){
			
			//Input Test Score
			//String strTestScore = JOptionPane.showInputDialog("Enter Test Score");
			String strTestScore = JOptionPane.showInputDialog("Enter Test Score \nEnter minus value to end loop");
			testScore = Double.parseDouble(strTestScore);
			
			//If score is less than zero, the loop terminates
			if (testScore < 0) break;
			
			//Enter Student Name
			String strStudentName = JOptionPane.showInputDialog("Enter Student Name");
			
			//Determine if it's a low score
			if (testScore < lowScore) {
				lowScore = testScore;
				strLowScore = strStudentName;
			} // end if for a new low score
			
			//Determine if it's a high score
			if (testScore > hightScore) {
				hightScore = testScore;
				strHightScore = strStudentName;
			} // end if for a new high score
			
			//Determine running Sum of Test Scores
			sum+=testScore;
			
			//Keep the count of test scores
			count++;
			
			//Determine what grade it receives
			if (testScore >= 90) btw90_100++;
			else if (testScore >= 80) btw80_89++;
			else if (testScore >= 70) btw70_79++;
			else if (testScore >= 60) btw60_69++;
			else bl60++;
			
			
		} // end while statement
		
		//Calculate Average to two decimals
		double dblAverage = sum/count;
		
		//Display results
		String output = "Test Analysis\n\n" + 
						"High Score:" + strHightScore + ":\t" + hightScore + "\n" +
						"Low Score:" + strLowScore + ":\t" + lowScore + "\n\n" +
						"Class Average:" + String.format("%.2f", dblAverage) + "\n\n" +
						"90-100:\t" + btw90_100 + "\n" +
						"80-89:\t" + btw80_89 + "\n" +
						"70-79:\t" + btw70_79 + "\n" +
						"60-69:\t" + btw60_69 + "\n" +
						"Below 60:\t" + bl60 + "\n";
		
		JOptionPane.showMessageDialog(null, new JTextArea(output)); //new to interpret the "\t"
		
	}

}
