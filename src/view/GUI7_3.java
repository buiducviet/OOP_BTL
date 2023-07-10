package view;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DB.FileChoiceGrade;
import DB.FileDsQuiz;
import DB.fileTimeLimitQuiz;
import view.GUI6_1;
import model.ChoiceGrade;
import model.CountDownLabel;
import model.IconofQuestion;
import model.Quiz;
import model.TimeLimitOfQuiz;
import model.QuestionInTestArea;
import model.Question;

//import Entity.CountdownTimerFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class GUI7_3 extends JFrame {

	private JPanel contentPane;
	private JPanel panelListQuesIndex;
	private String quizName;
	Timer timer;
	JButton[] buttons;
	QuestionInTestArea[] lambais; 
	int[] correct;
	int[] wrong ;
	private int socauhoi=0;
	private int countCorrect=0; 
	private int countWrong=0;
	private int trangThaiNop=0;    	
	private Quiz quiz;
	private JLabel lbKetQua;
	private CountDownLabel clockCountDown;
	private int quantity , initialTimeHour, initialTimeMinutes;
	private JButton btnFinish ,  btnFinishPreview;
	private JPanel panelQuestion;
	private PanelResult panelResult;
	private JScrollPane scrollPane_1;
	private JLabel labelTimeLeft;
	private double grade=0;
	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI7_3 frame = new GUI7_3(quizName);
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
	public GUI7_3(String quizName) {
		this.quizName = quizName;
		try {
			ArrayList<Quiz> listquiz= new FileDsQuiz().docQuiz();
			for(Quiz q:listquiz) {
				if(q.getQuizName().trim().equals(quizName.trim())) {
					this.quiz= q;
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		quantity = this.quiz.getListQuestions().size()+1;
		lambais= new QuestionInTestArea[quantity];
		buttons=new JButton[quantity];
		correct= new int[quantity];
		wrong = new int[quantity];
		
		
		
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1350, 716);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1314, 94);
		contentPane.add(panel);
		
		JLabel labelIT = new JLabel("IT\r\n");
		labelIT.setForeground(new Color(214, 20, 20));
		labelIT.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelIT.setBounds(10, 11, 24, 24);
		panel.add(labelIT);
		
		JButton btnHome_1 = new JButton("Home");
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
		labelbonus_1.setBounds(268, 56, 11, 27);
		panel.add(labelbonus_1);
		
		JLabel labelbonus_2 = new JLabel("General");
		labelbonus_2.setForeground(new Color(214, 20, 20));
		labelbonus_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_2.setBounds(283, 58, 53, 23);
		panel.add(labelbonus_2);
		
		JLabel labelbonus_3 = new JLabel("/");
		labelbonus_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_3.setFocusTraversalPolicyProvider(true);
		labelbonus_3.setBounds(338, 58, 11, 27);
		panel.add(labelbonus_3);
		
		JLabel labelbonus_4 = new JLabel(quizName);
		labelbonus_4.setForeground(new Color(214, 20, 20));
		labelbonus_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_4.setBounds(350, 58, 293, 23);
		Dimension size = labelbonus_4.getPreferredSize();
		labelbonus_4.setPreferredSize(size);
		panel.add(labelbonus_4);
		
		JLabel labelbonus_5 = new JLabel("/");
		labelbonus_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_5.setFocusTraversalPolicyProvider(true);
		labelbonus_5.setBounds(350+size.width+10, 56, 18, 27);
		panel.add(labelbonus_5);
		
		JLabel labelbonus_2_1 = new JLabel("Preview");
		labelbonus_2_1.setForeground(new Color(214, 20, 20));
		labelbonus_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelbonus_2_1.setBounds(370+size.width, 58, 53, 23);
		panel.add(labelbonus_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 116, 964, 550);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panelResult = new PanelResult();
		panelResult.setBounds(10, 10, 944, 168);
		panelResult.setLayout(null);
		panel_1.add(panelResult);
		panelResult.setVisible(false);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 51, 944, 488);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(20);
		panel_1.add(scrollPane_1);
		
		panelQuestion = new JPanel();
		panelQuestion.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(panelQuestion);
		panelQuestion.setLayout(new BoxLayout(panelQuestion, BoxLayout.Y_AXIS));
		

		JPanel panelNavigation = new JPanel();
		panelNavigation.setBackground(new Color(255, 255, 255));
		panelNavigation.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelNavigation.setBounds(984, 116, 340, 441);
		contentPane.add(panelNavigation);
		panelNavigation.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 320, 320);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelNavigation.add(scrollPane);
		
		panelListQuesIndex = new JPanel();
		panelListQuesIndex.setBorder(null);
		panelListQuesIndex.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panelListQuesIndex);
		panelListQuesIndex.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelListQuesIndex.setPreferredSize(new Dimension(300,500));
		int i=1;
		int j=0;
		
		for(Question question : quiz.getListQuestions()) {
			final float finalJ = j;
			final float finalI = i;
			lambais[i]= new QuestionInTestArea(i,question);
			
			panelQuestion.add(lambais[i]);
			panelQuestion.setPreferredSize(new Dimension(panelQuestion.getWidth(), panelQuestion.getPreferredSize().height + 350));			    
			panelQuestion.revalidate();
			panelQuestion.repaint();
			
			buttons[j]=new JButton(j+1+"");
			buttons[j].setFont(new Font("Tahoma", Font.PLAIN, 10));
			buttons[j].setPreferredSize(new Dimension(45,50));
			buttons[j].setBorder(new LineBorder(Color.BLACK));
			buttons[j].setBackground(Color.WHITE);
			buttons[j].setFocusPainted(false);
			buttons[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    JScrollBar verticalScrollBar = scrollPane_1.getVerticalScrollBar();
                    int scrollAmount= (int) (verticalScrollBar.getMaximum() * (finalJ*0.997/socauhoi));
                    verticalScrollBar.setValue(scrollAmount);
                }
            });
			panelListQuesIndex.add(buttons[j]);
			j++;
			i++;
			socauhoi++;
			if(socauhoi==this.quantity) {
				break;
			}
		}
		timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	for(int m=0;m<socauhoi;m++) {
            		if(lambais[m+1].getDaChon()!='\0') {
            			buttons[m].setBackground(Color.blue);
            		}
            	}
            
            }
        });
		timer.start();
		
		labelTimeLeft = new JLabel("Time left:");
		labelTimeLeft.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTimeLeft.setBackground(new Color(255, 255, 255));
		labelTimeLeft.setBounds(739, 11, 56, 29);
		panel_1.add(labelTimeLeft);
		
		
		clockCountDown = new CountDownLabel();
		clockCountDown.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				do_countdown_propertyChange(evt);
			}
		});
		clockCountDown.setFont(new Font("Tahoma", Font.PLAIN, 13));
		clockCountDown.setBackground(Color.WHITE);
		clockCountDown.setBounds(810, 11, 102, 29);
//		clockCountDown.setText(this.quiz);
		System.out.println("abcde");
		try {
			ArrayList<TimeLimitOfQuiz> arrayListQues = new fileTimeLimitQuiz().docTimeLimit();
			System.out.println("abcd");
			for(TimeLimitOfQuiz temp : arrayListQues) {
				if (temp.getQuizName().equalsIgnoreCase(this.quizName)) {
					if(temp.isHour()){
						System.out.println(temp.getQuizName());
						System.out.println("thời gian" + temp.getTimeLimit());
						clockCountDown.setHours( temp.getTimeLimit());					
						initialTimeHour=temp.getTimeLimit();
					}				
					else {
						System.out.println(temp.getQuizName());
						System.out.println("thời gian" + temp.getTimeLimit());
						clockCountDown.setHours(0);
						clockCountDown.setMinutes(temp.getTimeLimit());
						initialTimeMinutes=temp.getTimeLimit();
					}
						
				}
				
			}
				
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_1.add(clockCountDown);
		
		/*lbKetQua = new JLabel("");
		lbKetQua.setForeground(new Color(214, 20, 20));
		lbKetQua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbKetQua.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbKetQua.setBounds(239, 10, 232, 30);
		lbKetQua.setVisible(false);
		panel_1.add(lbKetQua);*/
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(0, 0, 340, 45);
		panelNavigation.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz navigation");
		lblNewLabel.setForeground(new Color(214, 20, 20));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 0, 136, 45);
		panel_3.add(lblNewLabel);
		
		JLabel iconQuestion_1 = new JLabel(new ImageIcon(GUI7_3.class.getResource("/assets/avatar.png")));
		iconQuestion_1.setBounds(10, 49, 27, 29);
		panelNavigation.add(iconQuestion_1);
				
		btnFinish = new JButton("Finish attempt...");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFinish_action(e);
			}
		});
		btnFinish.setFocusPainted(false);
		btnFinish.setForeground(new Color(128, 128, 128));
		btnFinish.setBackground(new Color(255, 255, 255));
		btnFinish.setBorder(null);
		btnFinish.setBounds(10, 410, 95, 23);
		panelNavigation.add(btnFinish);
		
		btnFinishPreview = new JButton("Finish preview...");
		btnFinishPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnFinishPreview_action(e);
			}
		});
		btnFinishPreview.setFocusPainted(false);
		btnFinishPreview.setForeground(new Color(128, 128, 128));
		btnFinishPreview.setBackground(new Color(255, 255, 255));
		btnFinishPreview.setBorder(null);
		btnFinishPreview.setBounds(10, 410, 95, 23);
		panelNavigation.add(btnFinishPreview);
		btnFinishPreview.setVisible(false);
	}

	protected void do_btnFinishPreview_action(ActionEvent e) {
		// TODO Auto-generated method stub
		GUI6_1 gui6_1 = new GUI6_1(this.quizName);
		this.setVisible(false);
		gui6_1.setVisible(true);
		
		
	}

	protected void do_btnFinish_action(ActionEvent e) {
		// TODO Auto-generated method stub
		if(trangThaiNop==0) {
			int x= JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn nộp bài?");
			if(x==JOptionPane.YES_OPTION) {
				trangThaiNop=1;
				timer.stop();
				panelQuestion = new JPanel();
				scrollPane_1.setBounds(10, 92+174, 944, 306);
				labelTimeLeft.setVisible(false);
				panelResult.setVisible(true);
				
				try {
					ArrayList<TimeLimitOfQuiz> arrayListQues = new fileTimeLimitQuiz().docTimeLimit();
					System.out.println("abcd");
					for(TimeLimitOfQuiz temp : arrayListQues) {
						if (temp.getQuizName().equalsIgnoreCase(this.quizName)) {
							if(temp.isHour()){
								int timeSecond =60 - clockCountDown.getSeconds();
								int timeMinute ;
								if( timeSecond == 0) timeMinute = 60 - clockCountDown.getMinutes();
								else if 	(  60 - clockCountDown.getMinutes()-1 < 0)  timeMinute = 0 ;
								else  timeMinute = 60 - clockCountDown.getMinutes()-1;
								
								
								
								int timeHour;
								
								if(timeMinute == 0 && timeSecond == 0) timeHour = -  clockCountDown.getHours() + initialTimeHour;
								else if			(  -  clockCountDown.getHours() + initialTimeHour-1 < 0)    timeHour=0;
								else 	timeHour = -  clockCountDown.getHours() + initialTimeHour-1;
								System.out.println(clockCountDown.getMinutes());
								
								
								panelResult.getLabelTimeTaken().setText(String.valueOf(timeHour)+"h, "+String.valueOf(timeMinute)+"m, "+String.valueOf(timeSecond)+"s"); 
							}				
							else {
								int timeSecond =60 - clockCountDown.getSeconds();
								
								
								int timeMinute ;
								if( timeSecond == 0) timeMinute = initialTimeMinutes - clockCountDown.getMinutes();
								else if 	(  initialTimeMinutes - clockCountDown.getMinutes()-1 < 0)  timeMinute = 0 ;
								else  timeMinute = initialTimeMinutes - clockCountDown.getMinutes()-1;
								
								
								int timeHour=0;								
								
								System.out.println(clockCountDown.getMinutes());
								
								
								panelResult.getLabelTimeTaken().setText(String.valueOf(timeHour)+"h, "+String.valueOf(timeMinute)+"m, "+String.valueOf(timeSecond)+"s"); 
							}
								
						}
						
					}
						
				}
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int k=1;k<=socauhoi;k++) {
					if(!lambais[k].getQuestion().isMultiple()) {
					
						Enumeration<AbstractButton> buttons = lambais[k].getGroup().getElements();
						
						lambais[k].getLbanswer().setText("The correct answer is: "+lambais[k].getAnswer());
						lambais[k].getPanel_2().setVisible(true);
										
													
						if(Character.toUpperCase(lambais[k].getAnswer())==Character.toUpperCase(lambais[k].getDaChon())) {
							correct[countCorrect]=k;
							countCorrect++;
							grade += 100;
							lambais[k].getPanel().setBackground(new Color(197,255,222));
							lambais[k].getPanel_2().setBackground(new Color(197,255,222));
						
						}else {
							wrong[countWrong]=k;
							countWrong++;
							lambais[k].getPanel().setBackground(new Color(245,222,179));
							lambais[k].getPanel_2().setBackground(new Color(245,222,179));
						
						}
						while (buttons.hasMoreElements()) {
					    AbstractButton button = buttons.nextElement();
					    button.setEnabled(false);
					}
					}
					else {
						ArrayList<JCheckBox> checkBoxMulti = lambais[k].getCheckBoxMulti();
						lambais[k].getLbanswer().setText("The correct answer is: "+lambais[k].getMultiAnswer());
						lambais[k].getPanel_2().setVisible(true);
						Question ques = lambais[k].getQuestion();
						double grade_1=0;
						for(int i = 0; i < checkBoxMulti.size(); i++) {
							JCheckBox checkBox = checkBoxMulti.get(i);
							if(checkBox.isSelected()) {
								try {
									ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
									for(ChoiceGrade choicegrade : arrayListQues) {
										if(choicegrade.getQuestion().getQuestion().equals(ques.getQuestion()) && choicegrade.getQuestion().getName().equals(ques.getName())) {
											if(choicegrade.getListGrade().get(i).charAt(0)!='-'&& !(choicegrade.getListGrade().get(i).equals("None"))) {
												grade+= Double.parseDouble(choicegrade.getListGrade().get(i).substring(0, choicegrade.getListGrade().get(i).length()-1))  ;
												grade_1+=Double.parseDouble(choicegrade.getListGrade().get(i).substring(0, choicegrade.getListGrade().get(i).length()-1))  ;
											}
											else if(choicegrade.getListGrade().get(i).charAt(0)=='-'&& !(choicegrade.getListGrade().get(i).equals("None"))){
												String st = choicegrade.getListGrade().get(i).substring(1, choicegrade.getListGrade().get(i).length()-1);
												grade+= (-1)*Double.parseDouble(st);
												grade_1+=(-1)*Double.parseDouble(st);
											}
										}
									}
									if(grade_1==100) {
										correct[countCorrect]=k;
										countCorrect++;
										lambais[k].getPanel().setBackground(new Color(197,255,222));
										lambais[k].getPanel_2().setBackground(new Color(197,255,222));
									}
									else {
										wrong[countWrong]=k;
										countWrong++;
										lambais[k].getPanel().setBackground(new Color(245,222,179));
										lambais[k].getPanel_2().setBackground(new Color(245,222,179));
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
								
							}
						}
						
						
						
					
					}
				}
				for(int k1=0;k1<countWrong;k1++) {
					buttons[wrong[k1]-1].setBackground(Color.RED);
				}
				for(int k1=0;k1<countCorrect;k1++) {
					buttons[correct[k1]-1].setBackground(Color.GREEN);
				}
				clockCountDown.stop();;
				
//				btnNewButton_1.setVisible(true);
				if(countWrong>0) {
					String str= "sai ở các câu: ";  
					for(int m=0;m<countWrong;m++) {     
						str+=wrong[m]+" ";
						
					}
					btnFinish.setVisible(false) ;
					btnFinishPreview.setVisible(true);
					JOptionPane.showMessageDialog(null, str);
				}else {
					btnFinish.setVisible(false) ;
					btnFinishPreview.setVisible(true);
					JOptionPane.showMessageDialog(null, "chúc mừng bạn làm đúng hết!");
				}
//			
				panelResult.getLabelMarks().setText(""+countCorrect+"/"+socauhoi);
				String s = String.valueOf(grade/socauhoi);
				s=s;
				panelResult.getLabelGrade().setText(s.substring(0,4)+"%");
			}else if(x==JOptionPane.CANCEL_OPTION){
				GUI6_1 gui6_1= new GUI6_1(quizName);
				gui6_1.setVisible(true);
				this.setVisible(false);
			}else {
				
			}
		}else {
			btnFinish.setVisible(false) ;
			btnFinishPreview.setVisible(true); 
	//		JOptionPane.showMessageDialog(null, "bạn đã nộp bài rồi!");
			
		}
	}
	protected void do_countdown_propertyChange(PropertyChangeEvent evt) {
		String s = clockCountDown.getText();
		if(s.equals("0:00:00") && trangThaiNop==0) {
			System.out.println(10012789);
			JOptionPane.showMessageDialog(null, "HẾT GIỜ!");
			timer.stop();
			panelQuestion = new JPanel();
			scrollPane_1.setBounds(10, 92+174, 944, 306);
			labelTimeLeft.setVisible(false);
			panelResult.setVisible(true);
			
			
			try {
				ArrayList<TimeLimitOfQuiz> arrayListQues = new fileTimeLimitQuiz().docTimeLimit();
				System.out.println("abcd");
				for(TimeLimitOfQuiz temp : arrayListQues) {
					if (temp.getQuizName().equalsIgnoreCase(this.quizName)) {
						if(temp.isHour()){
							int timeSecond =60 - clockCountDown.getSeconds();
							int timeMinute ;
							if( timeSecond == 0) timeMinute = 60 - clockCountDown.getMinutes();
							else if 	(  60 - clockCountDown.getMinutes()-1 < 0)  timeMinute = 0 ;
							else  timeMinute = 60 - clockCountDown.getMinutes()-1;
							
							
							
							int timeHour;
							
							if(timeMinute == 0 && timeSecond == 0) timeHour = -  clockCountDown.getHours() + initialTimeHour;
							else if			(  -  clockCountDown.getHours() + initialTimeHour-1 < 0)    timeHour=0;
							else 	timeHour = -  clockCountDown.getHours() + initialTimeHour-1;
							System.out.println(clockCountDown.getMinutes());
							
							
							panelResult.getLabelTimeTaken().setText(String.valueOf(timeHour)+"h, "+String.valueOf(timeMinute)+"m, "+String.valueOf(timeSecond)+"s"); 
						}				
						else {
							int timeSecond =60 - clockCountDown.getSeconds();
							
							
							int timeMinute ;
							if( timeSecond == 0) timeMinute = initialTimeMinutes - clockCountDown.getMinutes();
							else if 	(  initialTimeMinutes - clockCountDown.getMinutes()-1 < 0)  timeMinute = 0 ;
							else  timeMinute = initialTimeMinutes - clockCountDown.getMinutes()-1;
							
							
							int timeHour=0;								
							
							System.out.println(clockCountDown.getMinutes());
							
							
							panelResult.getLabelTimeTaken().setText(String.valueOf(timeHour)+"h, "+String.valueOf(timeMinute)+"m, "+String.valueOf(timeSecond)+"s"); 
						}
							
					}
					
				}
					
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int k=1;k<=socauhoi;k++) {
				if(!lambais[k].getQuestion().isMultiple()) {
					
					Enumeration<AbstractButton> buttons = lambais[k].getGroup().getElements();
					
					lambais[k].getLbanswer().setText("The correct answer is: "+lambais[k].getAnswer());
					lambais[k].getPanel_2().setVisible(true);
									
												
					if(Character.toUpperCase(lambais[k].getAnswer())==Character.toUpperCase(lambais[k].getDaChon())) {
						correct[countCorrect]=k;
						countCorrect++;
						grade += 100;
						lambais[k].getPanel().setBackground(new Color(197,255,222));
						lambais[k].getPanel_2().setBackground(new Color(197,255,222));
					
					}else {
						wrong[countWrong]=k;
						countWrong++;
						lambais[k].getPanel().setBackground(new Color(245,222,179));
						lambais[k].getPanel_2().setBackground(new Color(245,222,179));
					
					}
					while (buttons.hasMoreElements()) {
				    AbstractButton button = buttons.nextElement();
				    button.setEnabled(false);
				}
				}
				else {
					ArrayList<JCheckBox> checkBoxMulti = lambais[k].getCheckBoxMulti();
					lambais[k].getLbanswer().setText("The correct answer is: "+lambais[k].getMultiAnswer());
					lambais[k].getPanel_2().setVisible(true);
					Question ques = lambais[k].getQuestion();
					double grade_1 = 0;
					for(int i = 0; i < checkBoxMulti.size(); i++) {
						JCheckBox checkBox = checkBoxMulti.get(i);
						if(checkBox.isSelected()) {
							try {
								ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
								for(ChoiceGrade choicegrade : arrayListQues) {
									if(choicegrade.getQuestion().getQuestion().equals(ques.getQuestion()) && choicegrade.getQuestion().getName().equals(ques.getName())) {
										if(choicegrade.getListGrade().get(i).charAt(0)!='-'&& !(choicegrade.getListGrade().get(i).equals("None"))) {
											grade+= Double.parseDouble(choicegrade.getListGrade().get(i).substring(0, choicegrade.getListGrade().get(i).length()-1))  ;
											grade_1+=Double.parseDouble(choicegrade.getListGrade().get(i).substring(0, choicegrade.getListGrade().get(i).length()-1))  ;
										}
										else if(choicegrade.getListGrade().get(i).charAt(0)=='-'&& !(choicegrade.getListGrade().get(i).equals("None"))){
											String st = choicegrade.getListGrade().get(i).substring(1, choicegrade.getListGrade().get(i).length()-1);
											grade+= (-1)*Double.parseDouble(st);
											grade_1+=(-1)*Double.parseDouble(st);
										}
									}
								}
								if(grade_1==100) {
									correct[countCorrect]=k;
									countCorrect++;
								}
								else {
									wrong[countWrong]=k;
									countWrong++;
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
							
						}
					}
					
					
					
				
				}
			}
			for(int k=0;k<countWrong;k++) {
					buttons[wrong[k]-1].setBackground(Color.RED);
				}
				for(int k=0;k<countCorrect;k++) {
					buttons[correct[k]-1].setBackground(Color.GREEN);
				}
				clockCountDown.stop();;
				
//				btnNewButton_1.setVisible(true);
				if(countWrong>0) {
					String str= "sai ở các câu: ";  
					for(int m=0;m<countWrong;m++) {     
						str+=wrong[m]+" ";
						
					}
					btnFinish.setVisible(false) ;
					btnFinishPreview.setVisible(true);
					JOptionPane.showMessageDialog(null, str);
				}else {
					btnFinish.setVisible(false) ;
					btnFinishPreview.setVisible(true);
					JOptionPane.showMessageDialog(null, "chúc mừng bạn làm đúng hết!");
				}

				panelResult.getLabelMarks().setText(""+countCorrect+"/"+socauhoi);
				String s1 = String.valueOf(grade/socauhoi);
				s1=s1;
				panelResult.getLabelGrade().setText(s1.substring(0,4)+"%");
			}
		}
			

	

	protected void do_btnHome_1_action(ActionEvent e) {
		// TODO Auto-generated method stub
		BTL_View home = new BTL_View(); 
		this.setVisible(false);       
		home.do_btnHome_action(e);  
		
	} 
} 
