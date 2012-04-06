package expertguitar4noobs;

import de.hardcode.jxinput.Axis;
import de.hardcode.jxinput.JXInputDevice;
import de.hardcode.jxinput.JXInputManager;
import de.hardcode.jxinput.event.JXInputEventManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guitar {

    private static String[] compatibleDevices = new String[]{
        "Guitar Hero3 for PlayStation (R) 3"
    };
    private JXInputDevice device;// = getGuitarHeroController();
    private Keys pressedKeys;
    private Hashtable<Keys, Tab> mappings;
    private String name = "";
    private GuitarNoteHandler noteHandler;
    private GuitarHatHandler hatHandler;
    private GuitarDistorsionHandler distorsionHandler;
    private Tab lastTab = null;
    //private boolean isPlaying = false;

    @SuppressWarnings("UseOfObsoleteCollectionType")
    public Guitar() throws Exception {
        System.out.println("Device List");

        for (int i = 0; i != JXInputManager.getNumberOfDevices(); ++i) {
            JXInputDevice d = JXInputManager.getJXInputDevice(i);

            System.out.println(" - " + d.getName());

            boolean deviceFound = false;

            for (int j = 0; j != compatibleDevices.length; ++j) {
                if (d.getName().equals(compatibleDevices[j])) {
                    deviceFound = true;
                    this.device = d;
                    break;
                }
            }

            if (device != null) {
                break;
            }
        }

        if (device == null) {
            throw new Exception("Guitar device not found!");
        }

        this.pressedKeys = new Keys(new boolean[]{false, false, false, false, false});
        this.noteHandler = new GuitarNoteHandler(this);
        this.hatHandler = new GuitarHatHandler(this);
        this.distorsionHandler = new GuitarDistorsionHandler(this);
        this.mappings = new Hashtable<Keys, Tab>();

        System.out.println("Device Buttons");
        for (int i = 0; i != device.getNumberOfButtons(); ++i) {
            System.out.println(device.getButton(i).getName());
            JXInputEventManager.addListener(noteHandler, device.getButton(i));
        }

        for (int i = 0; i != device.getNumberOfDirectionals(); ++i) {
            System.out.println(device.getDirectional(i).getName());
            JXInputEventManager.addListener(hatHandler, device.getDirectional(i));
        }

        for (int i = 0; i != device.getMaxNumberOfAxes(); ++i) {
            Axis a = device.getAxis(i);
            if (a != null) {
                System.out.println(a.getName());
                JXInputEventManager.addListener(distorsionHandler, a);
            }
        }

        JXInputEventManager.setTriggerIntervall(1);
    }

    public Keys getPressedKeys() {
        return pressedKeys;
    }

    public void changeKeyState(int pos) {
        pressedKeys.checked[pos] = !pressedKeys.checked[pos];
    }

    void setKeyState(int i, boolean state) {
        pressedKeys.checked[i] = state;
    }

    void shut() {
        if (lastTab != null) {
            lastTab.shut(false);
            //try { Thread.sleep(300); } catch(Exception ex) {}
//            isPlaying = false;
        }
    }

    void playTab() {
        Tab newTab = mappings.get(pressedKeys);
        if (newTab == null) {
            return;
        }
        if (lastTab != null) {
            if (lastTab != newTab) {
                lastTab.shut(true);
                //try { Thread.sleep(1000); } catch (Exception ex) {}
            }
        }
        newTab.play();
        lastTab = newTab;
    }

    public void mapKeys(Keys keys, Tab tab) {
        if (keys.hasChecked()) {
            mappings.put(keys, tab);
        }
    }

    public void unmapKeys(Keys keys) {
        mappings.remove(keys);
    }

    void setDistorsion(double val) {
        if (lastTab != null) {
            lastTab.setDistorsion(val);
        }
    }

    void savePreset(String path) throws FileNotFoundException, IOException {
        OutputStream file = new FileOutputStream(path);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
        output.writeObject(mappings);
        output.close();
    }

    void loadPreset(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(path);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        this.mappings = (Hashtable<Keys, Tab>) input.readObject();
        input.close();
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Hashtable<Keys, Tab> getMappings(){
        return mappings;
    }
}
