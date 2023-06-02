package day04;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MySwing07 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing07 frame = new MySwing07();
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
	public MySwing07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(12, 23, 52, 21);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(98, 23, 52, 21);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(194, 23, 52, 21);
		contentPane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(352, 23, 52, 21);
		contentPane.add(tf4);
		
		JLabel lbl1 = new JLabel("에서");
		lbl1.setBounds(70, 26, 37, 15);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("까지");
		lbl2.setBounds(162, 26, 37, 15);
		contentPane.add(lbl2);
		
		JButton btn = new JButton("배수의 합은");
		btn.setBounds(253, 23, 97, 21);
		contentPane.add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
	}
	public void click() {
		String num1 = tf1.getText();
		String num2 = tf2.getText();
		String num3 = tf3.getText();
		int result = 0;
		
		int rnum1 = Integer.parseInt(num1);
		int rnum2 = Integer.parseInt(num2);
		int rnum3 = Integer.parseInt(num3);
		
		for(int i=rnum1; i<=rnum2; i++) {
			if(i % rnum3 == 0) {
				result += i;
			}
		}
		
		tf4.setText(result+"");
	}

}
