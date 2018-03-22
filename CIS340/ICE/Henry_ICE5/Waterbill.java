package Henry_ICE5;

public class Waterbill {
	static final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
	static final double BASE_CHARGE_DUPLEX = 15.51;
	
	private int gallons;
	private double billvalue;
	private int billtype;
	private String billRate;
	
	public Waterbill() {
		this.gallons=0;
		this.billvalue=0;
	}
	
	public Waterbill(int gallons, int billtype) {
		super();
		this.gallons = gallons;
		this.billtype = billtype;
		computeBill();
	}
	
	private void computeBill() {
		//calculation
		switch (billtype){
		case 1: 
			if (gallons <= 7000) billvalue = BASE_CHARGE_SINGLE_FAMILY + gallons*2.04/1000;
			else if (gallons <=13000) billvalue = BASE_CHARGE_SINGLE_FAMILY +7000*2.04/1000 +(gallons-7000)*2.35/1000;
			else billvalue = BASE_CHARGE_SINGLE_FAMILY+7000*2.04/1000 +6000*2.35/1000+(gallons-13000)*2.70/1000;
			billRate="Single";
			break;
		case 2: 
			if(gallons <=9000) billvalue = BASE_CHARGE_DUPLEX+gallons*1.97/1000;
			else if (gallons <=13000) billvalue = BASE_CHARGE_DUPLEX +9000*1.97/1000 +(gallons-9000)*2.26/1000;
			else billvalue = BASE_CHARGE_DUPLEX+9000*1.97/1000 +4000*2.26/1000+(gallons-13000)*2.60/1000;
			billRate="Duplex";
			break;
		}
	} //end of compute bill

	@Override
	public String toString() {
		return "Waterbill [gallons=" + gallons + ", billvalue=" + billvalue + ", billRate=" + billRate + "]";
	}
	
	
}
