/* Tea Shop Software
 * CS 234 - TB LG NA
 */ 

public class Product {
	
	private String name;
	private int id;
	private char productType;
	private String productDesc;
	private double price;
	private double discount;
	private double taxRate;
	private boolean available;
	private int quantity;
	private String vendor;
	private double vendorPrice;
	
	
	
	//Express Constructor -- Crucial information only, description left blank
	public Product(Register register, String name, double price, int quantity, String vendor) {
		
		setName(name);
		
		
		setId(register.getAndIncrementProductIndex());
		register.getProductList().put((register.getProductIndex()-1), this);
		
		//Automatically set productType to 'x' since no type is specified
		setProductType('x');
		
		setPrice(price);
		setQuantity(quantity);
		setProductDesc("");
		setDiscount(0.15);
		setVendor(vendor);
		setVendorPrice(price*0.87); //default 0.87 in order to get about a 15% mark-up from
									//vendor price based on original given price
		
		//Tax rate assigned by product type with default tax values
		switch (productType) {
		case 'T':
		case 't':
			setTaxRate(1.08); 
			break;

		case 'F':
		case 'f':
			setTaxRate(1.08);
			break;
			
		case 'A':
		case 'a':
			setTaxRate(1.12);
			break;
			
		case 'X':
		case 'x':
		
			setTaxRate(1.12);
			break;
		}
	}
	
	//Full Constructor -- For full control on product information
	public Product(Register register, String name, String productDesc, double price, double discount, double taxRate, int quantity, String vendor) {
		
		setName(name);
		
		setId(register.getAndIncrementProductIndex());
		register.getProductList().put((register.getProductIndex()-1), this);
		
		//Automatically set productType to 'x' since no type is specified
		setProductType('x');
		
		setProductDesc(productDesc);
		setPrice(price);
		setDiscount(discount);
		setTaxRate(taxRate);
		setQuantity(quantity);
		setVendor(vendor);
		setVendorPrice(vendorPrice);
	}
	
	//Empty Constructor to avoid compile errors
	public Product() {}
	
	/*
	 * Getters and Setters
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public char getProductType() {
		return productType;
	}

	public void setProductType(char productType) {
		this.productType = productType;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	private void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean getAvailable() {
		return available;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
		//Assign available automatically
		if(quantity>0) { setAvailable(true); }
		else { setAvailable(false); }
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public void delete(int id) {
		//remove from array list 
		//Set reference to null for deleteion via garbage collector?
	}

	public double getVendorPrice() {
		return vendorPrice;
	}

	public void setVendorPrice(double vendorPrice) {
		this.vendorPrice = vendorPrice;
	}
	
}
