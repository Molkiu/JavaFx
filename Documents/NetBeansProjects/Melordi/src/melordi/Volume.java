/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;

/**
 *
 * @author maste
 */
public class Volume extends Parent {
    protected Slider slider;
    
    public Volume(){
    slider = new Slider(0,127,60);
    slider.setOrientation(Orientation.VERTICAL);
    slider.setTranslateY(35);
    
    ProgressIndicator indicateur = new ProgressIndicator(0.0);
    indicateur.progressProperty().bind(slider.valueProperty().divide(127.0));
    
    this.getChildren().add(slider);
    this.getChildren().add(indicateur);
    this.setTranslateX(60);
    this.setTranslateY(260);
    }
}
