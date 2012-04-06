package expertguitar4noobs;

public class StopNoteThread extends Thread {

    Tab tab;
    boolean quick;

    public StopNoteThread(Tab tab, boolean quick) {
        this.tab = tab;
        this.quick = quick;
    }

    @Override
    public void run() {
        MidiPlayer mp = MidiPlayer.getInstance();
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
        }

        for (int i = 0; i != tab.frets.length; ++i) {
            if (tab.frets[i] != -1) {
                mp.stopNote(Tab.getNote(i, tab.frets[i]));
                if (!quick) {
                    if (tab.strum) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }
}
