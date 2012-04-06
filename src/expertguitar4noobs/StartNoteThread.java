package expertguitar4noobs;

public class StartNoteThread extends Thread {

    Tab tab;

    public StartNoteThread(Tab tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        MidiPlayer mp = MidiPlayer.getInstance();

        for(int i = 0; i != tab.frets.length; ++i) {
            if(tab.frets[i] != -1) {
                mp.startNote(Tab.getNote(i,tab.frets[i]));
                if(tab.strum) {
                    try { Thread.sleep(50); } catch(Exception e) {}
                }
            }
        }
    }
}
