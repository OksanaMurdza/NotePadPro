package notePad.model.actionFunc;

import notePad.model.DateNotePad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyFunc implements ActionListener {
    private JTextArea textArea;
    public CopyFunc (JTextArea area){
        textArea = area;
    }
    public void actionPerformed(ActionEvent e) {
        String strChange = textArea.getSelectedText();
        textArea.replaceRange(strChange, textArea.getSelectionStart(),textArea.getSelectionEnd());
        DateNotePad.setStrChange(strChange);
    }
}
