package model;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Question implements Serializable{

    private String name;
    private String question;
    private ArrayList<String> listChoice;
    private ArrayList<String> multiAnswer;
    private String answer;
    private Boolean isSelected = false;
 //   private ArrayList<ImageIcon> imageList;
    
    private boolean isMultiple = false;
    
	public boolean isMultiple() {
		return isMultiple;
	}
	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}
	public Boolean isSelected() {
		return isSelected;
	}
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getListChoice() {
		return listChoice;
	}
	public void setListChoice(ArrayList<String> listChoice) {
		this.listChoice = listChoice;
	}
	public String  getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**public void Question_1(String name, String question, ArrayList<String> listChoice, char[] answer) {
		
		this.name = name;
		this.question = question;
		this.listChoice = listChoice;
		this.answer = answer;
		this.isSelected = isSelected;
//		this.icon = icon;
//		this.isMultiple = isMultiple;
//		this.isInQuiz = isInQuiz;
	}*/
	public Question(String name, String question, ArrayList<String> listChoice) {
		super();
		this.name = name;
		this.question = question;
		this.listChoice = listChoice;
		this.answer = answer;
		this.isSelected = isSelected;
		this.multiAnswer = multiAnswer;
//		this.icon = icon;
//		this.isMultiple = isMultiple;
//		this.isInQuiz = isInQuiz;
	}
	public ArrayList<String> getMultiAnswer() {
		return multiAnswer;
	}
	public void setMultiAnswer(ArrayList<String> multiAnswer) {
		this.multiAnswer = multiAnswer;
	}
	@Override
	public String toString() {
		return name + ": " + question +"  "+ answer;
	}
    
}
