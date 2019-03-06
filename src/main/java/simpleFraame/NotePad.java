package simpleFraame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotePad {
    JFrame frame;
    JMenuBar menuBar;
    JMenu file;
    JMenuItem open, save, exit;
    JTextArea textArea;
    JFileChooser fileChooser;

    NotePad(){
        frame = new JFrame("NotePad");
        file = new JMenu("file");
        open = new JMenuItem("open");
        save = new JMenuItem("save");
        exit = new JMenuItem("exit");
        textArea = new JTextArea();
        fileChooser = new JFileChooser();
        menuBar = new JMenuBar();

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(textArea);
        file.add(open);
        file.add(save);
        file.add(exit);
        menuBar.add(file);
        frame.setJMenuBar(menuBar);

        OpenFunc openFn = new OpenFunc();
        SaveFunc saveFn = new SaveFunc();
        ExitFunc exitFn = new ExitFunc();

        open.addActionListener(openFn);
        save.addActionListener(saveFn);
        exit.addActionListener(exitFn);

        frame.setSize(800, 600);
        frame.setVisible(true);

    }

    class OpenFunc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(frame)) {
                File file = fileChooser.getSelectedFile();
                textArea.setText("");
                Scanner in = null;
                try {
                    in = new Scanner(file);
                    while(in.hasNext()) {
                        String line = in.nextLine();
                        textArea.append(line+"\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    in.close();
                }
            }
        }
    }

    class SaveFunc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
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
                    try {out.flush();} catch(Exception ex1) {}
                    try {out.close();} catch(Exception ex1) {}
                }
            }
        }
    }

    class ExitFunc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String args[]){
        NotePad notePad = new NotePad();
    }
}
