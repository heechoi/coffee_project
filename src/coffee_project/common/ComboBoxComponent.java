package coffee_project.common;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboBoxComponent extends JPanel {

	private JComboBox<String> comboBox;

	public ComboBoxComponent() {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblCombo = new JLabel("New label");
		lblCombo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblCombo);
		
		comboBox = new JComboBox<>();
		add(comboBox);
		
	}
	
	public int getSelectedIndex(){
		return comboBox.getSelectedIndex();
	}
	
	public void setSelectedIndex(int index){
		comboBox.setSelectedIndex(index);
	}
	
	public String getSelectedItem(){
		return (String)comboBox.getSelectedItem();
	}
	
	public void setSelectedItem(Object item){
		comboBox.setSelectedItem(item);
	}
	
	public void setComboBoxModel(Vector<String> lists){
		ComboBoxModel<String> model = new DefaultComboBoxModel<>(lists);
		comboBox.setModel(model);
	}
	
	public void isEmptyCheck() throws Exception{
		if(comboBox.getSelectedIndex()==-1){
			comboBox.requestFocus();
			throw new Exception("선택 하지 않음");
		}
	}
}
