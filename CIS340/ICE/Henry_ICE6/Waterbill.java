package Henry_ICE6;
import java.util.Date;

public abstract class Waterbill implements BaseCharge{
	protected double gallons;
	protected double value;
	private Date createdDate;
	
	public Waterbill(double gallons) {
		super();
		this.gallons = gallons;
		this.createdDate = new Date();
		
	}

	public double getGallons() {
		return gallons;
	}

	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	protected abstract void computeBill();

	@Override
	public String toString() {
		return gallons + "\t$" + String.format(".%2f", value) + "\t" + createdDate;
		
	}
	
	
	
}