/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author maste
 */
public class Touche extends Parent {

    protected String lettre;
    private int positionX;
    private int positionY;
    private int note;
    private Instru instru;
    private Rectangle fondTouche;

    public Touche(String l, int posX, int posY, int n,Instru ins) {
        instru = ins;
        lettre = l;
        note = n;
        positionX = posX;
        positionY = posY;

        fondTouche = new Rectangle(75, 75, Color.WHITE);
        fondTouche.setArcHeight(10);
        fondTouche.setArcWidth(10);
        this.getChildren().add(fondTouche);

        Text lettreTouche = new Text(lettre);
        lettreTouche.setFont(new Font(25));
        lettreTouche.setFill(Color.GREY);
        lettreTouche.setX(25);
        lettreTouche.setY(45);
        this.getChildren().add(lettreTouche);

        this.setTranslateX(positionX);
        this.setTranslateY(positionY);

        Light.Distant light = new Light.Distant();
        light.setAzimuth((-45.0));
        Lighting li = new Lighting();
        li.setLight(light);
        fondTouche.setEffect(li);

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                fondTouche.setFill(Color.LIGHTGREY);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                fondTouche.setFill(Color.WHITE);
            }
        });

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                appuyer();
            }
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                relacher();
            }
        });
    }

    public void appuyer() {
        fondTouche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY + 2);
        instru.note_on(note);
    }

    public void relacher() {
        fondTouche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        instru.note_off(note);
    }

}
