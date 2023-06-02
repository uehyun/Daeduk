package day04;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MySwing05 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing05 frame = new MySwing05();
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
	public MySwing05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("__");
		lbl1.setBounds(26, 32, 27, 15);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("__");
		lbl2.setBounds(65, 32, 27, 15);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("__");
		lbl3.setBounds(104, 32, 27, 15);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("__");
		lbl4.setBounds(144, 32, 27, 15);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("__");
		lbl5.setBounds(186, 32, 27, 15);
		contentPane.add(lbl5);
		
		lbl6 = new JLabel("__");
		lbl6.setBounds(228, 32, 27, 15);
		contentPane.add(lbl6);
		
		JButton btn = new JButton("로또 생성하기");
		btn.setBounds(26, 67, 229, 23);
		contentPane.add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lotto();
			}
		});
	}
	
	public void lotto() {
		int[] arr = new int[45];
		for(int i=0; i<=arr.length; i++) {
			arr[i] = i+1;
		}
		for(int i=1; i<=45; i++) {
			int rnd = (int) (Math.random()*45);
			int a = arr[rnd];
			int b = arr[0];
			arr[0] = a;
			arr[rnd] = b;
		}
		lbl1.setText(arr[0]+"");
		lbl2.setText(arr[1]+"");
		lbl3.setText(arr[2]+"");
		lbl4.setText(arr[3]+"");
		lbl5.setText(arr[4]+"");
		lbl6.setText(arr[5]+"");
	}

}
