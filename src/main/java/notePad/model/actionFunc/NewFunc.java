package notePad.model.actionFunc;

import javax.swing.*;
import java.awt.event.*;


public class NewFunc implements ActionListener {
    private JTextArea textArea;
    public NewFunc(JTextArea area){
        textArea = area;
    }
    public void actionPerformed(ActionEvent e) {
        textArea.setText("");
    }
}
