/*package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class FiledocxFormat {
	public static void main(String[] args) throws IOException {
	    // Create Blank document
	    XWPFDocument document = new XWPFDocument();
	    // Create new Paragraph
	    XWPFParagraph paragraph1 = document.createParagraph();
	    XWPFRun run = paragraph1.createRun();
	    run.setText("Paragraph 1: stackjava.com");
	    
	    XWPFParagraph paragraph2 = document.createParagraph();
	    run = paragraph2.createRun();
	    run.setText("Paragraph 2: demo read/write file MS-Word");
	    
	    // Write the Document in file system
	    FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Administrator\\Pictures\\demo-apache-apoi-word.docx"));
	    document.write(out);
	    out.close();
	    document.close();
	    System.out.println("successully");
	  }
}*/
package model;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.aspose.*;
import com.aspose.words.FileFormatUtil;
import com.aspose.words.NodeType;
import com.aspose.words.Shape;

import DB.FileChoiceGrade;
import DB.fileQuesIcon;

import com.aspose.words.Document;
import com.aspose.words.NodeCollection;


public class FiledocxFormat {
	
	private int temp_1, tmp,tap ;	
	private ArrayList<ImageIcon> iconList = new  ArrayList();
	private ArrayList<String> path = new  ArrayList();
	public ArrayList<Question> format(File file , String text){
		
	      ArrayList<Question> questions = new ArrayList<>();
	      Scanner scanner= new Scanner(text);
	      ArrayList<String> q= new ArrayList<>();
//	      int count = 0;
//	      int countLine = 2;
	      tmp=0;
	      temp_1=0;

	      
	      while(scanner.hasNextLine()) {
	    	  
	    	  String line=scanner.nextLine();
	    	  String tex="";
	    	  if(line==null) {
	    		  break;
	    	  }
	    	 
	    	  if(line.isBlank() || line.isEmpty() ) {
	    		  temp_1++;
	    		  continue;
	    		  
	    	  }
	    	  int temp =0;
	    	  Document doc ;
				try {
					path = new  ArrayList();
					 iconList = new  ArrayList();
					doc = new Document(file.getAbsolutePath());
					NodeCollection<Shape> shapes = (NodeCollection<Shape>) doc.getChildNodes(NodeType.SHAPE, true);
					int imageIndex = 0;

					// Loop through the shape collection
					for (Shape shape : shapes) {
					  
					    // Check if shape has image
					    if (shape.hasImage()) {
					      
					        // Extract and save the image
					        String imageFileName = String.format("Image"+temp, imageIndex, FileFormatUtil.imageTypeToExtension(shape.getImageData().getImageType()));
					        System.out.println(imageFileName);
					        shape.getImageData().save("C:\\Users\\Administrator\\"  + imageFileName+".png");
					        ImageIcon icon_1 = new ImageIcon("C:\\Users\\Administrator\\"  + imageFileName+".png");
					        iconList.add(icon_1);
					        path.add("C:\\Users\\Administrator\\"  + imageFileName+".png");
					        
					        temp++;
//					        textPaneCateInfor.insertIcon(icon_1);
					        imageIndex++;
					    }
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	    	 
	    	  while(!line.trim().equalsIgnoreCase("ANSWER: A".trim()) &&!line.trim().equalsIgnoreCase("ANSWER: B".trim())&&!line.trim().equalsIgnoreCase("ANSWER: C".trim()) 
	    			  &&!line.trim().equalsIgnoreCase("ANSWER: D".trim()) &&!line.trim().equalsIgnoreCase("ANSWER: E".trim()) ){
	    		  
	    		  tex= tex+line+"\n";
	  //  		  temp=temp+1;
	    		  System.out.println("số vòng lặp là "+temp);
//	    		  System.out.println(tex);	    		  
	    		  
//	    		  System.out.println(scanner.nextLine());
	    		  /*if(!scanner.hasNextLine()) {
	    			  JOptionPane.showMessageDialog(null, "Không có ANSWER tại dòng thứ "+countLine);
	    			  break;
	    		  }*/
	    		  line=scanner.nextLine();
	    		 /* if( line.isBlank() || line.isEmpty()) {
	    			  JOptionPane.showMessageDialog(null, "Không có ANSWER tại dòng thứ "+countLine);
	    			  break;
	    		  }
	    		  else {
	    			  countLine ++;
	    			  
	    		  }*/
	    		  
	    	  }
	    	 
	    	  tex=tex+line;
//	    	  System.out.println(tex);	 
	    	  if(!tex.isBlank() && !tex.isEmpty()) {
	    		  q.add(tex);
	    		  tmp++;
	    		  temp_1=0;
	    	  }
	    	  else System.out.println("abcvvdvf");
	      }
	    int demdong=0;
	    String loi= "Error at: ";
	    System.out.println(q);
        for(String qs: q) {
        	System.out.println(qs);
        	Scanner sc= new Scanner(qs);
        	System.out.println(1002);
        	String line= sc.nextLine();
        	System.out.println(1002);
        	demdong++;
        	String name= line.substring(0,line.indexOf('.'));
        	System.out.println(1002);
        	String cauHoi= line.substring(line.indexOf('.')+1).trim();
        	
        	System.out.println(line);
        	line=sc.nextLine();
        	if(q.get(0).equals(qs)) {
        	   line=sc.nextLine();
        	}
        	demdong++;
        	System.out.println(line);
        	while(line.trim().charAt(0)!='A' && line.trim().charAt(0)!='a'
        			&&line.trim().charAt(0)!='B' && line.trim().charAt(0)!='b'
	    					  &&line.trim().charAt(0)!='C' && line.trim().charAt(0)!='c'
	    					  &&line.trim().charAt(0)!='D' && line.trim().charAt(0)!='d'
	    					  &&line.trim().charAt(0)!='E' && line.trim().charAt(0)!='e') {
        		cauHoi=cauHoi+"<br>"+line;
        		line=sc.nextLine();
        		demdong++;
        	}
        	
        	ArrayList<String> choices= new ArrayList<>();
        	
        	while(!line.trim().equalsIgnoreCase("ANSWER: A".trim()) &&!line.trim().equalsIgnoreCase("ANSWER: B".trim())&&!line.trim().equalsIgnoreCase("ANSWER: C".trim()) 
	    			  &&!line.trim().equalsIgnoreCase("ANSWER: D".trim()) &&!line.trim().equalsIgnoreCase("ANSWER: E".trim())){
        		choices.add(line);
        		line= sc.nextLine();
        		demdong++;
        	}
        	
        	String answer = line;       	
        	
 //       	System.out.println(answer);
        	if(!check(name,cauHoi,choices,answer)) {
        		loi+=demdong+" ";
        		System.out.println(169);
        		continue;
        	}else {
        		Question ques= new Question(name, cauHoi, choices);
        		ques.setAnswer(answer);
        		IconofQuestion iconOfQuestion = new IconofQuestion(ques);
        		iconList.remove(iconList.size()-1);
        		System.out.println(iconList.size());
        		iconOfQuestion.setIconList(iconList);
        		path.remove(path.size()-1);
        		System.out.println(path.size());
        		iconOfQuestion.setPath(path);
        		try {
					ArrayList<IconofQuestion> arrayListQues = new fileQuesIcon().docIconList();
					arrayListQues.add(iconOfQuestion);
					new fileQuesIcon().ghiIconList(arrayListQues);
			} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
        		System.out.println(iconOfQuestion.getPath());
        		
        		ChoiceGrade choiceGrade = new ChoiceGrade(ques);
        		ArrayList<String> listChoiceGrade = new ArrayList();
        		System.out.println(101456);
        		System.out.println(choices.size());
        		for(int i = 0; i < choices.size(); i++) {
        			
        			listChoiceGrade.add("None");
        			System.out.println(10147);
        		}
        		if(answer.charAt(answer.length()-1) == 'A') {
        			
    				listChoiceGrade.add(0, "100%");
    				
    			}
        		if(answer.charAt(answer.length()-1) == 'B') {
        			listChoiceGrade.add(1, "100%");
    				
    			}
        		if(answer.charAt(answer.length()-1) == 'C') {
        			listChoiceGrade.add(2, "100%");
    				
    			}
        		if(answer.charAt(answer.length()-1) == 'D') {
        			listChoiceGrade.add(3, "100%");
    				
    			}
        		if(answer.charAt(answer.length()-1) == 'E') {
        			listChoiceGrade.add(4, "100%");
    				
    			}
        		System.out.println(101456);
        		choiceGrade.setListGrade(listChoiceGrade);
        		
           	 	try {
        			ArrayList<ChoiceGrade> arrayListQues = new FileChoiceGrade().docChoiceGradeList();
        			arrayListQues.add(choiceGrade);
        			new FileChoiceGrade().ghiChoiceGradeList(arrayListQues);
        			
        			
        		} catch (FileNotFoundException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (ClassNotFoundException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
           	    
            	questions.add(ques);
            	System.out.println(175);
        	}
        	
        	
        }
        System.out.println(177);
        if(loi.equals("Error at: " )) {
        	if(!q.isEmpty()) {
        	System.out.println(167);
        	JOptionPane.showMessageDialog(null, "Không có lỗi nào!");
        	}
        }else {
        	System.out.println(168);
        	JOptionPane.showMessageDialog(null, loi);
        }
        System.out.println(questions);
        return questions;
    }
	
	public boolean check(String name, String cauHoi, ArrayList<String> choices, String answer) {
		
		if(name==null || name.equalsIgnoreCase("")) {
			System.out.println(1);
			return false;
		}
		if(cauHoi==null || cauHoi.equalsIgnoreCase("")) {
			System.out.println(2);
			return false;
		}
		if(choices==null ||choices.size()<2) {
			System.out.println(3);
			return false;
		}
		if(answer==null) {
			System.out.println(4);
			return false;
		}
		String[] answerList= {"ANSWER: A", "ANSWER: B", "ANSWER: E", "ANSWER: C", "ANSWER: D"};
		int temp = 0;
		for(int i = 0; i < 5; i++) {
			System.out.println(i+6);
			if(answer.trim().equalsIgnoreCase(answerList[i].trim())) {
				System.out.println(answer);
				System.out.println(answerList[i]);
				temp++;
			}			
		}
		if(temp==0) {
			return false;
		}						
		return true;
		
	}
}
	
