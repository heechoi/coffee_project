package coffee_project.list;

import java.util.List;

import javax.swing.SwingConstants;

import coffee_project.dto.TotalSale;
import coffee_project.service.TotalService;

@SuppressWarnings("serial")
public class PriceList extends TableList {
	
	private TotalService service = new TotalService();
	
	public PriceList(TotalService service) {
		this.service = service;
	}

	@Override
	protected String[] getColumName() {
		return new String[]{"순위","제품코드","제품명","제품단가","판매수량","공급가액","부가세액","판매금액","마진율","마진액"};
	}

	@Override
	protected Object[][] getData() {
		List<TotalSale> lists = service.priceViewByAll();
		Object[][] datas = new Object[lists.size()][];		
		for(int i=0;i<lists.size();i++){
			datas[i]=lists.get(i).toArray();
		}
		return datas;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(50,70,100,70,50,100,100,100,70,100);	
		setAlign(SwingConstants.CENTER, 0,1,2);
		setAlign(SwingConstants.RIGHT, 3,4,5,6,7,8,9);
	}

}
