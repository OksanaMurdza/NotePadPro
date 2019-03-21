package notePad.model.actionFunc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class OpenFunc implements ActionListener {
    private JFrame frame;
    private JTextArea textArea;
    public OpenFunc(JTextArea area, JFrame frame){
        textArea = area;
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(frame)) {
            File file = fileChooser.getSelectedFile();
            textArea.setText("");
            Scanner in = null;
            try {
                in = new Scanner(file);
                while(in.hasNext()) {
                    String line = in.nextLine();
                    //line += System.getProperty("line.separator");
                    textArea.append(line + "\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
    }
}
