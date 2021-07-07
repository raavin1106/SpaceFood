/**
 * @author Raavin Ashwath Sundar Rajan
 * @version V1-30thOct2018
 */

public class Consumables
{
    private String ConsumableID;
    
    private double getAmount;
    
    private String getCategory;
    
    private int ConsumableWeight;
    
    public Consumables(String ConsumableID, double getAmount, String getCategory, int ConsumableWeight) {
        super();
        this.ConsumableID= ConsumableID;
        this.getAmount = getAmount;
        this.getCategory = getCategory;
        this.ConsumableWeight = ConsumableWeight;
    }
    
    
        public String ConsumableID() {
        return ConsumableID;
    }
    
    
        public double getAmount() {
        return getAmount;
    }
    
    
        public String getCategory() {
        return getCategory;
    }
    
    
        public int ConsumableWeight() {
        return ConsumableWeight;
    }   

    
    
    
}
