package sd7mytimerstopwatchf20;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

// initial build of program/skeleton from MyNewStopWatch code used in class

public class Clock {
    private double secondsElapsed = 0.0;
    private double tickTimeInSeconds = 1; // change resolution
    private double angleDeltaPerSeconds = 6.0; // angle between each keyframe
    private int minutes = 0;
    private Timeline timeline;
    private KeyFrame keyFrame;
    double totalSeconds = 0.0;
    int recordClickCount = 0;
    int realRecordCount = 0;
    Label digitalTime = new Label("");
    Label timerText = new Label("");
    double timerNum;
    Label recordTextOne = new Label("");
    Label recordTextTwo = new Label("");
    Label recordTextThree = new Label("");
    TextInputDialog textBox;
    private double secondsElapsed1 = 0.0;
    private int minutes1 = 0;
    private double secondsElapsed2 = 0.0;
    private int minutes2 = 0;
    private double secondsElapsed3 = 0.0;
    private int minutes3 = 0;
    private double prevSecondsElapsed = 0.0;
    private GridPane rootContainer;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private String handImageName;
    private String dialImageName;
    Button start = new Button("Start");
    Button stop = new Button("Stop");
    Button reset = new Button("Reset");
    Button record = new Button("Record");
    
    public Clock()
    {
        minutes = 0;
        secondsElapsed = 0.0;
        tickTimeInSeconds = 1; // change resolution
        angleDeltaPerSeconds = 6.0; // angle between each keyframe
        dialImageName = "clockface.png";
        handImageName = "hand.png";
        setupUI();
    }
    
    private void setupUI()
    {   
        rootContainer = new GridPane();
        rootContainer.setPadding(new Insets(10, 20, 10, 20));
        dialImageView = new ImageView();
        handImageView = new ImageView();    
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        timerText.setFont(new Font("Arial", 14));
        digitalTime.setFont(new Font("Arial", 24));
        recordTextOne.setFont(new Font("Arial", 14));
        recordTextTwo.setFont(new Font("Arial", 14));
        recordTextThree.setFont(new Font("Arial", 14));
        handImageView.setRotate(0);
        GridPane.setColumnSpan(dialImageView, 2);
        GridPane.setHalignment(dialImageView, HPos.CENTER);
        GridPane.setColumnSpan(handImageView, 2);
        GridPane.setHalignment(handImageView, HPos.CENTER);
        // extra button styling
        start.setStyle("-fx-background-color: #b8ffc4; "); 
        stop.setStyle("-fx-background-color: #ffbcb8; "); 
        reset.setStyle("-fx-background-color: #a4e0de; ");
        record.setStyle("-fx-background-color: #a4e0de; ");
        
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        HBox controlButtons = new HBox();
        recordTextOne.setText(String.format("Rec 00 %02d:%05.2f", minutes1, secondsElapsed1));
        recordTextTwo.setText(String.format("Rec 00 %02d:%05.2f", minutes2, secondsElapsed2));
        recordTextThree.setText(String.format("Rec 00 %02d:%05.2f", minutes3, secondsElapsed3));
               
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        reset.setMaxWidth(Double.MAX_VALUE);
        start.setOnAction((ActionEvent e) -> {
            timeline.play();
        });
        reset.setOnAction((ActionEvent e) -> {
            handImageView.setRotate(0);
            minutes = 0;
            minutes1 = 0;         
            minutes2 = 0;
            minutes3  = 0;
            timerNum = 0;
            secondsElapsed = 0;                   
            secondsElapsed1 = 0;
            secondsElapsed2 = 0;
            secondsElapsed3 = 0;
            recordClickCount = 0;
            digitalTime.setText(String.format("%02d:%05.2f", minutes, secondsElapsed));
            timerText.setText(String.format("Timer: %05.2f", timerNum));
            recordTextOne.setText(String.format("Rec 00 %02d:%05.2f", minutes1, secondsElapsed1));
            recordTextTwo.setText(String.format("Rec 00 %02d:%05.2f", minutes2, secondsElapsed2));
            recordTextThree.setText(String.format("Rec 00 %02d:%05.2f", minutes3, secondsElapsed3));
        });
        stop.setOnAction((ActionEvent e) -> {
            timeline.pause();
        });
        
        record.setOnAction((ActionEvent e) -> {
            recordClickCount++;
            realRecordCount++;
            if(timerNum > 0)
            {
                double calcDiff = 0;
                if(recordClickCount == 1)
                {
                    calcDiff = secondsElapsed - prevSecondsElapsed;
                    recordTextOne.setText(String.format("Rec 0%d %02d:%05.2f", realRecordCount, minutes1, calcDiff));
                    prevSecondsElapsed = secondsElapsed;
                }
                if(recordClickCount == 2)
                {         
                    calcDiff = secondsElapsed - prevSecondsElapsed;
                    recordTextTwo.setText(String.format("Rec 0%d %02d:%05.2f", realRecordCount, minutes2, calcDiff));
                    prevSecondsElapsed = secondsElapsed;
                }    
                if(recordClickCount == 3)
                {
                    calcDiff = secondsElapsed - prevSecondsElapsed;
                    recordTextThree.setText(String.format("Rec 0%d %02d:%05.2f", realRecordCount, minutes3, calcDiff));
                    recordClickCount = 0; 
                    prevSecondsElapsed = secondsElapsed;
                }
            }
            else // if timerNum less than of equal to zero
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Time is up!!!");
                alert.setHeaderText("Time is up!!!");
                alert.setContentText("Time is up... No more records");
                alert.show();
            }
        });
        
        // Alignment
        VBox records = new VBox();
        records.setAlignment(Pos.BOTTOM_RIGHT);
        records.getChildren().addAll(recordTextOne, recordTextTwo, recordTextThree);
        
        
        VBox time = new VBox();
        time.setAlignment(Pos.BOTTOM_LEFT);
        time.getChildren().addAll(digitalTime, timerText);
        
        GridPane.setColumnIndex(records, 1);
        GridPane.setColumnIndex(time, 0);
        GridPane.setRowIndex(records, 1);
        GridPane.setRowIndex(time, 1);
        
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25, 25, 25, 25));
        controlButtons.getChildren().addAll(stop, reset, start, record);
        controlButtons.toFront(); // bring buttons toward user
        
        GridPane.setRowIndex(controlButtons, 3);
        GridPane.setColumnSpan(controlButtons, 2);
        
        // Digital Time
        digitalTime.setText(String.format("%02d:%05.2f", minutes, secondsElapsed)); 
        
        rootContainer.getChildren().addAll(dialImageView, handImageView, time, records, controlButtons);
    }
    
    public void setupTimer() 
    {
        try // check if out of bounds
        {
            textBox = new TextInputDialog();
            textBox.setTitle("Timer Start Time Set Up");
            textBox.setHeaderText("Set up the start time:");
            textBox.setContentText("Please set up the start time (integer): ");
            if(textBox.getEditor().getText().isEmpty())
            {
                textBox.showAndWait();
            }
            timerNum = Integer.parseInt(textBox.getEditor().getText());

            int x = Integer.parseInt(textBox.getEditor().getText());
            if(x < 0 || x > 60)
            {
                setupTimer();
            } 
            
            if(isRunning()) {
                timeline.stop();
            }
            keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
                update();  
            });

            timeline = new Timeline(keyFrame);
            timeline.setCycleCount(Animation.INDEFINITE);

            if(!isRunning()) {
                timeline.play();
            }
        }
        catch (Exception NumberFormatException)
        {
               setupTimer(); // call again if it they enter the wrong input
        }
    }

    public void update() {
        secondsElapsed = secondsElapsed + tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);
        if(secondsElapsed >= 60)
        {
            secondsElapsed = 0;
            minutes++;
        }
        digitalTime.setText(String.format("%02d:%05.2f", minutes, secondsElapsed));
        
        Integer.parseInt(textBox.getEditor().getText()); // get text
        
        timerNum = timerNum - 0.01;
        timerText.setText(String.format("Timer: %05.2f", timerNum));
        if(timerNum <= 0)
        {
            timerText.setText("Time's Up!");
            recordTextOne.setText("Rec 00 00:00.00");
            recordTextTwo.setText("Rec 00 00:00.00");
            recordTextThree.setText("Rec 00 00:00.00");
        }
    }
    
    public boolean isRunning() {
        if(timeline != null)
        {
            if(timeline.getStatus() == Animation.Status.RUNNING) {
                return true;
            }
        }
        return false;
    }
    
    public Parent getRootContainer() {
        return rootContainer;
    }
    
    public Double getWidth() {
        if (dialImage != null) return dialImage.getWidth();
        else return 0.0;
    }
    
    public Double getHeight() {
        if (dialImage != null) return dialImage.getHeight();
        else return 0.0;       
    }
    
    public void start() {
        timeline.play();
    }
    
    public void setTickTimeInSeconds(Double tickTimeInSeconds) {
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer();
    }
}
