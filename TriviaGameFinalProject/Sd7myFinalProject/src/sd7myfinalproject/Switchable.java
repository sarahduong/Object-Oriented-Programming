// Switchable.java adapted from in code class
package sd7myfinalproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public abstract class Switchable {
    public static Scene scene;
    public static final HashMap<String, Switchable> controllers = new HashMap<>();
    private Parent root;  
    String getAnswer = "";
    String getName = "";
    FileInputStream readFile;
    static ArrayList<String> list; 
    static public int buttonCheck;
    String fileToRead = System.getProperty("user.dir") + "\\" + "javaReadFile.txt";
    String saveNameFile = System.getProperty("user.dir") + "\\" + "saveName.txt";
    String saveScoreFile = System.getProperty("user.dir") + "\\" + "saveScore.txt";
    
    
    public static Switchable add(String name) {
        Switchable controller; 
        
        controller = controllers.get(name); 
        
        if(controller == null){
            try {
                
                FXMLLoader loader = new FXMLLoader(Switchable.class.getResource(name + ".fxml"));
                 
                Parent root = loader.load();
                
                controller = loader.getController(); 
                
                controller.setRoot(root); 
                
                controllers.put(name, controller); 
                
            } catch (IOException ex) {
                Logger.getLogger(Switchable.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            } catch (Exception ex){
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            }
        }
        return controller; 
    }
    
    public static void switchTo(String name) {
        Switchable controller = controllers.get(name); 
        
        if(controller == null){
            controller = add(name); 
        }
        
        if(controller != null){
            if(scene != null){
                scene.setRoot(controller.getRoot());
            }
        }
    }
    
    public void setRoot(Parent root) {
        this.root = root;
    }
    
    public Parent getRoot() {
        return root;
    }
    
    public static Switchable getControllerByName(String name) {
        return controllers.get(name);
    }
}