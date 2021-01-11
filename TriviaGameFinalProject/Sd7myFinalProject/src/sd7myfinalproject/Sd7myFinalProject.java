// Sd7myFinalProject.java file adapted from in class code
package sd7myfinalproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sd7myFinalProject extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // UI if SceneManager can't switch to a Scene
        HBox root = new HBox();
        root.setPrefSize(600, 400);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("This is a failure!");
        message.setFont(Font.font(STYLESHEET_MODENA, 32));
        root.getChildren().add(message);
        
        // create Scene and init UI to show failure in case switch fails
        Scene scene = new Scene(root);
        
        Switchable.scene = scene; 
        Switchable.switchTo("About");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}