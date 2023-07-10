package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ChoiceGrade implements Serializable{
	private Question question;
	private ArrayList<String> listGrade;
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public ArrayList<String> getListGrade() {
		return listGrade;
	}

	public void setListGrade(ArrayList<String> listGrade) {
		this.listGrade = listGrade;
	}

	public ChoiceGrade(Question question) {
		super();
		this.question = question;
	}

}
