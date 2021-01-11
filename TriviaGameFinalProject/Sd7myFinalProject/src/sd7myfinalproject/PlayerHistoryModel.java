package sd7myfinalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerHistoryModel extends Switchable
{    
    ArrayList<String> nameList;
    ArrayList<String> scoreList;

    public String getPlayerNames()
    {
        createArray();
        readNameFile();
        readScoreFile();
        String nameString = getNameString(nameList);  
        return nameString;
    }        
    
    public String getPlayerScores()
    {
        String scoreString = getScoreString(scoreList);
        return scoreString;
    }        
    
    
    private void createArray()
    {
        nameList = new ArrayList<>();
        for (int i = 0; i < 10; i++) 
        {
            nameList.add(i, "-1");
        }
        
        scoreList = new ArrayList<>();
        for (int i = 0; i < 10; i++) 
        {
            scoreList.add(i, "-1");
        }
    }

    private void readNameFile() {
        // adapted from https://www.w3schools.com/java/java_files_read.asp
        int counter = 0;
        try {
            File myObj = new File(saveNameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                nameList.add(counter, data);
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    private void readScoreFile() {
        // adapted from https://www.w3schools.com/java/java_files_read.asp
        int counter = 0;
        try {
            File myObj = new File(saveScoreFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                scoreList.add(counter, data);
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    protected String getNameString(ArrayList<String> list) {
        String appendedStr = "";
        int count = 1;
        for (int i = 10; i >= 0; i--) {
            if (!list.get(i).equals("-1")) 
            {
                appendedStr = appendedStr + count + ". " + list.get(i) + "\n";
                count++;
            }
        }
        return appendedStr;
    }
    
    protected String getScoreString(ArrayList<String> list) {
        String appendedStr = "";
        for (int i = 10; i >= 0; i--) {
            if (!list.get(i).equals("-1")) 
            {
                appendedStr = appendedStr + list.get(i) + "\n";
            }
        }
        return appendedStr;
    }
    
    protected void deleteOldDataFromFile()
    {
        if(nameList.get(9) != null || scoreList.get(9) != null)
            {
                try {
                    removeFirstLine(saveNameFile);
                } catch (IOException ex) {
                    Logger.getLogger(CongratsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    removeFirstLine(saveScoreFile);
                } catch (IOException ex) {
                    Logger.getLogger(CongratsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    protected void removeFirstLine(String fileName) throws IOException {  
        // from https://stackoverflow.com/questions/13178397/how-to-remove-first-line-of-a-text-file-in-java/13178980#13178980
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");          
         //Initial write position                                             
        long writePosition = raf.getFilePointer();                            
        raf.readLine();                                                       
        // Shift the next lines upwards.                                      
        long readPosition = raf.getFilePointer();                             

        byte[] buff = new byte[1024];                                         
        int n;                                                                
        while (-1 != (n = raf.read(buff))) {                                  
            raf.seek(writePosition);                                          
            raf.write(buff, 0, n);                                            
            readPosition += n;                                                
            writePosition += n;                                               
            raf.seek(readPosition);                                           
        }                                                                     
        raf.setLength(writePosition);                                         
        raf.close();                                                          
    }  
}