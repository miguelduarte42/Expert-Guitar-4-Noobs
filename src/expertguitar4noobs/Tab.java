package expertguitar4noobs;

import java.io.Serializable;

public class Tab implements Serializable {

    final int FRET_NOT_USED = -1;
    protected boolean strum;
    protected int[] frets;

    public static int getNote(int string, int fret) {
        int[] initial_notes = {40,45,50,55,59,64};
        return initial_notes[string]+fret;
    }

    public Tab(int E_stringFret, int A_stringFret, int D_stringFret, int G_stringFret, int B_stringFret, int e_stringFret, boolean strum) {
        frets = new int[] {
            E_stringFret,
            A_stringFret,
            D_stringFret,
            G_stringFret,
            B_stringFret,
            e_stringFret
        };
        this.strum = strum;
    }

    Tab(int[] activeNotes) {
        this.frets = activeNotes;
    }

    public void play() {
        System.out.println(frets[0] + " " + frets[1] + " " + frets[2] + " " + frets[3] + " " + frets[4] + " " + frets[5]);
        new StartNoteThread(this).start();
    }

    public void shut(boolean quick) {
        new StopNoteThread(this, quick).start();
    }

    void setDistorsion(double val) {
        int dist = (int)((16383-8192) * val) + 8192;
        MidiPlayer.getInstance().changePitch(dist);
    }
}
