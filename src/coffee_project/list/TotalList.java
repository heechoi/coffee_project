package coffee_project.list;

@SuppressWarnings("serial")
public class TotalList extends TableList {

	@Override
	protected String[] getColumName() {
		return new String[]{"순위","제품코드","제품명","제품단가","판매수량","공급가액","부가세액","판매금액","마진율","마진액"};
	}

	@Override
	protected Object[][] getData() {
		return null;
	}

}
