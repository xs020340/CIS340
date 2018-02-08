import javax.swing.*;
public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int a = 1, b=2;
		int [] c = {1,2};
		
		System.out.println("a="+a+";b="+b);
		System.out.println("a[]="+c[0]+", "+c[1]);
		
		swap (a,b);
		swapFirst (c);
		
		System.out.println("a="+a+";b="+b);
		System.out.println("a[]="+c[0]+", "+c[1]);
		
		
		
		
		//System.out.print((int)'A');
		
		/*
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
		*/
	}
	public static void swap(int n1, int n2) {
		int temp = n1;
		n1=n2;
		n2=temp;
		return;
	}
	public static void swapFirst(int[] array){
		int temp = array[0];
		array[0] = array [1];
		array[1] = temp;
		return;
	}

}
