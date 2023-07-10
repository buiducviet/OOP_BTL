package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.Question;

public class Quiz implements Serializable{
	private String quizName;
	private final String quizIcon="/assets/quizIcon.png";
	private ArrayList<Question> listQuestions;
	/*private String timeLimit;
	
	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}*/

	public Quiz() {

	}
	
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public ArrayList<Question> getListQuestions() {
		return listQuestions;
	}
	public void setListQuestions(ArrayList<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}
	public String getQuizIcon() {
		return quizIcon;
	}
	
	public Quiz(String quizName) {
		super();
		this.quizName = quizName;
	}	
    @Override
    public String toString() {
    	return this.quizName;
    }
	
}
