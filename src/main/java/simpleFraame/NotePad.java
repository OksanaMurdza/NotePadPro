package simpleFraame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

class NotePad {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu file, edit, help;
    private JMenuItem nnew,open, save, saveAs, exit, cut, copy, paste, about;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JCheckBoxMenuItem onlyForRead;
    private String strChange;

    private NotePad(){
        frame = new JFrame("NotePad");
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        nnew = new JMenuItem("New");
        open = new JMenuItem("open");
        open.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        save = new JMenuItem("save");
        save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        saveAs = new JMenuItem("save as");
        saveAs.setEnabled(true);
        exit = new JMenuItem("exit");
        textArea = new JTextArea();
        fileChooser = new JFileChooser();
        menuBar = new JMenuBar();

        cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));

        about = new JMenuItem("About");


        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(textArea);
        file.add(nnew);
        file.add(open);
        file.addSeparator();


        //реалізувати save
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(exit);

        edit.add(cut);
        // внутрішній клас
        edit.add(copy);
        // внутрішній клас
        edit.add(paste);
        // внутрішній клас
        edit.addSeparator();


        JMenu sitting = new JMenu("Sitting");
        onlyForRead = new JCheckBoxMenuItem("Only for read");
        ActOnlyRead actOnlyRead = new ActOnlyRead();
        onlyForRead.setSelected(false);
        onlyForRead.addActionListener(actOnlyRead);


        edit.add(sitting);
        sitting.add(onlyForRead);
        help.add(about);
        //нова вкладка

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        frame.setJMenuBar(menuBar);

        NewFunc newFn = new NewFunc();
        OpenFunc openFn = new OpenFunc();
        SaveFunc saveFn = new SaveFunc();
        SaveAsFunc saveAsFn = new SaveAsFunc();
        ExitFunc exitFn = new ExitFunc();
        CutFunc cutFn = new CutFunc();
        CopyFunc copyFn = new CopyFunc();
        PasteFunc pasteFn = new PasteFunc();
        AboutFunc aboutFn = new AboutFunc();

        nnew.addActionListener(newFn);
        open.addActionListener(openFn);
        save.addActionListener(saveFn);
        saveAs.addActionListener(saveAsFn);
        exit.addActionListener(exitFn);

        cut.addActionListener(cutFn);
        copy.addActionListener(copyFn);
        paste.addActionListener(pasteFn);

        about.addActionListener(aboutFn);

        frame.setSize(800, 600);
        frame.setVisible(true);

    }

    class NewFunc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
        }
    }

    class CutFunc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            strChange = textArea.getSelectedText();
            textArea.replaceRange("", textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
    }

    class CopyFunc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            strChange = textArea.getSelectedText();
            textArea.replaceRange(strChange, textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
    }

    class PasteFunc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            textArea.replaceRange(strChange, textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
    }

    class ActOnlyRead implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            boolean acsess = onlyForRead.isSelected();
            saveAs.setEnabled(!acsess);
            save.setEnabled(!acsess);
        }
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
                    if (in != null) {
                        in.close();
                    }
                }
            }
        }
    }

    class SaveFunc implements ActionListener{
        public void actionPerformed(ActionEvent e) {
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
                try {out.flush();} catch(Exception ex1) { System.out.println(ex1);}
                try {out.close();} catch(Exception ex2) { System.out.println(ex2);}
            }
        }
    }

    class SaveAsFunc implements ActionListener {
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
                    try {out.flush();} catch(Exception ex1) {System.out.println(ex1);}
                    try {out.close();} catch(Exception ex2) {System.out.println(ex2);}
                }
            }
        }
    }

    class  AboutFunc implements  ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(textArea,
                    "Program\nby Oksana Murza");
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
