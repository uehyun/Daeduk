package day04;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MySwing11 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;
	int[] com = {1,2,3,4,5,6,7,8,9};
	private static MySwing11 frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MySwing11();
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
	public MySwing11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("맞춰보기");
		btn.setBounds(50, 92, 221, 23);
		contentPane.add(btn);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
		
		JLabel lbl = new JLabel("야구게임");
		lbl.setBounds(50, 57, 57, 15);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(124, 54, 147, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		ta = new JTextArea();
		ta.setBounds(49, 137, 222, 270);
		contentPane.add(ta);
		
		for(int i=1; i<=9; i++) {
			int rnd = (int) (Math.random()*9);
			int a = com[rnd];
			int b = com[0];
			com[0] = a;
			com[rnd] = b;
		}
	}
	
	public void click() {
		String me = tf.getText();
		int num = Integer.parseInt(me);
		int strike = 0;
		int ball = 0;
		int[] arr = new int[3];
		arr[0] = num / 100; 
		arr[1] = (num % 100) / 10; 
		arr[2] = num % 10; 
		if(num>999 || arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
			JOptionPane.showMessageDialog(tf, "다시 입력해주세요.");
			tf.setText("");
			return ;
		}
		if(com[0] == arr[0]) {
			strike++;
		}
		if(arr[0] == com[1] || arr[0] == com[2]) {
			ball++;
		}
		if(com[1] == arr[1]) {
			strike++;
		} 
		if(arr[1] == com[0] || arr[1] == com[2]) {
			ball++;
		}
		if(com[2] == arr[2]) {
			strike++;
		} 
		if(arr[2] == com[1] || arr[2] == com[0]) {
			ball++;
		}
		String result = strike +"S\t" + ball + "B\n";
		String textArea = ta.getText();
		ta.setText(textArea + result);
		tf.setText("");
		if(strike == 3) {
			JOptionPane.showMessageDialog(tf, "승리하였습니다.");
			frame.setVisible(false);
		}
	}
}
