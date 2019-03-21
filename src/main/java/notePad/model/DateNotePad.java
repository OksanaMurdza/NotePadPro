package notePad.model;

import notePad.model.actionFunc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateNotePad {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu file, edit, help;
    private JMenuItem nnew,open, save, saveAs, exit, cut, copy, paste, about;
    private JTextArea textArea;
    private JCheckBoxMenuItem onlyForRead;
    private static String strChange;

    public DateNotePad(){
        frame = new JFrame("NotePad");
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");

        nnew = new JMenuItem("New");
        open = new JMenuItem("open");
        open.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        save = new JMenuItem("save");
        save.setEnabled(true);
        save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        saveAs = new JMenuItem("save as");
        saveAs.setEnabled(true);
        exit = new JMenuItem("exit");
        textArea = new JTextArea();
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

        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();

        JMenu setting = new JMenu("Setting");
        onlyForRead = new JCheckBoxMenuItem("Only for read");
        onlyForRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAs.setEnabled(!onlyForRead.isSelected());
                save.setEnabled(!onlyForRead.isSelected());
            }
        });

        edit.add(setting);
        setting.add(onlyForRead);
        help.add(about);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        frame.setJMenuBar(menuBar);

        NewFunc newFn = new NewFunc(getTextArea());
        OpenFunc openFn = new OpenFunc(getTextArea(), getFrame());
        SaveFunc saveFn = new SaveFunc(getTextArea());
        SaveAsFunc saveAsFn = new SaveAsFunc(getTextArea(), getFrame());
        ExitFunc exitFn = new ExitFunc();
        CutFunc cutFn = new CutFunc(textArea);
        CopyFunc copyFn = new CopyFunc(getTextArea());
        PasteFunc pasteFn = new PasteFunc(textArea);
        AboutFunc aboutFn = new AboutFunc(getTextArea());

        nnew.addActionListener(newFn);
        open.addActionListener(openFn);
        save.addActionListener(saveFn);
        saveAs.addActionListener(saveAsFn);
        exit.addActionListener(exitFn);
        cut.addActionListener(cutFn);
        copy.addActionListener(copyFn);
        paste.addActionListener(pasteFn);
        about.addActionListener(aboutFn);
    }

    private JTextArea getTextArea(){
        return textArea;
    }

    public JFrame getFrame(){
        return this.frame;
    }

    public static String getStrChange(){
        return strChange;
    }
    public static void setStrChange(String str){
        strChange = str;
    }
}
