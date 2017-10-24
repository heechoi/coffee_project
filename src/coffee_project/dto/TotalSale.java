package coffee_project.dto;

public class TotalSale {
	private int rankNo;
	private String pdNo;
	private String pdName;
	private int price;
	private int amount;
	private int supplyPrice;
	private int surtax;
	private int salePrice;
	private int margin;
	private int marginRate;
	
	public TotalSale(int rankNo, String pdNo, String pdName, int price, int amount, int supplyPrice, int surtax,
			int salePrice, int margin, int marginRate) {
		this.rankNo = rankNo;
		this.pdNo = pdNo;
		this.pdName = pdName;
		this.price = price;
		this.amount = amount;
		this.supplyPrice = supplyPrice;
		this.surtax = surtax;
		this.salePrice = salePrice;
		this.margin = margin;
		this.marginRate = marginRate;
	}

	public int getRankNo() {
		return rankNo;
	}

	public void setRankNo(int rankNo) {
		this.rankNo = rankNo;
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

	public int getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public int getSurtax() {
		return surtax;
	}

	public void setSurtax(int surtax) {
		this.surtax = surtax;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	@Override
	public String toString() {
		return String.format(
				"TotalSale [rankNo=%s, pdNo=%s, pdName=%s, price=%s, amount=%s, supplyPrice=%s, surtax=%s, salePrice=%s, margin=%s, marginRate=%s]",
				rankNo, pdNo, pdName, price, amount, supplyPrice, surtax, salePrice, margin, marginRate);
	}

	public Object[] toArray() {
		return new Object[]{rankNo, 
							pdNo, 
							pdName, 
							String.format("%,d",price),
							amount, 
							String.format("%,d", supplyPrice), 
							String.format("%,d", surtax), 
							String.format("%,d", salePrice), 
							margin, 
							String.format("%,d", marginRate)};
		}
		//return new Object[]{rankNo, pdNo, pdName, price, amount, supplyPrice, surtax, salePrice, margin, marginRate};
	
	
	
	
	
}
