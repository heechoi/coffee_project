package coffee_project;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import coffee_project.list.CodeList;
import coffee_project.list.TableList;
import coffee_project.service.CodeService;

public class ListTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10,10,300,450);
		
		TableList ld = new CodeList(new CodeService());
		ld.loadData();
		jf.add(ld);
		
		jf.setVisible(true);
	}

}
