package model;

import java.io.Serializable;


import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TimeLimitOfQuiz implements Serializable{
	private static final long serialVersionUID = 8455589721337249632L;
	private int timeLimit;
	private String  quizName;
	private boolean isHour;
	
	
	public boolean isHour() {
		return isHour;
	}
	public void setHour(boolean isHour) {
		this.isHour = isHour;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public TimeLimitOfQuiz(String quizName,int s) {
		super();
		this.quizName = quizName;; 
		this.timeLimit = s;
		this.isHour = isHour;
	}

}
