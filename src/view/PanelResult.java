package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class PanelResult extends JPanel {
	
	private JLabel labelMarks, labelGrade, labelTimeTaken;
	
	public JLabel getLabelMarks() {
		return labelMarks;
	}

	public void setLabelMarks(JLabel labelMarks) {
		this.labelMarks = labelMarks;
	}

	public JLabel getLabelGrade() {
		return labelGrade;
	}

	public void setLabelGrade(JLabel labelGrade) {
		this.labelGrade = labelGrade;
	}

	public JLabel getLabelTimeTaken() {
		return labelTimeTaken;
	}

	public void setLabelTimeTaken(JLabel labelTimeTaken) {
		this.labelTimeTaken = labelTimeTaken;
	}

	public PanelResult() {
		setBorder(new LineBorder(new Color(192, 192, 192)));
		setBackground(new Color(244, 253, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Started on");
		lblNewLabel.setForeground(new Color(183, 43, 67));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 207, 21);

		add(lblNewLabel);
		
		JLabel lblState = new JLabel("State");
		lblState.setForeground(new Color(183, 43, 67));
		lblState.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblState.setBounds(10, 35, 207, 21);
		add(lblState);
		
		JLabel lblCompletesOn = new JLabel("Completed on");
		lblCompletesOn.setForeground(new Color(183, 43, 67));
		lblCompletesOn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCompletesOn.setBounds(10, 61, 207, 21);
		add(lblCompletesOn);
		
		JLabel lblTimeTaken = new JLabel("Time taken");
		lblTimeTaken.setForeground(new Color(183, 43, 67));
		lblTimeTaken.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTimeTaken.setBounds(10, 89, 207, 21);
		add(lblTimeTaken);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setForeground(new Color(183, 43, 67));
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarks.setBounds(10, 114, 207, 21);
		add(lblMarks);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(new Color(183, 43, 67));
		lblGrade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGrade.setBounds(10, 140, 207, 21);
		add(lblGrade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 31, 944, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 58, 944, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 85, 944, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 113, 944, 2);
		add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 138, 944, 2);
		add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(205, 0, 16, 167);
		add(separator_5);
		
		JLabel labelStartOn = new JLabel("Ngay thang nam");
		labelStartOn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelStartOn.setBounds(216, 11, 608, 18);
		add(labelStartOn);
		
		JLabel labelState = new JLabel("Finished");
		labelState.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelState.setBounds(216, 39, 159, 18);
		add(labelState);
		
		JLabel labelCompleteOn = new JLabel("Ngay gio thang nam");
		labelCompleteOn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCompleteOn.setBounds(216, 65, 608, 18);
		add(labelCompleteOn);
		
		labelTimeTaken = new JLabel("New label");
		labelTimeTaken.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTimeTaken.setBounds(216, 93, 608, 18);
		add(labelTimeTaken);
		
		labelMarks = new JLabel("New label");
		labelMarks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelMarks.setBounds(216, 117, 608, 18);
		add(labelMarks);
		
		labelGrade = new JLabel("New label");
		labelGrade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelGrade.setBounds(216, 146, 608, 18);
		add(labelGrade);
	}
}
