package DB;

import java.io.File;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Quiz;


public class FileDsQuiz {
     File f=new File("DsQuiz.DAT");
     public void ghiQuiz(ArrayList<Quiz> list)
     {
         try{
             if(!f.exists())
                 f.createNewFile();
             FileOutputStream fo= new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fo);
             oos.writeObject(list);
             oos.close();
             fo.close();
         }   
         catch(Exception e){} 
     }
     
     public ArrayList<Quiz> docQuiz() throws FileNotFoundException, IOException, ClassNotFoundException
     {
         if(!f.exists())
             return new ArrayList<Quiz>();
         FileInputStream fi= new FileInputStream(f);
         ObjectInputStream ois =new  ObjectInputStream(fi);
         ArrayList<Quiz> l= (ArrayList<Quiz>)ois.readObject(); 
         ois.close();
         fi.close();
         return (ArrayList<Quiz>)l;
     }
    
     
}
