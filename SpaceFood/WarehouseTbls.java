import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author Raavin Ashwath Sundar Rajan
 * @version  V1-30thOct2018
 */
public class WarehouseTbls
{
    String selectedOption = "";
    
    Scanner Check = new Scanner(System.in);
    
    final public static double TO_ORBIT_COST=18127;
    
    private Scanner input;

    
    private Consumables food1;
    private Consumables food2;
    private Consumables food3;
    private Consumables food4;
    private Consumables food5;

    private Firm company1;
    private Firm company2;
    private Firm company3;
    private Firm company4;
    private Firm company5;


    public WarehouseTbls()
    {
        input=new Scanner(System.in);
        ConsumablesList();
        FirmList();
    }

    
    private void FirmList() {
        company1=new Firm("BFSC", "Blue Fish Space Co", true, "MERCY");
        company2=new Firm("ECP", "Elon Cannon Personal", false, "KIT");
        company3=new Firm("NAASA", "NAASA", false, "MERCY");
        company4=new Firm("AARG", "AARG", false, "KAT");
        company5=new Firm("PUB", "General Public", false, "MAIL");

    }

    
    private void ConsumablesList() {
        food1=new Consumables("DC", 59, "Date cake" , 134);
        food2=new Consumables("BEEF", 49.50, "Beef sandwich" , 164);
        food3=new Consumables("CS", 93.70, "Cheese sandwich" , 206);
        food4=new Consumables("STRAW", 157.05, "Strawberry desert" , 177);
        food5=new Consumables("EGG2", 77.15, "Scrambled eggs" , 112);  
    }

    private Firm getFirmByID(String id)
    {
        Firm c=company1;
        if(c.FirmID().equalsIgnoreCase(id))
            return c;
        c=company2;
        if(c.FirmID().equalsIgnoreCase(id))
            return c;
        c=company3;
        if(c.FirmID().equalsIgnoreCase(id))
            return c;
        c=company4;
        if(c.FirmID().equalsIgnoreCase(id))
            return c;
        c=company5;
        if(c.FirmID().equalsIgnoreCase(id))
            return c;
        return null;
    }
    
        public void InteractionMenu()
	{
		while(true)
		{
			String choice=OptMenu();
			if(choice.equals("C"))
			{
				PresentFirmTbl();
			}
			else if (choice.equals("Q"))
			{
				System.exit(0);
			
			}
			else if (choice.equals("F"))
			{
				PresentConsumablesTbl();
			}
			else if (choice.equals("QU"))
			{
				CreateQuote();
			}
			else if(choice.equals("QF"))
			{
				System.out.println();
				FileReader();
			}
			else
			{
				System.out.println("!!ENTER VALID OUTPUT!!");
			}
			System.out.println();
		}
	}
            
	private String OptMenu() {
		System.out.println("Space Food Program Menu");
		System.out.println();
		System.out.println("Q - Exit/Quit");
		System.out.println("C - Company Table");
		System.out.println("F - Food Table");
		System.out.println("QU - Generate Quote");
		System.out.println("QF - Generate Quote to fileSelect Option:");
		String choice=input.nextLine();
		System.out.println("You Entered : "+choice);
		return choice.toUpperCase();
	}
        
    

    
    private void FileReader() {
        String file;
        System.out.println("Enter Ordering Company ID: ");
        String id=input.nextLine().toUpperCase();
        System.out.println("Company Code: "+id);
        Firm company=getFirmByID(id);
        if(company==null)
        {
            System.out.println("!!Company doesnt exit!!");
            return;
        }
        ProcessOrder order = new ProcessOrder(company);
        Consumables food=food1;
        int quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(0,food,quantity);

        food=food2;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(1,food,quantity);

        food=food3;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(2,food,quantity);

        food=food4;
        quantity=getConsumableQuota("Please Enter Amount of  "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(3,food,quantity);


        food=food5;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(4,food,quantity);


        System.out.println("Enter File Name To Write Quote To:");
        file=input.nextLine();
        System.out.println("You Entered : "+file);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(order.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File "+file+" Written");
    }

    
    private void CreateQuote() {
        System.out.println("Enter Ordering Company ID: ");
        String id=input.nextLine().toUpperCase();
        System.out.println("Company Code: "+id);
        Firm company=getFirmByID(id);
        if(company==null)
        {
            System.out.println("!!!Company doesnt exit!!!");
            return;
        }
        ProcessOrder order = new ProcessOrder(company);
        Consumables food=food1;
        int quantity=getConsumableQuota("Please Enter Amount of"+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(0,food,quantity);

        food=food2;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(1,food,quantity);

        food=food3;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(2,food,quantity);

        food=food4;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(3,food,quantity);


        food=food5;
        quantity=getConsumableQuota("Please Enter Amount of "+food.ConsumableID()+" "+food.getCategory()+":");
        if(quantity>24)
        {
            System.out.println("!!!Cannot Order More Than 24!!!");
            return;
        }
        order.addconsumables(4,food,quantity);


        System.out.println(order);


    }

    
    private int getConsumableQuota(String string) {
        try
        {
            System.out.println(string);
            int q=Integer.parseInt(input.nextLine());
            if(q<0)
            {
                System.out.println("Enter A Positive Value");
                return getConsumableQuota(string);
            }
            return q; 
        }
        catch(Exception e)
        {
            System.out.println("Enter A Valid Number");
            return getConsumableQuota(string);
        }
    }

    
    private void PresentConsumablesTbl() {
        String format="%-11s | %-23s | %-7s | %-11s";
        String format1="%11s | %-23s | %7d | $%-11.2f";
        String str=String.format(format, "Food Id    ","Food name ","Weight ","Cost");
        System.out.println(str);
        System.out.println("------------+-------------------------+---------+---------+");
        Consumables f=food1;
        System.out.println(String.format(format1,f.ConsumableID(),f.getCategory(),f.ConsumableWeight(),f.getAmount()));
        f=food2;
        System.out.println(String.format(format1,f.ConsumableID(),f.getCategory(),f.ConsumableWeight(),f.getAmount()));
        f=food3;
        System.out.println(String.format(format1,f.ConsumableID(),f.getCategory(),f.ConsumableWeight(),f.getAmount()));
        f=food4;
        System.out.println(String.format(format1,f.ConsumableID(),f.getCategory(),f.ConsumableWeight(),f.getAmount()));
        f=food5;
        System.out.println(String.format(format1,f.ConsumableID(),f.getCategory(),f.ConsumableWeight(),f.getAmount()));

        System.out.println("------------+-------------------------+---------+---------+");


    }

    
    private void PresentFirmTbl() {
        String format="%-11s | %-23s | %-10s | %-11s";
        String format1="%11s | %-23s | %10s | %10s";

        String str=String.format(format, "Company Id","Company name","Tax Exempt","Pickup Bay");
        System.out.println(str);
        System.out.println("------------+-------------------------+------------+-----------+");
        Firm c=company1;
        System.out.println(String.format(format1,c.FirmID(),c.FirmName(),c.TaxPay()?"true":"false",c.PickupBayID()));
        c=company2;
        System.out.println(String.format(format1,c.FirmID(),c.FirmName(),c.TaxPay()?"true":"false",c.PickupBayID()));
        c=company3;
        System.out.println(String.format(format1,c.FirmID(),c.FirmName(),c.TaxPay()?"true":"false",c.PickupBayID()));
        c=company4;
        System.out.println(String.format(format1,c.FirmID(),c.FirmName(),c.TaxPay()?"true":"false",c.PickupBayID()));
        c=company5;
        System.out.println(String.format(format1,c.FirmID(),c.FirmName(),c.TaxPay()?"true":"false",c.PickupBayID()));
        
        
		System.out.println("------------+-------------------------+------------+-----------+");

	}

	
	
}
