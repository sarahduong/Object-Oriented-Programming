package sd7myfinalproject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

public class TriviaGameController extends Switchable implements Initializable, TriviaGameInterface{
    @FXML
    private Button hundredButton1;
    @FXML
    private Button hundredButton2;
    @FXML
    private Button hundredButton3;
    @FXML
    private Button fiftyButton1;
    @FXML
    private Button fiftyButton2;
    @FXML
    private Button fiftyButton3;
    @FXML
    private Button twentyButton1;
    @FXML
    private Button twentyButton2;
    @FXML
    private Button twentyButton3;
    @FXML
    private Button tenButton1;
    @FXML
    private Button tenButton2;
    @FXML
    private Button tenButton3;
    @FXML
    private Text totalAmountText;
    @FXML
    private Text welcomeText;
    TextInputDialog textBox;
    TriviaGameModel model;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        model = new TriviaGameModel();
        buttonCheck = 0;
        namePopUp();
        welcomeText.setText("Welcome, " + getName + "!");
    }
    
    @FXML
    private void handleGoToA(ActionEvent event) 
    {
        Switchable.switchTo("About");
    }

    @FXML
    private void click100Left(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(hundredButton1);
        getAnswer = setUpTextBox("$100 Trivia Question", textBox, 0);
        checkAnswer(getAnswer, "A) Initializes fields in the object", "A", "a", 100, hundredButton1);
    }
    
    @FXML
    private void click100Center(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(hundredButton2);
        getAnswer = setUpTextBox("$100 Trivia Question", textBox, 5);
        checkAnswer(getAnswer, "The correct answer was: C) Function overloading", "C", "c", 100, hundredButton2);
    }


    @FXML
    private void click100Right(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(hundredButton3);
        getAnswer = setUpTextBox("$100 Trivia Question", textBox, 10);
        checkAnswer(getAnswer, "The correct answer was: B) super", "B", "b", 100, hundredButton3);
    }


    @FXML
    private void click50Left(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(fiftyButton1);
        getAnswer = setUpTextBox("$50 Trivia Question", textBox, 15);
        checkAnswer(getAnswer, "The correct answer was: A) Something that can only be true or false", "A", "a", 50, fiftyButton1);
    }
    
    @FXML
    private void click50Center(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(fiftyButton2);
        getAnswer = setUpTextBox("$50 Trivia Question", textBox, 20);
        checkAnswer(getAnswer, "The correct answer was: B) int.", "B", "b", 50, fiftyButton2);
    }
    
    @FXML
    private void click50Right(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(fiftyButton3);
        getAnswer = setUpTextBox("$50 Trivia Question", textBox, 25);
        checkAnswer(getAnswer, "The correct answer was: A) Create an instance of an object", "A", "a", 50, fiftyButton3);
    }


    @FXML
    private void click20Left(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(twentyButton1);
        getAnswer = setUpTextBox("$20 Trivia Question", textBox, 30);
        checkAnswer(getAnswer, "The correct answer was: C) Store elements of the same type", "C", "c", 20, twentyButton1);
    }


    @FXML
    private void click20Center(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(twentyButton2);
        getAnswer = setUpTextBox("$20 Trivia Question", textBox, 35);
        checkAnswer(getAnswer, "The correct answer was: Compares two values", "C", "c", 20, twentyButton2);
    }
    
    @FXML
    private void click20Right(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(twentyButton3);
        getAnswer = setUpTextBox("$20 Trivia Question", textBox, 40);
        checkAnswer(getAnswer, "The correct answer was: Assigning a value to a variable", "B", "b", 20, twentyButton3);
    } 


    @FXML
    private void click10Left(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(tenButton1);
        getAnswer = setUpTextBox("$10 Trivia Question", textBox, 45);
        checkAnswer(getAnswer, "The correct answer was: D) String", "D", "d", 10, tenButton1);
    }


    @FXML
    private void click10Center(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(tenButton2);
        getAnswer = setUpTextBox("$10 Trivia Question", textBox, 50);
        checkAnswer(getAnswer, "C) Object Oriented Programming", "C", "c", 10, tenButton2);
    }


    @FXML
    private void click10Right(ActionEvent event) 
    {
        buttonCheck++;
        textBox = createTextBox(tenButton3);
        getAnswer = setUpTextBox("$10 Trivia Question", textBox, 55);
        checkAnswer(getAnswer, "The correct answer was: A) Method", "A", "a", 10, tenButton3);
    }
    
    @Override
    public void namePopUp()
    {
        try
        {
            TextInputDialog textBox = new TextInputDialog();
            textBox.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true); // reference from https://stackoverflow.com/questions/31351103/javafx-textinputdialog-disable-ok-button
            textBox.setTitle("Player Name");
            textBox.setContentText("Please enter your name here:");
            textBox.showAndWait();
            getName = textBox.getEditor().getText();
            if(getName.isEmpty() == false)
            {
                try
                {                 
                    model.openFile();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(TriviaGameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("No input received. Please enter a name.");
                alert.showAndWait();
                namePopUp();
            }
        }
        catch(NumberFormatException e)
        {   
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("No input received. Please enter a name.");
            alert.showAndWait();
            namePopUp();
        }
    }


    @Override
    public String setUpTextBox(String titleToSet, TextInputDialog textBox, int i)
    {
        String n = System.lineSeparator();
        try
        {
            textBox.setTitle(titleToSet);
            textBox.setHeaderText(list.get(i) + n + list.get(i+1) + n + list.get(i+2) + n + list.get(i+3) + n + list.get(i+4));
            textBox.setContentText("Please type A, B, C, or D: ");
            textBox.showAndWait();
            getAnswer = String.valueOf(textBox.getEditor().getText());
            if(getAnswer.equals("A") || getAnswer.equals("a") || getAnswer.equals("B") || getAnswer.equals("b") || getAnswer.equals("C") || getAnswer.equals("c") || getAnswer.equals("D") || getAnswer.equals("d"))
            {
                return getAnswer = String.valueOf(textBox.getEditor().getText());
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Not a valid input. Please type A, B, C, or D:");
                alert.showAndWait();
                setUpTextBox(titleToSet, textBox, i);
            }
        }
        catch(NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Not a valid input. Please type A, B, C, or D:");
            alert.showAndWait();
            setUpTextBox(titleToSet, textBox, i);
        }  
        return getAnswer;
    }     
    
    @Override
    public void checkAnswer(String getAnswer, String incorrectAlertString, String capitalAnswer, String lowercaseAnswer, int addToTotal, Button button)
    {
        if(getAnswer.equals(capitalAnswer)|| getAnswer.equals(lowercaseAnswer))
        {
            model.setTotalAmount(addToTotal);
            totalAmountText.setText("$" + model.getTotalAmount());
            checkWinLose(model.getTotalAmount());
            congratsAlert();
            button.setStyle("-fx-base: #90FF60;");
        }
        else
        {
            incorrectAlert(incorrectAlertString);
            checkWinLose(model.getTotalAmount());
            button.setStyle("-fx-base: #FD3E3E;");
        }        
    }

    
    @Override
    public void checkWinLose(int total)
    {
        if(model.winOrLose() == "win")
        {
            model.saveName(getName);
            model.saveScore(total);
            Switchable.switchTo("Congrats");
            resetGame();
        }
        if(model.winOrLose() == "lose")
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sorry, you lost");
            alert.showAndWait();
            Switchable.switchTo("Lost");
        }
    }
    
    @Override
    public void congratsAlert()
    {
        if(buttonCheck != 12 && model.getTotalAmount() < 450)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Keep it up! Here's a little inspiration to keep you going strong: ");
            QuotesModel quote = new QuotesModel();
            String setQuote = quote.getQuote();
            alert.setContentText(setQuote);
            alert.show();
        }
    }
    
    @Override
    public void incorrectAlert(String contentText)
    {
        if(buttonCheck != 12)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sorry, try again next time!!!");
            alert.setContentText(contentText);
            alert.show();
        }
    }
    
    @Override
    public TextInputDialog createTextBox(Button button)
    {
        TextInputDialog textBox = new TextInputDialog();
        textBox.getDialogPane().lookupButton(ButtonType.CANCEL).setDisable(true); // reference from https://stackoverflow.com/questions/31351103/javafx-textinputdialog-disable-ok-button
        button.setDisable(true);
        return textBox;
    }
    
    @Override
    public void resetGame()
    {
        hundredButton1.setDisable(false);
        hundredButton2.setDisable(false);
        hundredButton3.setDisable(false);
        fiftyButton1.setDisable(false);
        fiftyButton2.setDisable(false);
        fiftyButton3.setDisable(false);
        twentyButton1.setDisable(false);
        twentyButton2.setDisable(false);
        twentyButton3.setDisable(false);
        tenButton1.setDisable(false);
        tenButton2.setDisable(false);
        tenButton3.setDisable(false);
        totalAmountText.setText("$0");
    }
    
    @Override
    public String getAPI() throws MalformedURLException, IOException
    {	
        QuotesModel myQuote = new QuotesModel();
        String quote = myQuote.getQuote();
        return quote = ("A little inspiration to keep you going: " + "\n" + quote);
    }  
}