package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MySwing09 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing09 frame = new MySwing09();
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
	public MySwing09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setBounds(12, 10, 161, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(12, 41, 44, 21);
		contentPane.add(btn1);
		btnClick(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(68, 41, 44, 21);
		contentPane.add(btn2);
		btnClick(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(129, 41, 44, 21);
		contentPane.add(btn3);
		btnClick(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(12, 72, 44, 21);
		contentPane.add(btn4);
		btnClick(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(67, 71, 44, 21);
		contentPane.add(btn5);
		btnClick(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(129, 71, 44, 21);
		contentPane.add(btn6);
		btnClick(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(12, 103, 44, 21);
		contentPane.add(btn7);
		btnClick(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(67, 102, 44, 21);
		contentPane.add(btn8);
		btnClick(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(129, 102, 44, 21);
		contentPane.add(btn9);
		btnClick(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(12, 134, 44, 21);
		contentPane.add(btn0);
		btnClick(btn0);
		
		JButton btnCall = new JButton("CALL");
		btnCall.setBounds(67, 133, 106, 21);
		contentPane.add(btnCall);
		btnCall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alert();
			}
		});
	}
	
//	public void click(JButton btn) {
//		String btnNum = btn.getText();
//		String num = tf.getText();
//		String result = num+btnNum;
//		tf.setText(result);
//	}
	
	public void btnClick(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String btnNum = btn.getText();
				String num = tf.getText();
				String result = num+btnNum;
				tf.setText(result);
			}
		});
	}
	
	public void alert() {
		JOptionPane.showMessageDialog(tf, "Calling\n" + tf.getText());
	}

}
