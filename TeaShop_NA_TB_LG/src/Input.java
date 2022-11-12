/**
Project Input Superclass
*/

/**
	This object class simulates the inputs that a tea shop utilizes for the consumer products 
	that they are selling, for example, if the tea shop is going to sell coconut tea to
	a customer they will need to have on hand coconut tea supplies provided by a certain
	vendor. The inputs that tea shop gets will be fed into an input cost report that captures 
	all the inputs purchased from all vendors. Hence, every time an input is created, a line 
	item ID number needs to be created to capture it within the report. For each input,
	the name of vendor purchased from, the category of goods the vendor provides, the 
	name of the input, the unit cost of the input, the total quantity purchased, the discount
	provided the vendor for the input, and the tax rate applied to each input will be 
	captured by this class.
	*/

public class Input {

	private int lineItemID;
	private String vendorName;
	private String vendorCategory;
	private String input;
	private double cost;
	private double taxRate;
	private double discount;
	private int quantity;

	/**
		Constructs a certain input that the tea shop will purchase from a certain vendor.
		@param the line item ID, to be used to record it in the input cost report
		@param the name of the vendor purchased from
		@param the category of goods that the vendor provides, such as tea supplies, food 
		       supples, etc.
		@param the name of the particular input that the tea shop purchases
		@param the unit cost of the input
		@param the quantity of the input purchased
		@param the discount off the unit cost of the input
		@param the tax rate applied to the unit cost of the input		
	*/
		
	public Input (int lineItemID, String vendorName, String vendorCategory, String input, 
		double cost, int quantity, double discount, double taxRate) {
	
		this.lineItemID = lineItemID;
		this.vendorName = vendorName;
		this.vendorCategory = vendorCategory;
		this.input = input;
		this.cost = cost;
		this.taxRate = taxRate;
		this.discount = discount;
		this.quantity = quantity;
		getDiscountAmount(cost, quantity, discount);
		getGrossCost(cost, quantity);
		getTaxAmount(taxRate, cost, quantity);
		getNetCost(taxRate, cost, quantity, discount);

	}
	
	/**
		Empty constructor to retrieve the miscellaneous methods, such as the displayHeaders()
		method below.
	*/
	
	public Input() {
	
	
	}
	
	/**
		Sets the discount rate applied to the cost of the particular input.
		@param the discount rate, as a decimal, ie 0.05, 0.1, etc.
	*/

	public void setDiscount(double discount) {
	
		this.discount = discount;
		
	}
	
	/**	
		Gets the discount rate applied to the cost of the particular input.
		@return the discount rate
	*/
	
	public double getDiscount() {
	
		return discount;
	
	}
	
	/**
		Sets the tax rate applied to the cost of the particular input.
		@param the tax rate, as a decimal, ie 0.05, 0.1, etc.
	*/
	
	public void setTaxRate(double taxRate) {
	
		this.taxRate = taxRate;
	
	}
	
	/**
		Gets the tax rate applied to the cost of the particular input.
		@return the tax rate
	*/
	
	public double getTaxRate() {
	
		return taxRate;
	
	}
	
	/** 
		Sets the name of the particular input purchased by the tea shop.
		@param the name of the input
	*/
	
	public void setInput(String input) {
	
		this.input = input;
	
	}
	
	/**
		Gets the name of the particular input purchased by the tea shop.
		@return the name of the input
	*/

	public String getInput() {
	
		return input;
	
	}
	
	/**
		Sets the number of units of the input purchased by the tea shop.
		@param the quantity purchased, as a nonnegative integer
	*/
	
	public void setQuantity(int quantity) {

		if (quantity >= 0)
		{
		
			this.quantity = quantity;
		
		}
		else 
		{
		
			System.out.println("Quantity must be at least zero.");
		
		}
	
	}
	
	/**
		Gets the number of units of the input purchased by the tea shop.
		@return the quantity purchased
	*/
	
	public int getQuantity() {
	
		return quantity;
	
	}
	
	/**
		Sets the cost of a unit of the input purchased by the tea shop.
		@param the unit cost
	*/
	
	public void setCost(double cost) {
	
		if (cost >= 0.0)
		{
		
			this.cost = cost;
		
		}
		else
		{
		
			System.out.println("Cost must be greater than or equal to zero.");
		
		}
	
	}
	
	/**
		Gets the cost of a unit of the input purchased by the tea shop.
		@return the unit cost
	*/
	
	public double getCost() {
	
		return cost;
	
	}
	
	/**	
		Calculates the gross cost of the quantity of inputs that the tea shop purchases, that
		is, the total cost before discounts and taxes are applied.
		@param the unit cost
		@param the quantity purchased
		@return the gross cost
	*/
	
	public double getGrossCost(double cost, int quantity) {

		double grossCost = 0.0;
		if (quantity <= 0)
		{
		
			grossCost = 0.0;
		
		}
		else 
		{
			
			grossCost = cost * quantity;
		
		}
		
		return grossCost;
	
	}
	
	/**
		Calculates the total amount of taxes that the tea shop has to pay for the quantity
		of units that the tea shop purchases.
		@param the tax rate applied to each unit, as a decimal, ie 0.05, 0.1, etc.
		@param the unit cost 
		@param the quantity purchased
		@return the total amount of taxes owed
	*/
	
	public double getTaxAmount(double taxRate, double cost, int quantity) {
	
		double taxAmount = taxRate * getGrossCost(cost, quantity);
		return taxAmount;
	
	}
	
	/**
		Calculates the total amount taken off from the gross cost of the quantity of units 
		purchased by the tea shop.
		@param the unit cost 
		@param the quantity purchased
		@param the discount rate, as a decimal, ie 0.05, 0.1, etc.
		@return the total discount amount from all the units purchased
	*/
	
	public double getDiscountAmount(double cost, int quantity, double discount) {
	
		double discountAmount = 0.0;
		if (discount <= 0.0)
		{
			
			discountAmount = 0.0;
		
		}
		else
		{
		
			discountAmount = getGrossCost(cost, quantity) * discount;
		
		}
		
		return discountAmount;
	
	}
	
	/**
		Calculates the net cost of the number of units that the tea shop purchased, that is,
		the gross cost minus the total discount amount plus the total taxes owed.
		@param the tax rate applied to each unit, as a decimal, ie 0.05, 0.1, etc.
		@param the unit cost
		@param the quantity purchased
		@param the discount rate, as a decimal, ie 0.05, 0.1, etc.
		@return the net cost of all the units purchased
	*/
	
	public double getNetCost(double taxRate, double cost, int quantity, double discount) {
	
		double netCost = 0.0;
		if (discount <= 0.0)
		{
		
			netCost = getGrossCost(cost, quantity) + getTaxAmount(taxRate, cost, quantity);
		
		}
		else
		{
			
			netCost = (getGrossCost(cost, quantity) - getDiscountAmount(cost, quantity, discount)) + getTaxAmount(taxRate, cost, quantity);
			
		}

		return netCost;
	
	}
	
	/**
		Sets the line item ID number to be used to record the purchase of an input that can
		be fed into a cost report.
		@param the line item number, as an integer
	*/
	
	public void setLineItemID(int lineItemID) {
	
		this.lineItemID = lineItemID;
		
	}
	
	/**
		Gets the line item ID number to be used to record the purchase of an input that can
		be fed into a cost report.
		@return the line item number
	*/
	
	public int getLineItemID() {
	
		return lineItemID;
	
	}
	
	/**
		Sets the name of the vendor providing the input.
		@param the vendor name
	*/
	
	public void setVendorName(String vendorName) {
	
		this.vendorName = vendorName;
	
	}
	
	/**
		Gets the name of the vendor providing the input.
		@return the vendor name 
	*/

	public String getVendorName() {
	
		return vendorName;
	
	}
	
	/**
		Sets the category of goods that the vendor provides, such as food or tea supplies.
		@param the category of goods the vendor provides
	*/
	
	public void setVendorCategory(String vendorCategory) {
	
		this.vendorCategory = vendorCategory;
		
	}
	
	/**
		Gets the category of goods that the vendor provides, such as food or tea supplies.
		@return the category of goods the vendor provides
	*/
	
	public String getVendorCategory() {
	
		return vendorCategory;
	
	}
	
	/**
		Used to display the headers for the cost report for each input entered.
		@param none
		@return none
	*/
	
	public void displayHeaders() {
	
		System.out.print("ID|     Vendor    |     Category     |     Input     | Unit Cost | ");
		System.out.print("Quantity | Discount(%) | Tax Rate(%) | Discount Amount($) |");
		System.out.print("Gross Cost($) | Tax Amount($) | Net Cost($)\n");

	}
	
	/**
		Used to display each line item in the cost report.
		@return all the information about the input purchased
	*/

	public String toString() {
	
		return lineItemID + " | " + vendorName + "| " + vendorCategory + "| " + input + 
		"| $" + cost + "|     " + quantity + "   | " + (double) discount * 100 + "%   |   " + 
		(double) taxRate * 100 + "%    |   $" + (double) Math.round(getDiscountAmount(cost, quantity, discount)*100)/100 + 
		"      |      $" + (double) Math.round(getGrossCost(cost, quantity)*100)/100 + "       |    $" + 
		(double) Math.round(getTaxAmount(taxRate, cost, quantity)*100)/100 + "    | $" + 
		(double) Math.round(getNetCost(taxRate, cost, quantity, discount)*100)/100; 
	
	}

}

