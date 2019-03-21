package notePad.model.actionFunc;


import notePad.model.DateNotePad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasteFunc implements ActionListener {
    private JTextArea textArea;
    private String strChange;
    public PasteFunc(JTextArea area){
        textArea = area;
    }
    public void actionPerformed(ActionEvent e) {
        strChange = DateNotePad.getStrChange();
        textArea.replaceRange(strChange, textArea.getSelectionStart(),textArea.getSelectionEnd());
    }
}
