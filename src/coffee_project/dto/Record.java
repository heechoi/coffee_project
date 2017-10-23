package coffee_project.dto;

public class Record {
	private String pdNo;
	private String pdName;
	private int price;
	private int amount;
	private int margin;
	
	public Record() {}
	
	
	public Record(String pdNo, String pdName, int price, int amount, int margin) {
		this.pdNo = pdNo;
		this.pdName = pdName;
		this.price = price;
		this.amount = amount;
		this.margin = margin;
	}


	public String getPdNo() {
		return pdNo;
	}

	public void setPdNo(String pdNo) {
		this.pdNo = pdNo;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	@Override
	public String toString() {
		return String.format("Record [pdNo=%s, pdName=%s, price=%s, amount=%s, margin=%s]", pdNo, pdName, price, amount,
				margin);
	}

	
}
