/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.sound.midi.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MiKe
 */
public class GuitarGUI extends JFrame {
    
    private Instrument[] guitars;
    private MidiPlayer player;
    private Guitar guitar;
    private GuitarCanvas canvas;

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new GuitarGUI().setVisible(true);
    }

    public GuitarGUI() {
        super("expert guitar 4 n00bs");
        try{
            this.player = MidiPlayer.getInstance();
            //this.guitar = new Guitar();
            this.guitars = player.getGuitars();
            
            this.setLayout(new BorderLayout());

            JPanel right_panel = new OptionsPanel(this);

            canvas = new GuitarCanvas(this);

            this.add(right_panel,BorderLayout.EAST);
            this.add(canvas,BorderLayout.WEST);

            this.pack();
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    public JPanel createGuitarListPanel(){

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Escolher Guitarra"));

        JComboBox guitar_list = new JComboBox(guitars);
        guitar_list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                MidiPlayer.getInstance().changeGuitar((Instrument) cb.getSelectedItem());
            }
        });
        panel.add(guitar_list);
        return panel;
    }

 /*  public JPanel createTabPanel(){

        JPanel panel = new JPanel();
        panel.setSize(40,100);
        panel.setBorder(new TitledBorder("Opções"));

        JPanel panel_save = new JPanel();

        JTextField nome_field = new JTextField(20);
        JButton save_button = new JButton("Guardar Mapeamento");

        panel_save.add(nome_field);
        panel_save.add(save_button);

        JButton add_button = new JButton("Mapear");
        add_button.addActionListener(new AddButtonListener());

        panel.add(panel_save);
        panel.add(add_button);

        return panel;
    }*/

    public Guitar getGuitar(){
        return guitar;
    }

    public GuitarCanvas getCanvas(){
        return canvas;
    }

}
