/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author maste
 */
public class Melordi extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Melordi");
        Group root = new Group();        
        Scene scene = new Scene(root, 500, 500,Color.WHITE);
        
        Instru monInstru = new Instru();
        Clavier monClavier = new Clavier(monInstru);
        ChangeInstrument monChangeInstru = new ChangeInstrument(monInstru);
        Son monSon = new Son(monClavier);
        Metronome monMetronome = new Metronome();
        monInstru.volume.bind(monSon.slider.valueProperty());

        root.getChildren().add(monClavier);
        root.getChildren().add(monChangeInstru);        
        root.getChildren().add(monSon);
        root.getChildren().add(monMetronome);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        monClavier.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
