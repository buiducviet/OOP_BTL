package model;

import model.Question;


import model.Quiz;
import view.GUI3_2;

import java.awt.Dimension;
//import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import DB.FileDsQuiz;
import DB.fileQuesIcon;
public class Export {
	String name;
	String password;
	Document doc;
	public Export(String name)	
	{
		this.name=name;
	}
	public  Export(String name, String password)
	{
	this.name=name;
	this.password=password;
	}
	public void exportPdf()
	{
		
		String s="";
		Quiz quiz = null;
		try {
			ArrayList<Quiz> listquiz= new FileDsQuiz().docQuiz();
			for(Quiz q:listquiz) {
				if(q.getQuizName().trim().equals(name.trim())) {
					quiz= q;
				}
			}
		} catch (Exception e1) {
		}
		
		
		
		for(Question ques:quiz.getListQuestions())
		{	
			System.out.println(s);
			System.out.println("heest 1 s ");
//			System.out.println(ques.getQuestion());
			s=s+ques.getName()+": ";
			s=s+ques.getQuestion().replaceAll("\r\n", "")+"\n";
			
			for(String choice:ques.getListChoice())
			{
				s=s+choice+"\n";
			}
			if(!ques.isMultiple())
				s=s+ques.getAnswer();
			else
				s=s+"ANSWER: "+ques.getMultiAnswer();;
			s=s+"\n\n";
			try {
				String path=name+".pdf"; 
				doc = new Document();
				
				PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Administrator\\"+name+".pdf"));
				doc.open();
				BaseFont bf = BaseFont.createFont("UVNThoiNay_I.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				Font font = new Font(bf, 12f, Font.NORMAL, BaseColor.BLACK);
				Paragraph para = new Paragraph();				
				para.setFont(font);
				try {
					ArrayList<IconofQuestion> arrayListQues = new fileQuesIcon().docIconList();
					for(IconofQuestion i:arrayListQues) {
						int index;
						if (i.getQuestion().getName().equalsIgnoreCase(ques.getName()) && i.getQuestion().getQuestion().equalsIgnoreCase(ques.getQuestion())) {
							index=0;
							for(ImageIcon j : i.getIconList()) {
								//System.out.println("đây là " +j.getDescription());
								Image image = Image.getInstance(i.getPath().get(index));
								float newHeight = 10000;
								float scale = newHeight / image.getHeight();
								image.scalePercent(scale, scale);
								System.out.println(101211);
								doc.add(image);
								System.out.println(101213);
								index ++;
							}
						}

					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				para.add(s);
				doc.add(para);
				doc.close();
				
			}
		 catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		
		
	}
	public void expordPdfwithPass()
	{
		String s="";
		Quiz quiz = null;
		try {
			ArrayList<Quiz> listquiz= new FileDsQuiz().docQuiz();
			for(Quiz q:listquiz) {
				if(q.getQuizName().trim().equals(name.trim())) {
					quiz= q;
				}
			}
		} catch (Exception e1) {
		}
		for(Question ques:quiz.getListQuestions())
		{
			
			s=s+ques.getName()+": "+ques.getQuestion().replaceAll("\r\n", "")+"\n";
			for(String choice:ques.getListChoice())
			{
				s=s+choice+"\n";
			}
			if(!ques.isMultiple())
				s=s+ques.getAnswer();
			else
				s=s+"ANSWER: "+ques.getMultiAnswer();
			s=s+"\n\n";
			
			try {
				String path="C:\\Users\\Administrator\\"+name+".pdf"; 
				Document doc = new Document();
				PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
				pdfWriter.setEncryption(password.getBytes(),
						null, 
			                  PdfWriter.ALLOW_PRINTING, 
			                   PdfWriter.ENCRYPTION_AES_256);
				doc.open();
				BaseFont bf = BaseFont.createFont("UVNThoiNay_I.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				Font font = new Font(bf, 12f, Font.NORMAL, BaseColor.BLACK);
				Paragraph para = new Paragraph();
				para.setFont(font);
				para.add(s);
				doc.add(para);
				doc.close();
			}
			catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		 } catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		}
	}
}

