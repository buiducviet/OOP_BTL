package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


import model.Quiz;

public class QuizRendered extends JPanel implements ListCellRenderer<Quiz>{
	private JLabel lbIcon= new JLabel();
	private JLabel lbTenQuiz = new JLabel();
	
	public QuizRendered() {
	
		setLayout(new BorderLayout(10, 20));
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		add(lbIcon,BorderLayout.WEST);
		add(lbTenQuiz,BorderLayout.CENTER);

	}
	 @Override
	    public Component getListCellRendererComponent(JList<? extends Quiz> list,
	            Quiz quiz, int index, boolean isSelected, boolean cellHasFocus) {
		  lbIcon.setIcon(new ImageIcon(getClass().getResource(quiz.getQuizIcon()))); 
		  lbTenQuiz.setText(quiz.getQuizName());
		  lbIcon.setOpaque(true);
		  lbTenQuiz.setOpaque(true);

		    // when select item
		    if (isSelected) {
		        lbTenQuiz.setBackground(list.getSelectionBackground());
		        lbIcon.setBackground(list.getSelectionBackground());
		        setBackground(list.getSelectionBackground());
		    } else { // when don't select
		        lbTenQuiz.setBackground(list.getBackground());
		        lbIcon.setBackground(list.getBackground());
		        setBackground(list.getBackground());
		    }
		  return this;
		 
	 }
}
