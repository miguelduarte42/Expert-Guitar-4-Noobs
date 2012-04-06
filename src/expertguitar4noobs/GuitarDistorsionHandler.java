package expertguitar4noobs;

import de.hardcode.jxinput.event.JXInputAxisEvent;
import de.hardcode.jxinput.event.JXInputAxisEventListener;

public class GuitarDistorsionHandler implements JXInputAxisEventListener  {

    private Guitar guitar;

    public GuitarDistorsionHandler(Guitar guitar) {
        this.guitar = guitar;
    }

    public void changed(JXInputAxisEvent jxiae) {
        if(jxiae.getAxis().getName().equals("Z Axis")) {
            double val = jxiae.getAxis().getValue();
            if(val < 0) val = 0;
            this.guitar.setDistorsion(val);
        }
    }

}
