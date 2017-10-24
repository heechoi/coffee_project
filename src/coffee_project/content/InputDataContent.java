package coffee_project.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import coffee_project.common.JTextFieldComponent;
import coffee_project.common.ComboBoxComponent;
import coffee_project.common.SpinnerComponent;

public class InputDataContent extends JPanel {

	public InputDataContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		ComboBoxComponent pdnoPanel = new ComboBoxComponent("제품코드");
		add(pdnoPanel);
		
		JTextFieldComponent pdnamePanel = new JTextFieldComponent("제품명");
		add(pdnamePanel);
		
		SpinnerComponent pricePanel = new SpinnerComponent("제품단가");
		add(pricePanel);
		
		SpinnerComponent amountPanel = new SpinnerComponent("판매수량");
		add(amountPanel);
		
		SpinnerComponent marginPanel = new SpinnerComponent("마진율");
		add(marginPanel);
		
	}

}
