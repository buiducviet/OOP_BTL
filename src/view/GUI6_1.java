package view;

import java.awt.EventQueue;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import DB.FileDsQuiz;
import DB.fileTimeLimitQuiz;
import model.Question;
import model.QuestionList;
import model.Quiz;
import model.TimeLimitOfQuiz;
import model.Export;
import view.GUI7_3;



import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListCellRenderer;

public class GUI6_1 extends JFrame {
	public JPanel contentPane;
	public JPanel panelPopup;
	public JPanel panelAddQuiz ;
	private JPanel panelStart;
	public JPanel panelEditQuiz ;
	public JTextField textField;
	private JList list;
	private JCheckBox checkBox_All;
	QuestionList renderer = new QuestionList();
	private DefaultListCellRenderer renderer_default = new DefaultListCellRenderer();
	private ArrayList<Question> quizzlistques_1;
	int count = 0;	
	int temp;
	private String Heading ;
	
	public String getHeading() {
		return Heading;
	}

	public void setHeading(String Heading) {
		this.Heading = Heading;
	}

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI6_1 frame = new GUI6_1(Heading);
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
	public GUI6_1(String str) {
		
		this.setHeading(str);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 45, 694, 94);
		contentPane.add(panel);
		
		JLabel labelIT = new JLabel("IT\r\n");
		labelIT.setForeground(new Color(214, 20, 20));
		labelIT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelIT.setBounds(10, 11, 24, 24);
		panel.add(labelIT);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.setForeground(new Color(214, 20, 20));
		btnHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHome_1_action(e);
			}
		});
		btnHome_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome_1.setFocusTraversalKeysEnabled(false);
		btnHome_1.setFocusPainted(false);
		btnHome_1.setBorder(null);
		btnHome_1.setBackground(Color.WHITE);
		btnHome_1.setBounds(10, 58, 45, 23);
		panel.add(btnHome_1);
		
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
		btnTCKy.setForeground(new Color(214, 20, 20));
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
		
		JLabel labelbonus_1 = new JLabel("/");
		labelbonus_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_1.setFocusTraversalPolicyProvider(true);
		labelbonus_1.setBounds(275, 58, 5, 27);
		panel.add(labelbonus_1);
		
		JLabel labelbonus_2 = new JLabel("General");
		labelbonus_2.setForeground(new Color(214, 20, 20));
		labelbonus_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_2.setBounds(290, 58, 57, 23);
		panel.add(labelbonus_2);
		
		JLabel labelbonus_3 = new JLabel("/");
		labelbonus_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_3.setFocusTraversalPolicyProvider(true);
		labelbonus_3.setBounds(345, 58, 5, 27);
		panel.add(labelbonus_3);
		
		JLabel labelbonus_4 = new JLabel(Heading);
		labelbonus_4.setForeground(new Color(214, 20, 20));
		labelbonus_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_4.setBounds(357, 58, 327, 23);
		panel.add(labelbonus_4);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 40));
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(39, 118, 143));
		menuBar.setBounds(0, 0, 714, 40);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/menuIconWhite.png")));
		menuBar.add(mnNewMenu);
		
		panelEditQuiz = new JPanel();
		panelEditQuiz.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelEditQuiz.setBackground(new Color(255, 255, 255));
		panelEditQuiz.setBounds(10, 150, 694, 427);
		contentPane.add(panelEditQuiz);
		panelEditQuiz.setLayout(null);
		panelEditQuiz.setVisible(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Jump to"}));
		comboBox_1.setBounds(432, 391, 109, 25);
		panelEditQuiz.add(comboBox_1);
		
		
		
		JLabel labelHeading = new JLabel("Edit quiz: "+str);
		labelHeading.setForeground(new Color(214, 20, 20));
		labelHeading.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelHeading.setBounds(10, 11, 340, 24);
		panelEditQuiz.add(labelHeading);
		
		JLabel labelQuestion = new JLabel("Question: 0");
		labelQuestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelQuestion.setBounds(10, 39, 89, 24);
		panelEditQuiz.add(labelQuestion);
		
		JLabel labelThisquiz = new JLabel("This quiz is open");
		labelThisquiz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelThisquiz.setBounds(119, 39, 108, 24);
		panelEditQuiz.add(labelThisquiz);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(100, 39, 8, 24);
		panelEditQuiz.add(separator);
		
		JButton btnRepag = new JButton("REPAGINATE");
		btnRepag.setForeground(Color.WHITE);
		btnRepag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRepag.setFocusPainted(false);
		btnRepag.setBorder(null);
		btnRepag.setBackground(new Color(39, 118, 143));
		btnRepag.setBounds(10, 74, 89, 34);
		panelEditQuiz.add(btnRepag);
		
		checkBox_All = new JCheckBox("Select all Questions");
		checkBox_All.addItemListener(new ItemListener() {
		      @Override
		      public void itemStateChanged(ItemEvent e) {
		    	  DefaultListModel model = (DefaultListModel)list.getModel();
		        if (checkBox_All.isSelected()) { 
		         
		          for (int i = 0; i < model.getSize(); i++) {
		        	  Question item = (Question) list.getModel().getElementAt(i);
		              item.setIsSelected(true); // Toggle selected state  
		              list.repaint(list.getCellBounds(i, i));// Repaint cell
		          }  
		        } else {  
		        	for (int i = 0; i < model.getSize(); i++) {
			        	  Question item = (Question) list.getModel().getElementAt(i);
			              item.setIsSelected(false); // Toggle selected state  
			              list.repaint(list.getCellBounds(i, i));// Repaint cell
			          }  
		        }
		        list.revalidate();
		          
		      }
		    });
		checkBox_All.setForeground(new Color(15, 192, 244));
		checkBox_All.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBox_All.setFocusPainted(false);
		checkBox_All.setBackground(Color.WHITE);
		checkBox_All.setBounds(119, 391, 136, 23);
		panelEditQuiz.add(checkBox_All);
		
		JButton btnRepag_1 = new JButton("SELECT MULTIPLE ITEMS");		
		btnRepag_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
			 list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						JList list = (JList) e.getSource();
		                int index = list.locationToIndex(e.getPoint());// Get index of item
		                // clicked		                
		                Question item = (Question) list.getModel().getElementAt(index);
		                item.setIsSelected(!item.isSelected()); 
		                list.repaint(list.getCellBounds(index, index));// Repaint cell
					}
				});
			 	 checkBox_All.setSelected(false);
				 list.setCellRenderer(renderer);
			}
		});
		btnRepag_1.setForeground(Color.WHITE);
		btnRepag_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRepag_1.setFocusPainted(false);
		btnRepag_1.setBorder(null);
		btnRepag_1.setBackground(new Color(39, 118, 143));
		btnRepag_1.setBounds(105, 74, 160, 34);
		panelEditQuiz.add(btnRepag_1);
		
		JLabel labelMaxGrade = new JLabel("Maximum grade");
		labelMaxGrade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelMaxGrade.setBounds(444, 39, 97, 24);
		panelEditQuiz.add(labelMaxGrade);
		
		textField = new JTextField();
		textField.setText("10.00");
		textField.setBounds(546, 29, 56, 33);
		panelEditQuiz.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setFocusPainted(false);
		btnSave.setBorder(null);
		btnSave.setBackground(new Color(39, 118, 143));
		btnSave.setBounds(612, 28, 61, 33);
		panelEditQuiz.add(btnSave);
		
		JLabel labelTotalMark = new JLabel("Total of marks: 0.00");
		labelTotalMark.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTotalMark.setBounds(556, 79, 127, 24);
		panelEditQuiz.add(labelTotalMark);
		
		JPanel panelShuffle = new JPanel();
		panelShuffle.setBackground(new Color(238, 238, 238));
		panelShuffle.setBorder(null);
		panelShuffle.setBounds(10, 131, 673, 71);
		panelEditQuiz.add(panelShuffle);
		panelShuffle.setLayout(null);
		
		JLabel iconPen = new JLabel(new ImageIcon(GUI6_1.class.getResource("/assets/pen.png")));
		iconPen.setBounds(22, 11, 24, 24);
		panelShuffle.add(iconPen);
		
		JCheckBox checkboxShuffle = new JCheckBox("Shuffle");
		checkboxShuffle.setFocusPainted(false);
		checkboxShuffle.setBounds(559, 11, 72, 23);
		panelShuffle.add(checkboxShuffle);
		
		JLabel iconQuestion_1 = new JLabel(new ImageIcon(GUI6_1.class.getResource("/assets/question.png")));
		iconQuestion_1.setBounds(628, 11, 24, 24);
		panelShuffle.add(iconQuestion_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_action(e);
			}
		});
		btnAdd.setForeground(new Color(0, 0, 255));
		btnAdd.setFocusable(false);
		btnAdd.setBounds(601, 46, 51, 25);
		panelShuffle.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/298882_down_triangle_icon (1).png")));
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(238, 238, 238));
		btnAdd.setBorder(null);
		btnAdd.setHorizontalTextPosition(SwingConstants.LEFT);
		
		
		
		panelPopup = new JPanel();
		panelPopup.setBorder(null);
		panelPopup.setBounds(504, 201, 160, 87);
		panelEditQuiz.add(panelPopup);
		panelPopup.setLayout(null);
		panelPopup.setVisible(false);
		
		Color color= new Color(238,238,238);  // màu nền của panel popup
		Color color1= new Color(51, 156, 255);  // màu icon của button
		
		JButton btnNewQuestion = new JButton("a new question      ");
		btnNewQuestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewQuestion.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/plus.png")));
		btnNewQuestion.setFocusPainted(false);
		btnNewQuestion.setBackground(new Color(238, 238, 238));
		btnNewQuestion.setBorder(null);
		btnNewQuestion.setBounds(0, 0, 160, 29);
		btnNewQuestion.setIconTextGap(12); 
		panelPopup.add(btnNewQuestion);
		btnNewQuestion.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	btnNewQuestion.setForeground(Color.WHITE);  // Đổi màu chữ khi di chuột vào
		    	btnNewQuestion.setBackground(color1);		    
		    	btnNewQuestion.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/pluswhite.png")));
		    }
		    public void mouseExited(MouseEvent e) {
		    	btnNewQuestion.setForeground(Color.BLACK); // Đổi lại màu chữ khi di chuột ra
		    	btnNewQuestion.setBackground(color);
		    	btnNewQuestion.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/plus.png")));
		    }
		});		
		
		
		JButton btnFromBank = new JButton("from question bank");
		btnFromBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 do_btnFromBank_action(e);
			}
		});
		btnFromBank.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/plus.png")));
		btnFromBank.setIconTextGap(12);
		btnFromBank.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFromBank.setFocusPainted(false);
		btnFromBank.setBorder(null);
		btnFromBank.setBackground(new Color(238, 238, 238));
		btnFromBank.setBounds(0, 29, 160, 29);
		panelPopup.add(btnFromBank);
		btnFromBank.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	btnFromBank.setForeground(Color.WHITE);  // Đổi màu chữ khi di chuột vào
		    	btnFromBank.setBackground(color1);
		    	btnFromBank.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/pluswhite.png")));
		    }
		    public void mouseExited(MouseEvent e) {
		    	btnFromBank.setForeground(Color.BLACK); // Đổi lại màu chữ khi di chuột ra
		    	btnFromBank.setBackground(color);
		    	btnFromBank.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/plus.png")));
		    }
		});
		
		JButton btnRandomQuestion = new JButton("a random question ");
		btnRandomQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRandomQuestion_action(e);
			}
		});
		btnRandomQuestion.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/plus.png")));
		btnRandomQuestion.setIconTextGap(12);
		btnRandomQuestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRandomQuestion.setFocusPainted(false);
		btnRandomQuestion.setBorder(null);
		btnRandomQuestion.setBackground(new Color(238, 238, 238));
		btnRandomQuestion.setBounds(0, 58, 160, 29);
		panelPopup.add(btnRandomQuestion);
		btnRandomQuestion.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	btnRandomQuestion.setForeground(Color.WHITE);  // Đổi màu chữ khi di chuột vào
		    	btnRandomQuestion.setBackground(color1);
		    	btnRandomQuestion.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/pluswhite.png")));
		    }
		    public void mouseExited(MouseEvent e) {
		    	btnRandomQuestion.setForeground(Color.BLACK); // Đổi lại màu chữ khi di chuột ra
		    	btnRandomQuestion.setBackground(color);
		    	btnRandomQuestion.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/plus.png")));
		    }
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 207, 673, 175);
		panelEditQuiz.add(scrollPane_1);
		
		list = new JList();
		
		
		DefaultListModel<Question> dlm= new DefaultListModel<>();
		try {
			ArrayList<Quiz> listquiz= new FileDsQuiz().docQuiz();
			for(Quiz q: listquiz) {
				count = 0;
				if(q.getQuizName().trim().equals(Heading.trim())) {
					ArrayList<Question> ques= q.getListQuestions();
					for(Question qs:ques) {
						dlm.addElement(qs);
						count++;
					}
					list.setModel(dlm);
					break;
				}
			}
			labelQuestion.setText("Question: "+count);
			labelTotalMark.setText("Total of Mark: "+count+".00");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_btnDelete_action(e);
			}
		});
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBackground(new Color(214, 20, 20));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(null);
		btnDelete.setBounds(261, 393, 89, 23);
		panelEditQuiz.add(btnDelete);
		
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReturn_action(e);
				
			}
		});
		btnReturn.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/return.png")));
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReturn.setFocusPainted(false);
		btnReturn.setBorder(null);
		btnReturn.setBackground(new Color(64, 128, 128));
		btnReturn.setBounds(10, 394, 89, 23);
		panelEditQuiz.add(btnReturn);
		
		
		
		
		
		
		
		
		/******* Panel Add Quiz ********/
		
		panelAddQuiz = new JPanel();
		panelAddQuiz.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelAddQuiz.setBackground(new Color(255, 255, 255));
		panelAddQuiz.setBounds(10, 156, 694, 421);
		contentPane.add(panelAddQuiz);
		panelAddQuiz.setLayout(null);
		panelAddQuiz.setVisible(true);
		
		panelStart = new JPanel();
		panelStart.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		panelStart.setBackground(new Color(255, 255, 255));
		panelStart.setBounds(109, 35, 462, 254);
		panelAddQuiz.add(panelStart);
		panelStart.setLayout(null);
		panelStart.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Start attempt");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 5, 101, 35);
		panelStart.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 44, 462, 2);
		panelStart.add(separator_1);
		
		JButton btnX = new JButton("");
		btnX.setFocusPainted(false);
		btnX.setIcon(new ImageIcon(GUI6_1.class.getResource("/assets/close.png")));
		btnX.setBorder(null);
		btnX.setBackground(new Color(255, 255, 255));
		btnX.setBounds(431, 13, 21, 23);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_btnX_action(e);
			}
			
			
		});
		panelStart.add(btnX);
		
		JTextPane txtpnYourAttemptWill = new JTextPane();
		txtpnYourAttemptWill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnYourAttemptWill.setText("Your attempt will have a time limit of 1 hour. When you start, the timer will begin to count down and cannot be paused. You must your attempt before it expires. Are you sure you wish to start now?");
		txtpnYourAttemptWill.setBounds(48, 81, 365, 92);
		panelStart.add(txtpnYourAttemptWill);
		
		JLabel lblTimeLimit = new JLabel("Time limit");
		lblTimeLimit.setForeground(new Color(214, 20, 20));
		lblTimeLimit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTimeLimit.setBounds(38, 51, 87, 24);
		panelStart.add(lblTimeLimit);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 184, 462, 2);
		panelStart.add(separator_1_1);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_btnCancel_action(e);
			}
			
			
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(39, 118, 143));
		btnCancel.setBounds(235, 209, 79, 34);
		panelStart.add(btnCancel);
		

		JButton btnExport = new JButton("EXPORT");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_btnExport_action(e);
			}
			
			
		});
		btnExport.setForeground(Color.WHITE);
		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExport.setFocusPainted(false);
		btnExport.setBorder(null);
		btnExport.setBackground(new Color(39, 118, 143));
		btnExport.setBounds(139, 209, 79, 34);
		panelStart.add(btnExport);
		
		JButton btnStartAttempt = new JButton("START ATTEMPT");
		btnStartAttempt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_btnStartAttempt_action(e);
			} 
		});
		btnStartAttempt.setForeground(Color.WHITE);
		btnStartAttempt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStartAttempt.setFocusPainted(false);
		btnStartAttempt.setBorder(null);
		btnStartAttempt.setBackground(new Color(214, 20, 20));
		btnStartAttempt.setBounds(10, 209, 115, 34);
		panelStart.add(btnStartAttempt);
		
		JLabel lblNewLabel_2_1 = new JLabel(str);
		lblNewLabel_2_1.setBounds(10, 11, 134, 22);
		panelAddQuiz.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(214, 20, 20));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton iconSetting = new JButton(new ImageIcon(GUI6_1.class.getResource("/assets/settings (1).png")));
		iconSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_iconSetting_action(e);
			}
			
			
		});
		iconSetting.setFocusPainted(false);
		iconSetting.setBorder(null);
		iconSetting.setBackground(Color.WHITE);
		iconSetting.setBounds(634, 11, 30, 24);
		panelAddQuiz.add(iconSetting);
		
		
		
		ImageIcon iconsort_down = new ImageIcon("D:/sort-down.png");
		Image image = iconsort_down.getImage();
		Image resizedImage = image.getScaledInstance(8, 8, Image.SCALE_SMOOTH);
		ImageIcon resizedIconSort_down = new ImageIcon(resizedImage);
		panelAddQuiz.setLayout(null);
		JLabel iconSort_down = new JLabel(resizedIconSort_down);
		iconSort_down.setBounds(660, 11, 24, 24);
		panelAddQuiz.add(iconSort_down);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Summary of your previous attempts");
		lblNewLabel_2_1_1.setForeground(new Color(214, 20, 20));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(10, 110, 365, 22);
		panelAddQuiz.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time limit:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(425, 39, 64, 22);
		panelAddQuiz.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Grading method:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2.setBounds(391, 72, 98, 22);
		panelAddQuiz.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel();
		try {
			
			ArrayList<TimeLimitOfQuiz> arrayListQues = new fileTimeLimitQuiz().docTimeLimit();
			System.out.println("abcd");
			for(TimeLimitOfQuiz temp : arrayListQues) {
				if (temp.getQuizName().equalsIgnoreCase(this.Heading)) {
					System.out.println(temp.getQuizName());
					System.out.println("thời gian" + temp.getTimeLimit());
					if(temp.isHour())
					  lblNewLabel_2_3.setText( Integer.toString(temp.getTimeLimit())+":00:00");
					else {
						lblNewLabel_2_3.setText("0:"+Integer.toString(temp.getTimeLimit())+":00");
					}
				}
			}
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
		
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_3.setBackground(Color.WHITE);
		lblNewLabel_2_3.setBounds(501, 39, 64, 22);
		panelAddQuiz.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Last attempt");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_4.setBackground(Color.WHITE);
		lblNewLabel_2_4.setBounds(499, 72, 88, 22);
		panelAddQuiz.add(lblNewLabel_2_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(39, 118, 143));
		panel_2.setBounds(10, 143, 674, 38);
		panelAddQuiz.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Attempt");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(60, 8, 73, 25);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("State");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(200, 8, 73, 25);
		panel_2.add(lblNewLabel_3_1);
		
		
		/***** list attempt ******/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 179, 674, 102);
		panelAddQuiz.add(scrollPane);
		
		JList listAttempt = new JList();
		list.setBackground(Color.WHITE);
		scrollPane.setViewportView(listAttempt);
		
		
		JButton previewQuiz_btn = new JButton("PREVIEW QUIZ NOW");
		previewQuiz_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_previewQuiz_btn_action(e);
			}
			
			
		});
		previewQuiz_btn.setForeground(Color.WHITE);
		previewQuiz_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		previewQuiz_btn.setFocusTraversalPolicyProvider(true);
		previewQuiz_btn.setFocusPainted(false);
		previewQuiz_btn.setBorder(null);
		previewQuiz_btn.setBackground(new Color(39, 118, 143));
		previewQuiz_btn.setBounds(527, 292, 157, 27);
		panelAddQuiz.add(previewQuiz_btn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Jump to"}));
		comboBox.setBounds(425, 356, 109, 25);
		panelAddQuiz.add(comboBox);
	}

	protected void do_btnReturn_action(ActionEvent e) {
		// TODO Auto-generated method stub		
		panelEditQuiz.setVisible(false);
		panelAddQuiz.setVisible(true);	
	}

	protected void do_btnDelete_action(ActionEvent e) {
		// TODO Auto-generated method stub
		try {		
			ArrayList<Quiz> listquiz= new FileDsQuiz().docQuiz();
			ArrayList<Question> listt= new ArrayList<>();
			DefaultListModel<Question> listModel = (DefaultListModel<Question>) list.getModel();
			int size = listModel.size();
			for (int i = 0; i < size; i++) {
			    Question question = listModel.getElementAt(i);
			    listt.add(question);
			};			
			for(Quiz q:listquiz) {				
				if(q.getQuizName().trim().equals(this.Heading.trim())) {
					if(q.getListQuestions()==null) {
						ArrayList<Question> quizzlistques=new ArrayList<>();
						for(Question i:listt) {
							if(i.isSelected()) {
								quizzlistques.add(i);
							}
						}
						q.setListQuestions(quizzlistques);
						new FileDsQuiz().ghiQuiz(listquiz);
						JOptionPane.showMessageDialog(null, "đã thêm câu hỏi vào quiz");
					}else {
						ArrayList<Question> quizzlistques= q.getListQuestions();
						quizzlistques_1= new ArrayList();
						ArrayList<Question> quizzlistquesResult= new ArrayList();
						
						temp = 0;

						for(Question i:listt ) {	
							if(i.isSelected() ) {														
								quizzlistques_1.add(i);								
								listModel.removeElement(i); 
								temp = temp+1;
							}
						}
						for(Question i:quizzlistques ) {
							int tmp = 0;
							
							for(Question j:quizzlistques_1 ) {	
								if(i.getName().equalsIgnoreCase(j.getName()) && i.getQuestion().equalsIgnoreCase(j.getQuestion()))
									tmp = tmp + 1;
								
							}
							if(tmp == 0) {
								quizzlistquesResult.add(i);
							}
				
						}		 
						q.setListQuestions(quizzlistquesResult);
						new FileDsQuiz().ghiQuiz(listquiz);
						JOptionPane.showMessageDialog(null, "Bạn đã xóa "+temp+" câu hỏi trong quiz "+this.Heading);
						
					}
					break;
				}
			
				
		}
			list.setModel(listModel);
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
	}

	protected void do_btnStartAttempt_action(ActionEvent e) {
		// TODO Auto-generated method stub
		
		this.setVisible(false);
		GUI7_3 gui7_3 = new GUI7_3(this.Heading);
		gui7_3.setVisible(true);
		
	}

	protected void do_btnX_action(ActionEvent e) {
		// TODO Auto-generated method stub
		panelStart.setVisible(false);
	}

	protected void do_btnExport_action(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(101215);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cài đặt mật khẩu cho file không?", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
		if(choice == 1)
		{
			Export export = new Export(this.getHeading());
			
			export.exportPdf();
			
			this.setVisible(false);
		}
		else if(choice == 0) {
			PasswordSetting ps = new PasswordSetting(this.getHeading());
			ps.setVisible(true);
			}
		}

	protected void do_btnCancel_action(ActionEvent e) {
		// TODO Auto-generated method stub
		panelStart.setVisible(false);
	}

	protected void do_previewQuiz_btn_action(ActionEvent e) {
		// TODO Auto-generated method stub
		panelStart.setVisible(true);
	}

	protected void do_btnRandomQuestion_action(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI6_5 gui6_5 = new GUI6_5(this.getHeading());
		gui6_5.setVisible(true);
	}

	protected void do_btnFromBank_action(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI6_3b gui6_3b = new GUI6_3b(this.getHeading());
		gui6_3b.setVisible(true);
	}

	protected void do_btnAdd_action(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!panelPopup.isVisible()) {
			panelPopup.setVisible(true);
		}
		else {
			panelPopup.setVisible(false);
		}
	}
	
	protected void do_btnHome_1_action(ActionEvent e) {
		// TODO Auto-generated method stub
		BTL_View home = new BTL_View();
		this.setVisible(false);
		home.do_btnHome_action(e);
	}

	public void do_iconSetting_action(ActionEvent e) {
		// TODO Auto-generated method stub
		panelAddQuiz.setVisible(false); 
		panelEditQuiz.setVisible(true);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
