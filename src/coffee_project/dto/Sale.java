package coffee_project.dto;

public class Sale {
	private String saleCd;
	private int supplyPrice;
	private int surTax;
	private int salePrice;
	private int mgRate;
	
	public Sale() {}

	public String getSaleCd() {
		return saleCd;
	}

	public void setSaleCd(String saleCd) {
		this.saleCd = saleCd;
	}

	public int getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(int supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public int getSurTax() {
		return surTax;
	}

	public void setSurTax(int surTax) {
		this.surTax = surTax;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMgRate() {
		return mgRate;
	}

	public void setMgRate(int mgRate) {
		this.mgRate = mgRate;
	}

	@Override
	public String toString() {
		return String.format("Sale [saleCd=%s, supplyPrice=%s, surTax=%s, salePrice=%s, mgRate=%s]", saleCd,
				supplyPrice, surTax, salePrice, mgRate);
	}
	
	
}
