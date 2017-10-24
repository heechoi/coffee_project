package coffee_project;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import coffee_project.list.RecordList;
import coffee_project.list.TableList;
import coffee_project.service.RecordService;

public class ListTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10,10,600,300);
		//TableList ld = new CodeList(new CodeService());
		TableList ld = new RecordList(new RecordService());
		//TableList ld = new PriceList(new TotalService());
		
		//TableList ld = new MarginList(new TotalService());
		ld.loadData();
		jf.add(ld);
		
		jf.setVisible(true);
	}

}
