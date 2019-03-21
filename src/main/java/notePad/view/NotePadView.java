package notePad.view;

import javax.swing.*;

public class NotePadView {
    public void ShowNotePad(JFrame frame){
        frame.setSize(800, 600);
        frame.setTitle("NotePad");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
