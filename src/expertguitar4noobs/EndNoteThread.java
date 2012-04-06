package expertguitar4noobs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EndNoteThread extends Thread {

    Tab tab;

    public EndNoteThread(Tab tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        MidiPlayer mp = MidiPlayer.getInstance();
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
        }

        for(int i = 0; i != tab.frets.length; ++i) {
            if(tab.frets[i] != -1) {
                mp.stopNote(Tab.getNote(i,tab.frets[i]));
                if(tab.strum) {
                    try { Thread.sleep(100); } catch(Exception e) {}
                }
            }
        }
    }
}
