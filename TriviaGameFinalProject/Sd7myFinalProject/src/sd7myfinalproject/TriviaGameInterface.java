package sd7myfinalproject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;


public interface TriviaGameInterface 
{   
    public void namePopUp();
    
    public String setUpTextBox(String titleToSet, TextInputDialog textBox, int i);
    
    public void checkAnswer(String getAnswer, String incorrectAlertString, String capitalAnswer, String lowercaseAnswer, int addToTotal, Button button);
            
    public void checkWinLose(int total);
    
    public void congratsAlert();
    
    public void incorrectAlert(String contentText);
    
    public TextInputDialog createTextBox(Button button);
    
    public void resetGame();
   
    public String getAPI() throws MalformedURLException, IOException;

}