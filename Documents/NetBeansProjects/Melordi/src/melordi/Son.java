/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import java.util.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;

/**
 *
 * @author maste
 */
public class Son extends Parent {

    public Slider slider;
    private Clavier clavier;

    public Son(Clavier clv) {
        clavier=clv;
        slider = new Slider(0, 127, 60);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setTranslateY(35);
        slider.valueProperty().addListener(new ChangeListener(){
            @Override public void changed(ObservableValue o,Object oldVal,Object newVal){
                clavier.requestFocus();
            }
        });

        ProgressIndicator indicateur = new ProgressIndicator(0.0);
        indicateur.progressProperty().bind(slider.valueProperty().divide(127.0));

        this.getChildren().add(slider);
        this.getChildren().add(indicateur);
        this.setTranslateX(60);
        this.setTranslateY(260);
    }
}
