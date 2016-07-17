/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author maste
 */
public class Instru {
    private Synthesizer synthe;
    private MidiChannel canal;
    
    /**
     *
     */
    public IntegerProperty volume = new SimpleIntegerProperty(100);
    
    
    public Instru(){
        try{
            synthe = MidiSystem.getSynthesizer();
            synthe.open();
        }catch(MidiUnavailableException ex){
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE,null,ex);
        }
        canal = synthe.getChannels()[0];
        
        canal.programChange(0);
    }
    
    public void note_on(int note){
        canal.noteOn(note,volume.get());
    }
    public void note_off(int note){
        canal.noteOff(note);
    }
    
    public void set_instrument(int instru){
        canal.programChange(instru);
    }
}
