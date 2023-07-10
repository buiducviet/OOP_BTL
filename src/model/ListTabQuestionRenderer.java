package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import view.BTL_View;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ListTabQuestionRenderer extends JPanel implements ListCellRenderer<Question> {
	
	JCheckBox checkBox = new JCheckBox();
	private String question ;
	private JButton btnEdit = new JButton("EDIT    ");
	
	public ListTabQuestionRenderer() {
		setLayout(new BorderLayout(10, 20));
		
		add(checkBox, BorderLayout.CENTER);
		
//		checkBox.setText("abcdefg");
		add(btnEdit, BorderLayout.EAST);
	}
	
	@Override
	
	public Component getListCellRendererComponent(JList<? extends Question> list, Question value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub

		question= value.getName() + ": " +value.getQuestion()+" " + value.getAnswer();
		if(question.length() > 110) {
			checkBox.setText(question.substring(0, 109)+"...");
		}
		else {
		checkBox.setText(question);
		}
		checkBox.setSelected(((Question) value).isSelected());
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setFocusPainted(false);
		btnEdit.setForeground(Color.BLUE);
		btnEdit.setBorder(null);
		if (isSelected) {
	        this.setBackground(list.getSelectionBackground()); 
	        checkBox.setBackground(list.getSelectionBackground());
	        System.out.println(list.getSelectionBackground());
	        btnEdit.setBackground(new Color(184,207,229));
	    } else { // when don't select
	        this.setBackground(list.getBackground());
	        checkBox.setBackground(list.getBackground());
	        btnEdit.setBackground(Color.WHITE);
	    }
		return this;
	}

	
}
    
