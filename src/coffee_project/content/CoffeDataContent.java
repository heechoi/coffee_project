package coffee_project.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import coffee_project.common.JTextFieldComponent;

public class CoffeDataContent extends JPanel {

	public CoffeDataContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		JTextFieldComponent codeId = new JTextFieldComponent("제품코드");
		add(codeId);
		
		JTextFieldComponent codName = new JTextFieldComponent("제품명");
		add(codName);
		
	}

}
