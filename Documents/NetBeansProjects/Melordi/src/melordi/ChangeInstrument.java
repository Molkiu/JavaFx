/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author maste
 */
public class ChangeInstrument extends Parent {

    private RadioButton rbPiano;
    private RadioButton rbGuitare;
    private RadioButton rbOrgue;
    private Instru instru;

    public ChangeInstrument(Instru ins) {
        instru = ins;
        GridPane grid = new GridPane();

        ImageView piano = new ImageView(new Image(ChangeInstrument.class.getResourceAsStream("images/piano.png")));
        piano.setFitHeight(50);
        piano.setPreserveRatio(true);

        ImageView guitare = new ImageView(new Image(ChangeInstrument.class.getResourceAsStream("images/guitare.png")));
        guitare.setFitHeight(50);
        guitare.setPreserveRatio(true);

        ImageView orgue = new ImageView(new Image(ChangeInstrument.class.getResourceAsStream("images/orgue.png")));
        orgue.setFitHeight(50);
        orgue.setPreserveRatio(true);

        grid.add(piano, 1, 0);
        grid.add(guitare, 1, 1);
        grid.add(orgue, 1, 2);
        grid.setVgap(15);

        this.setTranslateX(100);
        this.setTranslateY(30);

        ToggleGroup groupe = new ToggleGroup();
        rbPiano = new RadioButton();
        rbGuitare = new RadioButton();
        rbOrgue = new RadioButton();
        rbPiano.setToggleGroup(groupe);
        rbGuitare.setToggleGroup(groupe);
        rbOrgue.setToggleGroup(groupe);

        rbPiano.setFocusTraversable(false);
        rbGuitare.setFocusTraversable(false);
        rbOrgue.setFocusTraversable(false);
        rbPiano.setSelected(true);
        
        groupe.selectedToggleProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue.equals(rbPiano)) {
                    instru.set_instrument(0);//numéro MIDI du piano = 0
                } else if (newValue.equals(rbGuitare)) {
                    instru.set_instrument(26);//numéro MIDI de la guitare = 26
                } else {
                    instru.set_instrument(16);//numéro MIDI de l'orgue = 16
                }
            }
        });

        grid.add(rbPiano, 0, 0);
        grid.add(rbGuitare, 0, 1);
        grid.add(rbOrgue, 0, 2);

        grid.setHgap(20);

        this.getChildren().add(grid);
    }
}
