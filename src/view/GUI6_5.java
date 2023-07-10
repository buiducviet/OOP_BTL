package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;



import javax.swing.DefaultListCellRenderer;

import DB.FileDsQuiz;
import DB.fileQuestionBank;
import model.Quiz;
import view.GUI6_1;
import model.Question;
import model.QuestionBank;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class GUI6_5 extends JFrame {	

	private JPanel contentPane;
	private String heading;
	
	private JComboBox comboBox;
	private JComboBox comboBoxRandom;
	private JList list;
	private DefaultListCellRenderer renderer;
	int itemsPerPage = 12;
	int currentPage = 1;
	
	private int totalItems;
	
	ArrayList<String> listL = new ArrayList<>();
	ArrayList<Question> listL2 = new ArrayList<>();
	DefaultListModel<Question> dlm= new DefaultListModel<>();

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
					GUI6_5 frame = new GUI6_5(heading);
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
	public GUI6_5(String str) {
		this.heading = str;
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddARandom = new JLabel("Add a random question to page 1");
		lblAddARandom.setForeground(new Color(214, 20, 20));
		lblAddARandom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAddARandom.setBounds(10, 0, 393, 34);
		contentPane.add(lblAddARandom);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 694, 7);
		contentPane.add(separator);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 63, 694, 612);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("  Existing category  ", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(22, 20, 71, 20);
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_combobox_action(e);
			}
		});
		comboBox.setBounds(141, 11, 226, 41);
		panel.add(comboBox);
		
		DefaultComboBoxModel<String> dcb=new DefaultComboBoxModel<>();
		try {
			dcb=new fileQuestionBank().listCategory();
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
	            listL.add((element+" ("+k+")"));
	        }}catch (Exception e) {
				// TODO: handle exception
			}
		    DefaultComboBoxModel<String> dcb1= new DefaultComboBoxModel<>();
	    for(String s:listL) {
	    	dcb1.addElement(s);
	    }
	    comboBox.setModel(dcb1);
	    
	    
	    
	    renderer = new DefaultListCellRenderer() {
	        public Component getListCellRendererComponent(JList list, Object value, 
	                                                     int index, boolean isSelected, 
	                                                     boolean cellHasFocus) {
	            Component component = super.getListCellRendererComponent(list, value, index, 
	                                                                    isSelected, cellHasFocus);
	            if (component instanceof JLabel) {
	                ((JLabel) component).setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 0));	               
	            }
	            return component;           
	        }
	    };
      
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Includes questions from subcategories too");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(141, 59, 319, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNumberOfRandom = new JLabel("Number of random\r\n questions");
		lblNumberOfRandom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfRandom.setBounds(22, 129, 175, 20);
		panel.add(lblNumberOfRandom);
		
		comboBoxRandom = new JComboBox();
		comboBoxRandom.setBounds(309, 122, 58, 29);
		panel.add(comboBoxRandom);
		
		JButton btnTurnLeft = new JButton("");
		btnTurnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_btnTurnLeft_action(e);
			}
		});
		btnTurnLeft.setFocusPainted(false);
		btnTurnLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTurnLeft.setIcon(new ImageIcon(GUI6_5.class.getResource("/assets/arrow left.png")));
		btnTurnLeft.setBorder(null);
		btnTurnLeft.setBackground(new Color(255, 255, 255));
		btnTurnLeft.setBounds(22, 194, 29, 23);
		panel.add(btnTurnLeft);
		
		JLabel lblQuestionsMatchThis = new JLabel("Questions matching this filter");
		lblQuestionsMatchThis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuestionsMatchThis.setBounds(22, 173, 175, 20);
		panel.add(lblQuestionsMatchThis);
		
		JButton btnTurnRight = new JButton("");
		btnTurnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnTurnRight_action(e);
			}
		});
		btnTurnRight.setFocusPainted(false);
		btnTurnRight.setIcon(new ImageIcon(GUI6_5.class.getResource("/assets/arrow right.png")));
		btnTurnRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTurnRight.setBorder(null);
		btnTurnRight.setBackground(Color.WHITE);
		btnTurnRight.setBounds(58, 194, 29, 23);
		panel.add(btnTurnRight);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(55, 194, 9, 22);
		panel.add(separator_1);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(192, 192, 192)));
		list.setBounds(10, 221, 669, 315);
		panel.add(list);
		
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
		btnReturn.setBounds(10, 542, 79, 34);
		panel.add(btnReturn);
		
		JButton btnAddtoQuiz = new JButton("ADD TO QUIZ");
		btnAddtoQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddtoQuiz_action(e);
			}
		});
		btnAddtoQuiz.setForeground(Color.WHITE);
		btnAddtoQuiz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddtoQuiz.setFocusPainted(false);
		btnAddtoQuiz.setBorder(null);
		btnAddtoQuiz.setBackground(new Color(0, 0, 255));
		btnAddtoQuiz.setBounds(99, 542, 160, 34);
		panel.add(btnAddtoQuiz);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("  New category  ", null, panel_1, null);
	}

	protected void do_btnAddtoQuiz_action(ActionEvent e) {
		// TODO Auto-generated method stub
		int number= Integer.parseInt(comboBoxRandom.getSelectedItem().toString());
		ArrayList<Question> qsli= new ArrayList<>();
		for(int i=0;i<number;i++) {
			 int b=1;
			 while(b==1) {
				 Random random = new Random();
			     int randomIndex = random.nextInt(listL2.size());
			     Question q= listL2.get(randomIndex);
			     if(qsli.isEmpty()) {
			    	 qsli.add(q);
			    	 break;
			     }else {
			    	 int dem=0;
			    	 for(Question q1:qsli) {
							if(q1.getName().equals(q.getName())&& q1.getQuestion().equals(q.getQuestion()) && q1.getListChoice().equals(q.getListChoice())) {
								
							}else {
							    dem++; 
							}
						}
			    	 if(dem==qsli.size()) {
			    		 b=0;
			    		 qsli.add(q);
			    	 }
			    	 
			     }
			 }
			 
		}
		try {
			ArrayList<Quiz> lq= new FileDsQuiz().docQuiz();
			for(Quiz qu:lq) {
				if(qu.getQuizName().trim().equals(this.heading)) {
					if(qu.getListQuestions()==null) {
						qu.setListQuestions(qsli);
					}else {
						ArrayList<Question> liq1= qu.getListQuestions();
						for(Question qq:qsli) {
							liq1.add(qq);
						}
						qu.setListQuestions(liq1);
					}
				}
			}
			new FileDsQuiz().ghiQuiz(lq);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		JOptionPane.showMessageDialog(null, "Đã thêm "+number+" câu hỏi vào "+this.heading);
		GUI6_1 gui6_1= new GUI6_1(heading);
		gui6_1.setVisible(true);
		gui6_1.panelAddQuiz.setVisible(false);
		gui6_1.panelEditQuiz.setVisible(true);
		this.setVisible(false);
	}
	

	protected void do_btnTurnRight_action(ActionEvent e) {
		// TODO Auto-generated method stub
		int maxPage = (int) Math.ceil((double) totalItems / itemsPerPage);
        if (currentPage < maxPage) {
            currentPage++;
            updateJList();
        }
	}

	protected void do_btnTurnLeft_action(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentPage > 1) {
            currentPage--;
            updateJList();
        }
	}

	protected void do_combobox_action(ActionEvent e) {
		// TODO Auto-generated method stub
		dlm=new DefaultListModel<>();
		if(comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Default")==false) {
			try {
				ArrayList<QuestionBank> listQB= new fileQuestionBank().docQuiz();
//				listQB= new FileDsQuestionBank().docQuiz();
				
				for(QuestionBank q:listQB) {
					if(q.getNameQB().equalsIgnoreCase(extractCharacters(comboBox.getSelectedItem().toString(), '(', ')').trim())) {
						
						ArrayList<Question> listqs=new ArrayList<>();
						
						
						if(q.getListQuestions()==null || q.getListQuestions().isEmpty() ) {
							dlm=new DefaultListModel<>();
							list.setModel(dlm);
							list.setCellRenderer(renderer);
//							scrollPane_1.setViewportView(list);
							break;
						}else {
							listqs = q.getListQuestions();
							listL2.clear();
							totalItems=0;
							for(Question qs:listqs) {
								listL2.add(qs);
								totalItems++;
								updateJList();
								list.setModel(dlm);
								list.setCellRenderer(renderer);
							}
//							list.setModel(dlm);
//							scrollPane_1.setViewportView(list);
						}

					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else {
			dlm=new DefaultListModel<>();
			list.setModel(dlm);
			list.setCellRenderer(renderer);
//			scrollPane_1.setViewportView(list);
		}
		DefaultComboBoxModel<String> dcb= new DefaultComboBoxModel<>();
		for(int i=1;i<=totalItems;i++) {
			dcb.addElement(i+"");
			comboBoxRandom.setModel(dcb);
		}
		
	}

	private void updateJList() {
		// TODO Auto-generated method stub
		dlm.clear();

	    int startIndex = (currentPage - 1) * itemsPerPage;
	    int endIndex = Math.min(startIndex + itemsPerPage, totalItems);

	    for (int i = startIndex; i < endIndex; i++) {
	        dlm.addElement(listL2.get(i)); // Thay "data" bằng danh sách dữ liệu thực tế của bạn
	    }
		
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
