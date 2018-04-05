package Henry_ICE6;

public class Customer {
	
	private String custName;
	private int custNumber;
	private int custRate;
	private Waterbill bill;
	private static int numOfCustomers;
	
	public Customer() {
		this.custName=null;
		this.custNumber=0;
		this.bill=null;
		numOfCustomers=0;
	}
	
	public Customer(String custName, int custNumber, Waterbill bill) {
		super();
		this.custName = custName;
		this.custNumber = custNumber;
		this.bill = bill;
		numOfCustomers++;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(int custNumber) {
		this.custNumber = custNumber;
	}

	public Waterbill getBill() {
		return bill;
	}

	public void setBill(Waterbill bill) {
		this.bill = bill;
	}

	public static int getNumOfCustomers() {
		return numOfCustomers;
	}

	public static void setNumOfCustomers(int numOfCustomers) {
		Customer.numOfCustomers = numOfCustomers;
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custNumber=" + custNumber + ", custRate=" + custRate + ", bill="
				+ bill.toString() + "]";
	}
	
	
	
	

}
