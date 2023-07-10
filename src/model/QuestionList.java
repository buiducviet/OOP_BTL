package model;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuestionList extends JCheckBox implements ListCellRenderer<Question> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Question> list, Question value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		setEnabled(list.isEnabled());
	    setSelected(((Question) value).isSelected());
	    setFont(list.getFont());
	    setBackground(list.getBackground());
	    setForeground(list.getForeground());
	    setText(value.toString());
	    if (isSelected) {
	        this.setBackground(list.getSelectionBackground()); 
	        setBackground(list.getSelectionBackground());
	    } else { // when don't select
	        this.setBackground(list.getBackground());
	        setBackground(list.getBackground());
	    }
		return this;
	}
    
}
