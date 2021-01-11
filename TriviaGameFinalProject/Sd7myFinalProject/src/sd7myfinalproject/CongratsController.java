package sd7myfinalproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class CongratsController extends Switchable implements Initializable {

    @FXML
    public Text nameText; 
    @FXML
    public Text scoreText;
    PlayerHistoryModel playerHistoryModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        playerHistoryModel = new PlayerHistoryModel(); 
        String names = playerHistoryModel.getPlayerNames();
        String scores = playerHistoryModel.getPlayerScores();
        loadInfoToScreen(names, scores);
        // no updating of data required from model (read only data used), so firePropertyChange not needed
    }

    private void loadInfoToScreen(String names, String scores) 
    {
        nameText.setText(names);
        scoreText.setText(scores);
        playerHistoryModel.deleteOldDataFromFile();
    }
    
    @FXML
    private void exitGame(ActionEvent event)
    {
        System.exit(0);
    }
}