import java.text.DecimalFormat;

/**
 * @author Raavin Ashwath Sundar Rajan
 * @version V1-30thOct2018
 */
public class ProcessOrder
{

	// Firm Variables
	private Firm company;
	private Consumables consumables1;
	private Consumables consumables2;
	private Consumables consumables3;
	private Consumables consumables4;
	private Consumables consumables5;
	private int aggregate1;
	private int aggregate2;
	private int aggregate3;
	private int aggregate4;
	private int aggregate5;

	public ProcessOrder(Firm company)
	{
		this.company=company;
	}

	
	public void addconsumables(int index, Consumables consumables,int quantity)
	{
		if(index==0)
		{
			consumables1=consumables;
			aggregate1=quantity;
		}
		else if(index==1)
		{
			consumables2=consumables;
			aggregate2=quantity;
		}
		else if(index==2)
		{
			consumables3=consumables;
			aggregate3=quantity;
		}
		else if(index==3)
		{
			consumables4=consumables;
			aggregate4=quantity;
		}
		else if(index==4)
		{
			consumables5=consumables;
			aggregate5=quantity;
		}

	}
	
	private double getPackagingCost(int weight)
	{
		if(weight<5)
			return 3192;
		else if(weight >= 5 && weight <=15)
			return 6823.50;
		else
			return 457*weight;

	}

	@Override
	public String toString() {
		StringBuilder res=new StringBuilder("");
		res.append("|----------------------------------------------------------------------------------------|");
		res.append(System.lineSeparator());
		String format1="| Quotation For  %5s %25s (pack at dock %5s)%20s|";
		res.append(String.format(format1, company.FirmID(),company.FirmName(),company.PickupBayID(),""));
		res.append(System.lineSeparator());
		res.append("|----------------------------------------------------------------------------------------|");
		res.append(System.lineSeparator());
		String format="%6s | %-3s | %-6s | %-6s | %-9s | %-10s |";
		String format2="%7s| %4d| %7.2f| %7d| %10.2f| %7.2f kg |";
		String str=String.format(format, "Item","Num","Cost","Weight","Tot Cost","Tot Weight");

		res.append("|"+str);
		res.append(System.lineSeparator());
		res.append("|-------|-----|--------|--------|-----------|------------|");
		res.append(System.lineSeparator());
		int tWeight=0;
		double tCost=0.0;

		Consumables f=consumables1;
		if(aggregate1!=0)
		{
			res.append("|"+String.format(format2,f.ConsumableID(),aggregate1,f.getAmount(),f.ConsumableWeight(),
					f.getAmount()*aggregate1,
					(f.ConsumableWeight()*aggregate1)/1000.0));
			res.append(System.lineSeparator());
			tWeight+=f.ConsumableWeight()*aggregate1;
			tCost+=f.getAmount()*aggregate1;
		}
		f=consumables2;
		if(aggregate2!=0)
		{
			res.append("|"+String.format(format2,f.ConsumableID(),aggregate2,f.getAmount(),f.ConsumableWeight(),
					f.getAmount()*aggregate2,
					(f.ConsumableWeight()*aggregate2)/1000.0));
			res.append(System.lineSeparator());
			tWeight+=f.ConsumableWeight()*aggregate2;
			tCost+=f.getAmount()*aggregate2;
		}
		f=consumables3;
		if(aggregate3!=0)
		{
			res.append("|"+String.format(format2,f.ConsumableID(),aggregate3,f.getAmount(),f.ConsumableWeight(),
					f.getAmount()*aggregate3,
					(f.ConsumableWeight()*aggregate3)/1000.0));
			res.append(System.lineSeparator());
			tWeight+=f.ConsumableWeight()*aggregate3;
			tCost+=f.getAmount()*aggregate3;
		}
		f=consumables4;
		if(aggregate4!=0)
		{
			res.append("|"+String.format(format2,f.ConsumableID(),aggregate4,f.getAmount(),f.ConsumableWeight(),
					f.getAmount()*aggregate4,
					(f.ConsumableWeight()*aggregate4)/1000.0));
			res.append(System.lineSeparator());
			tWeight+=f.ConsumableWeight()*aggregate4;
			tCost+=f.getAmount()*aggregate4;
		}
		f=consumables5;
		if(aggregate5!=0)
		{
			res.append("|"+String.format(format2,f.ConsumableID(),aggregate5,f.getAmount(),f.ConsumableWeight(),
					f.getAmount()*aggregate5,
					(f.ConsumableWeight()*aggregate5)/1000.0));
			res.append(System.lineSeparator());
			tWeight+=f.ConsumableWeight()*aggregate5;
			tCost+=f.getAmount()*aggregate5;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		int weight=(int) (Math.ceil(tWeight/1000.0));
		res.append("|-------|-----|--------|--------|-----------|------------|");
		res.append(System.lineSeparator());
		res.append("| Total Weight g     :"+String.format("%10d", tWeight));
		res.append(System.lineSeparator());
		res.append("| Billing Weight kg  :"+String.format("%10s",df.format(weight)));
		res.append(System.lineSeparator());
		res.append("| Total consumables Cost    :"+String.format("%10s",df.format(tCost)));
		res.append(System.lineSeparator());
		res.append("| Packing Cost       :"+String.format("%10s",df.format(getPackagingCost(weight))));
		res.append(System.lineSeparator());
		res.append("| To Orbit Cost      :"+String.format("%10s",df.format(weight*WarehouseTbls.TO_ORBIT_COST)));
		res.append(System.lineSeparator());
		double total=tCost+getPackagingCost(weight)+weight*WarehouseTbls.TO_ORBIT_COST;
		res.append("| Total Meal Cost    :"+String.format("%10s",df.format(total)));
		res.append(System.lineSeparator());
		res.append("|----------------------------------------------------------------------------------------|");
		res.append(System.lineSeparator());
		return res.toString();
	}




}
