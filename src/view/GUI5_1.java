package view;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.fileQuesIcon;
import DB.fileTimeLimitQuiz;
import model.IconofQuestion;
import model.TimeLimitOfQuiz;
import view.BTL_View;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class GUI5_1 extends JFrame {
	LocalDateTime currentTime = LocalDateTime.now();
	private javax.swing.Timer timer;
	
	
	int day = currentTime.getDayOfMonth();
    int month = currentTime.getMonthValue();
    int year = currentTime.getYear();
    int hour = currentTime.getHour();
    int minute = currentTime.getMinute();
    private DefaultComboBoxModel<String> modelMinute1 ;
    private DefaultComboBoxModel<String> modelMinute ;
    private DefaultComboBoxModel<String> modelHour ;
    private DefaultComboBoxModel<String> modelHour1 ;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldTime;
	private JComboBox comboBoxDay;
	private JComboBox comboBoxDay_1;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxMonth_1;
	private JComboBox comboBoxYear;
	private JComboBox comboBoxYear_1;
	private JComboBox comboBoxHour;
	private JComboBox comboBoxHour_1;
	private JComboBox comboBoxMinute;
	private JComboBox comboBoxMinute_1;
	private JButton btnCreat ;
	private TimeLimitOfQuiz timeLimitOfQuiz;
	private JComboBox comboBox;
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI5_1 frame = new GUI5_1();
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
	public GUI5_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 750, 691);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Adding new Quiz");
		lblNewLabel_2_1.setForeground(new Color(214, 20, 20));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(34, 1, 148, 32);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel iconQuestion = new JLabel(new ImageIcon(GUI5_1.class.getResource("/assets/question.png")));
		iconQuestion.setBounds(181, 7, 24, 24);
		contentPane.add(iconQuestion);
		
		JLabel iconQuestion_1 = new JLabel(new ImageIcon(GUI5_1.class.getResource("/assets/checklist.png")));
		iconQuestion_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		iconQuestion_1.setBounds(8, 7, 24, 24);
		contentPane.add(iconQuestion_1);
		
		JLabel labelIptGeneral = new JLabel("General");
		labelIptGeneral.setForeground(new Color(214, 20, 20));
		labelIptGeneral.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelIptGeneral.setBounds(54, 44, 73, 27);
		contentPane.add(labelIptGeneral);
		
		JLabel iconGeneralSortdown = new JLabel(new ImageIcon(GUI5_1.class.getResource("/assets/298882_down_triangle_icon (1).png")));
		iconGeneralSortdown.setBounds(18, 47, 24, 24);
		contentPane.add(iconGeneralSortdown);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 317, 630, 16);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(28, 82, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescription.setBounds(26, 145, 83, 16);
		contentPane.add(lblDescription);
		
		textField = new JTextField();
		textField.setBounds(231, 81, 314, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 143, 426, 137);
		contentPane.add(scrollPane);
		
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Display description on course page");
		chckbxNewCheckBox.setFocusPainted(false);
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(231, 287, 235, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblTiming = new JLabel("Timing");
		lblTiming.setForeground(new Color(214, 20, 20));
		lblTiming.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTiming.setBounds(54, 325, 73, 27);
		contentPane.add(lblTiming);
		
		JLabel iconGeneralSortdown_1 = new JLabel(new ImageIcon(GUI5_1.class.getResource("/assets/298882_down_triangle_icon (1).png")));
		iconGeneralSortdown_1.setBounds(18, 325, 24, 24);
		contentPane.add(iconGeneralSortdown_1);
		
		JLabel lblOpenTheQuizz = new JLabel("Open the quiz");
		lblOpenTheQuizz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOpenTheQuizz.setBounds(34, 384, 115, 16);
		contentPane.add(lblOpenTheQuizz);
		
		JLabel lblCloseTheQuiz = new JLabel("Close the quiz");
		lblCloseTheQuiz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCloseTheQuiz.setBounds(34, 432, 115, 16);
		contentPane.add(lblCloseTheQuiz);
		
		JLabel lblTimeLimit = new JLabel("Time limit");
		lblTimeLimit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimeLimit.setBounds(34, 479, 115, 16);
		contentPane.add(lblTimeLimit);
		
		JLabel lblWhenTime = new JLabel("When time expires");
		lblWhenTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWhenTime.setBounds(34, 530, 125, 16);
		contentPane.add(lblWhenTime);
		
		comboBoxDay = new JComboBox();
		comboBoxDay.setBounds(231, 380, 60, 25);
		contentPane.add(comboBoxDay);
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setBounds(301, 380, 94, 25);
		contentPane.add(comboBoxMonth);
		
		comboBoxYear = new JComboBox();
		comboBoxYear.setBounds(405, 380, 61, 25);
		contentPane.add(comboBoxYear);
		
		comboBoxHour = new JComboBox();
		comboBoxHour.setBounds(476, 380, 61, 25);
		contentPane.add(comboBoxHour);
		
		comboBoxMinute = new JComboBox();
		comboBoxMinute.setBounds(547, 381, 63, 25);
		contentPane.add(comboBoxMinute);
		
		comboBoxDay_1 = new JComboBox();
		comboBoxDay_1.setBounds(231, 418, 60, 25);
		contentPane.add(comboBoxDay_1);
		
		comboBoxMonth_1 = new JComboBox();
		comboBoxMonth_1.setBounds(301, 418, 94, 25);
		contentPane.add(comboBoxMonth_1);
		
		comboBoxYear_1 = new JComboBox();
		comboBoxYear_1.setBounds(405, 418, 61, 25);
		contentPane.add(comboBoxYear_1);
		
		comboBoxHour_1 = new JComboBox();
		comboBoxHour_1.setBounds(476, 418, 61, 25);
		contentPane.add(comboBoxHour_1);
		
		comboBoxMinute_1 = new JComboBox();
		comboBoxMinute_1.setBounds(547, 417, 63, 25);
		contentPane.add(comboBoxMinute_1);
		
		JButton btnCalender = new JButton("");
		btnCalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCalender(e);
			}
		});
		btnCalender.setFocusPainted(false);
		btnCalender.setBorderPainted(false);
		btnCalender.setBackground(new Color(255, 255, 255));
		btnCalender.setBorder(null);
		btnCalender.setIcon(new ImageIcon(GUI5_1.class.getResource("/assets/calender.png")));
		btnCalender.setBounds(620, 382, 18, 23);
		contentPane.add(btnCalender);
		
		JButton btnCalender_1 = new JButton("");
		btnCalender_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCalender_1(e);
			}
		});
		btnCalender_1.setIcon(new ImageIcon(GUI5_1.class.getResource("/assets/calender.png")));
		btnCalender_1.setFocusPainted(false);
		btnCalender_1.setBorderPainted(false);
		btnCalender_1.setBorder(null);
		btnCalender_1.setBackground(Color.WHITE);
		btnCalender_1.setBounds(620, 419, 18, 23);
		contentPane.add(btnCalender_1);
		
		DefaultComboBoxModel<String> modelDay = new DefaultComboBoxModel<>();
		modelDay.addElement("Day");
		for (int i = 1; i < 32; i++) {
            modelDay.addElement(String.valueOf(i));
        }
		comboBoxDay.setModel(modelDay);
		
		DefaultComboBoxModel<String> modelDay1 = new DefaultComboBoxModel<>();
		modelDay1.addElement("Day");
		for (int i = 1; i < 32; i++) {
            modelDay1.addElement(String.valueOf(i));
        }
		comboBoxDay_1.setModel(modelDay1);
		DefaultComboBoxModel<String> modelMonth = new DefaultComboBoxModel<>(new String[] {
			"Month",
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"Octobor",
			"November",
			"December"

		});
	    
	        
		comboBoxMonth.setModel(modelMonth);
		comboBoxMonth_1.setModel(modelMonth);
		
		DefaultComboBoxModel<String> modelYear1= new DefaultComboBoxModel<>();
	    modelYear1.addElement(String.valueOf(year));
	    comboBoxYear_1.setModel(modelYear1);
	    
	    DefaultComboBoxModel<String> modelYear= new DefaultComboBoxModel<>();
	    modelYear.addElement(String.valueOf(year));
	    comboBoxYear.setModel(modelYear);


		modelHour = new DefaultComboBoxModel<>();
		modelHour.addElement("Hour");
		for (int i = 0; i < 24; i++) {
            modelHour.addElement(String.valueOf(i));
        }
		comboBoxHour.setModel(modelHour);

		modelHour1 = new DefaultComboBoxModel<>();
		modelHour1.addElement("Hour");
		for (int i = 0; i < 24; i++) {
            modelHour1.addElement(String.valueOf(i));
        }
		comboBoxHour_1.setModel(modelHour1);
		
		modelMinute = new DefaultComboBoxModel<>();
		modelMinute.addElement("Minute");
		for (int i = 0; i < 61; i++) {
            modelMinute.addElement(String.valueOf(i));
        }
		comboBoxMinute.setModel(modelMinute);
		
		modelMinute1 = new DefaultComboBoxModel<>();
		modelMinute1.addElement("Minute");
		for (int i = 0; i < 61; i++) {
            modelMinute1.addElement(String.valueOf(i));
        }
		comboBoxMinute_1.setModel(modelMinute1);
		
		
		textFieldTime = new JTextField();
		textFieldTime.setBounds(231, 476, 60, 24);
		contentPane.add(textFieldTime);		
		
		comboBox = new JComboBox(new DefaultComboBoxModel<>(new String[] {"minutes","hours"}));
		comboBox.setBounds(301, 476, 73, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new DefaultComboBoxModel(new String[] {"Open attempts are submitted automatically"}));
		comboBox_1.setBounds(231, 528, 270, 32);
		contentPane.add(comboBox_1);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel(e);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(39, 118, 143));
		btnCancel.setBounds(391, 602, 79, 39);
		contentPane.add(btnCancel);
		
		btnCreat = new JButton("CREAT");
		btnCreat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCreat_actionPerformed(e);
			}
		});
		btnCreat.setForeground(Color.WHITE);
		btnCreat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreat.setFocusPainted(false);
		btnCreat.setBorder(null);
		btnCreat.setBackground(new Color(255, 0, 0));
		btnCreat.setBounds(281, 602, 79, 39);
		contentPane.add(btnCreat);
		
		JCheckBox chckbxEnable = new JCheckBox("Enable");
		chckbxEnable.setFocusPainted(false);
		chckbxEnable.setBackground(Color.WHITE);
		chckbxEnable.setBounds(380, 476, 235, 23);
		contentPane.add(chckbxEnable);
		
		
	}

	protected void do_btnCreat_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s= textField.getText();
		timeLimitOfQuiz = new TimeLimitOfQuiz(s, Integer.parseInt(textFieldTime.getText()));
		if(this.getComboBox().getSelectedItem().toString().equals("hours"))
			timeLimitOfQuiz.setHour(true);		
		try {
			System.out.println(timeLimitOfQuiz.getQuizName());
			System.out.println(Integer.parseInt(textFieldTime.getText()));
			ArrayList<TimeLimitOfQuiz> arrayListQues = new fileTimeLimitQuiz().docTimeLimit();
			System.out.println(1002);
			
			arrayListQues.add(timeLimitOfQuiz);
			
			new fileTimeLimitQuiz().ghiTimeLimit(arrayListQues);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BTL_View mainView= new BTL_View();		
		mainView.loadDatapro(s);		
		this.setVisible(false);
		mainView.setVisible(true);
		
	}

	protected void do_btnCancel(ActionEvent e) {
		// TODO Auto-generated method stub
		BTL_View home = new BTL_View();
		this.setVisible(false);
		home.do_btnHome_action(e);
	}

	protected void do_btnCalender_1(ActionEvent e) {
		// TODO Auto-generated method stub
		 DefaultComboBoxModel<String> model1=new DefaultComboBoxModel<>();
	        model1.addElement(String.valueOf(day));

	        comboBoxDay_1.setModel(model1);
	        
	        DefaultComboBoxModel<String> model2= new DefaultComboBoxModel<>();
	        model2.addElement(String.valueOf(month));

	        comboBoxMonth_1.setModel(model2);
	        
	        modelHour1.setSelectedItem(hour);
	        comboBoxHour_1.setModel(modelHour1);
	        
	        modelMinute1.setSelectedItem(minute);
	        comboBoxMinute_1.setModel(modelMinute1);
	        
	}

	protected void do_btnCalender(ActionEvent e) {
		// TODO Auto-generated method stub
        
        DefaultComboBoxModel<String> model1=new DefaultComboBoxModel<>();
        model1.addElement(String.valueOf(day));
        comboBoxDay.setModel(model1);

        
        DefaultComboBoxModel<String> model2= new DefaultComboBoxModel<>();
        model2.addElement(String.valueOf(month));
        comboBoxMonth.setModel(model2);
        
        modelHour.setSelectedItem(hour);
        comboBoxHour.setModel(modelHour);
        
        modelMinute.setSelectedItem(minute);
        comboBoxMinute.setModel(modelMinute);
        
	}
}
