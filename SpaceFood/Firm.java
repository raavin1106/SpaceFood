/**
 * @author Raavin Ashwath Sundar Rajan
 * @version V1-30thOct2018
 */
public class Firm
{
	private String FirmID;

	private String FirmName;

	private boolean TaxPay;

	private String PickupBayID;


	public Firm(String FirmID, String fullName, boolean TaxPay, String PickupBayID) {
		super();
		this.FirmID = FirmID;
		this.FirmName = fullName;
		this.TaxPay = TaxPay;
		this.PickupBayID = PickupBayID;
	}
	
	public String FirmID() {
		return FirmID;
	}

	
	public String FirmName() {
		return FirmName;
	}

	
	public boolean TaxPay() {
		return TaxPay;
	}

	
	public String PickupBayID() {
		return PickupBayID;
	}





}
