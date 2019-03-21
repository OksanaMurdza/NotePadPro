package notePad.model.actionFunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  AboutFunc implements ActionListener {
    private JTextArea textArea;
    public AboutFunc(JTextArea area){
        textArea = area;
    }
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(textArea,
                "Program\nby Oksana Murza");
    }
}
