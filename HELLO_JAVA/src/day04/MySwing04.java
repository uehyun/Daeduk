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

public class MySwing04 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing04 frame = new MySwing04();
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
	public MySwing04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(12, 28, 56, 21);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lbl = new JLabel("에서");
		lbl.setBounds(80, 29, 36, 19);
		contentPane.add(lbl);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(116, 28, 58, 21);
		contentPane.add(tf2);
		
		JButton btn = new JButton("까지 합은");
		btn.setBounds(186, 27, 97, 23);
		contentPane.add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(295, 28, 56, 21);
		contentPane.add(tf3);
	}
	
	public void add() {
		String num1 = tf1.getText();
		String num2 = tf2.getText();
		int rnum1 = Integer.parseInt(num1);
		int rnum2 = Integer.parseInt(num2);
		
		int result = 0;
		for(int i=rnum1; i<=rnum2;i++ ) {
				result += i;
		}
		tf3.setText(result+"");
	}

}
