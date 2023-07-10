package view;

import java.awt.EventQueue;
//import com.itextpdf.text.Image;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.StyledDocument;

import com.aspose.words.Document;
import com.aspose.words.FileFormatUtil;
import com.aspose.words.NodeCollection;
import com.aspose.words.NodeType;
import com.aspose.words.Shape;

import javax.swing.filechooser.FileNameExtensionFilter;

import DB.FileChoiceGrade;
import DB.fileQuesIcon;
import DB.fileQuestionBank;
import DB.fileQuestionBank;
import model.ChoiceGrade;
import model.IconofQuestion;
import model.MenuPopupMouse;
import model.Question;
import model.QuestionBank;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.text.Element;
import javax.swing.text.ElementIterator;
import javax.swing.text.SimpleAttributeSet;  
import javax.swing.text.StyleConstants; 
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;

public class GUI3_2 extends JFrame {
	
	private int paraCount;
	boolean moreChoice = false;
	public JScrollPane scrollPane_1;
	public JPanel panel;
	public JPanel panel_1;
	public JPanel panelChoice;
	public JPanel panel_Choice3;
	private JComboBox comboBox_5, comboBox_1, comboBox_2, comboBox_3, comboBox_4 ;
	private boolean checkQuestionEdit = false;
	private int index;
	public JTextField getTextFieldAnswer() {
		return textFieldAnswer;
	}

	public void setTextFieldAnswer(JTextField textFieldAnswer) {
		this.textFieldAnswer = textFieldAnswer;
	}

	public JTextField getTextField_Choice1() {
		return textField_Choice1;
	}

	public void setTextField_Choice1(JTextField textField_Choice1) {
		this.textField_Choice1 = textField_Choice1;
	}

	public JTextField getTextField_Choice2() {
		return textField_Choice2;
	}

	public void setTextField_Choice2(JTextField textField_Choice2) {
		this.textField_Choice2 = textField_Choice2;
	}

	public JTextField getTextField_Choice3() {
		return textField_Choice3;
	}

	public void setTextField_Choice3(JTextField textField_Choice3) {
		this.textField_Choice3 = textField_Choice3;
	}

	public JTextField getTextField_Choice4() {
		return textField_Choice4;
	}

	public void setTextField_Choice4(JTextField textField_Choice4) {
		this.textField_Choice4 = textField_Choice4;
	}

	public JTextField getTextField_Choice5() {
		return textField_Choice5;
	}

	public void setTextField_Choice5(JTextField textField_Choice5) {
		this.textField_Choice5 = textField_Choice5;
	}

	public JTextPane getTextPaneCateInfor() {
		return textPaneCateInfor;
	}

	public void setTextPaneCateInfor(JTextPane textPaneCateInfor) {
		this.textPaneCateInfor = textPaneCateInfor;
	}

	public JPanel panel_Choice4;
	public JPanel panel_Choice5;
	private JPanel mainPane; 
	private JTextField textFieldName;
	private JTextField textField_1;
	public JButton moreChoicebtn;
	public JButton moreEditingbtn;
	public JButton btnCancel;
	public JButton btnSaveChanges;
	private JComboBox boxParent;
	private JTextField textField_Choice1;
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JComboBox getBoxParent() {
		return boxParent;
	}

	public void setBoxParent(JComboBox boxParent) {
		this.boxParent = boxParent;
	}

	private JTextField textField_Choice2;
	private JTextField textField_Choice3;
	private JTextField textField_Choice4;
	private JTextField textField_Choice5;
	public JTextPane textPaneCateInfor;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private JTextPane textPane_3;
	private JTextPane textPane_4;
	private JTextPane textPane_5;
	private JTextField textFieldAnswer;
	public JPopupMenu popupMenu;
	private ImageIcon icon=null;
	private Image image=null;
	private IconofQuestion iconOfQuestion ;
	private ArrayList<ImageIcon> iconList = new  ArrayList();
	private ArrayList<String> path = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI3_2 frame = new GUI3_2();
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
	public GUI3_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 805, 750);
		this.setResizable(false);
			
		mainPane = new JPanel();
		mainPane.setBackground(new Color(255, 255, 255));
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JPanel contentpane = new JPanel();
		contentpane.setBackground(new Color(255, 255, 255));
		contentpane.setBounds(0, 0, 10, 10);
		contentpane.setPreferredSize(new Dimension(789,1150));
		contentpane.setAutoscrolls(true);

		JScrollPane scrollPane = new JScrollPane(contentpane,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		scrollPane.setPreferredSize(new Dimension(789,1150));
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		contentpane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 750, 94);
		contentpane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IT\r\n");
		lblNewLabel.setForeground(new Color(214, 20, 20));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 24, 24);
		panel.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHome_1_action(e);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setBorder(null);
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(10, 58, 45, 23);
		panel.add(btnHome);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setFocusTraversalPolicyProvider(true);
		lblNewLabel_1.setBounds(63, 56, 5, 27);
		panel.add(lblNewLabel_1);
		
		JButton btnMycourse = new JButton("My courses");
		btnMycourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMycourse.setFocusTraversalKeysEnabled(false);
		btnMycourse.setFocusPainted(false);
		btnMycourse.setBorder(null);
		btnMycourse.setBackground(Color.WHITE);
		btnMycourse.setBounds(78, 58, 83, 23);
		panel.add(btnMycourse);
		
		JButton btnTCKy = new JButton("THI CUỐI KỲ");
		btnTCKy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTCKy.setFocusTraversalKeysEnabled(false);
		btnTCKy.setFocusPainted(false);
		btnTCKy.setBorder(null);
		btnTCKy.setBackground(Color.WHITE);
		btnTCKy.setBounds(182, 58, 83, 23);
		panel.add(btnTCKy);
		
		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setFocusTraversalPolicyProvider(true);
		lblNewLabel_1_1.setBounds(171, 56, 5, 27);
		panel.add(lblNewLabel_1_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 116, 750, 374);
		contentpane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Add a Multiple choice question");
		lblNewLabel_2_1.setForeground(new Color(214, 20, 20));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(10, 11, 320, 22);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setForeground(new Color(214, 20, 20));
		lblGeneral.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGeneral.setBounds(43, 44, 79, 24);
		panel_1.add(lblGeneral);
		
		JLabel lblNewLabel_5 = new JLabel("Parent category");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(40, 76, 109, 24);
		panel_1.add(lblNewLabel_5);
		
		JLabel iconQuestion = new JLabel((Icon) null);
		iconQuestion.setBounds(327, 76, 24, 24);
		panel_1.add(iconQuestion);
		
		boxParent = new JComboBox();
		boxParent.setSelectedIndex(-1);
		boxParent.setForeground(Color.BLACK);
		boxParent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boxParent.setBackground(Color.WHITE);
		boxParent.setBounds(361, 71, 240, 35);
		panel_1.add(boxParent); 
		
		try {
			DefaultComboBoxModel<String> dcb= new fileQuestionBank().listCategory();
			boxParent.setModel(dcb);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldName.setColumns(10);
		textFieldName.setBounds(361, 119, 326, 35);
		panel_1.add(textFieldName);
		
		JLabel iconWarning = new JLabel((Icon) null);
		iconWarning.setBounds(327, 124, 24, 24);
		panel_1.add(iconWarning);
		
		JLabel lblNewLabel_5_1 = new JLabel("Name");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(40, 124, 109, 24);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Question text");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_2.setBounds(40, 177, 109, 24);
		panel_1.add(lblNewLabel_5_2);
		
		
		JLabel lableDefaultMark = new JLabel("Default mark");
		lableDefaultMark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lableDefaultMark.setBounds(40, 325, 109, 24);
		panel_1.add(lableDefaultMark);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(361, 167, 326, 134);
		panel_1.add(scrollPane_2);
		
		textPaneCateInfor = new JTextPane();
		scrollPane_2.setViewportView(textPaneCateInfor);
		textPaneCateInfor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setText("1");
		textField_1.setColumns(10);
		textField_1.setBounds(361, 320, 53, 35);
		panel_1.add(textField_1);
		
		JLabel labelAnswer = new JLabel("ANSWER");
		labelAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAnswer.setBounds(515, 325, 86, 24);
		panel_1.add(labelAnswer);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setColumns(10);
		textFieldAnswer.setBounds(595, 320, 92, 35);
		panel_1.add(textFieldAnswer);
		
		JButton btnUpload = new JButton("");
		btnUpload.setFocusPainted(false);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnUpload_action(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpload.setBackground(new Color(255, 255, 255));
		btnUpload.setBorder(null);
		btnUpload.setIcon(new ImageIcon(GUI3_2.class.getResource("/assets/upload.png")));
		btnUpload.setBounds(687, 167, 24, 24);
		panel_1.add(btnUpload);
		
		JLabel lblNewLabel_2 = new JLabel("<html>upload image<br>here</html>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(692, 191, 53, 58);
		panel_1.add(lblNewLabel_2);
		

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setForeground(new Color(255, 255, 255));
		scrollPane_1.setBounds(10, 501, 750, 573);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(20);
		contentpane.add(scrollPane_1);
		scrollPane.setBounds(0, 41, 789, 744);
		mainPane.add(scrollPane);
		
		
		panelChoice = new JPanel();
		panelChoice.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelChoice.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(panelChoice);
		panelChoice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelChoice.setLayout(null);
		
		
		
		
		
		
		
		JPanel panel_Choice1 = new JPanel();
		panel_Choice1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Choice1.setBackground(new Color(255, 255, 255));
		panel_Choice1.setBounds(363, 11, 358, 178);
		panelChoice.add(panel_Choice1);
		panel_Choice1.setLayout(null);
		
		JLabel labelChoice1 = new JLabel("Choice 1");
		labelChoice1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelChoice1.setBounds(10, 74, 55, 21);
		panel_Choice1.add(labelChoice1);
		
		JLabel labelGrade1 = new JLabel("Grade");
		labelGrade1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGrade1.setBounds(10, 120, 55, 26);
		panel_Choice1.add(labelGrade1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(94, 115, 153, 39);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None", "100%", "90%", "83.33333%", "80%", "75%", "70%", "66.66667%", "60%", "50%", "40%", "33.3333%", "25%", "20%", "16.66667%", "14.28571%", "12.5%", "11.11111%", "10%", "5%", "-5%", "-10%", "-11.11111%", "-12.5%", "-14.28571%", "-16.66667%", "-20%", "-25%", "-30%", "-33.33333%", "-40%", "-50%", "-60%", "-66.66667%", "-70%", "-75%", "-80%", "-83.33333%"}));
		panel_Choice1.add(comboBox_1);
		
		JScrollPane scrollPane_Choice1 = new JScrollPane();
		scrollPane_Choice1.setBounds(93, 11, 235, 62);
		panel_Choice1.add(scrollPane_Choice1);
		textPane_1 = new JTextPane();
		textPane_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		textPane_1.setBounds(93, 11, 235, 62);
		scrollPane_Choice1.setViewportView(textPane_1);
//		panel_Choice1.add(textPane_1);
		
		textField_Choice1 = new JTextField();
		textField_Choice1.setBounds(93, 73, 235, 21);
		panel_Choice1.add(textField_Choice1);
		textField_Choice1.setColumns(10);
		
		
		
		
		
		
		
		
		JPanel panel_Choice2 = new JPanel();
		panel_Choice2.setLayout(null);
		panel_Choice2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Choice2.setBackground(Color.WHITE);
		panel_Choice2.setBounds(363, 209, 358, 178);
		panelChoice.add(panel_Choice2);
		
		JLabel labelChoice1_1 = new JLabel("Choice 2");
		labelChoice1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelChoice1_1.setBounds(10, 74, 55, 21);
		panel_Choice2.add(labelChoice1_1);
		
		JLabel labelGrade1_1 = new JLabel("Grade");
		labelGrade1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGrade1_1.setBounds(10, 120, 55, 26);
		panel_Choice2.add(labelGrade1_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(94, 115, 153, 39);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"None", "100%", "90%", "83.33333%", "80%", "75%", "70%", "66.66667%", "60%", "50%", "40%", "33.3333%", "25%", "20%", "16.66667%", "14.28571%", "12.5%", "11.11111%", "10%", "5%", "-5%", "-10%", "-11.11111%", "-12.5%", "-14.28571%", "-16.66667%", "-20%", "-25%", "-30%", "-33.33333%", "-40%", "-50%", "-60%", "-66.66667%", "-70%", "-75%", "-80%", "-83.33333%"}));
		panel_Choice2.add(comboBox_2);
		
		
		JScrollPane scrollPane_Choice2 = new JScrollPane();
		scrollPane_Choice2.setBounds(93, 11, 235, 62);
		panel_Choice2.add(scrollPane_Choice2);
		
		textPane_2 = new JTextPane();
		textPane_2.setBorder(new LineBorder(new Color(192, 192, 192)));
//		textPane_2.setBounds(93, 11, 235, 62);
//		panel_Choice2.add(textPane_2);
		scrollPane_Choice2.setViewportView(textPane_2);
		
		textField_Choice2 = new JTextField();
		textField_Choice2.setColumns(10);
		textField_Choice2.setBounds(93, 73, 235, 21);
		panel_Choice2.add(textField_Choice2);
		
		moreChoicebtn = new JButton("BLANK FOR MORE 3 CHOICES");
		moreChoicebtn.setBorder(null);
		moreChoicebtn.setFocusPainted(false);
		moreChoicebtn.setForeground(new Color(255, 255, 255));
		moreChoicebtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moreChoicebtn.setBackground(new Color(39, 118, 143));
		moreChoicebtn.setBounds(363, 400, 231, 39);
		panelChoice.add(moreChoicebtn);
		moreChoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_moreChoicebtn_actionPerformed(e);
			}
		}
		);
		
		moreEditingbtn = new JButton("SAVE CHANGES AND CONTINUE EDITING");
		moreEditingbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_moreEditingbtn_actionPerformed(e);
			}
		}
		);
		moreEditingbtn.setForeground(Color.WHITE);
		moreEditingbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		moreEditingbtn.setFocusPainted(false);
		moreEditingbtn.setBorder(null);
		moreEditingbtn.setBackground(new Color(39, 118, 143));
		moreEditingbtn.setBounds(363, 460, 332, 39);
		panelChoice.add(moreEditingbtn);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(39, 118, 143));
		btnCancel.setBounds(363, 510, 79, 39);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_action(e);
			}
		});
		panelChoice.add(btnCancel);
		
		btnSaveChanges = new JButton("SAVE CHANGES");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSaveChanges_action(e);
			}
		});
		btnSaveChanges.setForeground(Color.WHITE);
		btnSaveChanges.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSaveChanges.setFocusPainted(false);
		btnSaveChanges.setBorder(null);
		btnSaveChanges.setBackground(new Color(255, 0, 0));
		btnSaveChanges.setBounds(230, 510, 129, 39);
		panelChoice.add(btnSaveChanges);
		
		
		
		
		
		
		
		
		panel_Choice5 = new JPanel();
		panel_Choice5.setLayout(null);
		panel_Choice5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Choice5.setBackground(Color.WHITE);
		panel_Choice5.setBounds(363, 803, 358, 178);
		//panelChoice.add(panel_2_4);
		
		JLabel labelChoice1_4 = new JLabel("Choice 5");
		labelChoice1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelChoice1_4.setBounds(10, 74, 55, 21);
		panel_Choice5.add(labelChoice1_4);
		
		JLabel labelGrade1_4 = new JLabel("Grade");
		labelGrade1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGrade1_4.setBounds(10, 120, 55, 26);
		panel_Choice5.add(labelGrade1_4);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(94, 115, 153, 39);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"None", "100%", "90%", "83.33333%", "80%", "75%", "70%", "66.66667%", "60%", "50%", "40%", "33.3333%", "25%", "20%", "16.66667%", "14.28571%", "12.5%", "11.11111%", "10%", "5%", "-5%", "-10%", "-11.11111%", "-12.5%", "-14.28571%", "-16.66667%", "-20%", "-25%", "-30%", "-33.33333%", "-40%", "-50%", "-60%", "-66.66667%", "-70%", "-75%", "-80%", "-83.33333%"}));
		panel_Choice5.add(comboBox_5);
		
		
		
		JScrollPane scrollPane_Choice5 = new JScrollPane();
		scrollPane_Choice5.setBounds(93, 11, 235, 62);
		panel_Choice5.add(scrollPane_Choice5);
		textPane_5 = new JTextPane();
		textPane_5.setBorder(new LineBorder(new Color(192, 192, 192)));
//		textPane_5.setBounds(93, 11, 235, 62);
//		panel_Choice5.add(textPane_5);
		scrollPane_Choice5.setViewportView(textPane_5);
		
		textField_Choice5 = new JTextField();
		textField_Choice5.setColumns(10);
		textField_Choice5.setBounds(93, 73, 235, 21);
		panel_Choice5.add(textField_Choice5);
		
		
		
		
		
		
		
		panel_Choice4 = new JPanel();
		panel_Choice4.setLayout(null);
		panel_Choice4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Choice4.setBackground(Color.WHITE);
		panel_Choice4.setBounds(363, 605, 358, 178);
		
		JLabel labelChoice1_3 = new JLabel("Choice 4");
		labelChoice1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelChoice1_3.setBounds(10, 74, 55, 21);
		panel_Choice4.add(labelChoice1_3);
		
		JLabel labelGrade1_3 = new JLabel("Grade");
		labelGrade1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGrade1_3.setBounds(10, 120, 55, 26);
		panel_Choice4.add(labelGrade1_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(94, 115, 153, 39);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"None", "100%", "90%", "83.33333%", "80%", "75%", "70%", "66.66667%", "60%", "50%", "40%", "33.3333%", "25%", "20%", "16.66667%", "14.28571%", "12.5%", "11.11111%", "10%", "5%", "-5%", "-10%", "-11.11111%", "-12.5%", "-14.28571%", "-16.66667%", "-20%", "-25%", "-30%", "-33.33333%", "-40%", "-50%", "-60%", "-66.66667%", "-70%", "-75%", "-80%", "-83.33333%"}));
		panel_Choice4.add(comboBox_4);
		
		
		JScrollPane scrollPane_Choice4 = new JScrollPane();
		scrollPane_Choice4.setBounds(93, 11, 235, 62);
		panel_Choice4.add(scrollPane_Choice4);
		textPane_4 = new JTextPane();
		textPane_4.setBorder(new LineBorder(new Color(192, 192, 192)));
//		textPane_5.setBounds(93, 11, 235, 62);
//		panel_Choice5.add(textPane_5);
		scrollPane_Choice4.setViewportView(textPane_4);
		
		
		textField_Choice4 = new JTextField();
		textField_Choice4.setColumns(10);
		textField_Choice4.setBounds(93, 73, 235, 21);
		panel_Choice4.add(textField_Choice4);
		
		
		
		
		
		
		
		panel_Choice3 = new JPanel();
		panel_Choice3.setLayout(null);
		panel_Choice3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Choice3.setBackground(Color.WHITE);
		panel_Choice3.setBounds(363, 407, 358, 178);
		
		textField_Choice3 = new JTextField();
		textField_Choice3.setColumns(10);
		textField_Choice3.setBounds(93, 73, 235, 21);
		panel_Choice3.add(textField_Choice3);
		
		//panelChoice.add(panel_2_2);
		
		JLabel labelChoice1_2 = new JLabel("Choice 3");
		labelChoice1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelChoice1_2.setBounds(10, 74, 55, 21);
		panel_Choice3.add(labelChoice1_2);
		
		JLabel labelGrade1_2 = new JLabel("Grade");
		labelGrade1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGrade1_2.setBounds(10, 120, 55, 26);
		panel_Choice3.add(labelGrade1_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(94, 115, 153, 39);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"None", "100%", "90%", "83.33333%", "80%", "75%", "70%", "66.66667%", "60%", "50%", "40%", "33.3333%", "25%", "20%", "16.66667%", "14.28571%", "12.5%", "11.11111%", "10%", "5%", "-5%", "-10%", "-11.11111%", "-12.5%", "-14.28571%", "-16.66667%", "-20%", "-25%", "-30%", "-33.33333%", "-40%", "-50%", "-60%", "-66.66667%", "-70%", "-75%", "-80%", "-83.33333%"}));
		panel_Choice3.add(comboBox_3);
		
		JScrollPane scrollPane_Choice3 = new JScrollPane();
		scrollPane_Choice3.setBounds(93, 11, 235, 62);
		panel_Choice3.add(scrollPane_Choice3);
		textPane_3 = new JTextPane();
		textPane_3.setBorder(new LineBorder(new Color(192, 192, 192)));
//		textPane_5.setBounds(93, 11, 235, 62);
//		panel_Choice5.add(textPane_5);
		scrollPane_Choice3.setViewportView(textPane_3);
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 40));
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(39, 118, 143));
		menuBar.setBounds(0, 0, 789, 40);
		mainPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(GUI3_2.class.getResource("/assets/menuIconWhite.png")));
		menuBar.add(mnNewMenu);
   
	}

	protected void do_btnUpload_action(ActionEvent e) throws IOException {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Select an image");
		fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and  GIF images", "png", "gif", "jpg" ,"jpeg");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(this);  
        File file = fileChooser.getSelectedFile();
        if(file.getName().endsWith("gif")) {
        	icon = new ImageIcon(file.getAbsolutePath());
        	String s = file.getAbsolutePath();
            System.out.println(file.getAbsolutePath());
            path.add(s);
        }
        else  {
        	image = ImageIO.read(file);
        	int newHeight;
        	int newWidth;
        	newWidth = 100;
        	newHeight = image.getHeight(null)*newWidth/image.getWidth(null);
        
        	Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        /*InputStream is = new FileInputStream(file);
        FileOutputStream fimage = new FileOutputStream("C:\\Users\\Administrator\\Videos\\"+textFieldName.getText()+".jpeg");
        byte[] buffer = new byte[1024];
        int length; 
        
        while((length = is.read(buffer)) > 0) {
        	fimage.write(buffer, 0, length);  
        }
        is.close();
        fimage.close();*/
        
        System.out.println(file.getAbsolutePath());
        String s = file.getAbsolutePath();
        System.out.println(file.getAbsolutePath());
        path.add(s);
        System.out.println(path.get(0));
        
        icon = new ImageIcon(newImage); 
        
	}
        textPaneCateInfor.insertIcon(icon);
        iconList.add(icon);
       
        Element section = textPaneCateInfor.getDocument().getDefaultRootElement();
	    paraCount = section.getElementCount();
	}
	protected void do_moreEditingbtn_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(boxParent.getSelectedItem().toString().trim().equalsIgnoreCase("Default")) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn ngân hàng đề");
		}
		else if(textFieldName.getText().isBlank() || textPaneCateInfor.getText().isBlank()){
			JOptionPane.showMessageDialog(null, "Hãy điền đầy đủ thông tin");
		}
		
		else {
			
			ArrayList<String> listChoice= new ArrayList<>();
			ArrayList<String> listChoiceGrade= new ArrayList<>();
			if(textField_Choice1.getText().equalsIgnoreCase("")==false) {
				listChoice.add(textField_Choice1.getText().toUpperCase()+": "+textPane_1.getText() );
				listChoiceGrade.add(comboBox_1.getSelectedItem().toString());
			}
			if(textField_Choice2.getText().equalsIgnoreCase("")==false) {
				listChoice.add(textField_Choice2.getText().toUpperCase()+": "+textPane_2.getText());
				listChoiceGrade.add(comboBox_2.getSelectedItem().toString());
			}
			if(textField_Choice3.getText().equalsIgnoreCase("")==false) {
				listChoice.add(textField_Choice3.getText().toUpperCase()+": "+textPane_3.getText());
				listChoiceGrade.add(comboBox_3.getSelectedItem().toString());
			}
			if(textField_Choice4.getText().equalsIgnoreCase("")==false) {
				listChoice.add(textField_Choice4.getText().toUpperCase()+": "+textPane_4.getText());
				listChoiceGrade.add(comboBox_4.getSelectedItem().toString());
			}
			if(textField_Choice5.getText().equalsIgnoreCase("")==false) {
				listChoice.add(textField_Choice5.getText().toUpperCase()+": "+textPane_5.getText());
				listChoiceGrade.add(comboBox_5.getSelectedItem().toString());
			}
			int temp = 0; 
			double  percent;
			ArrayList<String> multiAnswer = new ArrayList();
			String answer = new String();
	   	 	for(String s : listChoiceGrade ) {
	   	 		if (!s.equalsIgnoreCase("None")) {
	   	 			temp++;
	   	 			System.out.println("ở đây "+ s);
	   	 		}
	   	 	}
	   	 	
	   	 	
	   	   if(temp ==1) {
	   		
	   	 		if (!comboBox_1.getSelectedItem().toString().equalsIgnoreCase("None") ) {
	   	 			answer="ANSWER: "+textField_Choice1.getText().toUpperCase();	   	 		
	   	 		}
	   	 		if (!comboBox_2.getSelectedItem().toString().equalsIgnoreCase("None") ) {
   	 			answer="ANSWER: "+textField_Choice2.getText().toUpperCase();	   	 		
	   	 		}
	   	 		if (!comboBox_3.getSelectedItem().toString().equalsIgnoreCase("None") ) {
	 			answer="ANSWER: "+textField_Choice3.getText().toUpperCase();	   	 		
	   	 		}
	   	 		if (!comboBox_4.getSelectedItem().toString().equalsIgnoreCase("None") ) {
	 			answer="ANSWER: "+textField_Choice4.getText().toUpperCase();	   	 		
	   	 		}
	   	 		if (!comboBox_5.getSelectedItem().toString().equalsIgnoreCase("None") ) {
   	 			answer="ANSWER: "+textField_Choice5.getText().toUpperCase();	   	 		
	   	 		}
	   	   }
	   	   else {

	   		   String[] arr = {	"A", "B", "C", "D", "E"	};
	   		for(int i = 0; i < listChoiceGrade.size();i++ ) {
	   	 		if (!listChoiceGrade.get(i).equals("None") && listChoiceGrade.get(i).charAt(0)!='-') {
	   	 			multiAnswer.add(arr[i]);	   	 			
	   	 		}
	   	 	}
	   		   
	   		   
	   	   }
	   	 	
			if(listChoice.size()>=2 && temp == 1) {
				Question question= new Question(textFieldName.getText(), textPaneCateInfor.getText(), listChoice );
				question.setAnswer(answer);
				question.setMultiple(false);
				iconOfQuestion = new IconofQuestion(question);
				iconOfQuestion.setIconList(iconList);
				iconOfQuestion.setPath(path);
				ChoiceGrade choiceGrade = new ChoiceGrade(question);
				choiceGrade.setListGrade(listChoiceGrade);
				try {
						ArrayList<IconofQuestion> arrayListQues = new fileQuesIcon().docIconList();
						arrayListQues.add(iconOfQuestion);
						new fileQuesIcon().ghiIconList(arrayListQues);
				} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				
				try {
					ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
					arrayListQues.add(choiceGrade);
					System.out.println(choiceGrade.getListGrade());
					new FileChoiceGrade().ghiChoiceGradeList(arrayListQues);
					
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
				
				try {
					ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
					for(QuestionBank q:listQB) {
						
					if((q.getNameQB()/*+" ("+q.getQuantity()+")"*/).equalsIgnoreCase(boxParent.getSelectedItem().toString().trim())) {
						if(!checkQuestionEdit) {
							ArrayList<Question> listqs=new ArrayList<>();
							int k = q.getQuantity() + 1;
							q.setQuantity(k);
							if(q.getListQuestions()==null || q.getListQuestions().isEmpty() ) {								
								listqs.add(question);
								q.setListQuestions(listqs);
								new fileQuestionBank().ghiBank(listQB);
								//themVaoCha(q.getParentQB(), question);
								JOptionPane.showMessageDialog(null, "successfull!");
								
								break;
							}else {
								listqs = q.getListQuestions();
								int j=0;
								for(Question qs:listqs) {
									if(qs.getName().equals(textFieldName.getText())){
										j++;
									}
								}
								if(j==0) {
									listqs.add(question);
									q.setListQuestions(listqs);
									new fileQuestionBank().ghiBank(listQB);
									JOptionPane.showMessageDialog(null, "successfull!");
									break;
								}else {
									JOptionPane.showMessageDialog(null, "Question name đã tồn tại!");
								}
							}
						
							}
						else {
								ArrayList<Question> listqs=new ArrayList<>();
								listqs = q.getListQuestions();
								listqs.set(index, question) ;
								System.out.println(listqs.get(index).getAnswer());
								q.setListQuestions(listqs);
								new fileQuestionBank().ghiBank(listQB);
								JOptionPane.showMessageDialog(null, "đã sửa!");
								break;
							}
							}
					}
					
					
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}
			
			else if(listChoice.size()>=2 && temp > 1) {
				Question question= new Question(textFieldName.getText(), textPaneCateInfor.getText(), listChoice );
				question.setMultiAnswer(multiAnswer);
				question.setMultiple(true);
				iconOfQuestion = new IconofQuestion(question);
				iconOfQuestion.setIconList(iconList);
				iconOfQuestion.setPath(path);
				ChoiceGrade choiceGrade = new ChoiceGrade(question);
				choiceGrade.setListGrade(listChoiceGrade);
				try {
						ArrayList<IconofQuestion> arrayListQues = new fileQuesIcon().docIconList();
						arrayListQues.add(iconOfQuestion);
						new fileQuesIcon().ghiIconList(arrayListQues);
				} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				
				try {
					ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
					arrayListQues.add(choiceGrade);
					System.out.println(choiceGrade.getListGrade());
					new FileChoiceGrade().ghiChoiceGradeList(arrayListQues);
					
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
				
				try {
					ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
					for(QuestionBank q:listQB) {
						
					if((q.getNameQB()/*+" ("+q.getQuantity()+")"*/).equalsIgnoreCase(boxParent.getSelectedItem().toString().trim())) {
						if(!checkQuestionEdit) {
							ArrayList<Question> listqs=new ArrayList<>();
							int k = q.getQuantity() + 1;
							q.setQuantity(k);
							if(q.getListQuestions()==null || q.getListQuestions().isEmpty() ) {								
								listqs.add(question);
								q.setListQuestions(listqs);
								new fileQuestionBank().ghiBank(listQB);
								//themVaoCha(q.getParentQB(), question);
								JOptionPane.showMessageDialog(null, "successfull!");
								
								break;
							}else {
								listqs = q.getListQuestions();
								int j=0;
								for(Question qs:listqs) {
									if(qs.getName().equals(textFieldName.getText())){
										j++;
									}
								}
								if(j==0) {
									listqs.add(question);
									q.setListQuestions(listqs);
									new fileQuestionBank().ghiBank(listQB);
									JOptionPane.showMessageDialog(null, "successfull!");
									break;
								}else {
									JOptionPane.showMessageDialog(null, "Question name đã tồn tại!");
								}
							}
						
							}
						else {
								ArrayList<Question> listqs=new ArrayList<>();
								listqs = q.getListQuestions();
								listqs.set(index, question) ;
								System.out.println(listqs.get(index).getAnswer());
								q.setListQuestions(listqs);
								new fileQuestionBank().ghiBank(listQB);
								JOptionPane.showMessageDialog(null, "đã sửa!");
								break;
							}
							}
					}
					
					
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "hãy nhập thêm lựa chọn đáp án");
			}
			
		}
	}

	private void themVaoCha(String name, Question list) {
		// TODO Auto-generated method stub
		try {
			ArrayList<QuestionBank> listQb=new fileQuestionBank().docQuiz();
			for(QuestionBank qb:listQb) {
				if(qb.getNameQB().equalsIgnoreCase(name)) {
					ArrayList<Question> aq= qb.getListQuestions();
					aq.add(list);
					qb.setListQuestions(aq);
					new fileQuestionBank().ghiBank(listQb);
					if(qb.getParentQB().equalsIgnoreCase("default")) {
						
					}else {
						themVaoCha(qb.getParentQB(), list);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

	protected void do_btnSaveChanges_action(ActionEvent e) {
		// TODO Auto-generated method stub
		do_moreEditingbtn_actionPerformed(e);
		this.setVisible(false);
		BTL_View mainView = new BTL_View();
		mainView.setVisible(true);
		mainView.do_btnQuestions_action(e);
	}

	protected void do_btnCancel_action(ActionEvent e) {
		// TODO Auto-generated method stub
		BTL_View home = new BTL_View();
		this.setVisible(false);
		home.setVisible(true);
		home.do_btnQuestions_action(e);
	}

	protected void do_moreChoicebtn_actionPerformed(ActionEvent e) {
		if(!moreChoice) {
			// Lấy kích thước hiện tại của panel
		    Dimension currentSize = panelChoice.getSize();
		    
		    // Tạo một kích thước mới gấp đôi chiều dài hiện tại
		    Dimension newSize = new Dimension(currentSize.width, currentSize.height * 2+30);
		    
		    // Đặt kích thước mới cho panel
		    panelChoice.setSize(newSize);
		    
		    panelChoice.setPreferredSize(newSize);
		    moreChoicebtn.setBounds(363, 1000, 231, 39);
		    moreEditingbtn.setBounds(363, 1060, 323, 39);
		    btnCancel.setBounds(363, 1110, 79, 39);
		    btnSaveChanges.setBounds(230, 1110, 129, 39);
		    moreChoicebtn.setText("DELETE 3 CHOICES");
		    panelChoice.add(panel_Choice3);
		    panelChoice.add(panel_Choice4);
		    panelChoice.add(panel_Choice5);
		    // Yêu cầu scrollPane cập nhật hiển thị
		    scrollPane_1.revalidate();
		    scrollPane_1.repaint();
		    moreChoice=true;
		}
		else{
			// Lấy kích thước hiện tại của panel
		    Dimension currentSize = panelChoice.getSize();
		    
		    // Tạo một kích thước mới gấp đôi chiều dài hiện tại
		    Dimension newSize = new Dimension(currentSize.width, currentSize.height / 2);
		    
		    // Đặt kích thước mới cho panel
		    panelChoice.setSize(newSize);
		    
		    panelChoice.setPreferredSize(newSize);
		    moreChoicebtn.setBounds(363, 400, 200, 39);
		    moreEditingbtn.setBounds(363, 460, 323, 39);
		    btnCancel.setBounds(363, 510, 79, 39);
		    btnSaveChanges.setBounds(230, 510, 129, 39);
		    moreChoicebtn.setText("BLANK FOR MORE 3 CHOICES");
		    panelChoice.remove(panel_Choice3);
		    panelChoice.remove(panel_Choice4);
		    panelChoice.remove(panel_Choice5);
		    // Yêu cầu scrollPane cập nhật hiển thị
		    scrollPane_1.revalidate();
		    scrollPane_1.repaint();
		    moreChoice=false;
		}
	}

	protected void do_btnHome_1_action(ActionEvent e) {
		// TODO Auto-generated method stub
		BTL_View home = new BTL_View();
		this.setVisible(false);
		home.do_btnHome_action(e);
		
	}
	
	public void setQues(Question q, JComboBox comboBox, int index) {
//		BTL_View mainView = new BTL_View();
//		char c = q.getAnswer().charAt(8);
		ArrayList<IconofQuestion> arrayListQuesIcon;
   	    ArrayList<ImageIcon> listIcon = new ArrayList();
		try {
			arrayListQuesIcon = new fileQuesIcon().docIconList();
			for(IconofQuestion j:arrayListQuesIcon) {
				if (j.getQuestion().getName().equalsIgnoreCase(q.getName()) && j.getQuestion().getQuestion().equalsIgnoreCase(q.getQuestion())) {
					listIcon = j.getIconList();
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		checkQuestionEdit = true;
		this.index = index;
		this.boxParent.setSelectedIndex(comboBox.getSelectedIndex());		
		System.out.println(boxParent.getSelectedItem());
		this.getTextFieldName().setText(q.getName());
		this.getTextFieldName().setText(q.getName());
   	 	this.getTextPaneCateInfor().setText(q.getQuestion());
   	 	for(ImageIcon iconn : listIcon) {
   	 	this.getTextPaneCateInfor().insertIcon(iconn);
   	 	}
   	 	
 //  	 	char answer = q.getAnswer().charAt(8);
 //  	 	this.getTextFieldAnswer().setText(String.valueOf(answer));
   	 System.out.println("đây là size  "+q.getListChoice().size());
   	 	int i = q.getListChoice().size();
   	 ArrayList<String> listChoiceGrade = new ArrayList();
   	 	try {
			ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
			for(ChoiceGrade choiceGrade : arrayListQues) {
				if(choiceGrade.getQuestion().getName().equalsIgnoreCase(q.getName()) && choiceGrade.getQuestion().getQuestion().equalsIgnoreCase(q.getQuestion())) {
					listChoiceGrade = choiceGrade.getListGrade();
					 
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	    
   	 	
   	 	if(i == 2) {
   	 		this.textPane_1.setText(q.getListChoice().get(0).substring(3));
   	 		this.textPane_2.setText(q.getListChoice().get(1).substring(3));
   	 		this.textField_Choice1.setText("A");
   	 		this.textField_Choice2.setText("B");
   	 		this.comboBox_1.setSelectedItem( listChoiceGrade.get(0) );
   	 	    this.comboBox_2.setSelectedItem( listChoiceGrade.get(1) );
   	 		
   	 		
   	 	}
   	 	if(i == 3) {
	 		this.textPane_1.setText(q.getListChoice().get(0).substring(3));
	 		this.textPane_2.setText(q.getListChoice().get(1).substring(3));
	 		this.textPane_3.setText(q.getListChoice().get(2).substring(3));
	 		this.textField_Choice1.setText("A");
   	 		this.textField_Choice2.setText("B");
   	 		this.textField_Choice3.setText("C");
   	 		this.do_moreChoicebtn_actionPerformed(null);
   	 	    this.comboBox_1.setSelectedItem( listChoiceGrade.get(0) );
	 	    this.comboBox_2.setSelectedItem( listChoiceGrade.get(1) );
	 	    this.comboBox_3.setSelectedItem( listChoiceGrade.get(2) );
  	 	    
	 		
	 	}
   	if(i == 4) {
 		this.textPane_1.setText(q.getListChoice().get(0).substring(3));
 		this.textPane_2.setText(q.getListChoice().get(1).substring(3));
 		this.textPane_3.setText(q.getListChoice().get(2).substring(3));
 		
 		System.out.println(q.getListChoice().get(2).substring(3));
 		this.textPane_4.setText(q.getListChoice().get(3).substring(3));
 		this.textField_Choice1.setText("A");
	 	this.textField_Choice2.setText("B");
	 	this.textField_Choice3.setText("C");
	 	this.textField_Choice4.setText("D");
	 	this.comboBox_1.setSelectedItem( listChoiceGrade.get(0) );
 	    this.comboBox_2.setSelectedItem( listChoiceGrade.get(1) );
 	    this.comboBox_3.setSelectedItem( listChoiceGrade.get(2) );
 	    this.comboBox_4.setSelectedItem( listChoiceGrade.get(3) );
	 	this.do_moreChoicebtn_actionPerformed(null);
 	}
   	if(i == 5) {
 		this.textPane_1.setText(q.getListChoice().get(0).substring(3));
 		this.textPane_2.setText(q.getListChoice().get(1).substring(3));
 		this.textPane_3.setText(q.getListChoice().get(2).substring(3));
 		this.textPane_4.setText(q.getListChoice().get(3).substring(3));
 		this.textPane_5.setText(q.getListChoice().get(4).substring(3));
 		this.textField_Choice1.setText("A");
	 	this.textField_Choice2.setText("B");
	 	this.textField_Choice3.setText("C");
	 	this.textField_Choice4.setText("D");
	 	this.textField_Choice4.setText("E");
	 	this.comboBox_1.setSelectedItem( listChoiceGrade.get(0) );
 	    this.comboBox_2.setSelectedItem( listChoiceGrade.get(1) );
 	    this.comboBox_3.setSelectedItem( listChoiceGrade.get(2) );
 	    this.comboBox_4.setSelectedItem( listChoiceGrade.get(3) );
 	    this.comboBox_5.setSelectedItem( listChoiceGrade.get(4) );
	 	this.do_moreChoicebtn_actionPerformed(null);
 	}
	}
}
