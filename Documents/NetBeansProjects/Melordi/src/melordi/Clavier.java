/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author maste
 */
public class Clavier extends Parent {

    private Touche[] touches;
    private Instru instru;

    public Clavier(Instru ins) {
        instru = ins;

        Rectangle fondClavier = new Rectangle();
        fondClavier.setWidth(400);
        fondClavier.setHeight(200);
        fondClavier.setArcWidth(30);
        fondClavier.setArcHeight(30);
        fondClavier.setFill(
                new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                        new Stop[]{
                            new Stop(0, Color.web("#333333")),
                            new Stop(1, Color.web("#000000")),}));
        Reflection r = new Reflection();
        r.setFraction(0.25);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        fondClavier.setEffect(r);

        this.setTranslateX(50);
        this.setTranslateY(250);
        this.getChildren().add(fondClavier);

        touches = new Touche[]{
            new Touche("U", 50, 20, 60, instru),
            new Touche("I", 128, 20, 62, instru),
            new Touche("O", 206, 20, 64, instru),
            new Touche("P", 284, 20, 65, instru),
            new Touche("J", 75, 98, 67, instru),
            new Touche("K", 153, 98, 69, instru),
            new Touche("L", 231, 98, 71, instru),
            new Touche("M", 309, 98, 72, instru)
        };
        for (Touche t : touches) {
            this.getChildren().add(t);
        }

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                for (Touche touche : touches) {
                    if (touche.lettre.equals(ke.getText().toUpperCase())) {
                        touche.appuyer();
                    }
                }
            }
        });

        this.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                for (Touche touche : touches) {
                    if (touche.lettre.equals(ke.getText().toUpperCase())) {
                        touche.relacher();
                    }
                }
            }
        });
    }
}
