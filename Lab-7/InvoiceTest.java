class Invoice{
    private String partNumber;
    private String partDesc;
    private int quantity;
    private double pricePerItem;
    Invoice(){
        partNumber="0";
        partDesc="";
        quantity=0;
        pricePerItem=0.0;
    }
    Invoice(String partNumber,String partDesc,int quantity,double pricePerItem)
    {
        this.partNumber=partNumber;
        this.partDesc=partDesc;
        this.quantity=quantity;
        this.pricePerItem=pricePerItem;
        if(quantity<0){
            quantity=0;
        }
        if(pricePerItem<0)
        {
            pricePerItem=0;
        }
    }
    public String getPartNumber()
    {
        return this.partNumber;
    }
    public void setPartNumber(String partNumber)
    {
        this.partNumber=partNumber;
    }
        public String getPartDesc()
    {
        return this.partDesc;
    }
    public void setPartDesc(String partDesc)
    {
        this.partDesc=partDesc;
    }
    public int getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
        if(quantity<0){
            quantity=0;
        }
    }
    public double getPricePerPart()
    {
        return this.pricePerItem;
    }
    public void setPricePerPart(double pricePerItem)
    {
        this.pricePerItem=pricePerItem;
        if(pricePerItem<0)
        {
            pricePerItem=0;
        }
    }
    public double getTotalCost()
    {
        return quantity*pricePerItem;
    }
}

public class InvoiceTest {
    public static void main(String [] args)
    {
        Invoice A=new Invoice();
        A.setPartNumber("1");
        A.setPartDesc("ScrewDriver");
        A.setQuantity(2);
        A.setPricePerPart(129.50);
        System.out.println("PartNumber: "+A.getPartNumber());
        System.out.println("PartDescription: "+A.getPartDesc());
        System.out.println("Quantity: "+A.getQuantity());
        System.out.println("Price Per Part: "+A.getPricePerPart());
        System.out.println("TotalCost: "+A.getTotalCost());
    }
}
