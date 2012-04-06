/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expertguitar4noobs;

import com.sun.media.sound.SF2Soundbank;
import com.sun.media.sound.SoftSynthesizer;
import java.io.File;
import java.util.ArrayList;
import javax.sound.midi.*;

/**
 *
 * @author MiKe
 */
public final class MidiPlayer {

    private static int DEFAULT_NOTE_VELOCITY = 400;
    private MidiChannel channel;
    private Synthesizer synthesizer;
    private Instrument[] guitars;

    private static MidiPlayer instance;

    static {
        instance = new MidiPlayer("guitar.sf2");
    }

    public static MidiPlayer getInstance() {
        return instance;
    }

    private MidiPlayer() {

        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();

            channel = synthesizer.getChannels()[0];

            //Increase the volume. IT'S OVER 9000!
            channel.controlChange(7, (int)(1D * 255.0));
            
            //Distortion Guitar
            guitars = getAvailableGuitars(synthesizer);
            
            changeGuitar(guitars[5]);
        } catch (Exception e) {
        }
    }

    private MidiPlayer(String path) {

        try {
            synthesizer = new SoftSynthesizer();
            synthesizer.open();

            SF2Soundbank sb = new SF2Soundbank(new File(path));

            System.out.println("------------------------");
            System.out.println(sb.getName());
            channel = synthesizer.getChannels()[0];
            synthesizer.loadAllInstruments(sb);

            System.out.println(sb.getName());

            //Increase the volume. IT'S OVER 9000!
            channel.controlChange(7, (int)(1D * 255.0));

            //Distortion Guitar
            guitars = synthesizer.getAvailableInstruments();



            for(int i = 0; i != guitars.length; ++i) {
                System.out.println(guitars[i].getName());
            }



            //changeGuitar(guitars[0]);
            System.out.println("------------------------");
        } catch (Exception e) {
        }
    }

    public void startNote(int note) {
        channel.noteOn(note, DEFAULT_NOTE_VELOCITY);
    }

    public void stopNote(int note) {
        channel.noteOff(note);
    }

    public void changePitch(int pitch) {
        channel.setPitchBend(pitch);
    }

    public void changeGuitar(Instrument guitar) {

        synthesizer.loadInstrument(guitar);
        channel.programChange(guitar.getPatch().getProgram());
    }

    public Instrument[] getGuitars() {
        return guitars;
    }

    private Instrument[] getAvailableGuitars(Synthesizer synthesizer) {

        ArrayList<Instrument> guitars_list = new ArrayList<Instrument>();

        for (Instrument inst : synthesizer.getAvailableInstruments()) {
            if (inst.getName().toLowerCase().contains("guitar") 
                    || inst.getName().toLowerCase().contains("gtr")
                    || inst.getName().toLowerCase().contains("gt")) {
                guitars_list.add(inst);
            }
        }

        Instrument[] guitars_array = new Instrument[guitars_list.size()];

        int i = 0;
        for (Instrument inst : guitars_list) {
            guitars_array[i] = inst;
            i++;
        }

        return guitars_array;
    }

    public void shut() {

        channel.allNotesOff();
    }
}
