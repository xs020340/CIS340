
public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double perCredit = 999.99;
		String courseName = "Java";
		String courseType = "600 Level ";
		
		if (courseName == "Java") {
			if (perCredit < 1000) {
				if (courseType =="600 Level") {
					System.out.println("600, within");
				}else {
					System.out.println("within");
				}
			}else {
				System.out.println("expensive");
			}
		}
		
	}

}
