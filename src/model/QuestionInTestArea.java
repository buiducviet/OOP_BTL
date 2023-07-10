package model;

import javax.swing.JPanel;


import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.itextpdf.text.Document;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;

import DB.FileChoiceGrade;
import DB.fileQuesIcon;
import model.Question;


import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionInTestArea extends JPanel{
	
	ButtonGroup group;
	ArrayList<JCheckBox> checkBoxMulti = new ArrayList();
	private char answer;
	private ArrayList<String> multiAnswer;
	private char daChon;
	JPanel panel;
	JPanel panel_Question;
	private JPanel panel_Choice;
	private JLabel labelQuestion;
	private JLabel lbanswer;
	private JLabel labelAnswerYet;
	int index;
	private IconofQuestion iconOfQuestion;
	private JTextPane deBai ;
	private JPanel panel_2;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	private Question question;
//	private JPanel deBai;
	
	public JPanel getPanel_2() {
		return panel_2;
	}
	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}
	public ButtonGroup getGroup() {
		return group;
	}
	public void setGroup(ButtonGroup group) { 
		this.group = group;
	}
	public char getAnswer() {
		return answer;
	}
	public void setAnswer(char answer) {
		this.answer = answer; 
	}
	public char getDaChon() {
		return daChon;
	}
	public void setDaChon(char daChon) {
		this.daChon = daChon;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JPanel getPanel_Question() {
		return panel_Question;
	}
	public void setPanel_Question(JPanel panel_Question) {
		this.panel_Question = panel_Question;
	}
	public JPanel getPanel_Choice() {
		return panel_Choice;
	}
	public void setPanel_Choice(JPanel panel_Choice) {
		this.panel_Choice = panel_Choice;
	}
	public JLabel getLabelQuestion() {
		return labelQuestion;
	}
	public void setLabelQuestion(JLabel labelQuestion) {
		this.labelQuestion = labelQuestion;
	}
	public JLabel getLbanswer() {
		return lbanswer;
	}
	public void setLbanswer(JLabel lbanswer) {
		this.lbanswer = lbanswer;
	}
	public JLabel getLabelAnswerYet() {
		return labelAnswerYet;
	}
	public void setLabelAnswerYet(JLabel labelAnswerYet) {
		this.labelAnswerYet = labelAnswerYet;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public DefaultButtonModel getDbm() {
		return dbm;
	}
	public void setDbm(DefaultButtonModel dbm) {
		this.dbm = dbm;
	}
	private DefaultButtonModel dbm= new DefaultButtonModel();
	private JTextPane panel_1;
	
	
	
	public QuestionInTestArea(int index,Question question) {
		
		this.index=index;
		this.question = question;
		if(!question.isMultiple())
		   this.answer = question.getAnswer().trim().charAt(8);
		else {
			this.multiAnswer = question.getMultiAnswer();
		}
		
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(10, 11, 150, 256);
		add(panel);
		panel.setLayout(null);
		
		labelQuestion = new JLabel("Question "+index);
		labelQuestion.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelQuestion.setForeground(new Color(214, 20, 20));
		labelQuestion.setBackground(new Color(245, 245, 245));
		labelQuestion.setBounds(10, 11, 130, 37);
		panel.add(labelQuestion);
		
		JLabel LabelMarkOutof = new JLabel("Mark out of");
		LabelMarkOutof.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelMarkOutof.setBounds(10, 107, 130, 28);
		panel.add(LabelMarkOutof);
		
		labelAnswerYet = new JLabel("Not yet answered");
		labelAnswerYet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAnswerYet.setBounds(10, 68, 130, 28);
		panel.add(labelAnswerYet);
		
		JLabel labelMarkperQuestion = new JLabel("1.00");
		labelMarkperQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMarkperQuestion.setBounds(10, 146, 48, 28);
		panel.add(labelMarkperQuestion);
		
		JButton btnFlag = new JButton("Flag question");
		btnFlag.setIcon(new ImageIcon(QuestionInTestArea.class.getResource("/assets/flag.png")));
		btnFlag.setBorder(null);
		btnFlag.setBackground(new Color(245, 245, 245));
		btnFlag.setFocusPainted(false);
		btnFlag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFlag.setBounds(10, 193, 120, 37);
		panel.add(btnFlag);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(232, 243, 244));
		scrollPane.setBounds(170, 11, 742, 256);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		add(scrollPane);
		
		panel_Question = new JPanel();
		panel_Question.setBorder(null);
		
//		deBai = new JPanel();
		deBai = new JTextPane();
		deBai.setEditable(false);
		deBai.setBounds(10, 0, 742, 36);
//		deBai.setCaret(null);
		deBai.setFont(new Font("Tahoma",Font.PLAIN,14));
		deBai.setContentType("text/html");
		deBai.setText("<html><body style='width: 525px'>"+ question.getName() + ": "  + question.getQuestion() + "\n" + "</body></html>");

//		deBai.setText("   "+ question.getName() + ": "  + question.getQuestion() + "\n" );
//		deBai.setText("line1" + System.lineSeparator() + "line2");
//		deBai.setWrapStyleWord(true);
		
		 
		panel_Question.setLayout(null);	
		panel_Question.setBorder(null);
		panel_Question.add(deBai);
		deBai.setSize(deBai.getPreferredSize());		
		deBai.setBorder(null);		
		deBai.setBackground(new Color(232, 243, 244));
		panel_Question.add(deBai,BorderLayout.NORTH);
		
		panel_Choice = new JPanel();
		panel_Choice.setBorder(null);
		panel_Choice.setBounds(0, deBai.getHeight(), 742, 218);
		panel_Question.add(panel_Choice);
		panel_Choice.setLayout(new GridLayout(0,1));
		
		
		panel_1 = new JTextPane();
		panel_1.setBorder(null);
		panel_1.setBounds(412, 36, 330, 218);
		panel_1.setBackground(new Color(232, 243, 244));
		panel_1.setEnabled(false);
		panel_1.setVisible(false);
		panel_Question.setBackground(deBai.getBackground());
		panel_Question.setPreferredSize(new Dimension(742,deBai.getHeight()+panel_Choice.getHeight()));
		scrollPane.setPreferredSize(panel_Question.getPreferredSize());
		
		
		
		try {
			ArrayList<IconofQuestion> arrayListQues = new fileQuesIcon().docIconList();
			for(IconofQuestion i:arrayListQues) {
				if (i.getQuestion().getName().equalsIgnoreCase(question.getName()) && i.getQuestion().getQuestion().equalsIgnoreCase(question.getQuestion())) {
					/*panel_1 = new JTextPane();
					panel_1.setBorder(null);
					panel_1.setBounds(412, 36, 330, 218);
					panel_1.setBackground(new Color(232, 243, 244));
					panel_1.setEnabled(false);
					panel_Question.setBackground(deBai.getBackground());*/
					panel_Question.add(panel_1);
					panel_1.setVisible(true);
					panel_Choice.setBounds(0, deBai.getHeight(), 412, 218);
					System.out.println(i.getIconList().size()+10000);
					int temp=0;
					int index_1 = 0;
					for(ImageIcon j : i.getIconList()) {
						System.out.println("đây là size" +i.getPath().size());
	//					panel_Question.setPreferredSize(new Dimension(750+100,400+200));
						panel_1.setBounds(412, 36, temp+232, 300);
						panel_Question.setPreferredSize(new Dimension(750+temp+20,400));
						String s="         ";
						StyledDocument doc = panel_1.getStyledDocument();
						SimpleAttributeSet style = new SimpleAttributeSet();
						StyleConstants.setBold(style, true);
						StyleConstants.setForeground(style, Color.RED);
						doc.setCharacterAttributes(0, doc.getLength(), style, false);
						
						try {
							doc.insertString(doc.getLength(), s, null);
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String s_1 = i.getPath().get(index_1);
						ImageIcon icon;
						if(s_1.endsWith("gif")) {
				        	
				        	icon = new ImageIcon(s_1); 					       
				        }
				        else  {	
				        icon = new ImageIcon(s_1); 
				        Image image = icon.getImage();
				        int newHeight;
				        int newWidth;
				        newWidth = 100;
				        newHeight = image.getHeight(null)*newWidth/image.getWidth(null);
				        
				        Image newImage = image.getScaledInstance(newWidth, newHeight, 
				                Image.SCALE_SMOOTH);
				        icon = new ImageIcon(newImage);
				        
					}
				        /*textPaneCateInfor.insertIcon(icon);
				        iconList.add(icon);*/
				       
						panel_1.insertIcon(icon);
						System.out.println(panel_1.getSize());
						temp = temp + 100;
						index_1++;
					}
					
					/*deBai.setBounds(0, 0, 742+110, 36+150);
					for(ImageIcon j : i.getIconList()) {
						panel_Question.setPreferredSize(new Dimension(750+100,400+200));				
						deBai.insertIcon(j);
						temp = temp + 100;
						panel_Choice.setBounds(0, 36+110, 413, 218);
						panel_1.setBounds(412, 36+110, 330, 218);
					}*/
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
		
		
		
		
		
		ArrayList<String> listChoiceGrade = new ArrayList();
   	 	try {
			ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
			for(ChoiceGrade choiceGrade : arrayListQues) {
				if(choiceGrade.getQuestion().getName().equalsIgnoreCase(question.getName()) && choiceGrade.getQuestion().getQuestion().equalsIgnoreCase(question.getQuestion())) {
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
   	 	
   	 	int temp = 0; 
   	 	for(String s : listChoiceGrade ) {
   	 		if (!s.equalsIgnoreCase("None")) {
   	 			temp++;
   	 		}
   	 	}
 	 	if(temp == 1) {
 	 	
		 group= new ButtonGroup();
		 for(String s:question.getListChoice()) {
			JRadioButton choice= new JRadioButton();
			choice.setFocusPainted(false);
			choice.setBackground(new Color(232, 243, 244));
			choice.setText("<html><body style='width: 520px'>" + s + "</body></html>");
//			choice.setText(s);
			choice.setActionCommand(s.trim());
		    choice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_rdbtnNewRadioButton_actionPerformed(e);
				}
			});
			group.add(choice);			
//			System.out.println(choice.getSize());
//			choice.setPreferredSize(choice.getSize());
			panel_Choice.add(choice);
//			System.out.println(+10000);
		 }
  	 	}
   	 	else {
   	 	question.setMultiple(true);
   	 	for(String s:question.getListChoice()) {
			JCheckBox choice= new JCheckBox();
			choice.setFocusPainted(false);
			choice.setBackground(new Color(232, 243, 244));
			choice.setText("<html><body style='width: 520px'>" + s + "</body></html>");
//			choice.setText(s);
/*			choice.setActionCommand(s.trim());
		    choice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_rdbtnNewRadioButton_actionPerformed(e);
				}
			});*/
//			group.add(choice);			
//			System.out.println(choice.getSize());
//			choice.setPreferredSize(choice.getSize());
			checkBoxMulti.add(choice);
			panel_Choice.add(choice);
//			System.out.println(+10000);
		}
   	 		
   	 	}
		panel_Question.add(panel_Choice,BorderLayout.CENTER);
//		panel_Choice.setLayout(new GridLayout(1, 0, 0, 0));
		scrollPane.setViewportView(panel_Question);
		scrollPane.revalidate();
		scrollPane.repaint();
		
		panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(232, 243, 244));
		panel_2.setBounds(170, 279, 742, 52);
		add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		
		
		
		lbanswer = new JLabel("");
		lbanswer.setBounds(10, 11, 722, 30);
		panel_2.add(lbanswer);
		lbanswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
	}
	
	public ArrayList<JCheckBox> getCheckBoxMulti() {
		return checkBoxMulti;
	}
	public void setCheckBoxMulti(ArrayList<JCheckBox> checkBoxMulti) {
		this.checkBoxMulti = checkBoxMulti;
	}
	public ArrayList<String> getMultiAnswer() {
		return multiAnswer;
	}
	public void setMultiAnswer(ArrayList<String> multiAnswer) {
		this.multiAnswer = multiAnswer;
	}
	public JTextPane getDeBai() {
		return deBai;
	}
	public void setDeBai(JTextPane deBai) {
		this.deBai = deBai;
	}
	public JTextPane getPanel_1() {
		return panel_1;
	}
	public void setPanel_1(JTextPane panel_1) {
		this.panel_1 = panel_1;
	}
	public IconofQuestion getIconOfQuestion() {
		return iconOfQuestion;
	}
	public void setIconOfQuestion(IconofQuestion iconOfQuestion) {
		this.iconOfQuestion = iconOfQuestion;
	}
	protected void do_rdbtnNewRadioButton_actionPerformed(ActionEvent e) {
		ButtonModel selectedButton = group.getSelection();
		if (selectedButton != null) {
		    String selectedRadioButtonText = selectedButton.getActionCommand();
		    
		    if (selectedRadioButtonText != null) {
		    	this.daChon=selectedRadioButtonText.trim().charAt(0);
		    	labelAnswerYet.setText("Answered");
		    } else {
		    }
		} else {
		}
	}
}

