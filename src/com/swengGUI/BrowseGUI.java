package com.swengGUI;

import javafx.stage.FileChooser;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowseGUI {

    /**
     * Declaring GUI components below
     */
    private JPanel mainPanel;
    private JTextField textField;
    private JButton browseButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextArea textArea1;
    private JButton submitButton;

    public BrowseGUI() {
        /**
         * Action Listener for the Browse Button
         */
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                /**
                 *The following line of code can be used to open the file search in a particular directory
                 * */
                 fc.setCurrentDirectory(new File("C:\\Users\\aanch\\Desktop\\Fall 2016"));
                 /**
                  * */
                /**
                 * The following line of code can be used to open file search for a particular type of file
                 * fileChooser.addChoosableFileFilter(new FileFilter() {

                 public String getDescription() {
                 return "PDF Documents (*.pdf)";
                 }

                 public boolean accept(File f) {
                 if (f.isDirectory()) {
                 return true;
                 } else {
                 return f.getName().toLowerCase().endsWith(".pdf");
                 }
                 }
                 });
                 */


                if (e.getSource() == browseButton) {
                    int returnVal = fc.showOpenDialog(mainPanel);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                            File file = fc.getSelectedFile();
                            textField.setText(file.getAbsolutePath());
                        /**
                         * if the user wants to display only file name then the following line of code can be used
                         * textField.setText(file.getName());
                         */

                    }
                }


                }
        });
    }

    public static void main (String[] args)
    {
        JFrame frame = new JFrame("Unit Test Generator Tool");
        JPanel mainPanel = new JPanel();
        frame.setContentPane(new BrowseGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //this should center the app
        /**
         * Menubar and its components can go here.
         * JMenuBar menubar = new JMenuBar();
         * JMenu menu1 = new JMenu();
         * menubar.add(menu1);
         * frame.setJMenuBar(menubar);
         */

        JButton browseButton = new JButton("Browse");
        mainPanel.add(browseButton);
        JTextField textField = new JTextField("");
        mainPanel.add(textField);
    }


}
