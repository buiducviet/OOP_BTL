package model;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import DB.FileChoiceGrade;

public class FiletxtFormat {
	
	private int temp_1, tmp,tap ;	
	public ArrayList<Question> format(String text){
		
	      ArrayList<Question> questions = new ArrayList<>();
	      Scanner scanner= new Scanner(text);
	      ArrayList<String> q= new ArrayList<>();
//	      int count = 0;
//	      int countLine = 2;
	      tmp=0;
	      temp_1=0;

	      int countLine = 0;
	      while(scanner.hasNextLine()) {
	    	  String line=scanner.nextLine();
	    	  countLine++;
	    	  String tex="";
	    	  if(line==null) {
	    		  break;
	    	  }
	    	 
	    	  if(line.isBlank() || line.isEmpty() ) {
	    		  temp_1++;
	    		  countLine ++;
	    		  continue;
	    		  
	    		  
	    	  }	
	    	  
	    	  int temp =0;
	    	  while(!line.trim().equalsIgnoreCase("ANSWER: A".trim()) &&!line.trim().equalsIgnoreCase("ANSWER: B".trim())&&!line.trim().equalsIgnoreCase("ANSWER: C".trim()) 
	    			  &&!line.trim().equalsIgnoreCase("ANSWER: D".trim()) &&!line.trim().equalsIgnoreCase("ANSWER: E".trim()) ){
	    		  tex= tex+line+"\n";
	    		  temp=temp+1;
	    		  System.out.println("số vòng lặp là "+temp);
	    		  if(temp>10) {
	    			  tap=1;
	    			  break;
	    			  
	    		  }
//	    		  System.out.println(tex);	    		  
	    		  
//	    		  System.out.println(scanner.nextLine());
	    		  if(!scanner.hasNextLine()) {
	    			  JOptionPane.showMessageDialog(null, "Không có ANSWER tại dòng thứ "+countLine);
	    			  break;
	    		  }
	    		  line=scanner.nextLine();
	    		  if( line.isBlank() || line.isEmpty()) {
	    			  JOptionPane.showMessageDialog(null, "Không có ANSWER tại dòng thứ "+countLine);
	    			  break;
	    		  }
	    		  else {
	    			  countLine ++;
	    			  
	    		  }
	    		  
	    	  }
	    	  
	    	 
	    	  tex=tex+line;
	    	  System.out.println(tex);	 
	    	  if(!tex.isBlank() && !tex.isEmpty()) {
	    		  q.add(tex);
	    		  tmp++;
	    		  temp_1=0;
	    	  }
	    	  else System.out.println("abcvvdvf");
	      }
	    int demdong=0;
	    if(tap==1) {
	    	countLine=countLine-1;
	    	JOptionPane.showMessageDialog(null, "Lỗi answer ở dòng thứ: "+countLine);
	    }
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
        		System.out.println(101456);
        		Question ques= new Question(name, cauHoi, choices);
        		ques.setAnswer(answer);
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
        	JOptionPane.showMessageDialog(null, "Success "+q.size());
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
			if(answer.equalsIgnoreCase(answerList[i])) {
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
	