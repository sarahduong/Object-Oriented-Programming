package sd7myfinalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TriviaGameModel extends Switchable
{
    int totalAmount = 0;
    
    public void saveName(String saveName) 
    {
        // adapted from https://www.w3schools.com/java/java_files_create.asp
        File read = new File(saveNameFile);
        try {
            FileWriter w;
            w = new FileWriter(read, true);
            w.write(saveName + "\n");
            w.close();
        } catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
   
    public void saveScore(int saveScore) 
    {
        // adapted from https://www.w3schools.com/java/java_files_create.asp
        File read = new File(saveScoreFile);
        try {
            FileWriter w;
            w = new FileWriter(read, true);
            w.write(saveScore + "\n");
            w.close();
        } catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void openFile() throws FileNotFoundException, IOException
    { 
        // adapted from https://www.w3schools.com/java/java_files_read.asp
        try
        {
            list = new ArrayList<>();
            File myObj = new File(fileToRead);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                list.add(data);
           }
          myReader.close();
        } 
        catch (FileNotFoundException e)
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    } 
    
    public String winOrLose()
    {
        String result = null;
        if(getTotalAmount() >= 450)
        {
            result = "win";
        }
        if(buttonCheck >= 12 && getTotalAmount() < 450)
        {
            result = "lose";
        }
        return result;
    }
    
    public int getTotalAmount()
    {
        return totalAmount; 
    }
    
    public void setTotalAmount(int value)
    {
        totalAmount = totalAmount + value;
    }  
}