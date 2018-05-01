package Henry_ICE8;

public class SingleFamily extends Waterbill{

	public SingleFamily(double gallons) {
		super(gallons);
		computeBill();
	}

	@Override
	protected void computeBill() {
		if (gallons <= 7000) value = BASE_CHARGE_SINGLE_FAMILY + gallons*2.04/1000;
		else if (gallons <=13000) value = BASE_CHARGE_SINGLE_FAMILY +7000*2.04/1000 +(gallons-7000)*2.35/1000;
		else value = BASE_CHARGE_SINGLE_FAMILY+7000*2.04/1000 +6000*2.35/1000+(gallons-13000)*2.70/1000;
	}

}
