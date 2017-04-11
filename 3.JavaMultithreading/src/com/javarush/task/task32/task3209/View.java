package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    public View() throws HeadlessException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try{
            undoManager.undo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }

    }

    public void redo() {
        try{
            undoManager.redo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        if(tabbedPane.getSelectedIndex() == 0){
            return true;
        } else return false;
    }

    public void selectedTabChanged() {
        int index = tabbedPane.getSelectedIndex();
        if(index == 0){
            controller.setPlainText(plainTextPane.getText());
        } else if(index == 1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        this.resetUndo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this, "Information null","About",JOptionPane.INFORMATION_MESSAGE);
    }


    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void initMenuBar() {

        JMenuBar bar = new JMenuBar();
        MenuHelper.initFileMenu(this, bar);
        MenuHelper.initEditMenu(this, bar);
        MenuHelper.initStyleMenu(this, bar);
        MenuHelper.initAlignMenu(this, bar);
        MenuHelper.initColorMenu(this, bar);
        MenuHelper.initFontMenu(this, bar);
        MenuHelper.initHelpMenu(this, bar);
        this.getContentPane().add(bar, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollPaneHTML);
        JScrollPane scrollPaneTEXT = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPaneTEXT);
        tabbedPane.setPreferredSize(new Dimension(400, 400));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void exit() {
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if(command.equals("Новый")){
            controller.createNewDocument();
        } else if (command.equals("Открыть")){
            controller.openDocument();
        } else if (command.equals("Сохранить")){
            controller.saveDocument();
        } else if (command.equals("Сохранить как...")){
            controller.saveDocumentAs();
        } else if (command.equals("Выход")){
            controller.exit();
        } else if (command.equals("О программе")){
            showAbout();
        }

    }

    public Controller getController() {
        return controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
}
