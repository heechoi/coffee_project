package coffee_project.common;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SpinnerComponent extends JPanel {


	private JSpinner spinner;

	public SpinnerComponent(String title) {
		setLayout(new GridLayout(0, 2, 10, 0));
		
		JLabel lblSpinner = new JLabel(title);
		lblSpinner.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSpinner);
		
		spinner = new JSpinner();
		add(spinner);
		
	}
	
	public JSpinner getComponent(){
		return spinner;
	}
	
	public void setSpinValue(int value){
		spinner.setValue(value);
	}
	
	public int getSpinValue(){
		Number n =(Number)spinner.getValue();
		return n.intValue();
	}
	
	public void setDefaultValue(double value, double minimum, double maximum, double stepSize){
		SpinnerModel model = new SpinnerNumberModel(value, minimum, maximum, stepSize);
		spinner.setModel(model);
	}
	public void isEmptyCheck() throws Exception{
		if(spinner.getValue().toString().equals("")){
			spinner.requestFocus();
			throw new Exception("공백 존재");
		}
	}
}
