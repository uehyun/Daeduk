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

public class MySwing08 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing08 frame = new MySwing08();
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
	public MySwing08() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("단수 :");
		lbl.setBounds(44, 39, 57, 15);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(113, 36, 116, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn = new JButton("출력하기");
		btn.setBounds(44, 64, 185, 23);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(44, 97, 185, 142);
		contentPane.add(ta);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
	}
	
	public void click() {
		String num = tf.getText();
		int rnum = Integer.parseInt(num);
		String res = "";
		for(int i=1; i<=9; i++) {
			res += num + " * " + i + " = " + rnum*i + "\n";
		}
		
		ta.setText(res);
	}
}
