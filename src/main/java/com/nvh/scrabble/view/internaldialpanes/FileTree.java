package com.nvh.scrabble.view.internaldialpanes;

import com.nvh.scrabble.model.Scrabble;
import com.nvh.scrabble.service.ResourceLoader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Calendar;

public class FileTree extends JFrame implements TreeSelectionListener {
    //    private static final Logger logger = LoggerFactory.getLogger(FileTree.class);
    ResourceLoader resourceLoader = new ResourceLoader();
    static final String directory = "/savedgames/";
    private static final long serialVersionUID = -4105494649356150949L;
    Calendar calendar = Calendar.getInstance();

    public FileTree(Scrabble game) {
        setBounds(600, 460, 410, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public void displayDialogBox() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        for (File file : File.listRoots()) {
            String absolutePath = file.getAbsolutePath();
            DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(absolutePath);
//            logger.info("Chemin du fichier : " + absolutePath);
            if (absolutePath.equals(resourceLoader.getPathFromResource(directory))) {

                try {
                    for (File file1 : file.listFiles()) {
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file1.getName() + "\\");
                        defaultMutableTreeNode.add(this.listFile(file1, node));
                    }
                } catch (NullPointerException ignored) {
                }
                root.add(defaultMutableTreeNode);
            }
        }
    }

    public String actualDate() {
        int jour = calendar.get(Calendar.DAY_OF_MONTH);
        int mois = calendar.get(Calendar.MONTH);
        int annee = calendar.get(Calendar.YEAR);
        return String.valueOf(jour) + "_" + String.valueOf(mois) + "_" + String.valueOf(annee);
    }

    private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node) {

        if (file.isFile())
            return new DefaultMutableTreeNode(file.getName());
        else {
            for (File file1 : file.listFiles()) {
                DefaultMutableTreeNode subNode;
                if (file1.isDirectory()) {
                    subNode = new DefaultMutableTreeNode(file1.getName() + "\\");
                    node.add(this.listFile(file1, subNode));
                } else {
                    subNode = new DefaultMutableTreeNode(file1.getName());
                }

                node.add(subNode);

            }
            return node;
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
    }
}
