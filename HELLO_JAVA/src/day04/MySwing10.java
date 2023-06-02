package day04;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class MySwing10 extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirst;
	private JTextField tfLast;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing10 frame = new MySwing10();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MySwing10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirst = new JLabel("첫별수:");
		lblFirst.setBounds(12, 10, 57, 15);
		contentPane.add(lblFirst);
		
		tfFirst = new JTextField();
		tfFirst.setBounds(89, 7, 116, 21);
		contentPane.add(tfFirst);
		tfFirst.setColumns(10);
		
		tfLast = new JTextField();
		tfLast.setColumns(10);
		tfLast.setBounds(89, 38, 116, 21);
		contentPane.add(tfLast);
		
		JLabel lblSecond = new JLabel("끝별수:");
		lblSecond.setBounds(12, 41, 57, 15);
		contentPane.add(lblSecond);
		
		JButton btn = new JButton("별그리기");
		btn.setBounds(12, 80, 193, 23);
		contentPane.add(btn);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
		
		ta = new JTextArea();
		ta.setBounds(12, 113, 193, 193);
		contentPane.add(ta);
	}
	
	public void click() {
		int num1 = Integer.parseInt(tfFirst.getText());
		int num2 = Integer.parseInt(tfLast.getText());
		String res = "";
		for(int i=num1; i<=num2; i++) {
			for(int j=1; j<=i; j++) {
				res += "*";
			}
			res +="\n";
		}
		System.out.println(res);
		ta.setText(res);
		
	}

}
