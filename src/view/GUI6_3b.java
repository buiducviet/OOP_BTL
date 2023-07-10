package view;

import java.awt.Color;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.FileDsQuiz;
import DB.fileQuestionBank;
import model.Quiz;
import model.Question;
import model.QuestionList;
import model.QuestionBank;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI6_3b extends JFrame {

	private JPanel contentPane;
	private String heading;
	private  JScrollPane scrollPane;
	private JComboBox comboBox ;
	private JList list = new JList();
	private JCheckBox checkBox_All;
	int temp,count ;
	DefaultListModel<Question> dlm;
	
	
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI6_3b frame = new GUI6_3b(heading);
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
	public GUI6_3b(String str) {
		this.heading = str;
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHeading = new JLabel("Add from question bank at the end");
		labelHeading.setForeground(new Color(214, 20, 20));
		labelHeading.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelHeading.setBounds(10, 11, 393, 24);
		contentPane.add(labelHeading);
		
		JLabel labelSelectCate = new JLabel("Select a category:");
		labelSelectCate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSelectCate.setBounds(20, 46, 118, 36);
		contentPane.add(labelSelectCate);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBox_actionPerformed(e);
			}
		});
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(148, 46, 207, 36);
		contentPane.add(comboBox);
		DefaultComboBoxModel<String> dcb=new DefaultComboBoxModel<>();
		try {
			dcb=new fileQuestionBank().listCategory();	    
			comboBox.setModel(dcb);
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
		    comboBox.setModel(dcb1);
		    scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 221, 694, 292);
			contentPane.add(scrollPane);
			
			list = new JList();
			list.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent event) {
	                JList list = (JList) event.getSource();
	                int index = list.locationToIndex(event.getPoint());// Get index of item
	                // clicked
	                
	                Question item = (Question) list.getModel().getElementAt(index);
	                item.setIsSelected(!item.isSelected()); // Toggle selected state
	                list.repaint(list.getCellBounds(index, index));// Repaint cell
	            }
	        });
			scrollPane.setViewportView(list);
		    
		    
		    
		} catch (Exception e) {
		    // Xử lý ngoại lệ
		}
		
		
		JCheckBox cbShowQuesFromSub = new JCheckBox("Also show questions from subcategories");
		cbShowQuesFromSub.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 DefaultListModel model = (DefaultListModel) list.getModel();
		    	  try {
					ArrayList<QuestionBank> listBank= new fileQuestionBank().docQuiz();
					 
					if (cbShowQuesFromSub.isSelected()) {
						System.out.println("in ra");
					for(QuestionBank questionBank : listBank) {
						if(questionBank.getParentQB().equalsIgnoreCase(extractCharacters(comboBox.getSelectedItem().toString(), '(', ')').trim())) {
							
							for(Question question : questionBank.getListQuestions()) {
							  model.addElement(question);
							  list.repaint();
							}
						}
						
					}
					list.setModel(model);
					
				  }
					else {
						
						for(QuestionBank questionBank : listBank) {
							
							if(questionBank.getNameQB().equalsIgnoreCase(extractCharacters(comboBox.getSelectedItem().toString(), '(', ')').trim())) {
								for(int i =questionBank.getQuantity()+1; i < model.getSize(); i++) {
									 model.remove(i);
									 list.repaint();
								}
							}
							
							
						}
						list.setModel(model);
						
					}
					 list.revalidate();
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
		cbShowQuesFromSub.setOpaque(false);
		cbShowQuesFromSub.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbShowQuesFromSub.setFocusPainted(false);
		cbShowQuesFromSub.setBackground(Color.BLUE);
		cbShowQuesFromSub.setBounds(16, 146, 319, 23);
		contentPane.add(cbShowQuesFromSub);
		
		JCheckBox cbQuestion_2 = new JCheckBox("Also show old questions");
		cbQuestion_2.setOpaque(false);
		cbQuestion_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbQuestion_2.setFocusPainted(false);
		cbQuestion_2.setBackground(Color.BLUE);
		cbQuestion_2.setBounds(16, 166, 319, 23);
		contentPane.add(cbQuestion_2);
		
		JLabel lblNewLabel = new JLabel("Search options");
		lblNewLabel.setForeground(new Color(15, 192, 244));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 122, 99, 24);
		contentPane.add(lblNewLabel);
		
		checkBox_All = new JCheckBox("Select all Questions");
		checkBox_All.setFocusPainted(false);
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
		checkBox_All.setBackground(new Color(255, 255, 255));
		checkBox_All.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkBox_All.setBounds(16, 191, 136, 23);
		contentPane.add(checkBox_All);
		
		JButton btnAddSelectedQuestion = new JButton("Add Selected Question to the Quiz");
		btnAddSelectedQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddSelectedQuestion_action(e);
			}
		});
		btnAddSelectedQuestion.setForeground(Color.WHITE);
		btnAddSelectedQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddSelectedQuestion.setFocusPainted(false);
		btnAddSelectedQuestion.setBorder(null);
		btnAddSelectedQuestion.setBackground(new Color(39, 118, 143));
		btnAddSelectedQuestion.setBounds(10, 524, 262, 34);
		contentPane.add(btnAddSelectedQuestion);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReturn_action(e);
			}
		});
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReturn.setFocusPainted(false);
		btnReturn.setBorder(null);
		btnReturn.setBackground(Color.RED);
		btnReturn.setBounds(300, 524, 79, 34);
		contentPane.add(btnReturn);
	}

	protected void do_btnAddSelectedQuestion_action(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			
			ArrayList<Quiz> listquiz= new FileDsQuiz().docQuiz();
			ArrayList<Question> listt= new ArrayList<>();
			DefaultListModel<Question> listModel = (DefaultListModel<Question>) list.getModel();
			int size = listModel.size();
			for (int i = 0; i < size; i++) {
			    Question question = listModel.getElementAt(i);
			    listt.add(question);
			}
			
			
			for(Quiz q:listquiz) {
				
				if(q.getQuizName().trim().equals(this.heading.trim())) {
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
						temp = 0;
						count  = 0;
						for(Question i:listt ) {	
							if(i.isSelected() && !checkInQuiz(q,i)) {
								quizzlistques.add(i);
								count= count + 1;
							}
							else if(i.isSelected() &&checkInQuiz(q,i)) {
								temp = temp+1;
							}
						}
						 
						q.setListQuestions(quizzlistques);
						new FileDsQuiz().ghiQuiz(listquiz);
						JOptionPane.showMessageDialog(null, "có "+temp+" câu hỏi đã chọn có trong quiz. Đã bổ sung "+count+" câu còn lại");
						
					}
					break;
				}
			}
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	protected Boolean checkInQuiz(Quiz q, Question ques) {
		for(Question i : q.getListQuestions()) {
			if(ques.getName().trim().equals(i.getName().trim())) {
				return true;
			}
		}
		return false;
	}

	protected void do_comboBox_actionPerformed(ActionEvent e) {
		checkBox_All.setSelected(false);
		// TODO Auto-generated method stub
		
		dlm=new DefaultListModel<>();
		if(comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Default")==false) {
			try {
				ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
				
				for(QuestionBank q:listQB) {
					if(q.getNameQB().equalsIgnoreCase(extractCharacters(comboBox.getSelectedItem().toString(), '(', ')').trim())) {
						
						ArrayList<Question> listqs=new ArrayList<>();
						
						
						if(q.getListQuestions()==null || q.getListQuestions().isEmpty() ) {
							dlm=new DefaultListModel<>();
							list.setModel(dlm);						    
							list.setCellRenderer(new QuestionList());
							scrollPane.setViewportView(list);
							break;
						}else {
							listqs = q.getListQuestions();
							for(Question qs:listqs) {
								dlm.addElement(qs);
								
							}
							list.setModel(dlm);
							list.setCellRenderer(new QuestionList());
							scrollPane.setViewportView(list);
						}

					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else {
			dlm=new DefaultListModel<>();
			list.setModel(dlm);
			list.setCellRenderer(new QuestionList());
			scrollPane.setViewportView(list);
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	 public String extractCharacters(String input, char startChar, char endChar) {
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
	protected void do_btnReturn_action(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		GUI6_1 gui6_1 = new GUI6_1(this.getHeading());
		gui6_1.setVisible(true);
		gui6_1.do_iconSetting_action(e);
	}
}
