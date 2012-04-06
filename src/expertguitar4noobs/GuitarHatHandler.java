package expertguitar4noobs;

import de.hardcode.jxinput.event.JXInputDirectionalEvent;
import de.hardcode.jxinput.event.JXInputDirectionalEventListener;

public class GuitarHatHandler implements JXInputDirectionalEventListener {

    private Guitar guitar;

    public GuitarHatHandler(Guitar guitar) {
        this.guitar = guitar;
    }

    public void changed(JXInputDirectionalEvent jxide) {
        if(jxide.getDirectional().getName().equals("Hat Switch")) {
            double delta = jxide.getValueDelta();
            if(delta == 1.0) {
                guitar.playTab();
            }
        }
    }

}
