package coffee_project.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coffee_project.common.JTextFieldComponent;
import coffee_project.list.CodeList;
import coffee_project.service.CodeService;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class CoffeeDataView extends JFrame {

	private JPanel contentPane;

	public CoffeeDataView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 623, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(inputPanel);
		inputPanel.setLayout(new BorderLayout(0, 40));
		
		JPanel tfPanel = new JPanel();
		inputPanel.add(tfPanel, BorderLayout.CENTER);
		tfPanel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JTextFieldComponent codeIdPanel = new JTextFieldComponent("제품코드");
		tfPanel.add(codeIdPanel);
		
		JTextFieldComponent codeNamePanel = new JTextFieldComponent("제품명");
		tfPanel.add(codeNamePanel);
		
		JPanel btnPanel = new JPanel();
		inputPanel.add(btnPanel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추가");
		btnPanel.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		btnPanel.add(btnCancel);
		
		CodeList tablePanel = new CodeList((CodeService) null);
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(tablePanel);
		tablePanel.setLayout(new BorderLayout(0, 0));
	}

}
