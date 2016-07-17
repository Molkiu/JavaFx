/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author maste
 */
public class Metronome extends Parent {

    public Metronome() {

        ImageView fond_metronome = new ImageView(new Image(Metronome.class.getResourceAsStream("images/metronome.png")));
        fond_metronome.setFitHeight(40);
        fond_metronome.setPreserveRatio(true);

        ImageView aiguille = new ImageView(new Image(Metronome.class.getResourceAsStream("images/aiguille.png")));
        aiguille.setFitHeight(32);
        aiguille.setPreserveRatio(true);
        aiguille.setTranslateX(16);
        aiguille.setTranslateY(2);

        Rotate rotation = new Rotate(0, 3, 29);
        aiguille.getTransforms().add(rotation);

        
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 45)),
                new KeyFrame(new Duration(1000), new KeyValue(rotation.angleProperty(), -45))
        );

        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        this.getChildren().add(fond_metronome);
        this.getChildren().add(aiguille);
        this.setTranslateX(400);
        this.setTranslateY(200);
    }
}
