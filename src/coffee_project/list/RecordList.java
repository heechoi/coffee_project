package coffee_project.list;

import java.util.List;

import javax.swing.SwingConstants;

import coffee_project.dto.Record;
import coffee_project.service.RecordService;

@SuppressWarnings("serial")
public class RecordList extends TableList {
	private RecordService service = new RecordService();
	
	public RecordList(RecordService service) {
		this.service = service;
	}

	@Override
	protected String[] getColumName() {
		return new String[]{"제품코드","제품명","제품단가","판매수량","마진율"};
	}

	@Override
	protected Object[][] getData() {
		List<Record> lists = service.selectRecordByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(50,100,50,100,50);
		setAlign(SwingConstants.CENTER, 0,1);
		setAlign(SwingConstants.RIGHT, 2,3,4);
		
	}
	
	

}
