package model;

import java.io.Serializable;

import java.util.ArrayList;

public class QuestionBank implements Serializable {
    private String nameQB;
    private String parentQB;
    private ArrayList<Question> listQuestions;
    private int quantity;
   
	public String getNameQB() {
		return nameQB;
	}

	public void setNameQB(String nameQB) {
		this.nameQB = nameQB; 
	}

	public String getParentQB() { 
		return parentQB;
	}

	public void setParentQB(String parentQB) {
		this.parentQB = parentQB;
	}

	public ArrayList<Question> getListQuestions() {
		return listQuestions;
	}

	public void setListQuestions(ArrayList<Question> listQuestions) {
		this.listQuestions = listQuestions;
	
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public QuestionBank(String nameQB, String parentQB) {
		super();
		this.nameQB = nameQB;
		this.parentQB = parentQB;
	}


}
