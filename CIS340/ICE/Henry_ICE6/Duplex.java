package Henry_ICE6;

public class Duplex extends Waterbill {

	public Duplex(double gallons) {
		super(gallons);
		computeBill();
	}

	@Override
	protected void computeBill() {
		if(gallons <=9000) value = BASE_CHARGE_DUPLEX+gallons*1.97/1000;
		else if (gallons <=13000) value = BASE_CHARGE_DUPLEX +9000*1.97/1000 +(gallons-9000)*2.26/1000;
		else value = BASE_CHARGE_DUPLEX+9000*1.97/1000 +4000*2.26/1000+(gallons-13000)*2.60/1000;
		
	}
	

}
