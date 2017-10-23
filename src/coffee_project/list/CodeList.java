package coffee_project.list;

import java.util.List;

import coffee_project.dto.Code;
import coffee_project.service.CodeService;

@SuppressWarnings("serial")
public class CodeList extends TableList {
	private CodeService service = new CodeService();
	
	
	public CodeList(CodeService service) {
		this.service = service;
	}

	@Override
	protected String[] getColumName() {
		return new String[]{"제품코드","제품명"};
	}

	@Override
	protected Object[][] getData() {
		List<Code> lists = service.selectCodeByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

}
