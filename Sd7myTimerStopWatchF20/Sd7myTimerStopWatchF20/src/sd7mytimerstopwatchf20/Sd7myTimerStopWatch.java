
package sd7mytimerstopwatchf20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sd7myTimerStopWatch extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Clock clockStopWatch = new Clock();
        
        Scene scene = new Scene(clockStopWatch.getRootContainer(), 300, 440);
        
        primaryStage.setTitle("StopWatch");
        primaryStage.setScene(scene);

        clockStopWatch.setTickTimeInSeconds(0.01); // smooth second hand
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}