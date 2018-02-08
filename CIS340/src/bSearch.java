import javax.swing.*;
public class bSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Use binary search code to find the key in the list
		int [] list = {1,3,5,6,10,12,22,25,26};
		int key=0;
		key = Integer.parseInt(JOptionPane.showInputDialog("key"));
		int low = 0;
		int high = list.length - 1;
		int index = -1;
		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key == list[mid]){
				index = mid;
				break;
			}
			else low = mid + 1;
		}// end of while loop
		if (index == -1)
		index = - low - 1;//index = -(insertion point) - 1
		System.out.println(index);

	}

}
