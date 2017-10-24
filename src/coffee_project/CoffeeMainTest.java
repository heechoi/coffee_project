package coffee_project;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coffee_project.view.CoffeeDataView;
import coffee_project.view.SaleManagerView;

@SuppressWarnings("serial")
public class CoffeeMainTest extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMainTest frame = new CoffeeMainTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CoffeeMainTest() {
		setTitle("커피 상품별 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 113);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 0));
		
		JButton btnMainData = new JButton("커피 상품 관리");
		btnMainData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CoffeeDataView coffeeDataView = new CoffeeDataView();
				coffeeDataView.setVisible(true);
			}
		});
		contentPane.add(btnMainData);
		
		JButton btnManager = new JButton("커피 상품별 판매실적 관리");
		btnManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SaleManagerView managerView = new SaleManagerView();
				managerView.setVisible(true);
			}
		});
		contentPane.add(btnManager);
	}

}
