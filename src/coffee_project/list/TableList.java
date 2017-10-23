package coffee_project.list;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public abstract class TableList extends JPanel {
	private JTable table;
	public TableList() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void loadData(){
		DefaultTableModel model = new DefaultTableModel(getData(), getColumName());
		table.setModel(model);
	}


	protected abstract String[] getColumName();

	protected abstract Object[][] getData();
}
