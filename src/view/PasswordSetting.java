package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import model.Export;

public class PasswordSetting extends JFrame {
	String name;
/*	PasswordSetting(String name)
	{
		this.name=name;
	}*/
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	/**
	 * Launch the application.
	 */
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordSetting frame = new PasswordSetting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PasswordSetting(String name) {
	this.name =name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550,250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(60, 60, 100, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(60, 100, 123, 40);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				} else 
					{
					passwordField_1.setEchoChar('*');
			}
			}
		});
		
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNewCheckBox.setBounds(160, 160, 164, 35);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Xuất file");
	
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(170, 220, 107, 21);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 62, 140, 25);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(200, 109, 140, 25);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu không khớp");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(160, 197, 129, 13);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
				char[] p1 = passwordField.getPassword();
				String value1 = new String(p1);
				char[] p2 = passwordField_1.getPassword();
				String value2 = new String(p2);
			//	System.out.println(value1);
			//	System.out.println(value2);
					if(value1.equals(value2)==false){
						lblNewLabel_2.setVisible(true);
					} else 
					{
						lblNewLabel_2.setVisible(false);
						setVisible(false);
						Export export = new Export(name,value1);
						export.expordPdfwithPass();
					}
				}
			}
		});
	}
}

