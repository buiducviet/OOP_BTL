package view;

import java.awt.EventQueue;







import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import DB.fileQuestionBank;
import model.FiledocxFormat;
import model.FiletxtFormat;
//import v.Gui2_1;

import DB.FileDsQuiz;
import model.Question;
import model.QuestionBank;
import view.GUI6_1;
import model.Quiz;
import model.QuizRendered;

import model.QuestionList;
import model.PopupMenu;
import model.MenuPopupMouse;
import model.MouseController;
import model.ListTabQuestionRenderer;
import javax.swing.DefaultListCellRenderer;

import javax.swing.JMenu;

public class BTL_View extends JFrame {

	private JPanel contentPane;
	private JPanel panelPopup;
	public JPanel panelDrop ;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneTabQuestion;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	public JLabel labelFileName;
	private JComboBox comboBox_SelectCate;
	private JComboBox comboBoxParentCate;
	private JCheckBox checkBox_All ;
//	private DefaultListCellRenderer renderer;
	public PopupMenu popupMenu  = new PopupMenu();
	public File f;
	public JList list;
	private JList listTabQuestion = new JList();
	private ArrayList<Question> Banklistques_1;
	private JCheckBox cbshowQuesFromSub ;

	int tempp;
	
	private DefaultListModel<Question> dlm= new DefaultListModel<>();
	QuestionList renderer = new QuestionList();
 
	ArrayList<Quiz> listQuiz =new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BTL_View frame = new BTL_View();
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
	public BTL_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 796, 745);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 40));
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(39, 118, 143));
		menuBar.setBounds(0, 0, 780, 40);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(BTL_View.class.getResource("/assets/menuIconWhite.png")));
		menuBar.add(mnNewMenu);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 40, 760, 211);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("IT\r\n");
		lblNewLabel.setForeground(new Color(214, 20, 20));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 24, 24);
		panel.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnHome_action(e);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setBorder(null);
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(10, 175, 45, 23);
		panel.add(btnHome);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setFocusTraversalPolicyProvider(true);
		lblNewLabel_1.setBounds(63, 173, 5, 27);
		panel.add(lblNewLabel_1);
		
		JButton btnMycourse = new JButton("My courses");
		btnMycourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMycourse.setFocusTraversalKeysEnabled(false);
		btnMycourse.setFocusPainted(false);
		btnMycourse.setBorder(null);
		btnMycourse.setBackground(Color.WHITE);
		btnMycourse.setBounds(78, 175, 83, 23);
		panel.add(btnMycourse);
		
		JButton btnTCKy = new JButton("THI CUỐI KỲ");
		btnTCKy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTCKy.setFocusTraversalKeysEnabled(false);
		btnTCKy.setFocusPainted(false);
		btnTCKy.setBorder(null);
		btnTCKy.setBackground(Color.WHITE);
		btnTCKy.setBounds(182, 175, 83, 23);
		panel.add(btnTCKy);
		
		JLabel lblNewLabel_1_1 = new JLabel("/");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setFocusTraversalPolicyProvider(true);
		lblNewLabel_1_1.setBounds(171, 173, 5, 27);
		panel.add(lblNewLabel_1_1);
		
		JButton btnTurnEditingOn = new JButton("TURN EDITING ON");
		btnTurnEditingOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTurnEditingOn_action(e);
			}
		});
		btnTurnEditingOn.setForeground(Color.WHITE);
		btnTurnEditingOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTurnEditingOn.setFocusPainted(false);
		btnTurnEditingOn.setBorder(null);
		btnTurnEditingOn.setBackground(new Color(39, 118, 143));
		btnTurnEditingOn.setBounds(575, 159, 175, 39);
		panel.add(btnTurnEditingOn);
		
		JButton iconSetting = new JButton(new ImageIcon(BTL_View.class.getResource("/assets/settings (1).png")));
		iconSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_iconSetting_action(e);
			}
		}); 
		iconSetting.setFocusPainted(false);
		iconSetting.setBorder(null);
		iconSetting.setBackground(Color.WHITE);
		iconSetting.setBounds(720, 11, 30, 24);
		panel.add(iconSetting);
		
		panelPopup = new JPanel();
		panelPopup.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelPopup.setBackground(new Color(255, 255, 255));
		panelPopup.setBounds(377, 6, 333, 148);
		panel.add(panelPopup);
		panelPopup.setLayout(null);
		panelPopup.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Question bank");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(10, 11, 98, 24);
		panelPopup.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Categories");
		lblNewLabel_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(203, 45, 98, 24);
		panelPopup.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Import");
		lblNewLabel_2_1_2.setForeground(Color.BLUE);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(203, 78, 98, 24);
		panelPopup.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Export");
		lblNewLabel_2_1_3.setForeground(Color.BLUE);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_3.setBounds(203, 110, 98, 24);
		panelPopup.add(lblNewLabel_2_1_3);
		
		JButton btnQuestions = new JButton("Questions");
		btnQuestions.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnQuestions.setForeground(Color.BLUE);  // Đặt lại màu ban đầu
		    }

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnQuestions.setForeground(Color.RED);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			} 
		}); 
		btnQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnQuestions_action(e);
			}
		});
		btnQuestions.setForeground(new Color(0, 0, 255));
		btnQuestions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuestions.setBackground(new Color(255, 255, 255));
		btnQuestions.setBorder(null);
		btnQuestions.setFocusPainted(false);
		btnQuestions.setBounds(188, 12, 89, 23);
		panelPopup.add(btnQuestions);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 262, 760, 450);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 0, 760, 450);
//		scrollPane.setVisible(true);
		panel_1.add(scrollPane);
		
		MenuPopupMouse menuPopupMouse =new MenuPopupMouse(this);
		MouseController menuExampleController = new MouseController(this, menuPopupMouse);
		popupMenu.itemCopy.addActionListener(menuExampleController);
		popupMenu.itemDelete.addActionListener(menuExampleController);
		popupMenu.itemPaste.addActionListener(menuExampleController);
		list = new JList();
		this.add(popupMenu);
		
		list.addMouseListener(menuPopupMouse);
		
		
		list.setBorder(new LineBorder(new Color(192, 192, 192)));
		scrollPane.setViewportView(list);
	    list.setSelectionBackground(Color.WHITE);
	    list.setForeground(new Color(0, 0, 0, 100));
	    list.setSelectionForeground(new Color(0, 0, 0, 255));
	    
	    try {
			listQuiz= new FileDsQuiz().docQuiz();
		} catch (Exception e) {
			// TODO: handle exception
		}
	    creatList();
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 770, 450);
		tabbedPane.setVisible(true);
		panel_1.add(tabbedPane);
		
		JPanel panelQuestions = new JPanel();
		panelQuestions.setBorder(null);
		panelQuestions.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab(" Questions ", null, panelQuestions, null);
		panelQuestions.setLayout(null);
		
		JLabel labelQuestionsBank = new JLabel("Question Bank");
		labelQuestionsBank.setForeground(new Color(214, 20, 20));
		labelQuestionsBank.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelQuestionsBank.setBounds(10, 11, 153, 29);
		panelQuestions.add(labelQuestionsBank);
		
		JLabel lblNewLabel_3 = new JLabel("Select a category:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 51, 109, 20);
		panelQuestions.add(lblNewLabel_3);
		
		comboBox_SelectCate = new JComboBox();
		comboBox_SelectCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBox_SelectCate_actionPerformed(e);
			}
		});
		comboBox_SelectCate.setBounds(117, 44, 186, 37);
		panelQuestions.add(comboBox_SelectCate);
		
		JLabel lblNewLabel_3_1 = new JLabel("The default category for question shared in context");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(10, 88, 295, 20);
		panelQuestions.add(lblNewLabel_3_1);
		
		JCheckBox cbQuestion_2 = new JCheckBox("Also show old questions");
		
		cbQuestion_2.setOpaque(false);
		cbQuestion_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbQuestion_2.setFocusPainted(false);
		cbQuestion_2.setBackground(Color.BLUE);
		cbQuestion_2.setBounds(10, 135, 319, 23);
		panelQuestions.add(cbQuestion_2);
		
		cbshowQuesFromSub = new JCheckBox("Also show questions from subcategories");
		 cbshowQuesFromSub.addItemListener(new ItemListener() {
			/* public void itemStateChanged(ItemEvent e) {
		    	  DefaultListModel model = (DefaultListModel)listTabQuestion.getModel();
		        if (checkBox_All.isSelected()) { 
		         
		          for (int i = 0; i < model.getSize(); i++) {
		        	  Question item = (Question) listTabQuestion.getModel().getElementAt(i);
		              item.setIsSelected(true); // Toggle selected state  
		              listTabQuestion.repaint(listTabQuestion.getCellBounds(i, i));// Repaint cell
		          }  
		        } else {  
		        	for (int i = 0; i < model.getSize(); i++) {
			        	  Question item = (Question) listTabQuestion.getModel().getElementAt(i);
			              item.setIsSelected(false); // Toggle selected state  
			              listTabQuestion.repaint(listTabQuestion.getCellBounds(i, i));// Repaint cell
			          }  
		        }
		        listTabQuestion.revalidate();
		          
		      }*/
		      @Override
		      public void itemStateChanged(ItemEvent e) {
		    	  DefaultListModel model = (DefaultListModel) listTabQuestion.getModel();
		    	  try {
					ArrayList<QuestionBank> listBank= new fileQuestionBank().docQuiz();
					 
					if (cbshowQuesFromSub.isSelected()) {
						System.out.println("in ra");
					for(QuestionBank questionBank : listBank) {
						if(questionBank.getParentQB().equalsIgnoreCase(extractCharacters(comboBox_SelectCate.getSelectedItem().toString(), '(', ')').trim())) {
							
							for(Question question : questionBank.getListQuestions()) {
							  model.addElement(question);
							  listTabQuestion.repaint();
							}
						}
						
					}
					listTabQuestion.setModel(model);
					
				  }
					else {
						
						for(QuestionBank questionBank : listBank) {
							
							if(questionBank.getNameQB().equalsIgnoreCase(extractCharacters(comboBox_SelectCate.getSelectedItem().toString(), '(', ')').trim())) {
								for(int i =questionBank.getQuantity()+1; i < model.getSize(); i++) {
									 model.remove(i);
									 listTabQuestion.repaint();
								}
							}
							
							
						}
						listTabQuestion.setModel(model);
						
					}
					 listTabQuestion.revalidate();
		    	  }catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      }
		    });
		cbshowQuesFromSub.setOpaque(false);
		cbshowQuesFromSub.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbshowQuesFromSub.setFocusPainted(false);
		cbshowQuesFromSub.setBackground(Color.BLUE);
		cbshowQuesFromSub.setBounds(10, 115, 319, 23);
		panelQuestions.add(cbshowQuesFromSub);
		
		JButton btnCreatANewQuestion = new JButton("CREAT A NEW QUESTION");
		btnCreatANewQuestion.setForeground(Color.WHITE);
		btnCreatANewQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreatANewQuestion.setFocusPainted(false);
		btnCreatANewQuestion.setBorder(null);
		btnCreatANewQuestion.setBackground(new Color(39, 118, 143));
		btnCreatANewQuestion.setBounds(10, 165, 194, 33);
		btnCreatANewQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCreatANewQuestion_action(e);
			}
		});
		panelQuestions.add(btnCreatANewQuestion);

		
		JPanel panelCategories = new JPanel();
		panelCategories.setBorder(null);
		panelCategories.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab(" Categories ", null, panelCategories, null);
		panelCategories.setLayout(null);
		
		JLabel lblAdd = new JLabel("Add category");
		lblAdd.setForeground(new Color(214, 20, 20));
		lblAdd.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAdd.setBounds(25, 11, 140, 29);
		panelCategories.add(lblAdd);
		
		JLabel iconGeneralSortdown_1 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/298882_down_triangle_icon (1).png")));
		iconGeneralSortdown_1.setBounds(0, 11, 24, 24);
		panelCategories.add(iconGeneralSortdown_1);
		
		JLabel lblNewLabel_4 = new JLabel("Parent category");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 46, 134, 24);
		panelCategories.add(lblNewLabel_4);
		
		List<QuestionBank> listt= new ArrayList<>();
		
		comboBoxParentCate = new JComboBox();
		
		DefaultComboBoxModel<String> dcb=new DefaultComboBoxModel<>();
		try {
			
			dcb=new fileQuestionBank().listCategory();	    
			comboBoxParentCate.setModel(dcb);
		    ArrayList<String> listL= new ArrayList<>();
		    for (int i = 0; i < dcb.getSize(); i++) {
		    	
	            String element = dcb.getElementAt(i);
	            int k=0;
	           
	            try {
					ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
					
					for(QuestionBank q:listQB) {
						if(q.getNameQB().equalsIgnoreCase(element.trim())) {
							k=q.getListQuestions().size();

						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
	            if(element.trim().equalsIgnoreCase("Default")) {
	            	  listL.add(element);
	            }
	            else {
	            	  listL.add(element+" ("+k+")");
	            }
	          
	        }
		    DefaultComboBoxModel<String> dcb1= new DefaultComboBoxModel<>();
		    for(String s:listL) {
		    	dcb1.addElement(s);
		    	
		    }
		    comboBox_SelectCate.setModel(dcb1);		    
		    scrollPaneTabQuestion = new JScrollPane();
		    scrollPaneTabQuestion.setBackground(new Color(255, 255, 255));
			scrollPaneTabQuestion.setBounds(10, 203, 735, 180);
			panelQuestions.add(scrollPaneTabQuestion);
			listTabQuestion = new JList();
			BTL_View mainview = this;
			listTabQuestion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JList list = (JList) e.getSource();
	                int index = list.locationToIndex(e.getPoint());// Get index of item
	                // clicked
	                Question item = (Question) list.getModel().getElementAt(index);
	                if(e.getPoint().x > 695) {
	                	 GUI3_2 Gui3_2 = new  GUI3_2();
	                	 mainview.setVisible(false);
	                	 Gui3_2.setVisible(true);
	                	 Gui3_2.setQues(item, comboBox_SelectCate, index);
	                }	                
	                
	                item.setIsSelected(!item.isSelected()); 
	                list.repaint(list.getCellBounds(index, index));// Repaint cell
				}
			});
			scrollPaneTabQuestion.setViewportView(listTabQuestion);
			
			JButton btnDeleteQuestionBank = new JButton("Delete Question Bank");
			btnDeleteQuestionBank.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnDeleteQuestionBank_action(e);
				}
			});
			btnDeleteQuestionBank.setForeground(Color.WHITE);
			btnDeleteQuestionBank.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnDeleteQuestionBank.setFocusPainted(false);
			btnDeleteQuestionBank.setBorder(null);
			btnDeleteQuestionBank.setBackground(new Color(214, 20, 20));
			btnDeleteQuestionBank.setBounds(214, 165, 194, 33);
			panelQuestions.add(btnDeleteQuestionBank);
			
			JButton btnDeleteQuestionInBank = new JButton("Delete Question");
			btnDeleteQuestionInBank.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_btnDeleteQuestionInBank_action(e);
				}
			});
			btnDeleteQuestionInBank.setForeground(Color.WHITE);
			btnDeleteQuestionInBank.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnDeleteQuestionInBank.setFocusPainted(false);
			btnDeleteQuestionInBank.setBorder(null);
			btnDeleteQuestionInBank.setBackground(new Color(214, 20, 20));
			btnDeleteQuestionInBank.setBounds(10, 387, 144, 30);
			panelQuestions.add(btnDeleteQuestionInBank);
			
			checkBox_All = new JCheckBox("Select all Questions");
			checkBox_All.addItemListener(new ItemListener() {
			      @Override
			      public void itemStateChanged(ItemEvent e) {
			    	  DefaultListModel model = (DefaultListModel)listTabQuestion.getModel();
			        if (checkBox_All.isSelected()) { 
			         
			          for (int i = 0; i < model.getSize(); i++) {
			        	  Question item = (Question) listTabQuestion.getModel().getElementAt(i);
			              item.setIsSelected(true); // Toggle selected state  
			              listTabQuestion.repaint(listTabQuestion.getCellBounds(i, i));// Repaint cell
			          }  
			        } else {  
			        	for (int i = 0; i < model.getSize(); i++) {
				        	  Question item = (Question) listTabQuestion.getModel().getElementAt(i);
				              item.setIsSelected(false); // Toggle selected state  
				              listTabQuestion.repaint(listTabQuestion.getCellBounds(i, i));// Repaint cell
				          }  
			        }
			        listTabQuestion.revalidate();
			          
			      }
			    });
			checkBox_All.setForeground(new Color(15, 192, 244));
			checkBox_All.setFont(new Font("Tahoma", Font.PLAIN, 12));
			checkBox_All.setFocusPainted(false);
			checkBox_All.setBackground(Color.WHITE);
			checkBox_All.setBounds(160, 393, 136, 23);
			panelQuestions.add(checkBox_All);
		    
		    
		} catch (Exception e) {
		    // Xử lý ngoại lệ
		}
		comboBoxParentCate.setBounds(385, 33, 261, 37);
		panelCategories.add(comboBoxParentCate);
		
		JLabel iconGeneralSortdown_1_1 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/question.png")));
		iconGeneralSortdown_1_1.setBounds(351, 46, 24, 24);
		panelCategories.add(iconGeneralSortdown_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Name");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(10, 103, 75, 24);
		panelCategories.add(lblNewLabel_4_1);
		
		textField = new JTextField();
		textField.setBounds(385, 93, 331, 37);
		panelCategories.add(textField);
		textField.setColumns(10);
		
		JLabel iconGeneralSortdown_1_1_1 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/warning.png")));
		iconGeneralSortdown_1_1_1.setBounds(351, 101, 24, 24);
		panelCategories.add(iconGeneralSortdown_1_1_1);
		
		JLabel labelCateInfor = new JLabel("Category infor");
		labelCateInfor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCateInfor.setBounds(10, 156, 120, 24);
		panelCategories.add(labelCateInfor);
		
		JScrollPane scrollPaneTabCate = new JScrollPane();
		scrollPaneTabCate.setBounds(385, 148, 360, 136);
		panelCategories.add(scrollPaneTabCate);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(385, 156, 360, 136);
		scrollPaneTabCate.setViewportView(textPane);
		
		JLabel labelID = new JLabel("ID");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelID.setBounds(10, 309, 32, 24);
		panelCategories.add(labelID);
		
		textField_1 = new JTextField();
		textField_1.setBounds(385, 312, 86, 29);
		panelCategories.add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 355, 735, 9);
		panelCategories.add(separator);
		
		JButton btnAddCate = new JButton("ADD CATEGORY");
		btnAddCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddCate_action(e);
			}
		});
		btnAddCate.setForeground(new Color(255, 255, 255));
		btnAddCate.setBackground(new Color(255, 0, 0));
		btnAddCate.setFocusPainted(false);
		btnAddCate.setBorder(null);
		btnAddCate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddCate.setBounds(323, 365, 134, 29);
		panelCategories.add(btnAddCate);
		
		JLabel lblThereIsA = new JLabel("There are required fields in this from marked! ");
		lblThereIsA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThereIsA.setBounds(264, 395, 272, 24);
		panelCategories.add(lblThereIsA);
		
		JLabel iconGeneralSortdown_1_1_1_1 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/warning.png")));
		iconGeneralSortdown_1_1_1_1.setBounds(528, 395, 24, 24);
		panelCategories.add(iconGeneralSortdown_1_1_1_1);
		
		JPanel panelImport = new JPanel();
		panelImport.setBorder(null);
		panelImport.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab(" Import ", null, panelImport, null);
		panelImport.setLayout(null);
		
		JLabel lblImportQuestionFrom = new JLabel("Import questions from file");
		lblImportQuestionFrom.setForeground(new Color(214, 20, 20));
		lblImportQuestionFrom.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblImportQuestionFrom.setBounds(10, 11, 295, 24);
		panelImport.add(lblImportQuestionFrom);
		
		JLabel labelFormat = new JLabel("File format");
		labelFormat.setForeground(new Color(214, 20, 20));
		labelFormat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelFormat.setBounds(52, 43, 76, 24);
		panelImport.add(labelFormat);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 69, 735, 11);
		panelImport.add(separator_1);
		
		JLabel lblAiken = new JLabel("Aiken format");
		lblAiken.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAiken.setBounds(489, 43, 89, 24);
		panelImport.add(lblAiken);
		
		JLabel iconGeneralSortdown_1_2 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/298882_down_triangle_icon (1).png")));
		iconGeneralSortdown_1_2.setBounds(20, 43, 24, 24);
		panelImport.add(iconGeneralSortdown_1_2);
		
		JLabel labelGeneral = new JLabel("General");
		labelGeneral.setForeground(new Color(214, 20, 20));
		labelGeneral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGeneral.setBounds(52, 86, 65, 24);
		panelImport.add(labelGeneral);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 111, 735, 11);
		panelImport.add(separator_1_1);
		
		JLabel lblImportQuestionsFrom = new JLabel("Import questions from file");
		lblImportQuestionsFrom.setForeground(new Color(214, 20, 20));
		lblImportQuestionsFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblImportQuestionsFrom.setBounds(52, 120, 163, 24);
		panelImport.add(lblImportQuestionsFrom);
		
		JLabel lblImport = new JLabel("Import");
		lblImport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImport.setBounds(28, 158, 57, 24);
		panelImport.add(lblImport);
		
		JButton btnChooseAFile = new JButton("CHOOSE A FILE");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnChooseAFile_action(e);
			}
		});
		btnChooseAFile.setForeground(Color.WHITE);
		btnChooseAFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChooseAFile.setFocusPainted(false);
		btnChooseAFile.setBorder(null);
		btnChooseAFile.setBackground(new Color(39, 118, 143));
		btnChooseAFile.setBounds(403, 169, 141, 30);
		panelImport.add(btnChooseAFile);
		
		JLabel lblAiken_1 = new JLabel("Maximum size for a new file: 100MB");
		lblAiken_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAiken_1.setBounds(554, 164, 191, 24);
		panelImport.add(lblAiken_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2.setBounds(403, 210, 342, 149);
		panelImport.add(panel_2);
		panel_2.setLayout(null);
		
		panelDrop = new JPanel();
		panelDrop.setBackground(new Color(255, 255, 255));
		Border dash = BorderFactory.createDashedBorder(Color.GRAY, 1, 5, 2, false);
		panelDrop.setDropTarget(new DropTarget(panelDrop, new DropListener()));
		panelDrop.setBorder( dash);
		panelDrop.setBounds(10, 24, 322, 114);
		panel_2.add(panelDrop);
		panelDrop.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("You can drag and drop files here to add them");
		lblNewLabel_17.setForeground(Color.GRAY);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_17.setBounds(37, 92, 264, 23);
		panelDrop.add(lblNewLabel_17);
		
		JLabel iconDropFile = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/dropfile.png")));
		iconDropFile.setBounds(94, 11, 137, 70);
		panelDrop.add(iconDropFile);
		
		labelFileName = new JLabel("file name");
		labelFileName.setBounds(10, 3, 322, 14);
		panel_2.add(labelFileName);
		
		JButton btnImport = new JButton("IMPORT");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnImport_action(e);
			}
		});
		btnImport.setForeground(Color.WHITE);
		btnImport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnImport.setFocusPainted(false);
		btnImport.setBorder(null);
		btnImport.setBackground(new Color(214, 20, 20));
		btnImport.setBounds(317, 359, 79, 30);
		panelImport.add(btnImport);
		
		JLabel lblThereIsA_1 = new JLabel("There are required fields in this from marked! ");
		lblThereIsA_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThereIsA_1.setBounds(225, 398, 272, 24);
		panelImport.add(lblThereIsA_1);
		
		JLabel iconGeneralSortdown_1_1_1_1_1 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/warning.png")));
		iconGeneralSortdown_1_1_1_1_1.setBounds(489, 398, 24, 24);
		panelImport.add(iconGeneralSortdown_1_1_1_1_1);
		
		JLabel iconGeneralSortdown_1_2_1 = new JLabel(new ImageIcon(BTL_View.class.getResource("/assets/298882_down_triangle_icon (1).png")));
		iconGeneralSortdown_1_2_1.setBounds(20, 120, 24, 24);
		panelImport.add(iconGeneralSortdown_1_2_1);
		
		JPanel panelExport = new JPanel();
		tabbedPane.addTab(" Export ", null, panelExport, null);
	}
	protected void do_btnDeleteQuestionInBank_action(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {		
			ArrayList<QuestionBank> questionBank= new fileQuestionBank().docQuiz();
			ArrayList<Question> listt= new ArrayList<>();
			DefaultListModel<Question> listModel = (DefaultListModel<Question>) listTabQuestion.getModel();
			int size = listModel.size();
			for (int i = 0; i < size; i++) {
			    Question question = listModel.getElementAt(i);
			    listt.add(question);
			};			
			for(QuestionBank q:questionBank) {				
				if(q.getNameQB().equalsIgnoreCase(extractCharacters(comboBox_SelectCate.getSelectedItem().toString(), '(', ')').trim())) {
					if(q.getListQuestions()==null) {
						ArrayList<Question> quizzlistques=new ArrayList<>();
						for(Question i:listt) {
							if(i.isSelected()) {
								quizzlistques.add(i);
							}
						}
						q.setListQuestions(quizzlistques);
						new fileQuestionBank().ghiBank(questionBank);
						JOptionPane.showMessageDialog(null, "đã thêm câu hỏi vào quiz");
					}else {
						ArrayList<Question> Banklistques= q.getListQuestions();
						Banklistques_1= new ArrayList();
						ArrayList<Question> BanklistquesResult= new ArrayList();
						
						tempp = 0;

						for(Question i:listt ) {	
							if(i.isSelected() ) {														
								Banklistques_1.add(i);								
								listModel.removeElement(i); 
								tempp = tempp+1;
							}
						}
						for(Question i:Banklistques ) {
							int tmp = 0;
							
							for(Question j:Banklistques_1 ) {	
								if(i.getName().equalsIgnoreCase(j.getName()) && i.getQuestion().equalsIgnoreCase(j.getQuestion()))
									tmp = tmp + 1;
								
							}
							if(tmp == 0) {
								BanklistquesResult.add(i);
							}
				
						}		 
						q.setListQuestions(BanklistquesResult);
						new fileQuestionBank().ghiBank(questionBank);
						JOptionPane.showMessageDialog(null, "Bạn đã xóa "+tempp+" câu hỏi trong quiz "+q.getNameQB());
						BTL_View mainView = new BTL_View();
						this.setVisible(false);
						mainView.setVisible(true);
						mainView.scrollPane.setVisible(false);
						mainView.tabbedPane.setVisible(true);
//						mainView.comboBox_SelectCate.setSelectedItem(q);
					}
					break;
				}
			
				
		}
//			list.setModel(listModel);
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		
	}

	protected void do_btnDeleteQuestionBank_action(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				try {		
					ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
					ArrayList<String> listt= new ArrayList<>();
					DefaultComboBoxModel<String> dcb =  (DefaultComboBoxModel<String>) comboBox_SelectCate.getModel();					
					int size = dcb.getSize();
					ArrayList<QuestionBank> listResult=new ArrayList();
					for(QuestionBank questionBank : listQB) {
						if(!questionBank.getNameQB().equalsIgnoreCase(extractCharacters(comboBox_SelectCate.getSelectedItem().toString(), '(', ')').trim())) {
							
							listResult.add(questionBank);
							
						}
					}
					new fileQuestionBank().ghiBank(listResult);
									
					BTL_View mainView = new BTL_View();
					this.setVisible(false);
					mainView.setVisible(true);
					mainView.scrollPane.setVisible(false);
					mainView.tabbedPane.setVisible(true);
					
					
					
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
		
	}

	protected void do_btnImport_action(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			
			
			if(f.getName().endsWith("txt")) {
				System.out.println("đây là txt");
			   FileInputStream fileInputStream=new FileInputStream(f);
			   InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

			    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			    String line=bufferedReader.readLine();
			    String sd="";
			    while(line!=null) {    
			    	sd=sd+line+"\n";
			    	line=bufferedReader.readLine();
			    	
			    }
			    ArrayList<QuestionBank> listBank= new fileQuestionBank().docQuiz();
			    for(QuestionBank qbi: listBank) {
			    	if(qbi.getNameQB().trim().equalsIgnoreCase(f.getName().substring(0,f.getName().length()-4))) {
			    		JOptionPane.showMessageDialog(null, "Tên ngân hàng đề đã tồn tại");
			    		return;
			    	}
			    }
				QuestionBank qb= new QuestionBank(f.getName().substring(0,f.getName().length()-4), "Default");
				System.out.println("lỗi tại đây nữa");
		    	ArrayList<Question> questions= new FiletxtFormat().format(sd);
		    	System.out.println("lỗi tại đây nữa");
		    	if(questions.size()!=0) {
		    		qb.setListQuestions(questions);
		    		ArrayList<QuestionBank> qblist= new fileQuestionBank().docQuiz();
		    		qblist.add(qb);
		    		new fileQuestionBank().ghiBank(qblist);
		    		
		    		
		    	}
		    	fileInputStream.close();
		    	BTL_View mainView = new BTL_View();
		    	this.setVisible(false);
	    		mainView.setVisible(true);
	    		mainView.scrollPane.setVisible(false);
	    		mainView.tabbedPane.setVisible(true);
			}
			
			else if(f.getName().endsWith("docx")) {
		
				System.out.println("đây là docx");
				FileInputStream fis = new FileInputStream(f);
				XWPFDocument doc = new XWPFDocument(OPCPackage.open(fis));

				List<XWPFParagraph> paragraphs = doc.getParagraphs();
				 String sd="";
				for (XWPFParagraph para : paragraphs) {  
					String text = para.getText();
					sd=sd+text+"\n";
				}
				ArrayList<QuestionBank> listBank= new fileQuestionBank().docQuiz();
				System.out.println("ak");
			    for(QuestionBank qbi: listBank) {
			    	if(qbi.getNameQB().trim().equalsIgnoreCase(f.getName().substring(0,f.getName().length()-5))) {
			    		System.out.println("trùng r");
			    		JOptionPane.showMessageDialog(null, "Tên ngân hàng đề đã tồn tại");
			    		return;
			    	}
			    }
				QuestionBank qb= new QuestionBank(f.getName().substring(0,f.getName().length()-5), "Default");
				System.out.println("lỗi tại đây nữa");
		    	ArrayList<Question> questions= new FiledocxFormat().format(f,sd);
		    	qb.setListQuestions(questions);
		    	
		    	ArrayList<QuestionBank> qblist= new fileQuestionBank().docQuiz();
		    	qblist.add(qb);
		    	 System.out.println("lỗi tại đây");	 
		    	new fileQuestionBank().ghiBank(qblist);
		    	System.out.println("lỗi tại đây nè");
		    	doc.close();
		    	BTL_View mainView = new BTL_View();
		    	this.setVisible(false);
		    	mainView.setVisible(true);
		    	mainView.scrollPane.setVisible(false);
		    	mainView.tabbedPane.setVisible(true);
				
				
				
			}
			else {
				JOptionPane.showMessageDialog(null, "WRONG FORMAT!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}

	protected void do_btnChooseAFile_action(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			JFileChooser jFileChooser=new JFileChooser("C:");
			jFileChooser.setDialogTitle("chon file");
			int result = jFileChooser.showOpenDialog(null);//tra ve 1 so nguyen
			if(result==jFileChooser.APPROVE_OPTION) {
			    jFileChooser.setMultiSelectionEnabled(false);//chi doc 1 file
			    f=jFileChooser.getSelectedFile();
			    labelFileName.setText( f.getName());
				
			    
			   
			}else {
				System.out.println("cancel");
			}			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}

	protected void do_list_mouseRightClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	protected void do_btnAddCate_action(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<QuestionBank> qbList= new ArrayList<>();
		try {
			qbList= new fileQuestionBank().docQuiz();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		int j=0;
		for(QuestionBank i:qbList) {
			if(textField.getText().equalsIgnoreCase(i.getNameQB())) {				
				j=j+1;
				
			}
		}
		if(j!=0) {
			JOptionPane.showMessageDialog(null, "tên Question Bank đã tồn tại");
			
		}else if(textField.getText().isBlank() ) {
			JOptionPane.showMessageDialog(null, "vui lòng điền đầy đủ"); 
		}else 
		{
			
			QuestionBank qb= new QuestionBank(textField.getText(),comboBoxParentCate.getSelectedItem().toString().trim());

			try {
				ArrayList<QuestionBank> list= new fileQuestionBank().docQuiz();
				list.add(qb);
				new fileQuestionBank().ghiBank(list);
				JOptionPane.showMessageDialog(null, "bạn đã thêm vào 1 category"); 
				
			BTL_View loadView = new BTL_View();
			this.setVisible(false);
			loadView.setVisible(true);
			loadView.tabbedPane.setVisible(true);
			loadView.scrollPane.setVisible(false);
				
			} catch (Exception e2) {
				// TODO: handle exception
		}}
	}

	protected void do_comboBox_SelectCate_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		dlm=new DefaultListModel<>();
		 
		if(comboBox_SelectCate.getSelectedItem().toString().trim().equalsIgnoreCase("Default")==false) {
			try {
				ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
//				listQB= new FileDsQuestionBank().docQuiz();
				
				for(QuestionBank q:listQB) {
					if(q.getNameQB().equalsIgnoreCase(extractCharacters(comboBox_SelectCate.getSelectedItem().toString(), '(', ')').trim())) {
						ArrayList<Question> listqs=new ArrayList<>();
						
						
						if(q.getListQuestions()==null || q.getListQuestions().isEmpty() ) {
							dlm=new DefaultListModel<>();
							listTabQuestion.setModel(dlm);
							listTabQuestion.setCellRenderer(new ListTabQuestionRenderer());
							scrollPaneTabQuestion.setViewportView(listTabQuestion);
							break;
						}else {
							listqs = q.getListQuestions();
							for(Question qs:listqs) {
								
								dlm.addElement(qs);
								
							}					
							listTabQuestion.setModel(dlm);																							
							listTabQuestion.setCellRenderer(new ListTabQuestionRenderer());
							checkBox_All.setSelected(false);
							scrollPaneTabQuestion.setViewportView(listTabQuestion);
						}

					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else {
			dlm=new DefaultListModel<>();
			listTabQuestion.setModel(dlm);
			scrollPaneTabQuestion.setViewportView(listTabQuestion);
		}
		
//		listTabQuestion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}

	private String extractCharacters(String input, char startChar, char endChar) {
		StringBuilder result = new StringBuilder();

        boolean insideRange = false;
        for (char c : input.toCharArray()) {
            if (c == startChar) {
                insideRange = true;
                continue;
            }
            if (c == endChar) {
                insideRange = false;
                continue;
            }

            if (insideRange==false) {
                result.append(c);
            }
        }

        return result.toString();
	}

	private void gui6_1(String str) {
		// TODO Auto-generated method stub
		GUI6_1 gui6_1= new GUI6_1(str);
		gui6_1.setHeading(str);
		gui6_1.setVisible(true);
		this.setVisible(false);
	}

	 public void do_list_mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String str= list.getSelectedValue().toString();
		gui6_1(str);
		
	}
	 
	void creatList() {
		 DefaultListModel<Quiz> d=new DefaultListModel<>();
		 for(Quiz i:listQuiz) {
			 d.addElement(i);
		 }
		 list.setModel(d);
		 list.setCellRenderer(new QuizRendered());
	 }
	 public void loadDatapro(String s) {
	   if(s.equals("")) {
		   
	   }else {
       try {
 
	   		DefaultListModel<Quiz> defaultListModel= new DefaultListModel<>();
	   		int j=0;
	   		Quiz quiz=new Quiz(s);
	   		
	   	ArrayList<Quiz> listt= new FileDsQuiz().docQuiz();
	   		for(Quiz i:listt) {
	   			if(i.getQuizName().equalsIgnoreCase(s)) {
	   				j++;
	   			}
	   		}
	   		// test xem có quiz chưa và listt docquiz có chạy không
	   		String c = quiz.getQuizName();
	   		if(j!=0) {
	   			JOptionPane.showMessageDialog(null, "tên đã tồn tại");
	   		}else {
//	   		quiz.setTenQuiz(s);
	   		listQuiz.add(quiz);
	   		
	   		new FileDsQuiz().ghiQuiz(listQuiz);
	   		
	   		for(Quiz i:listQuiz) {
	   			defaultListModel.addElement(i);
//	   			defaultListModel.addElement(s);
	   			}
	   		list.setModel(defaultListModel);
	   		list.setCellRenderer(new QuizRendered());
	   		} 
	   		
       		}
	   		catch (Exception e) {
			// TODO: handle exception
		}
	   }
	   
    }

	protected void do_btnCreatANewQuestion_action(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI3_2 gui3_2 = new GUI3_2();
		gui3_2.setVisible(true);
	}

	protected void do_btnTurnEditingOn_action(ActionEvent e) {
		
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI5_1 gui5_1 = new GUI5_1();
		gui5_1.setVisible(true);
	}

	protected void do_btnHome_action(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(true);
		panelPopup.setVisible(false);
		tabbedPane.setVisible(false);
		scrollPane.setVisible(true);
	
		
	}
	protected void do_btnQuestions_action(ActionEvent e) {
		// TODO Auto-generated method stub
		panelPopup.setVisible(false);
		scrollPane.setVisible(false);
		tabbedPane.setVisible(true);	
	}

	protected void do_iconSetting_action(ActionEvent e) {
		
		// TODO Auto-generated method stub		
		if(panelPopup.isVisible()) {
			panelPopup.setVisible(false);
		}
		else {
			panelPopup.setVisible(true);
		}
	}
	public class DropListener implements DropTargetListener {

		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub

		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			 panelDrop.setBackground(new Color(240,240,240));

		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void dragExit(DropTargetEvent dte) {
			// TODO Auto-generated method stub
			 panelDrop.setBackground(new Color(250,250,250));
		}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			
			 dtde.acceptDrop(DnDConstants.ACTION_COPY);
	         Transferable transferable = dtde.getTransferable();
	         DataFlavor[] flavors = transferable.getTransferDataFlavors();
	         for (DataFlavor flavor : flavors) {
	        	 
	             try {
	            	
	                 if (flavor.isFlavorJavaFileListType()) {
	                     List<File> files = (List<File>) transferable.getTransferData(flavor);
	                     // Xử lý file được thả vào đây
	                     for (File file : files) {
	                     	f=file;
	                     	labelFileName.setText( file.getName());
	                     }
	                 }
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }	 
	         }	
		}
	}
}
