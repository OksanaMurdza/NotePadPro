package notePad.model.actionFunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

public class SaveAsFunc implements ActionListener {
    private JFrame frame;
    private JTextArea textArea;
    public SaveAsFunc(JTextArea area, JFrame frame){
        textArea = area;
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(frame)) {
            File file = fileChooser.getSelectedFile();
            PrintWriter out = null;
            try {
                out = new PrintWriter(file);
                String output = textArea.getText();
                System.out.println(output);
                out.println(output);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {out.flush();} catch(Exception ex1) {System.out.println(ex1);}
                try {out.close();} catch(Exception ex2) {System.out.println(ex2);}
            }
        }
    }
}
