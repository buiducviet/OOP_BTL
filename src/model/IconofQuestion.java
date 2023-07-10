package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.itextpdf.text.Image;

public class IconofQuestion implements Serializable{
	
	private ArrayList<ImageIcon> iconList;
	private Question question;
	private ArrayList<String> path;
	
	public ArrayList<ImageIcon> getIconList() {
		return iconList;
	}
	public void setIconList(ArrayList<ImageIcon> iconList) {
		this.iconList = iconList;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public IconofQuestion(Question question) {
		super();
		this.question = question;
		this.iconList = iconList;
		this.path = path;
	}
	public ArrayList<String> getPath() {
		return path;
	}
	public void setPath(ArrayList<String> path) {
		this.path = path;
	}
	
}
