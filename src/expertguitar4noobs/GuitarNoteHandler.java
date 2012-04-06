package expertguitar4noobs;

import de.hardcode.jxinput.Button;
import de.hardcode.jxinput.event.JXInputButtonEvent;
import de.hardcode.jxinput.event.JXInputButtonEventListener;

public class GuitarNoteHandler implements JXInputButtonEventListener {

    private Guitar guitar;

    public GuitarNoteHandler(Guitar guitar) {
        this.guitar = guitar;
    }

    public void changed(JXInputButtonEvent jxibe) {

        Button button = jxibe.getButton();
        String buttonName = jxibe.getButton().getName();

        if(buttonName.equals("Button 1")) {
            guitar.setKeyState(0, button.getState());
        } else if(buttonName.equals("Button 2")) {
            guitar.setKeyState(1, button.getState());
        } else if(buttonName.equals("Button 0")) {
            guitar.setKeyState(2, button.getState());
        } else if(buttonName.equals("Button 3")) {
            guitar.setKeyState(3, button.getState());
        } else if(buttonName.equals("Button 4")) {
            guitar.setKeyState(4, button.getState());
        }

        if(!button.getState()) {
            guitar.shut();
        }
    }

}
