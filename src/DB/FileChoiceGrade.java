package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.ChoiceGrade;


public class FileChoiceGrade {
	File f= new File("DsChoiceGrade.DAT");
    public void ghiChoiceGradeList(ArrayList<ChoiceGrade>  list)
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
    
    public ArrayList<ChoiceGrade> docChoiceGradeList() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        if(!f.exists())
            return new ArrayList<ChoiceGrade>();
        FileInputStream fi= new FileInputStream(f);
        ObjectInputStream ois =new  ObjectInputStream(fi);
        ArrayList<ChoiceGrade> l= (ArrayList<ChoiceGrade>)ois.readObject(); 
        ois.close();
        fi.close();
        return (ArrayList<ChoiceGrade>) l;
    }

}
