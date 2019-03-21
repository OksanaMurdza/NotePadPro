package notePad.model.actionFunc;

import notePad.model.DateNotePad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CutFunc implements ActionListener {
    private JTextArea textArea;
    public CutFunc (JTextArea area){
        textArea = area;
    }
    public void actionPerformed(ActionEvent e) {
        String strChange = textArea.getSelectedText();
        textArea.replaceRange("", textArea.getSelectionStart(),textArea.getSelectionEnd());
        DateNotePad.setStrChange(strChange);
    }

}
