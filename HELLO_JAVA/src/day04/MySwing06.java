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

public class MySwing06 extends JFrame {

	private JPanel contentPane;
	private JTextField tfMine;
	private JTextField tfCom;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing06 frame = new MySwing06();
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
	public MySwing06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMine = new JLabel("나:");
		lblMine.setBounds(29, 37, 32, 21);
		contentPane.add(lblMine);
		
		JLabel lblCom = new JLabel("컴:");
		lblCom.setBounds(29, 68, 32, 21);
		contentPane.add(lblCom);
		
		JLabel lblResult = new JLabel("결과:");
		lblResult.setBounds(29, 102, 32, 21);
		contentPane.add(lblResult);
		
		tfMine = new JTextField();
		tfMine.setBounds(73, 37, 116, 21);
		contentPane.add(tfMine);
		tfMine.setColumns(10);
		
		tfCom = new JTextField();
		tfCom.setColumns(10);
		tfCom.setBounds(73, 68, 116, 21);
		contentPane.add(tfCom);
		
		tfResult = new JTextField();
		tfResult.setColumns(10);
		tfResult.setBounds(73, 102, 116, 21);
		contentPane.add(tfResult);
		
		JButton btn = new JButton("결과확인");
		btn.setBounds(84, 145, 97, 23);
		contentPane.add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Game();
			}
		});
	}
	
	public void Game() {
		double rnd = Math.random();
		
		String me = tfMine.getText();
		String com = "";
		String result = "";
		if(rnd>0.5) {
			com = "홀";
		} else {
			com = "짝";
		}
		
		if(me.equals(com)) {
			result = "정답";
		} else {
			result = "틀렸습니다.";
		}
		
		tfCom.setText(com);
		tfResult.setText(result);
	}

}
