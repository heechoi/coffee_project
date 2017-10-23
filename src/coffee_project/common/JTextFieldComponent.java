package coffee_project.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JTextFieldComponent extends JPanel {
	private JTextField textField;

	public JTextFieldComponent(String title) {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
	}
	
	public String getTextValue(){
		return textField.getText().trim();
	}
	
	public void setTextValue(String value){
		textField.setText(value);
	}
	
	public JTextField getTextField(){
		return textField;
	}
	
	public void setEnable(boolean isEnable){
		textField.setEnabled(isEnable);
	}
	
	public void isEmptyCheck() throws Exception{
		if(getTextValue().equals("")){
			textField.requestFocus();
			throw new Exception("공백존재");
		}
	}
}
