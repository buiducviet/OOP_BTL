package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.IconofQuestion;
import model.TimeLimitOfQuiz;

public class fileTimeLimitQuiz {
	File f= new File("DsTimeLimitQuiz.DAT");
	 public void ghiTimeLimit(ArrayList<TimeLimitOfQuiz> list)
     {
         try{
             if(!f.exists()) {
                 f.createNewFile();
                 System.out.println(10000000);                 
             }
             
             FileOutputStream fo= new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fo);
             oos.writeObject(list);
             oos.close();
             fo.close();
         }   
         catch(Exception e){} 
     }
     
     public ArrayList<TimeLimitOfQuiz> docTimeLimit() throws FileNotFoundException, IOException, ClassNotFoundException
     {
         if(!f.exists())
             return new ArrayList<TimeLimitOfQuiz>();
         FileInputStream fi= new FileInputStream(f);
         ObjectInputStream ois =new  ObjectInputStream(fi);
         ArrayList<TimeLimitOfQuiz> l= (ArrayList<TimeLimitOfQuiz>)ois.readObject(); 
         ois.close();
         fi.close();
         return (ArrayList<TimeLimitOfQuiz>)l;
     }
    
     

}
