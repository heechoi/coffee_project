package coffee_project.list;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
		setAlignWidth();
	}

	protected void setCellWidth(int...width){
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0;i<width.length;i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	
	protected void setAlign(int align,int...index){
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i=0;i<index.length;i++){
			cModel.getColumn(index[i]).setCellRenderer(dtcr);
		}
	}
	protected abstract String[] getColumName();

	protected abstract Object[][] getData();
	
	protected abstract void setAlignWidth();
}
